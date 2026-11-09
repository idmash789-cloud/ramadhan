package com.sembilansembilan.pertanyaanseputarramadhan.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

private val boldRegex = Regex("""\*\*(.+?)\*\*""")
private val arabicRegex = Regex("""[\u0600-\u06FF]""")
private val numberedRegex = Regex("""^\d+\.\s+.*""")

/**
 * Render konten Buku Saku baris per baris. Perbaikan bug web: teks tebal
 * di tengah kalimat ("**1 mud** (sekitar 675 gram)") kini dirender dengan
 * benar lewat [parseInlineBold], dan tabel "| ... |" dirender sebagai
 * tabel sungguhan, bukan dibuang.
 */
@Composable
fun MarkdownText(content: String, modifier: Modifier = Modifier) {
    val lines = content.split("\n")
    Column(modifier = modifier.fillMaxWidth()) {
        var index = 0
        while (index < lines.size) {
            val rawLine = lines[index]
            val line = rawLine.trim()

            when {
                line.isEmpty() -> {
                    Spacer(modifier = Modifier.height(4.dp))
                    index++
                }
                line.startsWith("## ") -> {
                    Text(
                        text = line.removePrefix("## ").trim(),
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.padding(top = 12.dp, bottom = 4.dp)
                    )
                    index++
                }
                line.startsWith("### ") -> {
                    Text(
                        text = line.removePrefix("### ").trim(),
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.padding(top = 8.dp, bottom = 4.dp)
                    )
                    index++
                }
                line == "---" -> {
                    Divider(modifier = Modifier.padding(vertical = 8.dp))
                    index++
                }
                line.startsWith("|") -> {
                    // Kumpulkan baris-baris tabel yang berurutan.
                    val tableLines = mutableListOf<String>()
                    while (index < lines.size && lines[index].trim().startsWith("|")) {
                        tableLines.add(lines[index].trim())
                        index++
                    }
                    MarkdownTable(rows = tableLines)
                }
                arabicRegex.containsMatchIn(line) -> {
                    Card(
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.primaryContainer,
                            contentColor = MaterialTheme.colorScheme.onPrimaryContainer
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    ) {
                        Text(
                            text = line,
                            style = MaterialTheme.typography.bodyLarge,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(12.dp)
                        )
                    }
                    index++
                }
                line.startsWith("**") && line.endsWith("**") && line.length > 4 -> {
                    Text(
                        text = parseInlineBold(line),
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(vertical = 2.dp)
                    )
                    index++
                }
                line.startsWith("*") && line.endsWith("*") && !line.startsWith("**") && line.length > 2 -> {
                    Text(
                        text = line.substring(1, line.length - 1),
                        style = MaterialTheme.typography.bodyMedium,
                        fontStyle = FontStyle.Italic,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                            .background(
                                color = MaterialTheme.colorScheme.surfaceVariant,
                                shape = RoundedCornerShape(8.dp)
                            )
                            .padding(12.dp)
                    )
                    index++
                }
                numberedRegex.matches(line) -> {
                    Text(
                        text = parseInlineBold(line),
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(start = 8.dp, top = 2.dp, bottom = 2.dp)
                    )
                    index++
                }
                line.startsWith("- ") -> {
                    Text(
                        text = parseInlineBold("• " + line.removePrefix("- ").trim()),
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(start = 8.dp, top = 2.dp, bottom = 2.dp)
                    )
                    index++
                }
                else -> {
                    Text(
                        text = parseInlineBold(line),
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(vertical = 2.dp)
                    )
                    index++
                }
            }
        }
    }
}

/** Render baris-baris "| ... |" sebagai tabel sungguhan. */
@Composable
private fun MarkdownTable(rows: List<String>) {
    val parsedRows = rows.map { row ->
        row.split("|")
            .map { it.trim() }
            .filter { it.isNotEmpty() }
    }.filter { cells ->
        // Lewati baris pemisah: semua sel hanya berisi '-' dan ':'.
        cells.isNotEmpty() && !cells.all { cell -> cell.all { it == '-' || it == ':' } }
    }
    if (parsedRows.isEmpty()) return

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {
        parsedRows.forEachIndexed { rowIndex, cells ->
            val isHeader = rowIndex == 0
            Row(modifier = Modifier.fillMaxWidth()) {
                cells.forEach { cell ->
                    Text(
                        text = parseInlineBold(cell),
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = if (isHeader) FontWeight.Bold else FontWeight.Normal,
                        modifier = Modifier
                            .weight(1f)
                            .background(
                                if (isHeader) MaterialTheme.colorScheme.primaryContainer
                                else MaterialTheme.colorScheme.surface
                            )
                            .border(
                                BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant)
                            )
                            .padding(8.dp)
                    )
                }
            }
        }
    }
}

/**
 * Pecah teks pada penanda **...**: bagian di dalam penanda ditebalkan,
 * sisanya normal. Contoh: "**1 mud** (sekitar 675 gram)" → "1 mud" tebal
 * + " (sekitar 675 gram)" normal.
 */
fun parseInlineBold(text: String): AnnotatedString {
    return buildAnnotatedString {
        var lastIndex = 0
        for (match in boldRegex.findAll(text)) {
            if (match.range.first > lastIndex) {
                append(text.substring(lastIndex, match.range.first))
            }
            pushStyle(SpanStyle(fontWeight = FontWeight.Bold))
            append(match.groupValues[1])
            pop()
            lastIndex = match.range.last + 1
        }
        if (lastIndex < text.length) {
            append(text.substring(lastIndex))
        }
    }
}
