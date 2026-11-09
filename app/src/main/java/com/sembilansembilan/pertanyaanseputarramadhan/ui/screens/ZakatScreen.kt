package com.sembilansembilan.pertanyaanseputarramadhan.ui.screens

import android.content.Intent
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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.sembilansembilan.pertanyaanseputarramadhan.data.ZakatCalculator
import com.sembilansembilan.pertanyaanseputarramadhan.ui.ZakatViewModel
import com.sembilansembilan.pertanyaanseputarramadhan.ui.components.AdNativeCard
import com.sembilansembilan.pertanyaanseputarramadhan.ui.components.SectionTitle

/**
 * Kalkulator Zakat (QW-2): tiga seksi bertumpuk dalam satu layar gulir —
 * Zakat Fitrah, Zakat Maal, Fidyah — plus total keseluruhan dan tombol bagikan.
 * Harga (beras/kg, emas/gram, 1x makan) bisa diubah dan tersimpan otomatis.
 */
@Composable
fun ZakatScreen(zakatVm: ZakatViewModel) {
    val summary by zakatVm.summary.collectAsState()
    val membersText by zakatVm.membersText.collectAsState()
    val ricePriceText by zakatVm.ricePriceText.collectAsState()
    val wealthText by zakatVm.wealthText.collectAsState()
    val goldPriceText by zakatVm.goldPriceText.collectAsState()
    val fidyahDaysText by zakatVm.fidyahDaysText.collectAsState()
    val mealPriceText by zakatVm.mealPriceText.collectAsState()
    val context = LocalContext.current

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item(key = "intro") {
            Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                Text(
                    text = "Kalkulator Zakat",
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Hitung zakat fitrah, zakat maal, dan fidyah. Harga bisa diubah sesuai daerah Anda dan tersimpan otomatis.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
        item(key = "fitrah") {
            // (a) Zakat Fitrah.
            Card(modifier = Modifier.fillMaxWidth()) {
                Column(modifier = Modifier.padding(16.dp)) {
                    SectionTitle("Zakat Fitrah")
                    Text(
                        text = "2,5 kg beras per jiwa (setara 3,5 liter).",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    OutlinedTextField(
                        value = membersText,
                        onValueChange = { zakatVm.setMembers(it) },
                        label = { Text("Jumlah anggota keluarga (jiwa)") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    OutlinedTextField(
                        value = ricePriceText,
                        onValueChange = { zakatVm.setRicePrice(it) },
                        label = { Text("Harga beras per kg") },
                        prefix = { Text("Rp") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    HasilRow(
                        label = "Per jiwa",
                        value = "2,5 kg = ${ZakatCalculator.formatRupiah(summary.fitrah.perPersonRupiah)}"
                    )
                    HasilRow(
                        label = "Total (${summary.members} jiwa)",
                        value = "${ZakatCalculator.formatKg(summary.fitrah.totalKg)} kg = " +
                            ZakatCalculator.formatRupiah(summary.fitrah.totalRupiah)
                    )
                }
            }
        }
        item(key = "ad-fitrah", contentType = "native") { AdNativeCard() }
        item(key = "maal") {
            // (b) Zakat Maal.
            Card(modifier = Modifier.fillMaxWidth()) {
                Column(modifier = Modifier.padding(16.dp)) {
                    SectionTitle("Zakat Maal")
                    Text(
                        text = "Wajib bila total harta mencapai nisab 85 gram emas dan sudah dimiliki 1 tahun (haul). Kadar 2,5%.",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    OutlinedTextField(
                        value = wealthText,
                        onValueChange = { zakatVm.setWealth(it) },
                        label = { Text("Total harta (uang, tabungan, emas, dll.)") },
                        prefix = { Text("Rp") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    OutlinedTextField(
                        value = goldPriceText,
                        onValueChange = { zakatVm.setGoldPrice(it) },
                        label = { Text("Harga emas per gram") },
                        prefix = { Text("Rp") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    HasilRow(
                        label = "Nisab (85 gram emas)",
                        value = ZakatCalculator.formatRupiah(summary.maal.nisabRupiah)
                    )
                    if (summary.maal.isObligatory) {
                        HasilRow(
                            label = "Zakat maal 2,5%",
                            value = ZakatCalculator.formatRupiah(summary.maal.zakatRupiah),
                            highlight = true
                        )
                    } else {
                        Text(
                            text = "Belum wajib zakat maal.",
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.SemiBold,
                            color = MaterialTheme.colorScheme.primary
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "Kekurangan ${ZakatCalculator.formatRupiah(summary.maal.shortfallRupiah)} lagi untuk mencapai nisab.",
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }
        }
        item(key = "ad-maal", contentType = "native") { AdNativeCard() }
        item(key = "fidyah") {
            // (c) Fidyah.
            Card(modifier = Modifier.fillMaxWidth()) {
                Column(modifier = Modifier.padding(16.dp)) {
                    SectionTitle("Fidyah")
                    Text(
                        text = "1 mud (±1 kali makan) per hari untuk setiap hari puasa yang ditinggalkan karena uzur syar'i.",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    OutlinedTextField(
                        value = fidyahDaysText,
                        onValueChange = { zakatVm.setFidyahDays(it) },
                        label = { Text("Jumlah hari yang ditinggalkan") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    OutlinedTextField(
                        value = mealPriceText,
                        onValueChange = { zakatVm.setMealPrice(it) },
                        label = { Text("Harga satu kali makan") },
                        prefix = { Text("Rp") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    HasilRow(
                        label = "Total fidyah (${summary.fidyahDays} hari)",
                        value = ZakatCalculator.formatRupiah(summary.fidyah.totalRupiah)
                    )
                }
            }
        }
        item(key = "total") {
            // Total keseluruhan.
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    contentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Total keseluruhan",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = ZakatCalculator.formatRupiah(summary.grandTotal),
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
        item(key = "share") {
            Button(
                onClick = {
                    val shareText = ZakatCalculator.buildShareText(summary)
                    val intent = Intent(Intent.ACTION_SEND).apply {
                        type = "text/plain"
                        putExtra(Intent.EXTRA_TEXT, shareText)
                    }
                    context.startActivity(Intent.createChooser(intent, "Bagikan hasil zakat"))
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(
                    imageVector = Icons.Filled.Share,
                    contentDescription = null
                )
                Text(
                    text = "Bagikan Hasil",
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
        }
        item(key = "ad-share", contentType = "native") { AdNativeCard() }
        item(key = "notes") {
            Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                Text(
                    text = "Standar umum BAZNAS: zakat fitrah 2,5 kg (3,5 liter) beras per jiwa; nisab zakat maal 85 gram emas, kadar 2,5%; fidyah 1 mud (±1 kali makan) per hari. Harga dapat diubah sesuai daerah Anda.",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Text(
                    text = "Hasil ini perkiraan, bukan fatwa personal. Untuk kepastian fikih, tanyakan kepada ustaz atau BAZNAS setempat.",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}

@Composable
private fun HasilRow(
    label: String,
    value: String,
    highlight: Boolean = false,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.weight(1f)
        )
        Text(
            text = value,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = if (highlight) FontWeight.Bold else FontWeight.SemiBold,
            color = if (highlight) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface
        )
    }
}
