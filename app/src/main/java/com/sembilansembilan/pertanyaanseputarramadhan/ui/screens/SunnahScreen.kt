package com.sembilansembilan.pertanyaanseputarramadhan.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.sembilansembilan.pertanyaanseputarramadhan.data.SunnahFastDay
import com.sembilansembilan.pertanyaanseputarramadhan.data.SunnahFastType
import com.sembilansembilan.pertanyaanseputarramadhan.imsakiyah.HijriCalendar
import com.sembilansembilan.pertanyaanseputarramadhan.ui.SunnahViewModel
import com.sembilansembilan.pertanyaanseputarramadhan.ui.components.EmptyState
import com.sembilansembilan.pertanyaanseputarramadhan.ui.components.formatTanggalIndonesia
import java.time.LocalDate
import java.time.YearMonth
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit
import java.util.Locale

/**
 * Layar "Puasa Sunnah": puasa berikutnya + daftar tanggal puasa sunnah
 * 12 bulan ke depan (Senin–Kamis, Ayyamul Bidh, Arafah, Puasa Syawal,
 * Tarwiyah, Tasu'a & Asyura), dikelompokkan per bulan Masehi, dengan
 * filter per jenis. Tiap entri menampilkan tanggal Masehi + tanggal
 * Hijriah + nama jenis + keterangan, dengan titik warna berbeda per jenis.
 * TANPA iklan.
 */
@Composable
fun SunnahScreen(sunnahVm: SunnahViewModel) {
    val fasts by sunnahVm.filteredFasts.collectAsState()
    val nextFast by sunnahVm.nextFast.collectAsState()
    val selectedType by sunnahVm.selectedType.collectAsState()
    val today = LocalDate.now()
    val grouped = fasts.groupBy { YearMonth.from(it.gregorian) }

    Column(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
        ) {
            item(key = "disclaimer") {
                DisclaimerCard()
            }

            nextFast?.let { next ->
                item(key = "next") {
                    NextFastCard(next, today)
                }
            }

            item(key = "filter") {
                LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    item(key = "filter-semua") {
                        FilterChip(
                            selected = selectedType == null,
                            onClick = { sunnahVm.selectType(null) },
                            label = { Text("Semua") }
                        )
                    }
                    items(SunnahFastType.values(), key = { it.name }) { type ->
                        FilterChip(
                            selected = selectedType == type,
                            onClick = { sunnahVm.selectType(type) },
                            label = { Text(type.displayName) }
                        )
                    }
                }
            }

            if (fasts.isEmpty()) {
                item(key = "empty") {
                    EmptyState("Tidak ada puasa sunnah untuk filter ini.")
                }
            } else {
                for ((month, days) in grouped) {
                    item(key = "header-$month") {
                        Text(
                            text = month.format(
                                DateTimeFormatter.ofPattern("MMMM yyyy", Locale("id", "ID"))
                            ),
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(top = 8.dp)
                        )
                    }
                    items(days, key = { "${it.gregorian}-${it.type}" }) { fast ->
                        SunnahFastCard(fast, today)
                    }
                }
            }
        }
    }
}

@Composable
private fun DisclaimerCard() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            contentColor = MaterialTheme.colorScheme.onPrimaryContainer
        )
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Tanggal Hijriah perkiraan, bisa selisih ±1 hari dari penetapan resmi pemerintah.",
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Tanggal Hijriah dihitung dengan algoritma Kuwaiti (Umm al-Qura). Cocokkan dengan pengumuman Kemenag untuk kepastian. Puasa Senin–Kamis dan Ayyamul Bidh tidak ditampilkan selama Ramadhan karena puasa Ramadhan sudah wajib.",
                style = MaterialTheme.typography.bodySmall
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Pengingat muncul pukul 19:00 sehari sebelum puasa. Aktifkan di Pengaturan → Pengingat puasa sunnah.",
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}

@Composable
private fun NextFastCard(next: SunnahFastDay, today: LocalDate) {
    val daysUntil = ChronoUnit.DAYS.between(today, next.gregorian)
    val label = when (daysUntil) {
        0L -> "Hari ini"
        1L -> "Besok"
        else -> "$daysUntil hari lagi"
    }
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.onPrimary
        )
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Puasa sunnah berikutnya",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = next.type.displayName,
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "${formatTanggalIndonesia(next.gregorian)} • ${HijriCalendar.formatHijri(next.hijri)}",
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = label,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}

@Composable
private fun SunnahFastCard(fast: SunnahFastDay, today: LocalDate) {
    val daysUntil = ChronoUnit.DAYS.between(today, fast.gregorian)
    Card(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(12.dp)
                    .clip(CircleShape)
                    .background(Color(fast.type.colorHex))
            )
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 12.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = fast.type.displayName,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.weight(1f)
                    )
                    if (daysUntil == 0L || daysUntil == 1L) {
                        Text(
                            text = if (daysUntil == 0L) "Hari ini" else "Besok",
                            style = MaterialTheme.typography.labelMedium,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                }
                Text(
                    text = formatTanggalIndonesia(fast.gregorian),
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    text = HijriCalendar.formatHijri(fast.hijri),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Text(
                    text = fast.type.description,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}
