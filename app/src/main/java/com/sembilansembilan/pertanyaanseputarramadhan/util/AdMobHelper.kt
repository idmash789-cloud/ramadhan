package com.sembilansembilan.pertanyaanseputarramadhan.util

import android.app.Activity
import android.content.Context
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.RequestConfiguration
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

/**
 * AdMob helper — TEST ad unit IDs only, never ship production IDs from here.
 * Replace the constants with real production IDs (and fill in app-ads.txt,
 * see docs/app-ads.txt) before a Play Store release.
 *
 * Placement rules (locked, demi kenyamanan pengguna — iklan mengganggu adalah
 * keluhan #1 di kategori aplikasi Ramadhan):
 * - Banner tetap di bawah, native disisipkan di daftar.
 * - Interstitial: MAKS 1x per sesi DAN jeda >= 3 menit (lihat InterstitialGate),
 *   hanya di jeda natural (mis. setelah membagikan jawaban), tidak pernah
 *   saat aplikasi dibuka dan tidak pernah menutupi konten yang sedang dibaca.
 */
object AdMobHelper {

    const val BANNER_TEST_ID = "ca-app-pub-3940256099942544/6300978111"
    const val NATIVE_TEST_ID = "ca-app-pub-3940256099942544/2247696110"
    const val INTERSTITIAL_TEST_ID = "ca-app-pub-3940256099942544/1033173712"

    private val _adsReady = MutableStateFlow(false)
    val adsReady = _adsReady.asStateFlow()

    fun initialize(context: Context) {
        if (_adsReady.value) return
        // QW-3 — rating konten iklan "G" (General audiences, paling aman
        // untuk aplikasi keluarga). Ini membatasi iklan ke konten yang cocok
        // untuk semua umur; pemblokiran kategori sensitif (judi, pinjol,
        // dll.) tetap harus dilakukan di konsol AdMob — lihat README.
        // Harus dipanggil SEBELUM MobileAds.initialize.
        MobileAds.setRequestConfiguration(
            RequestConfiguration.Builder()
                .setMaxAdContentRating(RequestConfiguration.MAX_AD_CONTENT_RATING_G)
                .build()
        )
        MobileAds.initialize(context.applicationContext) { _adsReady.value = true }
    }

    fun adaptiveBannerSize(context: Context, widthDp: Int): AdSize =
        AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(context, widthDp)

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
    private var loading = false

    fun maybeShow(activity: Activity) {
        val now = System.currentTimeMillis()
        if (!AdMobHelper.adsReady.value || shownThisSession || loading) return
        if (now - lastShownMs < MIN_GAP_MS) return
        loading = true
        AdMobHelper.loadInterstitial(activity) { ad ->
            loading = false
            if (ad != null && !activity.isFinishing && !activity.isDestroyed) {
                shownThisSession = true
                lastShownMs = System.currentTimeMillis()
                ad.show(activity)
            }
        }
    }
}
