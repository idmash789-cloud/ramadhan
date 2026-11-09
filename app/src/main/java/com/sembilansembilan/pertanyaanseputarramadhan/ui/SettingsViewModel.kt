package com.sembilansembilan.pertanyaanseputarramadhan.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.sembilansembilan.pertanyaanseputarramadhan.data.AppSettings
import com.sembilansembilan.pertanyaanseputarramadhan.data.DarkMode
import com.sembilansembilan.pertanyaanseputarramadhan.data.SettingsStore
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

/** ViewModel bersama untuk pengaturan + bookmark (dipakai semua layar). */
class SettingsViewModel(private val settingsStore: SettingsStore) : ViewModel() {

    val settings: StateFlow<AppSettings> = settingsStore.settings
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), AppSettings())

    fun setDarkMode(mode: DarkMode) {
        viewModelScope.launch { settingsStore.setDarkMode(mode) }
    }

    fun setCityName(name: String) {
        viewModelScope.launch { settingsStore.setCityName(name) }
    }

    fun setRemindersEnabled(enabled: Boolean) {
        viewModelScope.launch { settingsStore.setRemindersEnabled(enabled) }
    }

    fun toggleBookmark(key: String) {
        viewModelScope.launch { settingsStore.toggleBookmark(key) }
    }

    fun isBookmarked(key: String): Boolean = key in settings.value.bookmarks

    class Factory(private val settingsStore: SettingsStore) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(SettingsViewModel::class.java)) {
                return SettingsViewModel(settingsStore) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}
