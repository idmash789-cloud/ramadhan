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

/**
 * Satu artikel Kajian NU Online. [content] memakai gaya markdown yang sama
 * seperti [BukuSakuSection] (judul "## "/"### ", tebal "**...**", daftar,
 * tabel "| ... |", baris Arab) dan dirender oleh MarkdownText. [source]
 * adalah URL artikel NU Online asal materi (atribusi).
 * Isi ditulis ulang (parafrase) dari artikel sumber — bukan salinan mentah.
 */
data class NuArticle(
    val id: String,
    val title: String,
    val content: String,
    val source: String,
)

/**
 * Satu tanya-jawab fikih dari PISS-KTB (forum kajian berbasis kitab kuning).
 * Pola sama seperti [Question] ditambah [source] (URL halaman PISS-KTB asal).
 * Jawaban diparafrase dari jawaban di situs; referensi kitab ditulis persis
 * seperti tercantum di sumber.
 */
data class PissQuestion(
    val id: Int,
    val title: String,
    val question: String,
    val answer: String,
    val reference: String?,
    val source: String,
)

/**
 * Satu kultum Ramadhan (kuliah tujuh menit), satu untuk tiap malam Ramadhan
 * ([night] 1–30). [quote] hanya kutipan Al-Qur'an/hadits yang sudah dikenal
 * luas dan terverifikasi; bila ragu, isikan null. [content] adalah isi kultum
 * (±7 menit baca) yang ditulis orisinal untuk aplikasi ini.
 */
data class Kultum(
    val night: Int,
    val title: String,
    val theme: String,
    val quote: String?,
    val quoteSource: String?,
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
     * "s:<sectionId>" untuk seksi Buku Saku, "n:<articleId>" untuk
     * artikel Kajian NU Online, "p:<pissId>" untuk tanya-jawab
     * PISS-KTB, "k:<night>" untuk kultum.
     */
    val bookmarks: Set<String> = emptySet(),
    /**
     * Status prompt rating (QW-1): "unasked" (belum pernah ditanya),
     * "later" (pengguna menekan "Nanti" — boleh ditanya lagi nanti),
     * "never" ("Jangan tanya lagi"), "rated" (sudah memberi rating).
     */
    val ratingPromptState: String = "unasked",
    /** Jumlah jawaban yang dibuka (detail) sejak terakhir prompt rating. */
    val detailOpenCount: Int = 0,
    /** True bila pengguna pernah membagikan satu jawaban/aplikasi. */
    val sharedOnce: Boolean = false,
    /**
     * Harga tersimpan untuk Kalkulator Zakat (QW-2). Default sama dengan
     * ZakatCalculator.DEFAULT_RICE_PRICE_PER_KG / DEFAULT_GOLD_PRICE_PER_GRAM /
     * DEFAULT_FIDYAH_MEAL_PRICE; pengguna bisa mengubahnya di layar Kalkulator Zakat.
     */
    val ricePricePerKg: Long = 15_000L,
    val goldPricePerGram: Long = 2_000_000L,
    val fidyahMealPrice: Long = 20_000L,
    /** Toggle pengingat puasa sunnah (QW-4). Default AKTIF. */
    val sunnahRemindersEnabled: Boolean = true,
    /**
     * Juz tadarus yang sudah selesai dibaca: "1".."30" (QW-5).
     * Disimpan sebagai stringSet di DataStore (key "tadarus_completed").
     */
    val tadarusCompleted: Set<String> = emptySet(),
    /**
     * Target tanggal khatam, format ISO "yyyy-MM-dd" (QW-5).
     * "" = belum diset. Key DataStore "tadarus_target_date".
     */
    val tadarusTargetDate: String = "",
    /**
     * Pilihan pengingat harian tadarus (QW-5).
     * Key DataStore "tadarus_reminder_enabled".
     */
    val tadarusReminderEnabled: Boolean = false,
)
