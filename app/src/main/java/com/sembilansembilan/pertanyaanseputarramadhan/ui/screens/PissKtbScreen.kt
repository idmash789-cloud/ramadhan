package com.sembilansembilan.pertanyaanseputarramadhan.ui.screens

import android.app.Activity
import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material.icons.filled.ContentCopy
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import com.sembilansembilan.pertanyaanseputarramadhan.ui.components.itemsWithNativeAds
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.sembilansembilan.pertanyaanseputarramadhan.data.PissQuestion
import com.sembilansembilan.pertanyaanseputarramadhan.ui.PissKtbViewModel
import com.sembilansembilan.pertanyaanseputarramadhan.ui.SettingsViewModel
import com.sembilansembilan.pertanyaanseputarramadhan.ui.components.EmptyState
import com.sembilansembilan.pertanyaanseputarramadhan.ui.components.RatingPromptDialog
import com.sembilansembilan.pertanyaanseputarramadhan.util.InterstitialGate

/**
 * Daftar Tanya Jawab PISS-KTB (20 tanya-jawab fikih puasa, diparafrase
 * dari piss-ktb.com beserta referensi kitabnya). Pola sama seperti layar
 * 99 Pertanyaan: pencarian, jawaban expandable, bookmark, bagikan/salin,
 * banner di bawah — tidak ada penempatan iklan baru.
 */
@Composable
fun PissKtbScreen(
    pissVm: PissKtbViewModel,
    settingsVm: SettingsViewModel,
) {
    val searchQuery by pissVm.searchQuery.collectAsState()
    val questions by pissVm.filteredQuestions.collectAsState()
    val expandedId by pissVm.expandedId.collectAsState()
    val settings by settingsVm.settings.collectAsState()

    // QW-1: prompt rating sopan — sama seperti di layar 99 Pertanyaan.
    var showRatingDialog by remember { mutableStateOf(false) }
    val ratingEligible = settings.ratingPromptState == "unasked" &&
        (settings.detailOpenCount >= 3 || settings.sharedOnce)
    LaunchedEffect(ratingEligible) {
        if (ratingEligible) showRatingDialog = true
    }
    if (showRatingDialog) {
        RatingPromptDialog(
            onRate = {
                settingsVm.setRatingPromptState("rated")
                showRatingDialog = false
            },
            onLater = {
                settingsVm.resetDetailOpenCount()
                showRatingDialog = false
            },
            onNever = {
                settingsVm.setRatingPromptState("never")
                showRatingDialog = false
            },
        )
    }

    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            "Tanya Jawab Tambahan",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(start = 16.dp, top = 12.dp)
        )
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { pissVm.setSearchQuery(it) },
            placeholder = { Text("Cari tanya-jawab…") },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = null
                )
            },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
        )

        Text(
            text = if (searchQuery.isBlank()) {
                "Menampilkan ${questions.size} tanya-jawab"
            } else {
                "Ditemukan ${questions.size} tanya-jawab"
            },
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp)
        )

        if (questions.isEmpty()) {
            EmptyState(
                text = if (searchQuery.isBlank()) {
                    "Belum ada tanya-jawab."
                } else {
                    "Tidak ditemukan tanya-jawab untuk \"$searchQuery\"."
                }
            )
        } else {
            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
            ) {
                itemsWithNativeAds(questions, key = { it.id }) { question ->
                    PissQuestionCard(
                        question = question,
                        expanded = expandedId == question.id,
                        bookmarked = "p:${question.id}" in settings.bookmarks,
                        onToggleExpanded = { pissVm.toggleExpanded(question.id) },
                        onToggleBookmark = { pissVm.toggleBookmark(question.id) },
                        onShared = { settingsVm.recordShared() }
                    )
                }
            }
        }
    }
}

@Composable
private fun PissQuestionCard(
    question: PissQuestion,
    expanded: Boolean,
    bookmarked: Boolean,
    onToggleExpanded: () -> Unit,
    onToggleBookmark: () -> Unit,
    onShared: () -> Unit,
) {
    val context = LocalContext.current
    val clipboardManager = LocalClipboardManager.current

    Card(
        onClick = onToggleExpanded,
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "${question.id}.",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
                Text(
                    text = question.title,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 8.dp)
                )
                Icon(
                    imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                    contentDescription = if (expanded) "Tutup" else "Buka"
                )
            }

            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = question.question,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                maxLines = if (expanded) Int.MAX_VALUE else 2
            )

            if (expanded) {
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = question.question,
                    style = MaterialTheme.typography.bodyMedium,
                    fontStyle = FontStyle.Italic
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Jawab:",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = question.answer,
                    style = MaterialTheme.typography.bodyMedium
                )
                question.reference?.let { reference ->
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Referensi: $reference",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    TextButton(onClick = onToggleBookmark) {
                        Icon(
                            imageVector = if (bookmarked) Icons.Filled.Bookmark else Icons.Filled.BookmarkBorder,
                            contentDescription = if (bookmarked) "Hapus bookmark" else "Simpan bookmark"
                        )
                        Text(if (bookmarked) "Tersimpan" else "Bookmark")
                    }
                    TextButton(
                        onClick = {
                            val shareText = buildPissShareText(question)
                            val intent = Intent(Intent.ACTION_SEND).apply {
                                type = "text/plain"
                                putExtra(Intent.EXTRA_TEXT, shareText)
                            }
                            context.startActivity(
                                Intent.createChooser(intent, "Bagikan tanya-jawab")
                            )
                            // QW-1: bagikan jawaban = salah satu pemicu prompt rating.
                            onShared()
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
                                AnnotatedString(buildPissShareText(question))
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
    }
}

private fun buildPissShareText(question: PissQuestion): String {
    val builder = StringBuilder()
    builder.append(question.title).append("\n\n")
    builder.append(question.question).append("\n\n")
    builder.append(question.answer)
    question.reference?.let { builder.append("\n\nReferensi: ").append(it) }
    builder.append("\n\n— 99 Pertanyaan Seputar Ramadhan")
    return builder.toString()
}
