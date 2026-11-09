package com.sembilansembilan.pertanyaanseputarramadhan.imsakiyah

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.sembilansembilan.pertanyaanseputarramadhan.data.SettingsStore
import kotlinx.coroutines.runBlocking

/**
 * Menjadwalkan ulang pengingat sahur/berbuka setelah HP selesai restart
 * (WorkManager tidak bertahan melewati reboot untuk one-time work).
 * Dideklarasikan di AndroidManifest dengan RECEIVE_BOOT_COMPLETED.
 */
class BootReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        if (context == null) return
        if (intent?.action != Intent.ACTION_BOOT_COMPLETED) return
        runCatching {
            val appContext = context.applicationContext
            val settings = runBlocking {
                SettingsStore(appContext).getSettings()
            }
            if (settings.remindersEnabled) {
                ReminderScheduler.schedule(appContext, settings.cityName)
            }
        }
    }
}
