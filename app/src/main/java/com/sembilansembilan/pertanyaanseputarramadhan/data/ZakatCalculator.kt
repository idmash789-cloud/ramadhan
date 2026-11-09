package com.sembilansembilan.pertanyaanseputarramadhan.data

import java.text.NumberFormat
import java.util.Locale
import kotlin.math.roundToLong

/**
 * Logika murni Kalkulator Zakat (QW-2). Tanpa framework Android, tanpa state.
 *
 * Standar fikih yang dipakai (umum, mengikuti BAZNAS):
 * - Zakat fitrah: 2,5 kg beras per jiwa (setara 3,5 liter), sesuai Keputusan
 *   Ketua BAZNAS RI No. 14 Tahun 2026 (fitrah 1447 H = Rp50.000/jiwa, setara
 *   2,5 kg / 3,5 liter beras premium).
 * - Zakat maal: nisab 85 gram emas murni, haul 1 tahun Hijriah, kadar 2,5%.
 *   Nisab 2026 setara Rp91.681.728/tahun (85 gram emas) menurut BAZNAS RI.
 * - Fidyah: 1 mud (±0,8 kg beras / 1 kali makan) per hari per jiwa yang
 *   tidak berpuasa karena uzur syar'i; BAZNAS daerah menetapkan Rp25.000–
 *   Rp65.000/hari (berbeda per daerah).
 * Harga (beras/kg, emas/gram, 1x makan) adalah angka default yang WAJAR dan
 * bisa diubah pengguna — bukan ketetapan BAZNAS.
 */
object ZakatCalculator {

    /** Kadar zakat fitrah per jiwa: 2,5 kg beras (setara 3,5 liter). */
    const val FITRAH_KG_PER_PERSON: Double = 2.5

    /** Nisab zakat maal: 85 gram emas murni. */
    const val MAAL_NISAB_GOLD_GRAMS: Double = 85.0

    /** Kadar zakat maal: 2,5% dari total harta. */
    const val MAAL_RATE: Double = 0.025

    /** Harga beras per kg default (Rp) — bisa diubah pengguna. */
    const val DEFAULT_RICE_PRICE_PER_KG: Long = 15_000L

    /** Harga emas per gram default (Rp) — bisa diubah pengguna. */
    const val DEFAULT_GOLD_PRICE_PER_GRAM: Long = 2_000_000L

    /** Harga satu kali makan untuk fidyah default (Rp) — bisa diubah pengguna. */
    const val DEFAULT_FIDYAH_MEAL_PRICE: Long = 20_000L

    private val indonesianLocale = Locale("id", "ID")
    private val numberFormat: NumberFormat = NumberFormat.getNumberInstance(indonesianLocale)

    /** "Rp15.000" — tanpa desimal, sesuai kebiasaan penulisan rupiah. */
    fun formatRupiah(amount: Long): String = "Rp" + numberFormat.format(amount)

    /** "2,5" / "5" / "7,5" — kilogram dengan pemisah desimal Indonesia. */
    fun formatKg(kg: Double): String {
        val formatter = NumberFormat.getNumberInstance(indonesianLocale).apply {
            maximumFractionDigits = 1
        }
        return formatter.format(kg)
    }

    /** Ambil angka dari teks input (buang semua non-digit). "" / tidak valid -> 0. */
    fun parseAmount(text: String): Long {
        val digits = text.filter { it.isDigit() }
        if (digits.isEmpty()) return 0L
        return digits.toLongOrNull() ?: 0L
    }

    /** Jumlah (jiwa/hari) dari teks input. "" / tidak valid / negatif -> 0. */
    fun parseCount(text: String): Int {
        val value = text.filter { it.isDigit() }.toIntOrNull() ?: 0
        return value.coerceAtLeast(0)
    }

    data class FitrahResult(
        /** Rupiah per jiwa (2,5 kg x harga beras/kg). */
        val perPersonRupiah: Long,
        /** Total kilogram beras untuk seluruh anggota keluarga. */
        val totalKg: Double,
        /** Total rupiah untuk seluruh anggota keluarga. */
        val totalRupiah: Long,
    )

    fun calculateFitrah(members: Int, ricePricePerKg: Long): FitrahResult {
        val safeMembers = members.coerceAtLeast(0)
        val safePrice = ricePricePerKg.coerceAtLeast(0L)
        val perPerson = (FITRAH_KG_PER_PERSON * safePrice).roundToLong()
        return FitrahResult(
            perPersonRupiah = perPerson,
            totalKg = safeMembers * FITRAH_KG_PER_PERSON,
            totalRupiah = safeMembers * perPerson
        )
    }

    data class MaalResult(
        /** Nilai nisab dalam rupiah (85 gram x harga emas/gram). */
        val nisabRupiah: Long,
        /** True bila total harta mencapai nisab (wajib zakat). */
        val isObligatory: Boolean,
        /** Zakat 2,5% dari total harta (0 bila belum wajib). */
        val zakatRupiah: Long,
        /** Selisih ke nisab (0 bila sudah wajib). */
        val shortfallRupiah: Long,
    )

    fun calculateMaal(totalWealth: Long, goldPricePerGram: Long): MaalResult {
        val safeWealth = totalWealth.coerceAtLeast(0L)
        val safeGoldPrice = goldPricePerGram.coerceAtLeast(0L)
        val nisab = (MAAL_NISAB_GOLD_GRAMS * safeGoldPrice).roundToLong()
        val obligatory = safeWealth >= nisab
        return MaalResult(
            nisabRupiah = nisab,
            isObligatory = obligatory,
            zakatRupiah = if (obligatory) (safeWealth * MAAL_RATE).roundToLong() else 0L,
            shortfallRupiah = if (obligatory) 0L else (nisab - safeWealth).coerceAtLeast(0L)
        )
    }

    data class FidyahResult(
        /** Total rupiah (jumlah hari x harga satu kali makan). */
        val totalRupiah: Long,
    )

    fun calculateFidyah(days: Int, mealPrice: Long): FidyahResult {
        val safeDays = days.coerceAtLeast(0)
        val safePrice = mealPrice.coerceAtLeast(0L)
        return FidyahResult(totalRupiah = safeDays.toLong() * safePrice)
    }

    /** Satu paket hasil lengkap untuk layar + teks bagikan. */
    data class ZakatSummary(
        val members: Int,
        val ricePricePerKg: Long,
        val fitrah: FitrahResult,
        val totalWealth: Long,
        val goldPricePerGram: Long,
        val maal: MaalResult,
        val fidyahDays: Int,
        val mealPrice: Long,
        val fidyah: FidyahResult,
        /** Fitrah + zakat maal (bila wajib) + fidyah. */
        val grandTotal: Long,
    )

    fun buildSummary(
        members: Int,
        ricePricePerKg: Long,
        totalWealth: Long,
        goldPricePerGram: Long,
        fidyahDays: Int,
        mealPrice: Long,
    ): ZakatSummary {
        val fitrah = calculateFitrah(members, ricePricePerKg)
        val maal = calculateMaal(totalWealth, goldPricePerGram)
        val fidyah = calculateFidyah(fidyahDays, mealPrice)
        return ZakatSummary(
            members = members,
            ricePricePerKg = ricePricePerKg,
            fitrah = fitrah,
            totalWealth = totalWealth,
            goldPricePerGram = goldPricePerGram,
            maal = maal,
            fidyahDays = fidyahDays,
            mealPrice = mealPrice,
            fidyah = fidyah,
            grandTotal = fitrah.totalRupiah + maal.zakatRupiah + fidyah.totalRupiah
        )
    }

    /** Ringkasan teks rapi, siap kirim lewat WhatsApp / share sheet. */
    fun buildShareText(summary: ZakatSummary): String {
        val builder = StringBuilder()
        builder.append("Hitung Zakat — 99 Pertanyaan Seputar Ramadhan\n")
        builder.append("\nZakat Fitrah\n")
        builder.append("${summary.members} jiwa x 2,5 kg beras")
        builder.append(" (${formatKg(summary.fitrah.totalKg)} kg)")
        builder.append(" x ${formatRupiah(summary.ricePricePerKg)}/kg\n")
        builder.append("Per jiwa: ${formatRupiah(summary.fitrah.perPersonRupiah)}\n")
        builder.append("Total: ${formatRupiah(summary.fitrah.totalRupiah)}\n")
        builder.append("\nZakat Maal\n")
        builder.append("Total harta: ${formatRupiah(summary.totalWealth)}\n")
        builder.append("Nisab (85 gram emas x ${formatRupiah(summary.goldPricePerGram)}): ")
        builder.append("${formatRupiah(summary.maal.nisabRupiah)}\n")
        if (summary.maal.isObligatory) {
            builder.append("Wajib zakat 2,5%: ${formatRupiah(summary.maal.zakatRupiah)}\n")
        } else {
            builder.append("Belum wajib zakat.")
            builder.append(" Kekurangan ${formatRupiah(summary.maal.shortfallRupiah)} lagi untuk mencapai nisab.\n")
        }
        builder.append("\nFidyah\n")
        builder.append("${summary.fidyahDays} hari x ${formatRupiah(summary.mealPrice)} (1 kali makan)\n")
        builder.append("Total: ${formatRupiah(summary.fidyah.totalRupiah)}\n")
        builder.append("\nTotal keseluruhan: ${formatRupiah(summary.grandTotal)}\n")
        builder.append("\nStandar umum BAZNAS; harga dapat diubah. ")
        builder.append("Hasil ini perkiraan, bukan fatwa personal.")
        return builder.toString()
    }
}
