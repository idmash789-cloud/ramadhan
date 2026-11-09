package com.sembilansembilan.pertanyaanseputarramadhan.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.sembilansembilan.pertanyaanseputarramadhan.data.City
import com.sembilansembilan.pertanyaanseputarramadhan.data.SettingsStore
import com.sembilansembilan.pertanyaanseputarramadhan.data.cityByName
import com.sembilansembilan.pertanyaanseputarramadhan.imsakiyah.PrayerTimes
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.temporal.ChronoUnit
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn

data class HomeUiState(
    val city: City = cityByName("Jakarta"),
    val date: LocalDate = LocalDate.now(),
    val times: PrayerTimes.Times? = null,
    /** "Imsak" atau "Berbuka". */
    val nextEventLabel: String = "Imsak",
    val nextEventTime: LocalTime? = null,
    val countdownMinutes: Long = 0,
)

/** Beranda: jadwal imsakiyah hari ini + hitung mundur ke Imsak / Berbuka. */
class HomeViewModel(private val settingsStore: SettingsStore) : ViewModel() {

    private val ticker: Flow<LocalDateTime> = flow {
        while (true) {
            emit(LocalDateTime.now())
            delay(30_000)
        }
    }

    val uiState: StateFlow<HomeUiState> = combine(
        settingsStore.settings,
        ticker
    ) { settings, now -> buildState(settings.cityName, now) }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), buildState("Jakarta", LocalDateTime.now()))

    private fun buildState(cityName: String, now: LocalDateTime): HomeUiState {
        val city = cityByName(cityName)
        val today = now.toLocalDate()
        val times = PrayerTimes.compute(today, city.latitude, city.longitude, city.timezoneHours)
        val nowTime = now.toLocalTime()
        return when {
            nowTime < times.imsak -> {
                val target = LocalDateTime.of(today, times.imsak)
                HomeUiState(city, today, times, "Imsak", times.imsak, minutesUntil(now, target))
            }
            nowTime < times.maghrib -> {
                val target = LocalDateTime.of(today, times.maghrib)
                HomeUiState(city, today, times, "Berbuka", times.maghrib, minutesUntil(now, target))
            }
            else -> {
                val tomorrow = today.plusDays(1)
                val tomorrowTimes = PrayerTimes.compute(tomorrow, city.latitude, city.longitude, city.timezoneHours)
                val target = LocalDateTime.of(tomorrow, tomorrowTimes.imsak)
                HomeUiState(city, today, times, "Imsak", tomorrowTimes.imsak, minutesUntil(now, target))
            }
        }
    }

    private fun minutesUntil(now: LocalDateTime, target: LocalDateTime): Long {
        return ChronoUnit.MINUTES.between(now, target).coerceAtLeast(0)
    }

    class Factory(private val settingsStore: SettingsStore) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
                return HomeViewModel(settingsStore) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}
