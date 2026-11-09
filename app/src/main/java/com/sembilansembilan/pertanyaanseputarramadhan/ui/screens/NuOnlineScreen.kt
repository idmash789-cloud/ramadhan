package com.sembilansembilan.pertanyaanseputarramadhan.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import com.sembilansembilan.pertanyaanseputarramadhan.ui.components.itemsWithNativeAds
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.sembilansembilan.pertanyaanseputarramadhan.data.nuOnlineArticles
import com.sembilansembilan.pertanyaanseputarramadhan.ui.SettingsViewModel

/**
 * Daftar artikel Kajian NU Online (15 artikel, ditulis ulang dari
 * nu.or.id / islam.nu.or.id dan kanal daerah NU Online).
 * Tanpa banner iklan — sama seperti layar Buku Saku.
 */
@Composable
fun NuOnlineScreen(
    settingsVm: SettingsViewModel,
    onOpenArticle: (String) -> Unit,
) {
    val settings by settingsVm.settings.collectAsState()

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        item { Text("Kajian Tambahan", style = MaterialTheme.typography.titleMedium) }
        itemsWithNativeAds(nuOnlineArticles, key = { it.id }) { article ->
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
                    if ("n:${article.id}" in settings.bookmarks) {
                        Icon(
                            imageVector = Icons.Filled.Bookmark,
                            contentDescription = "Tersimpan di bookmark",
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
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
