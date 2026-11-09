package com.sembilansembilan.pertanyaanseputarramadhan.ui.screens

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import com.sembilansembilan.pertanyaanseputarramadhan.data.CITIES
import com.sembilansembilan.pertanyaanseputarramadhan.data.DarkMode
import com.sembilansembilan.pertanyaanseputarramadhan.imsakiyah.ReminderScheduler
import com.sembilansembilan.pertanyaanseputarramadhan.imsakiyah.SunnahReminderScheduler
import com.sembilansembilan.pertanyaanseputarramadhan.ui.SettingsViewModel
import com.sembilansembilan.pertanyaanseputarramadhan.ui.components.PLAY_STORE_URL
import com.sembilansembilan.pertanyaanseputarramadhan.ui.components.SectionTitle

@Composable
fun SettingsScreen(settingsVm: SettingsViewModel) {
    val settings by settingsVm.settings.collectAsState()
    val context = LocalContext.current
    var showCityDialog by remember { mutableStateOf(false) }

    val permissionLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { granted ->
        if (granted) {
            settingsVm.setRemindersEnabled(true)
            ReminderScheduler.schedule(context.applicationContext, settings.cityName)
        }
    }

    // QW-4: launcher izin sendiri untuk pengingat puasa sunnah (callback-nya
    // memanggil setter yang berbeda — JANGAN pakai ulang permissionLauncher).
    val sunnahPermissionLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { granted ->
        if (granted) {
            settingsVm.setSunnahRemindersEnabled(true)
            SunnahReminderScheduler.schedule(context.applicationContext)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        // (a) Mode gelap.
        SectionTitle("Mode Gelap")
        Card(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.padding(vertical = 4.dp)) {
                DarkModeOption(
                    label = "Sistem",
                    selected = settings.darkMode == DarkMode.SYSTEM,
                    onClick = { settingsVm.setDarkMode(DarkMode.SYSTEM) }
                )
                DarkModeOption(
                    label = "Terang",
                    selected = settings.darkMode == DarkMode.LIGHT,
                    onClick = { settingsVm.setDarkMode(DarkMode.LIGHT) }
                )
                DarkModeOption(
                    label = "Gelap",
                    selected = settings.darkMode == DarkMode.DARK,
                    onClick = { settingsVm.setDarkMode(DarkMode.DARK) }
                )
            }
        }

        // (b) Kota.
        SectionTitle("Kota")
        Card(modifier = Modifier.fillMaxWidth()) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                        text = "Kota saat ini",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Text(
                        text = settings.cityName,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.SemiBold
                    )
                }
                OutlinedButton(onClick = { showCityDialog = true }) {
                    Text("Pilih Kota")
                }
            }
        }

        // (c) Pengingat.
        SectionTitle("Pengingat")
        Card(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.padding(16.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Pengingat sahur & berbuka",
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.weight(1f)
                    )
                    Switch(
                        checked = settings.remindersEnabled,
                        onCheckedChange = { enabled ->
                            if (enabled) {
                                val needsPermission = Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU &&
                                    ContextCompat.checkSelfPermission(
                                        context,
                                        Manifest.permission.POST_NOTIFICATIONS
                                    ) != PackageManager.PERMISSION_GRANTED
                                if (needsPermission) {
                                    permissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
                                } else {
                                    settingsVm.setRemindersEnabled(true)
                                    ReminderScheduler.schedule(
                                        context.applicationContext,
                                        settings.cityName
                                    )
                                }
                            } else {
                                settingsVm.setRemindersEnabled(false)
                                ReminderScheduler.cancel(context.applicationContext)
                            }
                        }
                    )
                }
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Sahur 30 menit sebelum Imsak, berbuka saat Maghrib. Pengingat bersifat best-effort.",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                // QW-4: pengingat puasa sunnah (19:00 sehari sebelum puasa).
                Spacer(modifier = Modifier.height(12.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Pengingat puasa sunnah",
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.weight(1f)
                    )
                    Switch(
                        checked = settings.sunnahRemindersEnabled,
                        onCheckedChange = { enabled ->
                            if (enabled) {
                                val needsPermission = Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU &&
                                    ContextCompat.checkSelfPermission(
                                        context,
                                        Manifest.permission.POST_NOTIFICATIONS
                                    ) != PackageManager.PERMISSION_GRANTED
                                if (needsPermission) {
                                    sunnahPermissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
                                } else {
                                    settingsVm.setSunnahRemindersEnabled(true)
                                    SunnahReminderScheduler.schedule(
                                        context.applicationContext
                                    )
                                }
                            } else {
                                settingsVm.setSunnahRemindersEnabled(false)
                                SunnahReminderScheduler.cancel(context.applicationContext)
                            }
                        }
                    )
                }
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Pengingat pukul 19:00 sehari sebelum puasa sunnah (Senin–Kamis, Ayyamul Bidh, Arafah, Syawal, Tarwiyah, Tasu'a & Asyura). Pengingat bersifat best-effort.",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }

        // (d) Tentang.
        SectionTitle("Tentang")
        Card(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = "99 Pertanyaan Seputar Ramadhan",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = "Versi 3.0.0",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Panduan fikih umum, bukan fatwa personal.",
                    style = MaterialTheme.typography.bodyMedium
                )
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = {
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(PLAY_STORE_URL))
                        context.startActivity(intent)
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Beri rating di Play Store")
                }
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedButton(
                    onClick = {
                        val shareText = "Yuk belajar fikih puasa dengan 99 Pertanyaan Seputar Ramadhan: $PLAY_STORE_URL"
                        val intent = Intent(Intent.ACTION_SEND).apply {
                            type = "text/plain"
                            putExtra(Intent.EXTRA_TEXT, shareText)
                        }
                        context.startActivity(
                            Intent.createChooser(intent, "Bagikan aplikasi")
                        )
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Bagikan aplikasi")
                }
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Kebijakan Privasi: lihat PRIVACY_POLICY.md di repositori.",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }

    if (showCityDialog) {
        AlertDialog(
            onDismissRequest = { showCityDialog = false },
            title = { Text("Pilih Kota") },
            text = {
                LazyColumn {
                    items(CITIES, key = { it.name }) { city ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    settingsVm.setCityName(city.name)
                                    showCityDialog = false
                                }
                                .padding(vertical = 12.dp, horizontal = 4.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = city.name,
                                style = MaterialTheme.typography.bodyMedium,
                                fontWeight = if (city.name == settings.cityName) {
                                    FontWeight.Bold
                                } else {
                                    FontWeight.Normal
                                }
                            )
                            if (city.name == settings.cityName) {
                                Text(
                                    text = "✓",
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = MaterialTheme.colorScheme.primary
                                )
                            }
                        }
                    }
                }
            },
            confirmButton = {
                TextButton(onClick = { showCityDialog = false }) {
                    Text("Tutup")
                }
            }
        )
    }
}

@Composable
private fun DarkModeOption(
    label: String,
    selected: Boolean,
    onClick: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(
            selected = selected,
            onClick = onClick
        )
        Text(
            text = label,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}
