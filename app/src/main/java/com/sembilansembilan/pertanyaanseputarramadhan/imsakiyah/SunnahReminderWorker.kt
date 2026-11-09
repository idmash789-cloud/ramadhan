package com.sembilansembilan.pertanyaanseputarramadhan.imsakiyah

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale

/**
 * Menampilkan satu pengingat puasa sunnah sebagai notifikasi lokal, lalu
 * menjadwalkan pengingat berikutnya lewat [SunnahReminderScheduler].
 *
 * Input (inputData):
 * - "fast_name": nama jenis puasa, mis. "Ayyamul Bidh".
 * - "fast_date": tanggal puasa dalam ISO-8601, mis. "2027-02-20".
 *
 * Isi notifikasi: "Besok puasa sunnah: <nama> (<tanggal>)".
 * Channel notifikasi dipakai bersama pengingat sahur/berbuka
 * ([ReminderWorker.CHANNEL_ID]) — satu channel "Pengingat Ramadhan".
 *
 * CATATAN: pengingat WorkManager bersifat best-effort — sistem bisa
 * menunda pekerjaan saat HP masuk Doze / hemat baterai. Untuk keandalan
 * penuh perlu izin exact-alarm (AlarmManager) yang belum dipakai di MVP ini.
 */
class SunnahReminderWorker(
    appContext: Context,
    params: WorkerParameters,
) : CoroutineWorker(appContext, params) {

    override suspend fun doWork(): Result {
        val fastName = inputData.getString(KEY_FAST_NAME) ?: return Result.success()
        val fastDateIso = inputData.getString(KEY_FAST_DATE) ?: return Result.success()
        val fastDate = runCatching { LocalDate.parse(fastDateIso) }.getOrNull()
            ?: return Result.success()

        showNotification(
            id = NOTIFICATION_ID_SUNNAH,
            title = "Pengingat Puasa Sunnah",
            text = "Besok puasa sunnah: $fastName (${formatTanggalIndonesia(fastDate)})",
        )

        // Jadwalkan pengingat puasa sunnah berikutnya.
        runCatching {
            SunnahReminderScheduler.schedule(applicationContext)
        }
        return Result.success()
    }

    private fun showNotification(id: Int, title: String, text: String) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU &&
            ContextCompat.checkSelfPermission(
                applicationContext,
                Manifest.permission.POST_NOTIFICATIONS,
            ) != PackageManager.PERMISSION_GRANTED
        ) return

        createChannelIfNeeded()
        val notification = NotificationCompat.Builder(applicationContext, ReminderWorker.CHANNEL_ID)
            .setSmallIcon(android.R.drawable.ic_dialog_info)
            .setContentTitle(title)
            .setContentText(text)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setAutoCancel(true)
            .build()
        try {
            NotificationManagerCompat.from(applicationContext).notify(id, notification)
        } catch (_: SecurityException) {
            // Izin dapat dicabut setelah pemeriksaan di atas.
        }
    }

    private fun createChannelIfNeeded() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O) return
        val manager = applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as? NotificationManager
            ?: return
        if (manager.getNotificationChannel(ReminderWorker.CHANNEL_ID) != null) return
        val channel = NotificationChannel(
            ReminderWorker.CHANNEL_ID,
            ReminderWorker.CHANNEL_NAME,
            NotificationManager.IMPORTANCE_DEFAULT,
        ).apply {
            description = "Pengingat waktu sahur dan berbuka puasa"
        }
        runCatching { manager.createNotificationChannel(channel) }
    }

    companion object {
        const val KEY_FAST_NAME = "fast_name"
        const val KEY_FAST_DATE = "fast_date"
        const val NOTIFICATION_ID_SUNNAH = 1003
    }
}

/** "Sabtu, 20 Februari 2027" — format lokal, tanpa dependensi UI. */
private fun formatTanggalIndonesia(date: LocalDate): String {
    val formatter = DateTimeFormatter.ofPattern("EEEE, d MMMM yyyy", Locale("id", "ID"))
    return date.format(formatter)
}
