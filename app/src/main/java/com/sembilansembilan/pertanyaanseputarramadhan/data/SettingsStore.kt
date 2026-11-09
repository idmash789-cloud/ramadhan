package com.sembilansembilan.pertanyaanseputarramadhan.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.longPreferencesKey
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
        // QW-1: prompt rating sopan.
        val RATING_PROMPT_STATE = stringPreferencesKey("rating_prompt_state")
        val DETAIL_OPEN_COUNT = intPreferencesKey("detail_open_count")
        val SHARED_ONCE = booleanPreferencesKey("shared_once")
        // QW-2: harga Kalkulator Zakat.
        val ZAKAT_RICE_PRICE_PER_KG = longPreferencesKey("zakat_rice_price_per_kg")
        val ZAKAT_GOLD_PRICE_PER_GRAM = longPreferencesKey("zakat_gold_price_per_gram")
        val ZAKAT_FIDYAH_MEAL_PRICE = longPreferencesKey("zakat_fidyah_meal_price")
        // QW-4: pengingat puasa sunnah.
        val SUNNAH_REMINDERS_ENABLED = booleanPreferencesKey("sunnah_reminders_enabled")
        // QW-5: tadarus tracker.
        val TADARUS_COMPLETED = stringSetPreferencesKey("tadarus_completed")
        val TADARUS_TARGET_DATE = stringPreferencesKey("tadarus_target_date")
        val TADARUS_REMINDER_ENABLED = booleanPreferencesKey("tadarus_reminder_enabled")
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
            bookmarks = prefs[Keys.BOOKMARKS] ?: emptySet(),
            ratingPromptState = prefs[Keys.RATING_PROMPT_STATE] ?: "unasked",
            detailOpenCount = prefs[Keys.DETAIL_OPEN_COUNT] ?: 0,
            sharedOnce = prefs[Keys.SHARED_ONCE] ?: false,
            ricePricePerKg = prefs[Keys.ZAKAT_RICE_PRICE_PER_KG] ?: 15_000L,
            goldPricePerGram = prefs[Keys.ZAKAT_GOLD_PRICE_PER_GRAM] ?: 2_000_000L,
            fidyahMealPrice = prefs[Keys.ZAKAT_FIDYAH_MEAL_PRICE] ?: 20_000L,
            sunnahRemindersEnabled = prefs[Keys.SUNNAH_REMINDERS_ENABLED] ?: true,
            tadarusCompleted = prefs[Keys.TADARUS_COMPLETED] ?: emptySet(),
            tadarusTargetDate = prefs[Keys.TADARUS_TARGET_DATE] ?: "",
            tadarusReminderEnabled = prefs[Keys.TADARUS_REMINDER_ENABLED] ?: false
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

    // --- QW-1: prompt rating sopan ---
    // Prompt muncul SEKALI bila pengguna sudah membuka 3 jawaban (detail)
    // atau pernah membagikan 1 jawaban — dan hanya bila status "unasked".

    suspend fun setRatingPromptState(state: String) {
        context.dataStore.edit { prefs -> prefs[Keys.RATING_PROMPT_STATE] = state }
    }

    /** Tambah 1 hitungan jawaban yang dibuka (dipanggil saat detail di-expand). */
    suspend fun recordDetailOpen() {
        context.dataStore.edit { prefs ->
            prefs[Keys.DETAIL_OPEN_COUNT] = (prefs[Keys.DETAIL_OPEN_COUNT] ?: 0) + 1
        }
    }

    /** Nol-kan hitungan (dipanggil saat pengguna menekan "Nanti"). */
    suspend fun resetDetailOpenCount() {
        context.dataStore.edit { prefs -> prefs[Keys.DETAIL_OPEN_COUNT] = 0 }
    }

    /** Tandai pengguna pernah membagikan jawaban/aplikasi. */
    suspend fun recordShared() {
        context.dataStore.edit { prefs -> prefs[Keys.SHARED_ONCE] = true }
    }

    // --- QW-2: harga Kalkulator Zakat ---
    suspend fun setRicePricePerKg(pricePerKg: Long) {
        context.dataStore.edit { prefs -> prefs[Keys.ZAKAT_RICE_PRICE_PER_KG] = pricePerKg }
    }

    suspend fun setGoldPricePerGram(pricePerGram: Long) {
        context.dataStore.edit { prefs -> prefs[Keys.ZAKAT_GOLD_PRICE_PER_GRAM] = pricePerGram }
    }

    suspend fun setFidyahMealPrice(price: Long) {
        context.dataStore.edit { prefs -> prefs[Keys.ZAKAT_FIDYAH_MEAL_PRICE] = price }
    }

    // --- QW-4: pengingat puasa sunnah ---
    suspend fun setSunnahRemindersEnabled(enabled: Boolean) {
        context.dataStore.edit { prefs -> prefs[Keys.SUNNAH_REMINDERS_ENABLED] = enabled }
    }

    // --- QW-5: tadarus tracker ---
    /** Toggle satu juz tadarus ("1".."30") di set yang tersimpan. */
    suspend fun toggleTadarusJuz(juz: Int) {
        context.dataStore.edit { prefs ->
            val current = prefs[Keys.TADARUS_COMPLETED] ?: emptySet()
            val key = juz.toString()
            prefs[Keys.TADARUS_COMPLETED] = if (key in current) current - key else current + key
        }
    }

    /** Simpan target tanggal khatam (ISO "yyyy-MM-dd"); null/blank = hapus. */
    suspend fun setTadarusTargetDate(dateIso: String?) {
        context.dataStore.edit { prefs ->
            if (dateIso.isNullOrBlank()) {
                prefs.remove(Keys.TADARUS_TARGET_DATE)
            } else {
                prefs[Keys.TADARUS_TARGET_DATE] = dateIso
            }
        }
    }

    /** Simpan pilihan toggle pengingat harian tadarus. */
    suspend fun setTadarusReminderEnabled(enabled: Boolean) {
        context.dataStore.edit { prefs -> prefs[Keys.TADARUS_REMINDER_ENABLED] = enabled }
    }
}
