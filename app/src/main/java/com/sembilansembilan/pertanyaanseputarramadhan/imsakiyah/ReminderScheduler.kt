package com.sembilansembilan.pertanyaanseputarramadhan.imsakiyah

import android.content.Context
import androidx.work.Data
import androidx.work.ExistingWorkPolicy
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.sembilansembilan.pertanyaanseputarramadhan.data.cityByName
import java.time.Duration
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.util.concurrent.TimeUnit

/**
 * Penjadwal pengingat sahur & berbuka berbasis WorkManager (one-time work
 * berantai: tiap [ReminderWorker] yang jalan menjadwalkan pengingat
 * berikutnya).
 *
 * - Pengingat sahur = Imsak − 30 menit.
 * - Pengingat berbuka = Maghrib.
 * - Bila kedua event hari ini sudah lewat, dipakai pengingat sahur besok.
 *
 * CATATAN: WorkManager bersifat best-effort — pengingat bisa tertunda saat
 * Doze / hemat baterai. Untuk keandalan penuh perlu izin exact-alarm.
 */
object ReminderScheduler {

    const val UNIQUE_WORK_NAME = "ramadhan_reminder"

    private val TIME_FORMATTER: DateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm")

    fun schedule(context: Context, cityName: String) {
        val city = cityByName(cityName)
        val now = LocalDateTime.now()

        // Cari event berikutnya: sahur hari ini → buka hari ini → sahur besok.
        val next = nextEvent(now, city.latitude, city.longitude, city.timezoneHours)
            ?: return
        val (kind, eventTime, imsakTime) = next

        val delayMillis = Duration.between(now, eventTime).toMillis().coerceAtLeast(0)
        val inputData = Data.Builder()
            .putString(ReminderWorker.KEY_KIND, kind)
            .putString(ReminderWorker.KEY_CITY, city.name)
            .apply {
                if (kind == ReminderWorker.KIND_SAHUR && imsakTime != null) {
                    putString(ReminderWorker.KEY_IMSAK_TIME, imsakTime.format(TIME_FORMATTER))
                }
            }
            .build()

        val request = OneTimeWorkRequestBuilder<ReminderWorker>()
            .setInitialDelay(delayMillis, TimeUnit.MILLISECONDS)
            .setInputData(inputData)
            .build()

        WorkManager.getInstance(context).enqueueUniqueWork(
            UNIQUE_WORK_NAME,
            ExistingWorkPolicy.REPLACE,
            request,
        )
    }

    fun cancel(context: Context) {
        WorkManager.getInstance(context).cancelUniqueWork(UNIQUE_WORK_NAME)
    }

    /**
     * Event berikutnya sebagai Triple(kind, waktu event, waktu imsak).
     * Waktu imsak hanya diisi untuk kind "sahur" (ditampilkan di notifikasi).
     */
    private fun nextEvent(
        now: LocalDateTime,
        latitude: Double,
        longitude: Double,
        timezoneHours: Double,
    ): Triple<String, LocalDateTime, LocalTime?>? {
        val today: LocalDate = now.toLocalDate()
        val todayTimes = PrayerTimes.compute(today, latitude, longitude, timezoneHours)

        val sahurReminderToday = LocalDateTime.of(today, todayTimes.imsak.minusMinutes(30))
        if (now.isBefore(sahurReminderToday)) {
            return Triple(ReminderWorker.KIND_SAHUR, sahurReminderToday, todayTimes.imsak)
        }
        val bukaToday = LocalDateTime.of(today, todayTimes.maghrib)
        if (now.isBefore(bukaToday)) {
            return Triple(ReminderWorker.KIND_BUKA, bukaToday, null)
        }

        val tomorrow = today.plusDays(1)
        val tomorrowTimes = PrayerTimes.compute(tomorrow, latitude, longitude, timezoneHours)
        val sahurReminderTomorrow = LocalDateTime.of(tomorrow, tomorrowTimes.imsak.minusMinutes(30))
        return Triple(ReminderWorker.KIND_SAHUR, sahurReminderTomorrow, tomorrowTimes.imsak)
    }
}
