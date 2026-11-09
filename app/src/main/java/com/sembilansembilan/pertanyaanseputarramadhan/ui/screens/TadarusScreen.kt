package com.sembilansembilan.pertanyaanseputarramadhan.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.RadioButtonUnchecked
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.SelectableDates
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.sembilansembilan.pertanyaanseputarramadhan.ui.JUZ_LIST
import com.sembilansembilan.pertanyaanseputarramadhan.ui.JuzInfo
import com.sembilansembilan.pertanyaanseputarramadhan.ui.TadarusUiState
import com.sembilansembilan.pertanyaanseputarramadhan.ui.TadarusViewModel
import com.sembilansembilan.pertanyaanseputarramadhan.ui.components.SectionTitle
import com.sembilansembilan.pertanyaanseputarramadhan.ui.components.formatTanggalIndonesia
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneOffset
import java.util.Locale

/**
 * QW-5 (b): layar Tadarus — grid 30 juz (ketuk untuk centang), persentase
 * khatam, target tanggal khatam + kecepatan yang dibutuhkan, dan toggle
 * pengingat harian. Tanpa iklan.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TadarusScreen(tadarusVm: TadarusViewModel) {
    val state by tadarusVm.uiState.collectAsState()
    var showDatePicker by remember { mutableStateOf(false) }

    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.fillMaxSize()
    ) {
        item(span = { GridItemSpan(3) }) {
            ProgressCard(state)
        }
        item(span = { GridItemSpan(3) }) {
            TargetCard(
                state = state,
                onAturTarget = { showDatePicker = true },
                onHapusTarget = { tadarusVm.clearTargetDate() }
            )
        }
        item(span = { GridItemSpan(3) }) {
            ReminderCard(
                checked = state.reminderEnabled,
                onCheckedChange = { tadarusVm.setReminderEnabled(it) }
            )
        }
        item(span = { GridItemSpan(3) }) {
            SectionTitle("Daftar Juz")
        }
        items(JUZ_LIST, key = { it.number }) { juz ->
            JuzItem(
                juz = juz,
                done = juz.number in state.completedJuz,
                onToggle = { tadarusVm.toggleJuz(juz.number) }
            )
        }
        item(span = { GridItemSpan(3) }) {
            Text(
                text = "Progress tersimpan otomatis di perangkat ini.",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }

    if (showDatePicker) {
        val datePickerState = rememberDatePickerState(
            initialSelectedDateMillis = state.targetDate
                ?.atStartOfDay(ZoneOffset.UTC)?.toInstant()?.toEpochMilli(),
            selectableDates = object : SelectableDates {
                override fun isSelectableDate(utcTimeMillis: Long): Boolean {
                    val todayStart = LocalDate.now()
                        .atStartOfDay(ZoneOffset.UTC).toInstant().toEpochMilli()
                    return utcTimeMillis >= todayStart
                }
            }
        )
        DatePickerDialog(
            onDismissRequest = { showDatePicker = false },
            confirmButton = {
                TextButton(
                    onClick = {
                        datePickerState.selectedDateMillis?.let { millis ->
                            val date = Instant.ofEpochMilli(millis)
                                .atZone(ZoneOffset.UTC).toLocalDate()
                            tadarusVm.setTargetDate(date)
                        }
                        showDatePicker = false
                    },
                    enabled = datePickerState.selectedDateMillis != null
                ) {
                    Text("Pilih")
                }
            },
            dismissButton = {
                TextButton(onClick = { showDatePicker = false }) {
                    Text("Batal")
                }
            }
        ) {
            DatePicker(state = datePickerState)
        }
    }
}

@Composable
private fun ProgressCard(state: TadarusUiState) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "${state.completedCount} dari 30 juz",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "${state.percent}%",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            LinearProgressIndicator(
                progress = { state.percent / 100f },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = if (state.isKhatam) {
                    "Alhamdulillah, khatam 30 juz!"
                } else {
                    "Sisa ${state.remainingCount} juz lagi menuju khatam."
                },
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Composable
private fun TargetCard(
    state: TadarusUiState,
    onAturTarget: () -> Unit,
    onHapusTarget: () -> Unit,
) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Filled.DateRange,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Target Khatam",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.SemiBold
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            val target = state.targetDate
            if (target == null) {
                Text(
                    text = "Belum ada target tanggal khatam.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedButton(onClick = onAturTarget) {
                    Text("Atur Target Tanggal")
                }
            } else {
                Text(
                    text = "Target: ${formatTanggalIndonesia(target)}",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(modifier = Modifier.height(4.dp))
                // daysLeft lokal agar smart-cast Long? bekerja (getter custom
                // di TadarusUiState tidak bisa di-smart-cast langsung).
                val daysLeft = state.daysUntilTarget
                when {
                    state.isKhatam -> {
                        Text(
                            text = "Alhamdulillah, target tercapai!",
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                    daysLeft == null -> Unit
                    daysLeft < 0 -> {
                        Text(
                            text = "Target tanggal sudah lewat. Atur target baru.",
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                    daysLeft == 0L -> {
                        Text(
                            text = "Target hari ini \u2014 baca ${state.remainingCount} juz lagi hari ini.",
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                    else -> {
                        Text(
                            text = "Sisa $daysLeft hari lagi.",
                            style = MaterialTheme.typography.bodyMedium
                        )
                        state.juzPerDayNeeded?.let { pace ->
                            Text(
                                text = "Butuh ${formatPace(pace)} juz/hari agar khatam tepat waktu.",
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }
                    }
                }
                if (!state.isKhatam) {
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Perkiraan selesai: ${formatTanggalIndonesia(state.estimatedFinishDate)} bila membaca 1 juz setiap hari.",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Row {
                    OutlinedButton(onClick = onAturTarget) {
                        Text("Ubah Target")
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    TextButton(onClick = onHapusTarget) {
                        Text("Hapus Target")
                    }
                }
            }
        }
    }
}

@Composable
private fun ReminderCard(checked: Boolean, onCheckedChange: (Boolean) -> Unit) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Filled.Notifications,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary
            )
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 12.dp)
            ) {
                Text(
                    text = "Pengingat harian",
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = "Pengingat baca tadarus setiap hari (penjadwalan menyusul).",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            Switch(checked = checked, onCheckedChange = onCheckedChange)
        }
    }
}

@Composable
private fun JuzItem(juz: JuzInfo, done: Boolean, onToggle: () -> Unit) {
    Card(
        onClick = onToggle,
        colors = CardDefaults.cardColors(
            containerColor = if (done) {
                MaterialTheme.colorScheme.primaryContainer
            } else {
                MaterialTheme.colorScheme.surface
            }
        ),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                imageVector = if (done) {
                    Icons.Filled.CheckCircle
                } else {
                    Icons.Filled.RadioButtonUnchecked
                },
                contentDescription = if (done) "Selesai dibaca" else "Belum dibaca",
                tint = if (done) {
                    MaterialTheme.colorScheme.primary
                } else {
                    MaterialTheme.colorScheme.onSurfaceVariant
                }
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Juz ${juz.number}",
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center
            )
            Text(
                text = juz.startSurah,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                textAlign = TextAlign.Center
            )
        }
    }
}

/** "1" untuk 1,0 — "1,2" untuk 1,2 (koma desimal Indonesia). */
private fun formatPace(pace: Double): String {
    return if (pace % 1.0 == 0.0) {
        pace.toInt().toString()
    } else {
        String.format(Locale("id", "ID"), "%.1f", pace)
    }
}
