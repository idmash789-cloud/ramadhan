package com.sembilansembilan.pertanyaanseputarramadhan.data

/**
 * Satu tanya-jawab fikih puasa. Isi dipertahankan utuh dari data web
 * (ramadhanQuestions.ts) termasuk referensi kitab klasiknya.
 */
data class Question(
    val id: Int,
    val title: String,
    val question: String,
    val answer: String,
    val reference: String?,
)

/**
 * Satu seksi Buku Saku. [content] adalah teks mentah gaya markdown persis
 * seperti data web (bukuSakuContent.ts): judul "## "/"### ", tebal "**...**",
 * miring "*...*", tabel "| ... |", daftar "- "/"1. ", pemisah "---",
 * dan baris Arab (dirender RTL). Jangan diringkas — semua paragraf dipertahankan.
 */
data class BukuSakuSection(
    val id: String,
    val title: String,
    val content: String,
)

/** Kota untuk jadwal imsakiyah. [timezoneHours] = selisih dari UTC dalam jam. */
data class City(
    val name: String,
    val latitude: Double,
    val longitude: Double,
    val timezoneHours: Double,
)

enum class DarkMode { SYSTEM, LIGHT, DARK }

data class AppSettings(
    val darkMode: DarkMode = DarkMode.SYSTEM,
    val cityName: String = "Jakarta",
    val remindersEnabled: Boolean = false,
    /**
     * Kunci bookmark: "q:<questionId>" untuk pertanyaan,
     * "s:<sectionId>" untuk seksi Buku Saku.
     */
    val bookmarks: Set<String> = emptySet(),
)
