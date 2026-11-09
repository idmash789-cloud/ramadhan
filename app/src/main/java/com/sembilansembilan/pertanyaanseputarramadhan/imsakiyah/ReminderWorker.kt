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

/**
 * Menampilkan satu pengingat sahur / berbuka sebagai notifikasi lokal, lalu
 * menjadwalkan pengingat berikutnya lewat [ReminderScheduler].
 *
 * Input (inputData):
 * - "kind": "sahur" atau "buka".
 * - "city": nama kota.
 * - "imsak_time": waktu imsak "HH:mm" (hanya untuk kind "sahur").
 *
 * CATATAN: pengingat WorkManager bersifat best-effort — sistem bisa menunda
 * pekerjaan saat HP masuk Doze / hemat baterai. Untuk keandalan penuh perlu
 * izin exact-alarm (AlarmManager) yang belum dipakai di MVP ini.
 */
class ReminderWorker(
    appContext: Context,
    params: WorkerParameters,
) : CoroutineWorker(appContext, params) {

    override suspend fun doWork(): Result {
        val kind = inputData.getString(KEY_KIND) ?: return Result.success()
        val cityName = inputData.getString(KEY_CITY) ?: "Jakarta"
        val imsakTime = inputData.getString(KEY_IMSAK_TIME)

        when (kind) {
            KIND_SAHUR -> {
                val imsakText = imsakTime?.takeIf { it.isNotBlank() } ?: "??:??"
                showNotification(
                    id = NOTIFICATION_ID_SAHUR,
                    title = "Pengingat Sahur",
                    text = "Waktunya sahur — Imsak pukul $imsakText",
                )
            }
            KIND_BUKA -> {
                showNotification(
                    id = NOTIFICATION_ID_BUKA,
                    title = "Pengingat Berbuka",
                    text = "Waktunya berbuka — Selamat berbuka puasa",
                )
            }
            else -> return Result.success()
        }

        // Jadwalkan pengingat berikutnya (besok / sore ini).
        runCatching {
            ReminderScheduler.schedule(applicationContext, cityName)
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
        val notification = NotificationCompat.Builder(applicationContext, CHANNEL_ID)
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
        if (manager.getNotificationChannel(CHANNEL_ID) != null) return
        val channel = NotificationChannel(
            CHANNEL_ID,
            CHANNEL_NAME,
            NotificationManager.IMPORTANCE_DEFAULT,
        ).apply {
            description = "Pengingat waktu sahur dan berbuka puasa"
        }
        runCatching { manager.createNotificationChannel(channel) }
    }

    companion object {
        const val CHANNEL_ID = "ramadhan_reminders"
        const val CHANNEL_NAME = "Pengingat Ramadhan"
        const val KEY_KIND = "kind"
        const val KEY_CITY = "city"
        const val KEY_IMSAK_TIME = "imsak_time"
        const val KIND_SAHUR = "sahur"
        const val KIND_BUKA = "buka"
        const val NOTIFICATION_ID_SAHUR = 1001
        const val NOTIFICATION_ID_BUKA = 1002
    }
}
