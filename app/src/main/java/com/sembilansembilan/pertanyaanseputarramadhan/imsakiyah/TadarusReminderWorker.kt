package com.sembilansembilan.pertanyaanseputarramadhan.imsakiyah

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat
import androidx.work.CoroutineWorker
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkerParameters
import com.sembilansembilan.pertanyaanseputarramadhan.MainActivity
import com.sembilansembilan.pertanyaanseputarramadhan.data.SettingsStore
import java.time.Duration
import java.time.ZonedDateTime
import java.util.concurrent.TimeUnit

class TadarusReminderWorker(
    appContext: Context,
    params: WorkerParameters,
) : CoroutineWorker(appContext, params) {

    override suspend fun doWork(): Result {
        val context = applicationContext
        if (!SettingsStore(context).getSettings().tadarusReminderEnabled) return Result.success()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU &&
            ContextCompat.checkSelfPermission(
                context, Manifest.permission.POST_NOTIFICATIONS
            ) != PackageManager.PERMISSION_GRANTED
        ) return Result.success()

        context.getSystemService(NotificationManager::class.java)?.createNotificationChannel(
            NotificationChannel(
                ReminderWorker.CHANNEL_ID,
                ReminderWorker.CHANNEL_NAME,
                NotificationManager.IMPORTANCE_DEFAULT,
            )
        )
        val openApp = PendingIntent.getActivity(
            context,
            NOTIFICATION_ID,
            Intent(context, MainActivity::class.java)
                .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP),
            PendingIntent.FLAG_IMMUTABLE,
        )
        val notification = NotificationCompat.Builder(context, ReminderWorker.CHANNEL_ID)
            .setSmallIcon(android.R.drawable.ic_dialog_info)
            .setContentTitle("Pengingat Tadarus")
            .setContentText("Saatnya melanjutkan bacaan Al-Qur’an hari ini.")
            .setContentIntent(openApp)
            .setAutoCancel(true)
            .build()
        try {
            NotificationManagerCompat.from(context).notify(NOTIFICATION_ID, notification)
        } catch (_: SecurityException) {
            // Izin dapat dicabut setelah pemeriksaan.
        }
        return Result.success()
    }

    companion object {
        private const val WORK_NAME = "tadarus_daily_reminder"
        private const val NOTIFICATION_ID = 1004

        fun updateSchedule(context: Context, enabled: Boolean) {
            val workManager = WorkManager.getInstance(context)
            if (!enabled) {
                workManager.cancelUniqueWork(WORK_NAME)
                NotificationManagerCompat.from(context).cancel(NOTIFICATION_ID)
                return
            }

            val now = ZonedDateTime.now()
            val evening = now.withHour(19).withMinute(0).withSecond(0).withNano(0)
            val firstRun = if (evening.isBefore(now)) evening.plusDays(1) else evening
            val request = PeriodicWorkRequestBuilder<TadarusReminderWorker>(1, TimeUnit.DAYS)
                .setInitialDelay(Duration.between(now, firstRun).toMillis(), TimeUnit.MILLISECONDS)
                .build()
            workManager.enqueueUniquePeriodicWork(WORK_NAME, ExistingPeriodicWorkPolicy.KEEP, request)
        }
    }
}
