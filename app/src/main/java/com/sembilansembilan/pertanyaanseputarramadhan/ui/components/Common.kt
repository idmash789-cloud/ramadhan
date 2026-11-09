package com.sembilansembilan.pertanyaanseputarramadhan.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.util.Locale

private val indonesianLocale = Locale("id", "ID")

@Composable
fun SectionTitle(text: String) {
    Text(
        text = text,
        style = MaterialTheme.typography.titleMedium,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(vertical = 8.dp)
    )
}

@Composable
fun EmptyState(text: String) {
    Text(
        text = text,
        style = MaterialTheme.typography.bodyMedium,
        color = MaterialTheme.colorScheme.onSurfaceVariant,
        textAlign = TextAlign.Center,
        modifier = Modifier.padding(vertical = 16.dp)
    )
}

/** "Senin, 8 Februari 2027" */
fun formatTanggalIndonesia(date: LocalDate): String {
    val formatter = DateTimeFormatter.ofPattern("EEEE, d MMMM yyyy", indonesianLocale)
    return date.format(formatter)
}

/** "04:30" */
fun formatJam(time: LocalTime): String {
    return time.format(DateTimeFormatter.ofPattern("HH:mm"))
}

/** "1 j 23 mnt" untuk hitung mundur. */
fun formatHitungMundur(totalMenit: Long): String {
    if (totalMenit <= 0) return "0 mnt"
    val jam = totalMenit / 60
    val menit = totalMenit % 60
    return if (jam > 0) "$jam j $menit mnt" else "$menit mnt"
}
