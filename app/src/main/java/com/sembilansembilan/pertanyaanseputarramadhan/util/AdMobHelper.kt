package com.sembilansembilan.pertanyaanseputarramadhan.util

import android.app.Activity
import android.content.Context
import android.os.SystemClock
import com.google.android.gms.ads.AdError
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.FullScreenContentCallback
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
 * - Interstitial: maksimal sekali per sesi saat kembali dari bacaan.
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

/** Menayangkan iklan yang sudah siap pada jeda setelah membaca. */
object InterstitialGate {
    private const val MIN_READING_TIME_MS = 20_000L
    private const val MIN_READING_EXITS = 3
    private const val AD_MAX_AGE_MS = 50 * 60 * 1000L
    private var readingExits = 0
    private var shownThisSession = false
    private var loading = false
    private var showing = false
    private var loadedAt = 0L
    private var loadedAd: InterstitialAd? = null

    fun preload(context: Context) {
        if (!AdMobHelper.adsReady.value || shownThisSession || loading || showing) return
        if (freshAd() != null) return

        loading = true
        AdMobHelper.loadInterstitial(context) { ad ->
            loading = false
            loadedAd = ad
            loadedAt = SystemClock.elapsedRealtime()
        }
    }

    fun onReadingExit(activity: Activity, openedAt: Long, onExit: () -> Unit) {
        if (showing) return
        val eligibleRead = SystemClock.elapsedRealtime() - openedAt >= MIN_READING_TIME_MS
        if (eligibleRead) readingExits++
        val ad = freshAd()
        if (!eligibleRead || readingExits < MIN_READING_EXITS || shownThisSession ||
            ad == null || activity.isFinishing || activity.isDestroyed
        ) {
            onExit()
            return
        }

        loadedAd = null
        showing = true
        ad.fullScreenContentCallback = object : FullScreenContentCallback() {
            override fun onAdShowedFullScreenContent() {
                shownThisSession = true
            }

            override fun onAdDismissedFullScreenContent() {
                showing = false
                onExit()
            }

            override fun onAdFailedToShowFullScreenContent(error: AdError) {
                showing = false
                onExit()
            }
        }
        ad.show(activity)
    }

    private fun freshAd(): InterstitialAd? {
        if (SystemClock.elapsedRealtime() - loadedAt >= AD_MAX_AGE_MS) loadedAd = null
        return loadedAd
    }
}
