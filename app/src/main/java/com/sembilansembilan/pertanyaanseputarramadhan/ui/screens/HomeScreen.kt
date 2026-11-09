package com.sembilansembilan.pertanyaanseputarramadhan.ui.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Article
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.Calculate
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Forum
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material.icons.filled.QuestionAnswer
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.sembilansembilan.pertanyaanseputarramadhan.imsakiyah.HijriCalendar
import com.sembilansembilan.pertanyaanseputarramadhan.ui.HomeViewModel
import com.sembilansembilan.pertanyaanseputarramadhan.ui.components.SectionTitle
import com.sembilansembilan.pertanyaanseputarramadhan.ui.components.formatHitungMundur
import com.sembilansembilan.pertanyaanseputarramadhan.ui.components.formatJam
import com.sembilansembilan.pertanyaanseputarramadhan.ui.components.formatTanggalIndonesia
import com.sembilansembilan.pertanyaanseputarramadhan.util.ScheduleImageCard
import java.time.LocalTime

@Composable
fun HomeScreen(
    homeVm: HomeViewModel,
    onOpenQuestions: () -> Unit,
    onOpenBukuSaku: () -> Unit,
    onOpenNu: () -> Unit,
    onOpenPiss: () -> Unit,
    onOpenKultum: () -> Unit,
    onOpenZakat: () -> Unit,
    onOpenSunnah: () -> Unit,
    onOpenTadarus: () -> Unit,
) {
    val state by homeVm.uiState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Kartu hero.
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary
            )
        ) {
            Column(modifier = Modifier.padding(20.dp)) {
                Text(
                    text = "99 Pertanyaan Seputar Ramadhan",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Panduan puasa dengan dalil yang shahih",
                    style = MaterialTheme.typography.bodyMedium
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = formatTanggalIndonesia(state.date),
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.SemiBold
                )
                // QW-3: tanggal Hijriah hari ini (perkiraan, ±1 hari) —
                // label tahun Hijriah di Beranda, mis. "1 Ramadhan 1448 H".
                Text(
                    text = "${HijriCalendar.formatHijri(HijriCalendar.gregorianToHijri(state.date))} (perkiraan)",
                    style = MaterialTheme.typography.bodyMedium
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Filled.LocationOn,
                        contentDescription = null,
                        modifier = Modifier.size(16.dp)
                    )
                    Text(
                        text = state.city.name,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }

        // Kartu hitung mundur ke Imsak / Berbuka.
        Card(modifier = Modifier.fillMaxWidth()) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Menuju ${state.nextEventLabel}",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = formatHitungMundur(state.countdownMinutes),
                    style = MaterialTheme.typography.displaySmall,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary,
                    textAlign = TextAlign.Center
                )
                state.nextEventTime?.let { target ->
                    Text(
                        text = "Pukul ${formatJam(target)}",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }

        // Kartu jadwal hari ini.
        Card(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.padding(16.dp)) {
                SectionTitle("Jadwal Hari Ini")
                val times = state.times
                if (times == null) {
                    Text(
                        text = "Memuat…",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                } else {
                    JadwalRow("Imsak", times.imsak)
                    JadwalRow("Subuh", times.fajr)
                    JadwalRow("Terbit", times.sunrise)
                    JadwalRow("Dzuhur", times.dhuhr)
                    JadwalRow("Ashar", times.asr)
                    JadwalRow("Maghrib", times.maghrib)
                    JadwalRow("Isya", times.isha)
                }
            }
        }

        // Bagikan jadwal hari ini sebagai gambar (QW-5).
        val context = LocalContext.current
        Button(
            onClick = {
                val ok = ScheduleImageCard.shareScheduleImage(context, state)
                if (!ok) {
                    Toast.makeText(context, "Jadwal belum tersedia", Toast.LENGTH_SHORT).show()
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(
                imageVector = Icons.Filled.Share,
                contentDescription = null
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text("Bagikan sebagai Gambar")
        }

        val menu = listOf(
            HomeMenuItem("Buku Saku Ramadhan", Icons.Filled.MenuBook, onOpenBukuSaku),
            HomeMenuItem("99 Pertanyaan", Icons.Filled.QuestionAnswer, onOpenQuestions),
            HomeMenuItem("Kajian Tambahan", Icons.Filled.Article, onOpenNu),
            HomeMenuItem("Tanya Jawab Tambahan", Icons.Filled.Forum, onOpenPiss),
            HomeMenuItem("Kultum Ramadhan", Icons.Filled.Mic, onOpenKultum),
            HomeMenuItem("Kalkulator Zakat", Icons.Filled.Calculate, onOpenZakat),
            HomeMenuItem("Puasa Sunnah", Icons.Filled.DateRange, onOpenSunnah),
            HomeMenuItem("Tadarus 30 Juz", Icons.Filled.Book, onOpenTadarus),
        )
        val menuHeight = 72.dp + with(androidx.compose.ui.platform.LocalDensity.current) {
            (MaterialTheme.typography.titleSmall.lineHeight * 3).toDp()
        }
        for (row in menu.chunked(2)) {
            Row(
                modifier = Modifier.fillMaxWidth().height(menuHeight),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                for (item in row) {
                    ElevatedCard(onClick = item.onClick, modifier = Modifier.weight(1f).fillMaxHeight()) {
                        Column(
                            modifier = Modifier.fillMaxSize().padding(10.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Icon(
                                imageVector = item.icon,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.primary,
                                modifier = Modifier.size(28.dp)
                            )
                            Spacer(Modifier.height(8.dp))
                            Text(
                                text = item.title,
                                style = MaterialTheme.typography.titleSmall,
                                fontWeight = FontWeight.SemiBold,
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                }
            }
        }

        Text(
            text = "Panduan fikih umum, bukan fatwa personal.",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )

    }
}

private data class HomeMenuItem(val title: String, val icon: ImageVector, val onClick: () -> Unit)

@Composable
private fun JadwalRow(label: String, time: LocalTime) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.bodyMedium
        )
        Text(
            text = formatJam(time),
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.SemiBold
        )
    }
}
