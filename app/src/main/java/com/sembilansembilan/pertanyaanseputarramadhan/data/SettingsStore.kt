package com.sembilansembilan.pertanyaanseputarramadhan.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.core.stringSetPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

/** Pengaturan pengguna live di DataStore (Preferences). Tanpa akun, tanpa server. */
private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class SettingsStore(private val context: Context) {
    private object Keys {
        val DARK_MODE = stringPreferencesKey("dark_mode")
        val CITY_NAME = stringPreferencesKey("city_name")
        val REMINDERS_ENABLED = booleanPreferencesKey("reminders_enabled")
        val BOOKMARKS = stringSetPreferencesKey("bookmarks")
    }

    val settings: Flow<AppSettings> = context.dataStore.data.map { prefs ->
        val darkMode = when (prefs[Keys.DARK_MODE]) {
            "light" -> DarkMode.LIGHT
            "dark" -> DarkMode.DARK
            else -> DarkMode.SYSTEM
        }
        AppSettings(
            darkMode = darkMode,
            cityName = prefs[Keys.CITY_NAME] ?: "Jakarta",
            remindersEnabled = prefs[Keys.REMINDERS_ENABLED] ?: false,
            bookmarks = prefs[Keys.BOOKMARKS] ?: emptySet()
        )
    }

    suspend fun getSettings(): AppSettings = settings.first()

    suspend fun setDarkMode(mode: DarkMode) {
        context.dataStore.edit { prefs ->
            prefs[Keys.DARK_MODE] = when (mode) {
                DarkMode.LIGHT -> "light"
                DarkMode.DARK -> "dark"
                DarkMode.SYSTEM -> "system"
            }
        }
    }

    suspend fun setCityName(name: String) {
        context.dataStore.edit { prefs -> prefs[Keys.CITY_NAME] = name }
    }

    suspend fun setRemindersEnabled(enabled: Boolean) {
        context.dataStore.edit { prefs -> prefs[Keys.REMINDERS_ENABLED] = enabled }
    }

    suspend fun toggleBookmark(key: String) {
        context.dataStore.edit { prefs ->
            val current = prefs[Keys.BOOKMARKS] ?: emptySet()
            prefs[Keys.BOOKMARKS] = if (key in current) current - key else current + key
        }
    }

    suspend fun clearBookmarks() {
        context.dataStore.edit { prefs -> prefs[Keys.BOOKMARKS] = emptySet() }
    }
}
