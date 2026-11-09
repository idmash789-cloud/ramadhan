package com.sembilansembilan.pertanyaanseputarramadhan.ui.screens

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
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
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Surface
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.sembilansembilan.pertanyaanseputarramadhan.imsakiyah.HijriCalendar
import com.sembilansembilan.pertanyaanseputarramadhan.ui.HomeViewModel
import com.sembilansembilan.pertanyaanseputarramadhan.ui.components.RamadhanHero
import com.sembilansembilan.pertanyaanseputarramadhan.ui.components.SectionTitle
import com.sembilansembilan.pertanyaanseputarramadhan.ui.theme.Champagne
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
        val summaryMaxHeight = LocalConfiguration.current.screenHeightDp.dp / 4
        RamadhanHero(
            modifier = Modifier.heightIn(max = summaryMaxHeight),
            contentPadding = PaddingValues(horizontal = 14.dp, vertical = 10.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth().verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(
                    "99 Pertanyaan Seputar Ramadhan",
                    style = MaterialTheme.typography.titleSmall,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.SemiBold
                )
                val eventTime = state.nextEventTime?.let { " · ${formatJam(it)}" }.orEmpty()
                Text(
                    "Menuju ${state.nextEventLabel}: ${formatHitungMundur(state.countdownMinutes)}$eventTime",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Champagne
                )
            }
        }

        val context = LocalContext.current
        OutlinedCard(
            modifier = Modifier.fillMaxWidth(),
            border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant)
        ) {
            Column(Modifier.padding(12.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
                Text(
                    "Jadwal Hari Ini",
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.SemiBold
                )
                Row(
                    horizontalArrangement = Arrangement.spacedBy(5.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        Icons.Filled.LocationOn, null,
                        modifier = Modifier.size(16.dp),
                        tint = MaterialTheme.colorScheme.primary
                    )
                    Text(state.city.name, style = MaterialTheme.typography.bodySmall)
                }
                val hijri = HijriCalendar.formatHijri(HijriCalendar.gregorianToHijri(state.date))
                Text(
                    "${formatTanggalIndonesia(state.date)} · $hijri (perkiraan)",
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                val times = state.times
                if (times == null) {
                    Text("Memuat…", style = MaterialTheme.typography.bodyMedium)
                } else {
                    val events = listOf(
                        "Imsak" to times.imsak, "Subuh" to times.fajr,
                        "Terbit" to times.sunrise, "Dzuhur" to times.dhuhr,
                        "Ashar" to times.asr, "Maghrib" to times.maghrib,
                        "Isya" to times.isha,
                    )
                    for (pair in events.chunked(2)) {
                        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                            for ((label, time) in pair) {
                                JadwalTile(label, time, Modifier.weight(1f))
                            }
                            if (pair.size == 1) Spacer(Modifier.weight(1f))
                        }
                    }
                }
                OutlinedButton(
                    onClick = {
                        if (!ScheduleImageCard.shareScheduleImage(context, state)) {
                            Toast.makeText(context, "Jadwal belum tersedia", Toast.LENGTH_SHORT).show()
                        }
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Icon(Icons.Filled.Share, null, modifier = Modifier.size(18.dp))
                    Spacer(Modifier.width(8.dp))
                    Text("Bagikan sebagai Gambar")
                }
            }
        }

        SectionTitle("Jelajahi Ramadhan")
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
        val menuHeight = 76.dp + with(androidx.compose.ui.platform.LocalDensity.current) {
            (MaterialTheme.typography.titleSmall.lineHeight * 3).toDp()
        }
        for (row in menu.chunked(2)) {
            Row(
                modifier = Modifier.fillMaxWidth().height(menuHeight),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                for (item in row) {
                    OutlinedCard(
                        onClick = item.onClick,
                        modifier = Modifier.weight(1f).fillMaxHeight(),
                        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant)
                    ) {
                        Column(
                            modifier = Modifier.fillMaxSize().padding(14.dp),
                            verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterVertically)
                        ) {
                            Surface(
                                color = MaterialTheme.colorScheme.primaryContainer,
                                contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                                shape = MaterialTheme.shapes.small
                            ) {
                                Box(Modifier.size(38.dp), contentAlignment = Alignment.Center) {
                                    Icon(item.icon, null, modifier = Modifier.size(21.dp))
                                }
                            }
                            Text(
                                text = item.title,
                                style = MaterialTheme.typography.titleSmall,
                                fontWeight = FontWeight.SemiBold
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
private fun JadwalTile(label: String, time: LocalTime, modifier: Modifier = Modifier) {
    val featured = label == "Imsak" || label == "Maghrib"
    Surface(
        modifier = modifier,
        color = if (featured) MaterialTheme.colorScheme.primaryContainer else MaterialTheme.colorScheme.surfaceVariant,
        contentColor = if (featured) MaterialTheme.colorScheme.onPrimaryContainer else MaterialTheme.colorScheme.onSurfaceVariant,
        shape = MaterialTheme.shapes.small
    ) {
        Text(
            text = "$label: ${formatJam(time)}",
            modifier = Modifier.padding(horizontal = 9.dp, vertical = 6.dp),
            style = MaterialTheme.typography.bodySmall,
            fontWeight = if (featured) FontWeight.SemiBold else FontWeight.Normal
        )
    }
}
