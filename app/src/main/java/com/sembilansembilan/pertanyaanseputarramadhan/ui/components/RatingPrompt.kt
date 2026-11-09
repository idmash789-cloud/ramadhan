package com.sembilansembilan.pertanyaanseputarramadhan.ui.components

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

/** Tautan Play Store aplikasi ini (dipakai tombol rating & bagikan). */
const val PLAY_STORE_URL =
    "https://play.google.com/store/apps/details?id=com.sembilansembilan.pertanyaanseputarramadhan"

/**
 * QW-1 — Prompt rating sopan. Muncul SEKALI, hanya di layar daftar
 * pertanyaan (bukan saat pengguna sedang membaca jadwal di Beranda),
 * setelah pengguna membuka 3 jawaban atau membagikan 1 jawaban.
 *
 * - "Beri rating" → buka halaman Play Store + tandai sudah dinilai.
 * - "Nanti" → tutup, hitungan dibuka-di-nol-kan, boleh muncul lagi nanti.
 * - "Jangan tanya lagi" → tutup dan jangan pernah muncul lagi.
 * Menutup dialog dengan tombol kembali / ketuk di luar = "Nanti".
 */
@Composable
fun RatingPromptDialog(
    onRate: () -> Unit,
    onLater: () -> Unit,
    onNever: () -> Unit,
) {
    val context = LocalContext.current
    AlertDialog(
        onDismissRequest = onLater,
        title = { Text("Suka aplikasi ini?") },
        text = {
            Text(
                "Kalau aplikasi ini membantu, mohon luangkan sebentar " +
                    "untuk memberi rating di Play Store. Rating Anda membantu " +
                    "aplikasi ini ditemukan lebih banyak orang."
            )
        },
        confirmButton = {
            TextButton(
                onClick = {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(PLAY_STORE_URL))
                    context.startActivity(intent)
                    onRate()
                }
            ) {
                Text("Beri rating")
            }
        },
        dismissButton = {
            Row {
                TextButton(onClick = onLater) {
                    Text("Nanti")
                }
                TextButton(onClick = onNever) {
                    Text("Jangan tanya lagi")
                }
            }
        },
    )
}
