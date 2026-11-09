package com.sembilansembilan.pertanyaanseputarramadhan.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.sembilansembilan.pertanyaanseputarramadhan.util.AdMobHelper

/**
 * Anchored adaptive banner. Selalu letakkan DI BAWAH konten utama
 * (mis. di bawah daftar pertanyaan) agar iklan tidak pernah menutupi
 * isi atau tombol.
 */
@Composable
fun AdBanner(modifier: Modifier = Modifier) {
    AndroidView(
        modifier = modifier.fillMaxWidth(),
        factory = { context ->
            AdView(context).apply {
                setAdSize(AdMobHelper.adaptiveBannerSize(context))
                adUnitId = AdMobHelper.BANNER_TEST_ID
                loadAd(AdRequest.Builder().build())
            }
        }
    )
}
