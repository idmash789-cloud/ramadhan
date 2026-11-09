package com.sembilansembilan.pertanyaanseputarramadhan.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.sembilansembilan.pertanyaanseputarramadhan.data.AppSettings
import com.sembilansembilan.pertanyaanseputarramadhan.data.SettingsStore
import com.sembilansembilan.pertanyaanseputarramadhan.data.ZakatCalculator
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

/**
 * Kalkulator Zakat (QW-2): input fitrah/maal/fidyah + harga yang bisa diubah.
 * Harga tersimpan di DataStore lewat [SettingsStore] (key zakat_rice_price_per_kg,
 * zakat_gold_price_per_gram, zakat_fidyah_meal_price) sehingga tetap sama saat
 * aplikasi dibuka lagi. Input jumlah/harta hanya di memori (tidak disimpan).
 */
class ZakatViewModel(private val settingsStore: SettingsStore) : ViewModel() {

    val settings: StateFlow<AppSettings> = settingsStore.settings
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), AppSettings())

    private val _membersText = MutableStateFlow("1")
    val membersText: StateFlow<String> = _membersText

    private val _ricePriceText =
        MutableStateFlow(ZakatCalculator.DEFAULT_RICE_PRICE_PER_KG.toString())
    val ricePriceText: StateFlow<String> = _ricePriceText

    private val _wealthText = MutableStateFlow("")
    val wealthText: StateFlow<String> = _wealthText

    private val _goldPriceText =
        MutableStateFlow(ZakatCalculator.DEFAULT_GOLD_PRICE_PER_GRAM.toString())
    val goldPriceText: StateFlow<String> = _goldPriceText

    private val _fidyahDaysText = MutableStateFlow("1")
    val fidyahDaysText: StateFlow<String> = _fidyahDaysText

    private val _mealPriceText =
        MutableStateFlow(ZakatCalculator.DEFAULT_FIDYAH_MEAL_PRICE.toString())
    val mealPriceText: StateFlow<String> = _mealPriceText

    init {
        // Sekali saat awal: isi kolom harga dari nilai yang tersimpan di DataStore.
        // Hanya sekali (first) agar ketikan pengguna sesudahnya tidak tertimpa.
        viewModelScope.launch {
            val saved = settingsStore.settings.first()
            _ricePriceText.value = saved.ricePricePerKg.toString()
            _goldPriceText.value = saved.goldPricePerGram.toString()
            _mealPriceText.value = saved.fidyahMealPrice.toString()
        }
    }

    /** Ringkasan hasil yang dihitung ulang dari setiap perubahan input/harga. */
    val summary: StateFlow<ZakatCalculator.ZakatSummary> = combine(
        _membersText,
        _ricePriceText,
        _wealthText,
        _goldPriceText,
        _fidyahDaysText,
        _mealPriceText,
        settings
    ) { members, ricePrice, wealth, goldPrice, days, mealPrice, appSettings ->
        // Bila kolom harga dikosongkan pengguna, pakai harga tersimpan sebagai fallback.
        val effectiveRicePrice = ZakatCalculator.parseAmount(ricePrice)
            .takeIf { it > 0 } ?: appSettings.ricePricePerKg
        val effectiveGoldPrice = ZakatCalculator.parseAmount(goldPrice)
            .takeIf { it > 0 } ?: appSettings.goldPricePerGram
        val effectiveMealPrice = ZakatCalculator.parseAmount(mealPrice)
            .takeIf { it > 0 } ?: appSettings.fidyahMealPrice
        ZakatCalculator.buildSummary(
            members = ZakatCalculator.parseCount(members),
            ricePricePerKg = effectiveRicePrice,
            totalWealth = ZakatCalculator.parseAmount(wealth),
            goldPricePerGram = effectiveGoldPrice,
            fidyahDays = ZakatCalculator.parseCount(days),
            mealPrice = effectiveMealPrice
        )
    }.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000),
        ZakatCalculator.buildSummary(
            members = 1,
            ricePricePerKg = ZakatCalculator.DEFAULT_RICE_PRICE_PER_KG,
            totalWealth = 0L,
            goldPricePerGram = ZakatCalculator.DEFAULT_GOLD_PRICE_PER_GRAM,
            fidyahDays = 1,
            mealPrice = ZakatCalculator.DEFAULT_FIDYAH_MEAL_PRICE
        )
    )

    /** Jumlah anggota keluarga (jiwa). Hanya digit, maks. 3 digit. */
    fun setMembers(text: String) {
        _membersText.value = text.filter { it.isDigit() }.take(3)
    }

    /** Harga beras per kg (Rp). Hanya digit; bila > 0 langsung disimpan ke DataStore. */
    fun setRicePrice(text: String) {
        val digits = text.filter { it.isDigit() }.take(12)
        _ricePriceText.value = digits
        val value = digits.toLongOrNull()
        if (value != null && value > 0) {
            viewModelScope.launch { settingsStore.setRicePricePerKg(value) }
        }
    }

    /** Total harta untuk zakat maal (Rp). Hanya digit, maks. 15 digit. */
    fun setWealth(text: String) {
        _wealthText.value = text.filter { it.isDigit() }.take(15)
    }

    /** Harga emas per gram (Rp). Hanya digit; bila > 0 langsung disimpan ke DataStore. */
    fun setGoldPrice(text: String) {
        val digits = text.filter { it.isDigit() }.take(12)
        _goldPriceText.value = digits
        val value = digits.toLongOrNull()
        if (value != null && value > 0) {
            viewModelScope.launch { settingsStore.setGoldPricePerGram(value) }
        }
    }

    /** Jumlah hari fidyah. Hanya digit, maks. 3 digit. */
    fun setFidyahDays(text: String) {
        _fidyahDaysText.value = text.filter { it.isDigit() }.take(3)
    }

    /** Harga satu kali makan untuk fidyah (Rp). Hanya digit; bila > 0 disimpan ke DataStore. */
    fun setMealPrice(text: String) {
        val digits = text.filter { it.isDigit() }.take(12)
        _mealPriceText.value = digits
        val value = digits.toLongOrNull()
        if (value != null && value > 0) {
            viewModelScope.launch { settingsStore.setFidyahMealPrice(value) }
        }
    }

    class Factory(private val settingsStore: SettingsStore) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(ZakatViewModel::class.java)) {
                return ZakatViewModel(settingsStore) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}
