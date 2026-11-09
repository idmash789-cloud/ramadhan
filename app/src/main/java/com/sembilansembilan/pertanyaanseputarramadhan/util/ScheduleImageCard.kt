package com.sembilansembilan.pertanyaanseputarramadhan.util

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.graphics.Typeface
import androidx.core.content.FileProvider
import com.sembilansembilan.pertanyaanseputarramadhan.imsakiyah.HijriCalendar
import com.sembilansembilan.pertanyaanseputarramadhan.ui.HomeUiState
import com.sembilansembilan.pertanyaanseputarramadhan.ui.components.formatHitungMundur
import com.sembilansembilan.pertanyaanseputarramadhan.ui.components.formatJam
import com.sembilansembilan.pertanyaanseputarramadhan.ui.components.formatTanggalIndonesia
import java.io.File
import java.io.FileOutputStream

/**
 * QW-5 (a): "Bagikan sebagai Gambar" — kartu jadwal imsakiyah hari ini
 * dirender MANUAL menjadi bitmap (android.graphics Bitmap + Canvas + Paint),
 * BUKAN screenshot layar, lalu dibagikan lewat Intent + FileProvider.
 *
 * Kartu selalu memakai palet TERANG tema coklat/krem (bukan mode gelap)
 * agar tetap terbaca saat dibagikan ke WhatsApp / Status / media sosial.
 * Warna disalin dari ui/theme/Color.kt (varian terang).
 *
 * Membutuhkan entri FileProvider di AndroidManifest (lihat spec QW-5):
 * authority "${applicationId}.fileprovider", resource @xml/file_paths.
 */
object ScheduleImageCard {

    /** Teks pendamping saat berbagi gambar jadwal. */
    const val SHARE_TEXT = "Jadwal imsakiyah hari ini — 99 Pertanyaan Seputar Ramadhan"

    // Ukuran kartu (portrait, cocok untuk Status WhatsApp / feed).
    private const val WIDTH = 1080
    private const val HEIGHT = 1500

    // Palet terang (Color.kt): krem, coklat, emas.
    private const val COLOR_BG = 0xFFF7F3EC.toInt() // CreamBackgroundLight
    private const val COLOR_CARD = 0xFFFFFDF8.toInt() // CreamSurfaceLight
    private const val COLOR_BROWN = 0xFF7A5A2E.toInt() // BrownPrimaryLight
    private const val COLOR_GOLD = 0xFFC9A66B.toInt() // GoldTertiaryLight
    private const val COLOR_TEXT = 0xFF2A2118.toInt() // BrownOnSurfaceLight
    private const val COLOR_VARIANT = 0xFF6B5D49.toInt() // BrownOnSurfaceVariantLight
    private const val COLOR_DIVIDER = 0xFFEFE7D8.toInt() // CreamSurfaceVariantLight

    /**
     * Render kartu jadwal menjadi bitmap 1080×1500, simpan sebagai PNG di
     * cacheDir/shared/, lalu bagikan via Intent.ACTION_SEND + FileProvider.
     *
     * @return true bila chooser berhasil dibuka; false bila jadwal belum
     * tersedia ([HomeUiState.times] null) atau penyimpanan/berbagi gagal.
     * Pemanggil menampilkan Toast bila hasilnya false.
     */
    fun shareScheduleImage(context: Context, state: HomeUiState): Boolean {
        val bitmap = renderScheduleBitmap(state) ?: return false
        return try {
            val dir = File(context.cacheDir, "shared").apply { mkdirs() }
            val file = File(dir, "jadwal-imsakiyah-${state.date}.png")
            FileOutputStream(file).use { out ->
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, out)
            }
            val uri = FileProvider.getUriForFile(
                context,
                "${context.packageName}.fileprovider",
                file
            )
            val intent = Intent(Intent.ACTION_SEND).apply {
                type = "image/png"
                putExtra(Intent.EXTRA_STREAM, uri)
                putExtra(Intent.EXTRA_TEXT, SHARE_TEXT)
                addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
            }
            context.startActivity(Intent.createChooser(intent, "Bagikan jadwal"))
            true
        } catch (e: Exception) {
            false
        }
    }

    /**
     * Gambar kartu jadwal hari ini. Mengembalikan null bila [state.times]
     * null (jadwal belum terhitung).
     */
    fun renderScheduleBitmap(state: HomeUiState): Bitmap? {
        val times = state.times ?: return null
        val bitmap = Bitmap.createBitmap(WIDTH, HEIGHT, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)

        // Latar + kartu.
        canvas.drawColor(COLOR_BG)
        val cardPaint = paint(COLOR_CARD)
        canvas.drawRoundRect(RectF(48f, 48f, 1032f, 1452f), 48f, 48f, cardPaint)
        val borderPaint = paint(COLOR_GOLD).apply {
            style = Paint.Style.STROKE
            strokeWidth = 4f
        }
        canvas.drawRoundRect(RectF(48f, 48f, 1032f, 1452f), 48f, 48f, borderPaint)

        val centerX = WIDTH / 2f

        // Judul.
        canvas.drawText(
            "JADWAL IMSAKIYAH",
            centerX,
            180f,
            paint(COLOR_BROWN, 58f, bold = true)
        )
        // Tanggal Masehi + Hijriah (perkiraan) + kota.
        canvas.drawText(
            formatTanggalIndonesia(state.date),
            centerX,
            248f,
            paint(COLOR_TEXT, 40f, bold = true)
        )
        canvas.drawText(
            "${HijriCalendar.formatHijri(HijriCalendar.gregorianToHijri(state.date))} (perkiraan)",
            centerX,
            302f,
            paint(COLOR_VARIANT, 36f)
        )
        canvas.drawText(
            "Kota: ${state.city.name}",
            centerX,
            356f,
            paint(COLOR_VARIANT, 36f)
        )

        // Garis pemisah emas.
        val dividerPaint = paint(COLOR_GOLD).apply { strokeWidth = 4f }
        canvas.drawLine(140f, 400f, 940f, 400f, dividerPaint)

        // Pil hitung mundur ke event berikutnya.
        val countdownText =
            "Menuju ${state.nextEventLabel} \u2022 ${formatHitungMundur(state.countdownMinutes)}"
        val countdownPaint = paint(COLOR_BROWN, 36f, bold = true)
        val pillWidth = countdownPaint.measureText(countdownText) + 80f
        val pillLeft = centerX - pillWidth / 2f
        canvas.drawRoundRect(
            RectF(pillLeft, 440f, pillLeft + pillWidth, 524f),
            42f,
            42f,
            paint(COLOR_GOLD)
        )
        canvas.drawText(countdownText, centerX, 496f, countdownPaint)

        // Tujuh baris waktu imsakiyah.
        val rows = listOf(
            "Imsak" to times.imsak,
            "Subuh" to times.fajr,
            "Terbit" to times.sunrise,
            "Dzuhur" to times.dhuhr,
            "Ashar" to times.asr,
            "Maghrib" to times.maghrib,
            "Isya" to times.isha,
        )
        var rowTop = 580f
        val rowHeight = 96f
        val labelPaint = paint(COLOR_TEXT, 40f, align = Paint.Align.LEFT)
        val timePaint = paint(COLOR_BROWN, 40f, bold = true, align = Paint.Align.RIGHT)
        val rowDividerPaint = paint(COLOR_DIVIDER).apply { strokeWidth = 2f }
        for ((index, row) in rows.withIndex()) {
            val baseline = rowTop + 62f
            canvas.drawText(row.first, 140f, baseline, labelPaint)
            canvas.drawText(formatJam(row.second), 940f, baseline, timePaint)
            if (index < rows.lastIndex) {
                canvas.drawLine(140f, rowTop + rowHeight, 940f, rowTop + rowHeight, rowDividerPaint)
            }
            rowTop += rowHeight
        }

        // Footer: nama aplikasi + catatan kejujuran jadwal.
        canvas.drawText(
            "99 Pertanyaan Seputar Ramadhan",
            centerX,
            1310f,
            paint(COLOR_BROWN, 34f, bold = true)
        )
        canvas.drawText(
            "Jadwal perkiraan \u2014 cocokkan dengan jadwal resmi Kemenag",
            centerX,
            1356f,
            paint(COLOR_VARIANT, 28f)
        )

        return bitmap
    }

    private fun paint(
        color: Int,
        sizePx: Float = 40f,
        bold: Boolean = false,
        align: Paint.Align = Paint.Align.CENTER,
    ): Paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        this.color = color
        textSize = sizePx
        typeface = if (bold) Typeface.DEFAULT_BOLD else Typeface.DEFAULT
        textAlign = align
    }
}
