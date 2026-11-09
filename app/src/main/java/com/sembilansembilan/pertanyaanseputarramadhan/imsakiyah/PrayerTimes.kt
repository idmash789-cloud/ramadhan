package com.sembilansembilan.pertanyaanseputarramadhan.imsakiyah

import java.time.LocalDate
import java.time.LocalTime
import kotlin.math.abs
import kotlin.math.acos
import kotlin.math.asin
import kotlin.math.atan
import kotlin.math.atan2
import kotlin.math.cos
import kotlin.math.floor
import kotlin.math.sin
import kotlin.math.tan

/**
 * Jadwal salat & imsakiyah dihitung lokal (offline) dengan algoritma posisi
 * matahari gaya PrayTimes (metode standar Hamid Zarrabi-Zadeh).
 *
 * Parameter WAJIB mengikuti Kemenag / MABIMS:
 * - Sudut Subuh 20°, sudut Isya 18°.
 * - Terbit / terbenam matahari pada sudut -0,833° (refraksi + radius matahari).
 * - Ashar: faktor bayangan 1 (mazhab Syafi'i).
 * - Imsak = Subuh − 10 menit.
 * - Ihtiyat +2 menit untuk Subuh, Dzuhur, Ashar, Maghrib, dan Isya. Ihtiyat
 *   diterapkan DULU, lalu Imsak = Subuh (setelah ihtiyat) − 10 menit.
 *   Terbit matahari TANPA ihtiyat.
 *
 * PENTING: waktu hasil hitungan ini WAJIB dicocokkan dengan jadwal resmi
 * Kemenag (Jakarta) sebelum rilis — ini aproksimasi astronomis, bukan
 * jadwal resmi.
 */
object PrayerTimes {

    data class Times(
        val imsak: LocalTime,
        val fajr: LocalTime,
        val sunrise: LocalTime,
        val dhuhr: LocalTime,
        val asr: LocalTime,
        val maghrib: LocalTime,
        val isha: LocalTime,
    )

    private const val FAJR_ANGLE = 20.0
    private const val ISHA_ANGLE = 18.0
    private const val RISE_SET_ANGLE = 0.833
    private const val ASR_FACTOR = 1.0 // Syafi'i
    private const val IMSAK_OFFSET_MINUTES = 10L
    private const val IHTIYAT_MINUTES = 2L

    /**
     * Hitung ketujuh waktu untuk [date] pada posisi ([latitude], [longitude])
     * dengan [timezoneHours] = selisih dari UTC dalam jam. Tidak pernah crash:
     * koordinat dijepit ke rentang valid dan hasil NaN diganti nilai aman.
     */
    fun compute(
        date: LocalDate,
        latitude: Double,
        longitude: Double,
        timezoneHours: Double,
    ): Times {
        val lat = latitude.coerceIn(-90.0, 90.0)
        val lng = longitude.coerceIn(-180.0, 180.0)
        val tz = timezoneHours.coerceIn(-12.0, 14.0)
        val jd = julianDay(date.year, date.monthValue, date.dayOfMonth)

        // Posisi matahari pada tengah hari dipakai sebagai tebakan awal;
        // deklinasi & equation of time hanya berubah sedikit dalam sehari.
        val dhuhr = midDay(jd, 0.5)

        val fajr = sunAngleTime(jd, lat, FAJR_ANGLE, dhuhr, ccw = true)
        val sunrise = sunAngleTime(jd, lat, RISE_SET_ANGLE, dhuhr, ccw = true)
        val asr = asrTime(jd, lat, ASR_FACTOR, dhuhr)
        val sunset = sunAngleTime(jd, lat, RISE_SET_ANGLE, dhuhr, ccw = false)
        val maghrib = sunset // Kemenag: Maghrib = terbenam matahari.
        val isha = sunAngleTime(jd, lat, ISHA_ANGLE, dhuhr, ccw = false)

        // Koreksi zona waktu & bujur: jam lokal = jam matahari + (tz − lng/15).
        val adjust = tz - lng / 15.0
        val fajrMin = toMinutes(fajr + adjust)
        val sunriseMin = toMinutes(sunrise + adjust)
        val dhuhrMin = toMinutes(dhuhr + adjust)
        val asrMin = toMinutes(asr + adjust)
        val maghribMin = toMinutes(maghrib + adjust)
        val ishaMin = toMinutes(isha + adjust)

        // Ihtiyat +2 menit — DULU, sebelum Imsak diturunkan dari Subuh.
        val fajrSafe = (fajrMin + IHTIYAT_MINUTES).coerceIn(0, 1439)
        val dhuhrSafe = (dhuhrMin + IHTIYAT_MINUTES).coerceIn(0, 1439)
        val asrSafe = (asrMin + IHTIYAT_MINUTES).coerceIn(0, 1439)
        val maghribSafe = (maghribMin + IHTIYAT_MINUTES).coerceIn(0, 1439)
        val ishaSafe = (ishaMin + IHTIYAT_MINUTES).coerceIn(0, 1439)
        val sunriseSafe = sunriseMin.coerceIn(0, 1439) // tanpa ihtiyat
        val imsakSafe = (fajrSafe - IMSAK_OFFSET_MINUTES).coerceIn(0, 1439)

        return Times(
            imsak = fromMinutes(imsakSafe),
            fajr = fromMinutes(fajrSafe),
            sunrise = fromMinutes(sunriseSafe),
            dhuhr = fromMinutes(dhuhrSafe),
            asr = fromMinutes(asrSafe),
            maghrib = fromMinutes(maghribSafe),
            isha = fromMinutes(ishaSafe),
        )
    }

    // --- Algoritma posisi matahari (PrayTimes) ---

    /** Julian Day pada 00:00 UT di tanggal yang diminta. */
    private fun julianDay(year: Int, month: Int, day: Int): Double {
        var y = year
        var m = month
        if (m <= 2) {
            y -= 1
            m += 12
        }
        val a = floor(y / 100.0)
        val b = 2 - a + floor(a / 4.0)
        return floor(365.25 * (y + 4716)) + floor(30.6001 * (m + 1)) + day + b - 1524.5
    }

    /** Deklinasi matahari (derajat) dan equation of time (jam) pada [jd]. */
    private fun sunPosition(jd: Double): Pair<Double, Double> {
        val d = jd - 2451545.0
        val g = fixAngle(357.529 + 0.98560028 * d)
        val q = fixAngle(280.459 + 0.98564736 * d)
        val l = fixAngle(q + 1.915 * sinDeg(g) + 0.020 * sinDeg(2 * g))
        val e = 23.439 - 0.00000036 * d
        val declination = asinDeg(sinDeg(e) * sinDeg(l))
        val ra = atan2Deg(cosDeg(e) * sinDeg(l), cosDeg(l)) / 15.0
        val equation = q / 15.0 - fixHour(ra)
        return declination to equation
    }

    /** Tengah hari (Dzuhur astronomis, dalam jam 0–24) pada [jd]. */
    private fun midDay(jd: Double, time: Double): Double {
        val equation = sunPosition(jd + time / 24.0).second
        return fixHour(12 - equation)
    }

    /**
     * Waktu saat matahari berada pada sudut [angle] derajat di bawah/atas
     * ufuk. [ccw] = true untuk waktu pagi (sebelum tengah hari).
     */
    private fun sunAngleTime(jd: Double, lat: Double, angle: Double, time: Double, ccw: Boolean): Double {
        val declination = sunPosition(jd + time / 24.0).first
        val noon = midDay(jd, time)
        val numerator = -sinDeg(angle) - sinDeg(declination) * sinDeg(lat)
        val denominator = cosDeg(declination) * cosDeg(lat)
        // Jepit agar acos tidak NaN di lintang ekstrem (siang/malam kutub).
        val ratio = (numerator / denominator).coerceIn(-1.0, 1.0)
        val t = acosDeg(ratio) / 15.0
        return if (ccw) noon - t else noon + t
    }

    /** Waktu Ashar: saat panjang bayangan = [factor] × tinggi benda + bayangan Dzuhur. */
    private fun asrTime(jd: Double, lat: Double, factor: Double, time: Double): Double {
        val declination = sunPosition(jd + time / 24.0).first
        val angle = -arccotDeg(factor + tanDeg(abs(lat - declination)))
        return sunAngleTime(jd, lat, angle, time, ccw = false)
    }

    // --- Util trigonometri derajat & normalisasi ---

    private fun fixAngle(angle: Double): Double = angle - 360.0 * floor(angle / 360.0)

    private fun fixHour(hour: Double): Double = hour - 24.0 * floor(hour / 24.0)

    private fun sinDeg(deg: Double): Double = sin(Math.toRadians(deg))

    private fun cosDeg(deg: Double): Double = cos(Math.toRadians(deg))

    private fun tanDeg(deg: Double): Double = tan(Math.toRadians(deg))

    private fun asinDeg(x: Double): Double = Math.toDegrees(asin(x.coerceIn(-1.0, 1.0)))

    private fun acosDeg(x: Double): Double = Math.toDegrees(acos(x.coerceIn(-1.0, 1.0)))

    private fun atan2Deg(y: Double, x: Double): Double = Math.toDegrees(atan2(y, x))

    private fun arccotDeg(x: Double): Double = Math.toDegrees(atan(1.0 / x))

    /** Jam desimal (0–24) → menit sejak 00:00, dibulatkan ke menit terdekat. */
    private fun toMinutes(hours: Double): Long {
        if (hours.isNaN() || hours.isInfinite()) return 12 * 60L // fallback aman: 12:00
        val fixed = fixHour(hours)
        val total = (fixed * 60.0 + 0.5).toLong()
        return total.coerceIn(0, 1439)
    }

    private fun fromMinutes(minutes: Long): LocalTime {
        val m = minutes.coerceIn(0, 1439).toInt()
        return LocalTime.of(m / 60, m % 60)
    }
}
