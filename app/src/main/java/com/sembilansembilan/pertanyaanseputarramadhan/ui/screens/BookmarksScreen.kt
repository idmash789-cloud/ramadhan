package com.sembilansembilan.pertanyaanseputarramadhan.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.sembilansembilan.pertanyaanseputarramadhan.data.bukuSakuSections
import com.sembilansembilan.pertanyaanseputarramadhan.data.kultumRamadhan
import com.sembilansembilan.pertanyaanseputarramadhan.data.nuOnlineArticles
import com.sembilansembilan.pertanyaanseputarramadhan.data.pissKtbQuestions
import com.sembilansembilan.pertanyaanseputarramadhan.data.ramadhanQuestions
import com.sembilansembilan.pertanyaanseputarramadhan.ui.SettingsViewModel
import com.sembilansembilan.pertanyaanseputarramadhan.ui.components.EmptyState
import com.sembilansembilan.pertanyaanseputarramadhan.ui.components.SectionTitle
import com.sembilansembilan.pertanyaanseputarramadhan.ui.components.itemsWithNativeAds

@Composable
fun BookmarksScreen(
    settingsVm: SettingsViewModel,
    onOpenQuestion: (Int) -> Unit,
    onOpenSection: (String) -> Unit,
    onOpenArticle: (String) -> Unit,
    onOpenPiss: (Int) -> Unit,
    onOpenKultum: (Int) -> Unit,
) {
    val settings by settingsVm.settings.collectAsState()
    val bookmarks = settings.bookmarks

    val bookmarkedQuestions = ramadhanQuestions.filter { "q:${it.id}" in bookmarks }
    val bookmarkedSections = bukuSakuSections.filter { "s:${it.id}" in bookmarks }
    val bookmarkedArticles = nuOnlineArticles.filter { "n:${it.id}" in bookmarks }
    val bookmarkedPiss = pissKtbQuestions.filter { "p:${it.id}" in bookmarks }
    val bookmarkedKultums = kultumRamadhan.filter { "k:${it.night}" in bookmarks }

    if (bookmarkedQuestions.isEmpty() && bookmarkedSections.isEmpty() &&
        bookmarkedArticles.isEmpty() && bookmarkedPiss.isEmpty() &&
        bookmarkedKultums.isEmpty()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            EmptyState(
                "Belum ada bookmark. Ketuk ikon bookmark pada pertanyaan, topik, artikel, tanya-jawab, atau kultum untuk menyimpannya di sini."
            )
        }
        return
    }

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        var precedingItems = 0
        if (bookmarkedQuestions.isNotEmpty()) {
            item {
                SectionTitle("Pertanyaan")
            }
            itemsWithNativeAds(bookmarkedQuestions, every = 5, precedingItems = precedingItems, key = { "q:${it.id}" }) { question ->
                Card(
                    onClick = { onOpenQuestion(question.id) },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
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
                            imageVector = Icons.Filled.ChevronRight,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }
            precedingItems += bookmarkedQuestions.size
        }

        if (bookmarkedSections.isNotEmpty()) {
            item {
                SectionTitle("Buku Saku")
            }
            itemsWithNativeAds(bookmarkedSections, every = 5, precedingItems = precedingItems, key = { "s:${it.id}" }) { section ->
                Card(
                    onClick = { onOpenSection(section.id) },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = section.title,
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier.weight(1f)
                        )
                        Icon(
                            imageVector = Icons.Filled.ChevronRight,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }
            precedingItems += bookmarkedSections.size
        }

        if (bookmarkedArticles.isNotEmpty()) {
            item {
                SectionTitle("Kajian Tambahan")
            }
            itemsWithNativeAds(bookmarkedArticles, every = 5, precedingItems = precedingItems, key = { "n:${it.id}" }) { article ->
                Card(
                    onClick = { onOpenArticle(article.id) },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = article.title,
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier.weight(1f)
                        )
                        Icon(
                            imageVector = Icons.Filled.ChevronRight,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }
            precedingItems += bookmarkedArticles.size
        }

        if (bookmarkedPiss.isNotEmpty()) {
            item {
                SectionTitle("Tanya Jawab Tambahan")
            }
            itemsWithNativeAds(bookmarkedPiss, every = 5, precedingItems = precedingItems, key = { "p:${it.id}" }) { question ->
                Card(
                    onClick = { onOpenPiss(question.id) },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
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
                            imageVector = Icons.Filled.ChevronRight,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }
            precedingItems += bookmarkedPiss.size
        }

        if (bookmarkedKultums.isNotEmpty()) {
            item {
                SectionTitle("Kultum Ramadhan")
            }
            itemsWithNativeAds(bookmarkedKultums, every = 5, precedingItems = precedingItems, key = { "k:${it.night}" }) { kultum ->
                Card(
                    onClick = { onOpenKultum(kultum.night) },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Malam ${kultum.night}",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary
                        )
                        Text(
                            text = kultum.title,
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier
                                .weight(1f)
                                .padding(horizontal = 8.dp)
                        )
                        Icon(
                            imageVector = Icons.Filled.ChevronRight,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }
        }
    }
}
