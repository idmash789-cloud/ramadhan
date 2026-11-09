package com.sembilansembilan.pertanyaanseputarramadhan.data

import com.sembilansembilan.pertanyaanseputarramadhan.imsakiyah.HijriCalendar
import java.time.DayOfWeek
import java.time.LocalDate

/**
 * Jenis puasa sunnah yang ditampilkan di layar "Puasa Sunnah".
 * [colorHex] dipakai sebagai titik warna pembeda di daftar (ARGB, cukup
 * gelap untuk teks putih bila dipakai sebagai latar chip).
 */
enum class SunnahFastType(
    val displayName: String,
    val description: String,
    val colorHex: Long,
) {
    SENIN_KAMIS(
        "Senin–Kamis",
        "Puasa sunnah setiap hari Senin dan Kamis.",
        0xFF7A5A2E
    ),
    AYYAMUL_BIDH(
        "Ayyamul Bidh",
        "Tanggal 13, 14, dan 15 setiap bulan Hijriah.",
        0xFF2F6F6A
    ),
    ARAFAH(
        "Arafah",
        "9 Dzulhijjah, sehari sebelum Iduladha.",
        0xFF2E6B34
    ),
    SYAWAL(
        "Puasa Syawal",
        "Enam hari pada 2–7 Syawal.",
        0xFF3E6B9C
    ),
    TARWIYAH(
        "Tarwiyah",
        "8 Dzulhijjah.",
        0xFF6B4E8E
    ),
    TASUA_ASYURA(
        "Tasu'a & Asyura",
        "9–10 Muharram.",
        0xFF8E3B46
    ),
}

/** Satu hari puasa sunnah: tanggal Masehi + padanan Hijriah + jenisnya. */
data class SunnahFastDay(
    val gregorian: LocalDate,
    val hijri: HijriCalendar.HijriDate,
    val type: SunnahFastType,
)

/**
 * Aturan puasa sunnah + daftar tanggal yang dihitung DINAMIS dari tanggal
 * Hijriah (algoritma Kuwaiti di [HijriCalendar]) — tidak ada hardcode
 * tahun tertentu, jadi daftar selalu mencakup 12 bulan ke depan dari
 * hari ini, tahun berapa pun.
 *
 * Pengecualian fikih yang diterapkan (agar tidak menyesatkan):
 * - Senin–Kamis dan Ayyamul Bidh TIDAK ditampilkan selama Ramadhan
 *   (bulan 9 Hijriah) karena puasa Ramadhan sudah wajib.
 * - Senin–Kamis TIDAK ditampilkan pada 1 Syawal (Idulfitri) dan
 *   10–13 Dzulhijjah (hari tasyrik) — puasa pada hari-hari itu haram.
 * - Ayyamul Bidh TIDAK ditampilkan pada 13 Dzulhijjah (hari tasyrik).
 * - Puasa Syawal hanya 2–7 Syawal (1 Syawal adalah Idulfitri).
 * - Satu tanggal bisa memuat dua jenis sekaligus (mis. Arafah yang jatuh
 *   pada hari Kamis) — keduanya ditampilkan sebagai entri terpisah.
 */
object SunnahFasting {

    /** Jenis-jenis puasa sunnah yang jatuh pada [date] (bisa kosong). */
    fun fastsOn(date: LocalDate): List<SunnahFastType> {
        val hijri = HijriCalendar.gregorianToHijri(date)
        return typesFor(date, hijri)
    }

    private fun typesFor(date: LocalDate, hijri: HijriCalendar.HijriDate): List<SunnahFastType> {
        val types = mutableListOf<SunnahFastType>()
        val isRamadhan = hijri.month == 9
        val isIdulFitri = hijri.month == 10 && hijri.day == 1
        val isTasyrik = hijri.month == 12 && hijri.day in 10..13

        if (!isRamadhan && !isIdulFitri && !isTasyrik &&
            (date.dayOfWeek == DayOfWeek.MONDAY || date.dayOfWeek == DayOfWeek.THURSDAY)
        ) {
            types += SunnahFastType.SENIN_KAMIS
        }
        if (!isRamadhan && !isTasyrik && hijri.day in 13..15) {
            types += SunnahFastType.AYYAMUL_BIDH
        }
        if (hijri.month == 12 && hijri.day == 8) {
            types += SunnahFastType.TARWIYAH
        }
        if (hijri.month == 12 && hijri.day == 9) {
            types += SunnahFastType.ARAFAH
        }
        if (hijri.month == 10 && hijri.day in 2..7) {
            types += SunnahFastType.SYAWAL
        }
        if (hijri.month == 1 && hijri.day in 9..10) {
            types += SunnahFastType.TASUA_ASYURA
        }
        return types
    }

    /**
     * Semua hari puasa sunnah mulai [from] selama [months] bulan ke depan
     * (default 12 bulan), terurut naik berdasarkan tanggal. Dihitung
     * dengan memindai hari demi hari dan mengonversi tiap tanggal ke
     * Hijriah — ±366 konversi, murah untuk sekali hitung.
     */
    fun upcoming(from: LocalDate = LocalDate.now(), months: Int = 12): List<SunnahFastDay> {
        val end = from.plusMonths(months.toLong())
        val result = mutableListOf<SunnahFastDay>()
        var day = from
        while (day.isBefore(end)) {
            val hijri = HijriCalendar.gregorianToHijri(day)
            for (type in typesFor(day, hijri)) {
                result += SunnahFastDay(gregorian = day, hijri = hijri, type = type)
            }
            day = day.plusDays(1)
        }
        return result
    }

    /** Puasa sunnah terdekat pada/ sesudah [from], atau null bila tidak ada. */
    fun nextFast(from: LocalDate = LocalDate.now()): SunnahFastDay? =
        upcoming(from).firstOrNull { it.gregorian >= from }
}
