package com.sembilansembilan.pertanyaanseputarramadhan.ui.screens

import android.app.Activity
import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material.icons.filled.ContentCopy
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.sembilansembilan.pertanyaanseputarramadhan.data.kultumRamadhan
import com.sembilansembilan.pertanyaanseputarramadhan.ui.SettingsViewModel
import com.sembilansembilan.pertanyaanseputarramadhan.ui.components.EmptyState
import com.sembilansembilan.pertanyaanseputarramadhan.ui.components.MarkdownText
import com.sembilansembilan.pertanyaanseputarramadhan.util.InterstitialGate

/**
 * Isi satu kultum: judul, tema, kutipan, isi, bagikan/salin.
 * Bookmark memakai kunci "k:<night>".
 */
@Composable
fun KultumDetailScreen(
    night: Int,
    settingsVm: SettingsViewModel,
    onBack: () -> Unit,
) {
    val settings by settingsVm.settings.collectAsState()
    val kultum = kultumRamadhan.firstOrNull { it.night == night }
    val context = LocalContext.current
    val clipboardManager = LocalClipboardManager.current

    if (kultum == null) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            EmptyState("Kultum tidak ditemukan")
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = onBack) {
                Text("Kembali")
            }
        }
        return
    }

    val bookmarked = "k:${kultum.night}" in settings.bookmarks

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = onBack) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Kembali"
                )
            }
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = "Malam ${kultum.night}",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.primary
                )
                Text(
                    text = kultum.title,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )
            }
            IconButton(
                onClick = { settingsVm.toggleBookmark("k:${kultum.night}") }
            ) {
                Icon(
                    imageVector = if (bookmarked) Icons.Filled.Bookmark else Icons.Filled.BookmarkBorder,
                    contentDescription = if (bookmarked) "Hapus bookmark" else "Simpan bookmark",
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        }

        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = kultum.theme,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        kultum.quote?.let { quote ->
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "\"$quote\"",
                style = MaterialTheme.typography.bodyMedium,
                fontStyle = FontStyle.Italic
            )
            kultum.quoteSource?.let { source ->
                Text(
                    text = source,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }

        Spacer(modifier = Modifier.height(12.dp))
        MarkdownText(content = kultum.content)

        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = androidx.compose.foundation.layout.Arrangement.End
        ) {
            TextButton(
                onClick = {
                    val shareText = buildKultumShareText(kultum)
                    val intent = Intent(Intent.ACTION_SEND).apply {
                        type = "text/plain"
                        putExtra(Intent.EXTRA_TEXT, shareText)
                    }
                    context.startActivity(
                        Intent.createChooser(intent, "Bagikan kultum")
                    )
                    (context as? Activity)?.let { activity ->
                        InterstitialGate.maybeShow(activity)
                    }
                }
            ) {
                Icon(
                    imageVector = Icons.Filled.Share,
                    contentDescription = "Bagikan"
                )
                Text("Bagikan")
            }
            TextButton(
                onClick = {
                    clipboardManager.setText(
                        AnnotatedString(
                            buildKultumShareText(kultum)
                        )
                    )
                    Toast.makeText(context, "Disalin", Toast.LENGTH_SHORT).show()
                }
            ) {
                Icon(
                    imageVector = Icons.Filled.ContentCopy,
                    contentDescription = "Salin"
                )
                Text("Salin")
            }
        }
    }
}

private fun buildKultumShareText(kultum: com.sembilansembilan.pertanyaanseputarramadhan.data.Kultum): String {
    val builder = StringBuilder()
    builder.append("Kultum Malam ${kultum.night}: ").append(kultum.title).append("\n\n")
    kultum.quote?.let {
        builder.append("\"").append(it).append("\"")
        kultum.quoteSource?.let { source -> builder.append(" (").append(source).append(")") }
        builder.append("\n\n")
    }
    builder.append(kultum.content)
    builder.append("\n\n— 99 Pertanyaan Seputar Ramadhan")
    return builder.toString()
}
