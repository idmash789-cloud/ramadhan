package com.sembilansembilan.pertanyaanseputarramadhan.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.sembilansembilan.pertanyaanseputarramadhan.data.SunnahFastDay
import com.sembilansembilan.pertanyaanseputarramadhan.data.SunnahFastType
import com.sembilansembilan.pertanyaanseputarramadhan.data.SunnahFasting
import java.time.LocalDate
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

/** Layar Puasa Sunnah: daftar 12 bulan ke depan + filter per jenis. */
class SunnahViewModel : ViewModel() {

    private val initialFasts: List<SunnahFastDay> = SunnahFasting.upcoming()

    private val _allFasts = MutableStateFlow(initialFasts)

    private val _selectedType = MutableStateFlow<SunnahFastType?>(null)
    val selectedType: StateFlow<SunnahFastType?> = _selectedType

    /** Daftar (terfilter) untuk 12 bulan ke depan, terurut naik. */
    val filteredFasts: StateFlow<List<SunnahFastDay>> =
        combine(_allFasts, _selectedType) { fasts, type ->
            if (type == null) fasts else fasts.filter { it.type == type }
        }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), initialFasts)

    /** Puasa sunnah terdekat pada/hari ini ke depan (untuk kartu sorotan). */
    val nextFast: StateFlow<SunnahFastDay?> = _allFasts
        .map { fasts -> fasts.firstOrNull { it.gregorian >= LocalDate.now() } }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            initialFasts.firstOrNull { it.gregorian >= LocalDate.now() }
        )

    /** null = "Semua". */
    fun selectType(type: SunnahFastType?) {
        _selectedType.value = type
    }

    /** Hitung ulang daftar (mis. setelah pergantian hari). */
    fun refresh() {
        _allFasts.value = SunnahFasting.upcoming()
    }

    class Factory : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(SunnahViewModel::class.java)) {
                return SunnahViewModel() as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}
