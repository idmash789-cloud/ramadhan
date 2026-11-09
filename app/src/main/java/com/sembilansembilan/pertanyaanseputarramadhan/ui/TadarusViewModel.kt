package com.sembilansembilan.pertanyaanseputarramadhan.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.sembilansembilan.pertanyaanseputarramadhan.data.SettingsStore
import java.time.LocalDate
import java.time.temporal.ChronoUnit
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

/**
 * Satu juz Al-Qur'an beserta surah awalnya. Pembagian juz dan surah awal
 * mengikuti pembagian juz standar (mushaf Madinah):
 * Juz 1 Al-Fatihah, 2–3 Al-Baqarah, 4 Ali 'Imran, 5–6 An-Nisa', 7 Al-Ma'idah,
 * 8 Al-An'am, 9 Al-A'raf, 10 Al-Anfal, 11 At-Taubah, 12 Hud, 13 Yusuf,
 * 14 Al-Hijr, 15 Al-Isra', 16 Al-Kahf, 17 Al-Anbiya', 18 Al-Mu'minun,
 * 19 Al-Furqan, 20 An-Naml, 21 Al-'Ankabut, 22 Al-Ahzab, 23 Ya-Sin,
 * 24 Az-Zumar, 25 Fussilat, 26 Al-Ahqaf, 27 Az-Zariyat, 28 Al-Mujadila,
 * 29 Al-Mulk, 30 An-Naba'.
 */
data class JuzInfo(val number: Int, val startSurah: String)

val JUZ_LIST: List<JuzInfo> = listOf(
    JuzInfo(1, "Al-Fatihah"),
    JuzInfo(2, "Al-Baqarah"),
    JuzInfo(3, "Al-Baqarah"),
    JuzInfo(4, "Ali 'Imran"),
    JuzInfo(5, "An-Nisa'"),
    JuzInfo(6, "An-Nisa'"),
    JuzInfo(7, "Al-Ma'idah"),
    JuzInfo(8, "Al-An'am"),
    JuzInfo(9, "Al-A'raf"),
    JuzInfo(10, "Al-Anfal"),
    JuzInfo(11, "At-Taubah"),
    JuzInfo(12, "Hud"),
    JuzInfo(13, "Yusuf"),
    JuzInfo(14, "Al-Hijr"),
    JuzInfo(15, "Al-Isra'"),
    JuzInfo(16, "Al-Kahf"),
    JuzInfo(17, "Al-Anbiya'"),
    JuzInfo(18, "Al-Mu'minun"),
    JuzInfo(19, "Al-Furqan"),
    JuzInfo(20, "An-Naml"),
    JuzInfo(21, "Al-'Ankabut"),
    JuzInfo(22, "Al-Ahzab"),
    JuzInfo(23, "Ya-Sin"),
    JuzInfo(24, "Az-Zumar"),
    JuzInfo(25, "Fussilat"),
    JuzInfo(26, "Al-Ahqaf"),
    JuzInfo(27, "Az-Zariyat"),
    JuzInfo(28, "Al-Mujadila"),
    JuzInfo(29, "Al-Mulk"),
    JuzInfo(30, "An-Naba'"),
)

data class TadarusUiState(
    val completedJuz: Set<Int> = emptySet(),
    val targetDate: LocalDate? = null,
    val reminderEnabled: Boolean = false,
    val today: LocalDate = LocalDate.now(),
) {
    val completedCount: Int get() = completedJuz.size
    val remainingCount: Int get() = (30 - completedCount).coerceAtLeast(0)
    val percent: Int get() = completedCount * 100 / 30
    val isKhatam: Boolean get() = completedCount >= 30

    /** Sisa hari sampai target (negatif bila target sudah lewat). */
    val daysUntilTarget: Long? get() = targetDate?.let { ChronoUnit.DAYS.between(today, it) }

    /**
     * Juz per hari yang dibutuhkan agar khatam tepat pada tanggal target.
     * Null bila: tidak ada target, sudah khatam, atau target hari ini / lewat.
     */
    val juzPerDayNeeded: Double?
        get() {
            val days = daysUntilTarget ?: return null
            if (isKhatam || days <= 0) return null
            return remainingCount.toDouble() / days.toDouble()
        }

    /** Perkiraan tanggal selesai bila membaca 1 juz setiap hari mulai hari ini. */
    val estimatedFinishDate: LocalDate get() = today.plusDays(remainingCount.toLong())
}

/**
 * Tadarus tracker 30 juz: centang per juz, target tanggal khatam,
 * kecepatan yang dibutuhkan, dan toggle pengingat harian.
 *
 * Progress tersimpan di DataStore lewat SettingsStore (key tadarus_*,
 * lihat spec QW-5). Toggle pengingat HANYA menyimpan pilihan pengguna;
 * penjadwalan WorkManager-nya adalah langkah lanjutan (lihat spec QW-5 §5)
 * — tidak ada worker setengah jadi di sini.
 */
class TadarusViewModel(private val settingsStore: SettingsStore) : ViewModel() {

    // Tanggal "hari ini" diperbarui tiap menit agar hitung mundur target
    // tetap segar tanpa perlu menutup-membuka aplikasi.
    private val todayTicker: Flow<LocalDate> = flow {
        while (true) {
            emit(LocalDate.now())
            delay(60_000)
        }
    }

    val uiState: StateFlow<TadarusUiState> = combine(
        settingsStore.settings,
        todayTicker
    ) { settings, today ->
        TadarusUiState(
            completedJuz = settings.tadarusCompleted
                .mapNotNull { it.toIntOrNull() }
                .filter { it in 1..30 }
                .toSet(),
            targetDate = settings.tadarusTargetDate
                .takeIf { it.isNotBlank() }
                ?.let { runCatching { LocalDate.parse(it) }.getOrNull() },
            reminderEnabled = settings.tadarusReminderEnabled,
            today = today
        )
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), TadarusUiState())

    /** Ketuk juz untuk menandai selesai / membatalkan tanda selesai. */
    fun toggleJuz(juz: Int) {
        if (juz !in 1..30) return
        viewModelScope.launch { settingsStore.toggleTadarusJuz(juz) }
    }

    /** Simpan target tanggal khatam (format ISO "yyyy-MM-dd"). */
    fun setTargetDate(date: LocalDate?) {
        viewModelScope.launch { settingsStore.setTadarusTargetDate(date?.toString()) }
    }

    /** Hapus target tanggal khatam. */
    fun clearTargetDate() {
        viewModelScope.launch { settingsStore.setTadarusTargetDate(null) }
    }

    /** Toggle pengingat harian (hanya tersimpan; penjadwalan menyusul). */
    fun setReminderEnabled(enabled: Boolean) {
        viewModelScope.launch { settingsStore.setTadarusReminderEnabled(enabled) }
    }

    class Factory(private val settingsStore: SettingsStore) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(TadarusViewModel::class.java)) {
                return TadarusViewModel(settingsStore) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}
