package com.sembilansembilan.pertanyaanseputarramadhan.imsakiyah

import java.time.LocalDate
import kotlin.math.ceil
import kotlin.math.floor

/**
 * Konversi Masehi ↔ Hijriah dengan algoritma Kuwaiti (kalender tabular
 * Umm al-Qura, 30 tahun / 10631 hari per siklus). Pure logic, tanpa
 * dependensi baru, tanpa jaringan — cocok untuk pemakaian offline.
 *
 * CATATAN KEJUJURAN (validasi 9 Nov 2026, dihitung di luar aplikasi lalu
 * dicocokkan dengan tanggal yang diketahui):
 * - TEPAT (selisih 0 hari): 1 Ramadhan 1448H = 8 Feb 2027; 1 Syawal 1448H
 *   = 10 Mar 2027 (dalam rentang perkiraan 9/10 Mar 2027); 1 Ramadhan
 *   1446H = 1 Mar 2025; 1 Syawal 1447H = 20 Mar 2026; Arafah 1447H
 *   (9 Dzulhijjah) = 26 Mei 2026; Iduladha 1447H = 27 Mei 2026.
 * - MELESET 1 HARI (algoritma 1 hari LEBIH LAMBAT dari penetapan
 *   pemerintah): 1 Muharram 1448H → algoritma 17 Jun 2026, pemerintah
 *   16 Jun 2026 (PBNU 17 Jun 2026); Tasu'a 1448H → 25 Jun 2026 (umumnya
 *   24 Jun 2026); Asyura 1448H → 26 Jun 2026 (umumnya 25 Jun 2026);
 *   1 Ramadhan 1447H → 20 Feb 2026 (Kemenag 19 Feb 2026).
 * - Selisih maksimum yang teramati = 1 hari, dan TIDAK searah konsisten
 *   (6 dari 10 jangkar tepat, 4 meleset 1 hari), jadi TIDAK ada koreksi
 *   epoch/konstanta global yang bisa diterapkan tanpa merusak jangkar
 *   yang sudah tepat. Inilah sifat kalender tabular vs penetapan
 *   rukyat/hisab resmi — karena itu layar Puasa Sunnah WAJIB menampilkan
 *   label "Tanggal Hijriah perkiraan, bisa selisih ±1 hari dari penetapan
 *   resmi pemerintah."
 * - Round-trip gregorianToHijri → hijriToGregorian: 0 kegagalan pada
 *   400 hari berturut-turut mulai 9 Nov 2026 (algoritma konsisten
 *   dengan inversnya sendiri).
 *
 * Detail teknis: pembagian bilangan bulat di rumus memakai pembagian
 * Int Kotlin (pemotongan ke nol, seperti C), BUKAN floor — penting untuk
 * bulan Januari–Februari karena (bulan − 14) negatif. Jangan ganti
 * dengan pembagian floor.
 */
object HijriCalendar {

    /** Satu tanggal Hijriah. [month] 1 = Muharram … 12 = Zulhijjah. */
    data class HijriDate(val year: Int, val month: Int, val day: Int)

    private val MONTH_NAMES = listOf(
        "Muharram", "Safar", "Rabiulawal", "Rabiulakhir",
        "Jumadilawal", "Jumadilakhir", "Rajab", "Sya'ban",
        "Ramadhan", "Syawal", "Zulkaidah", "Zulhijjah"
    )

    /** Nama bulan Hijriah dalam Bahasa Indonesia, [month] 1–12. */
    fun monthName(month: Int): String =
        MONTH_NAMES.getOrNull(month - 1) ?: "Bulan $month"

    /** "13 Ramadhan 1448 H". */
    fun formatHijri(hijri: HijriDate): String =
        "${hijri.day} ${monthName(hijri.month)} ${hijri.year} H"

    /** Masehi → Hijriah (algoritma Kuwaiti). */
    fun gregorianToHijri(date: LocalDate): HijriDate {
        val y = date.year
        val m = date.monthValue
        val d = date.dayOfMonth
        // Julian Day Number — (m - 14) / 12 adalah pembagian Int (trunc).
        val julianDay = floor(1461.0 * (y + 4800 + (m - 14) / 12) / 4.0) +
            floor(367.0 * (m - 2 - 12 * ((m - 14) / 12)) / 12.0) -
            floor(3 * floor((y + 4900 + (m - 14) / 12) / 100.0) / 4.0) +
            d - 32075
        var l = julianDay - 1948440 + 10632
        val n = floor((l - 1) / 10631.0)
        l = l - 10631 * n + 354
        val j = floor((10985 - l) / 5316.0) * floor(50 * l / 17719.0) +
            floor(l / 5670.0) * floor(43 * l / 15238.0)
        l = l - floor((30 - j) / 15.0) * floor(17719 * j / 50.0) -
            floor(j / 16.0) * floor(15238 * j / 43.0) + 29
        val month = floor(24 * l / 709.0).toInt()
        val day = (l - floor(709 * month / 24.0)).toInt()
        val year = (30 * n + j - 30).toInt()
        return HijriDate(year = year, month = month, day = day)
    }

    /** Hijriah → Masehi (invers algoritma Kuwaiti). */
    fun hijriToGregorian(hijri: HijriDate): LocalDate {
        val jd = hijri.day + ceil(29.5 * (hijri.month - 1)) +
            (hijri.year - 1) * 354 +
            floor((3 + 11 * hijri.year) / 30.0) + 1948440 - 1
        var l = jd + 68569
        val n = floor(4 * l / 146097.0)
        l = l - floor((146097 * n + 3) / 4.0)
        val i = floor(4000 * (l + 1) / 1461001.0)
        l = l - floor(1461 * i / 4.0) + 31
        val j = floor(80 * l / 2447.0)
        val day = (l - floor(2447 * j / 80.0)).toInt()
        l = floor(j / 11.0)
        val month = (j + 2 - 12 * l).toInt()
        val year = (100 * (n - 49) + i + l).toInt()
        return LocalDate.of(year, month, day)
    }
}
