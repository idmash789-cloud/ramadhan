package com.sembilansembilan.pertanyaanseputarramadhan.imsakiyah

import android.content.Context
import androidx.work.Data
import androidx.work.ExistingWorkPolicy
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.sembilansembilan.pertanyaanseputarramadhan.data.SunnahFastDay
import com.sembilansembilan.pertanyaanseputarramadhan.data.SunnahFasting
import java.time.Duration
import java.time.LocalDateTime
import java.time.LocalTime
import java.util.concurrent.TimeUnit

/**
 * Penjadwal pengingat puasa sunnah berbasis WorkManager (one-time work
 * berantai, pola sama seperti [ReminderScheduler]: tiap
 * [SunnahReminderWorker] yang jalan menjadwalkan pengingat berikutnya).
 *
 * - Pengingat = pukul 19:00, SEHARI SEBELUM tiap puasa sunnah.
 * - Unique work name sendiri ("sunnah_reminder") — berbeda dari
 *   pengingat sahur/berbuka ("ramadhan_reminder") agar keduanya bisa
 *   hidup berdampingan dan dibatalkan masing-masing.
 * - Bila waktu pengingat puasa terdekat sudah lewat, dipakai puasa
 *   berikutnya (dipindai sampai 13 bulan ke depan).
 *
 * CATATAN: sama seperti pengingat lama, WorkManager bersifat best-effort
 * — pengingat bisa tertunda saat Doze / hemat baterai. Untuk keandalan
 * penuh perlu izin exact-alarm (belum dipakai di MVP ini).
 */
object SunnahReminderScheduler {

    const val UNIQUE_WORK_NAME = "sunnah_reminder"

    /** Pengingat berbunyi pukul 19:00 sehari sebelum puasa. */
    private val REMINDER_TIME: LocalTime = LocalTime.of(19, 0)

    fun schedule(context: Context) {
        val now = LocalDateTime.now()
        val target = nextReminderTarget(now) ?: return
        val (fast, reminderTime) = target

        val delayMillis = Duration.between(now, reminderTime).toMillis().coerceAtLeast(0)
        val inputData = Data.Builder()
            .putString(SunnahReminderWorker.KEY_FAST_NAME, fast.type.displayName)
            .putString(SunnahReminderWorker.KEY_FAST_DATE, fast.gregorian.toString())
            .build()

        val request = OneTimeWorkRequestBuilder<SunnahReminderWorker>()
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
     * Puasa berikutnya beserta waktu pengingatnya: pengingat pertama
     * yang waktunya masih di masa depan.
     */
    private fun nextReminderTarget(now: LocalDateTime): Pair<SunnahFastDay, LocalDateTime>? {
        for (fast in SunnahFasting.upcoming(now.toLocalDate(), months = 13)) {
            val reminderTime = LocalDateTime.of(fast.gregorian.minusDays(1), REMINDER_TIME)
            if (reminderTime.isAfter(now)) {
                return fast to reminderTime
            }
        }
        return null
    }
}
