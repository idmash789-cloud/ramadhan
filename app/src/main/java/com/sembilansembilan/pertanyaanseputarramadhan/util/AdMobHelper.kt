package com.sembilansembilan.pertanyaanseputarramadhan.util

import android.app.Activity
import android.content.Context
import android.util.DisplayMetrics
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback

/**
 * AdMob helper — TEST ad unit IDs only, never ship production IDs from here.
 * Replace the constants with real production IDs (and fill in app-ads.txt,
 * see docs/app-ads.txt) before a Play Store release.
 *
 * Placement rules (locked, demi kenyamanan pengguna — iklan mengganggu adalah
 * keluhan #1 di kategori aplikasi Ramadhan):
 * - Banner: ADAPTIVE banner di BAWAH konten (Beranda + daftar Pertanyaan),
 *   tidak pernah menutupi tombol atau isi.
 * - Interstitial: MAKS 1x per sesi DAN jeda >= 3 menit (lihat InterstitialGate),
 *   hanya di jeda natural (mis. setelah membagikan jawaban), tidak pernah
 *   saat aplikasi dibuka dan tidak pernah menutupi konten yang sedang dibaca.
 */
object AdMobHelper {

    const val BANNER_TEST_ID = "ca-app-pub-3940256099942544/6300978111"
    const val INTERSTITIAL_TEST_ID = "ca-app-pub-3940256099942544/1033173712"

    fun initialize(context: Context) {
        MobileAds.initialize(context)
    }

    /** Anchored adaptive banner sized for the current screen width. */
    fun adaptiveBannerSize(context: Context): AdSize {
        val displayMetrics: DisplayMetrics = context.resources.displayMetrics
        val widthPixels = displayMetrics.widthPixels.toFloat()
        val density = displayMetrics.density
        val adWidth = (widthPixels / density).toInt()
        return AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(context, adWidth)
    }

    fun createBannerAdView(context: Context): AdView {
        return AdView(context).apply {
            setAdSize(adaptiveBannerSize(context))
            adUnitId = BANNER_TEST_ID
            loadAd(AdRequest.Builder().build())
        }
    }

    fun loadInterstitial(context: Context, onLoaded: (InterstitialAd?) -> Unit) {
        InterstitialAd.load(
            context,
            INTERSTITIAL_TEST_ID,
            AdRequest.Builder().build(),
            object : InterstitialAdLoadCallback() {
                override fun onAdLoaded(interstitialAd: InterstitialAd) {
                    onLoaded(interstitialAd)
                }

                override fun onAdFailedToLoad(error: com.google.android.gms.ads.LoadAdError) {
                    onLoaded(null)
                }
            }
        )
    }
}

/**
 * Penjaga interstitial: maks 1x per sesi DAN jeda minimal 3 menit antar tayang.
 * Panggil [maybeShow] hanya di jeda natural (mis. setelah pengguna membagikan
 * jawaban). Jika syarat tidak terpenuhi, tidak terjadi apa-apa.
 */
object InterstitialGate {
    private const val MIN_GAP_MS = 3 * 60 * 1000L
    private var lastShownMs: Long = 0L
    private var shownThisSession: Boolean = false

    fun maybeShow(activity: Activity) {
        val now = System.currentTimeMillis()
        if (shownThisSession) return
        if (now - lastShownMs < MIN_GAP_MS) return
        AdMobHelper.loadInterstitial(activity) { ad ->
            if (ad != null) {
                shownThisSession = true
                lastShownMs = System.currentTimeMillis()
                ad.show(activity)
            }
        }
    }
}
