package com.sembilansembilan.pertanyaanseputarramadhan.ui.components

import android.view.View
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.sembilansembilan.pertanyaanseputarramadhan.util.AdMobHelper

@Composable
fun AdBanner() {
    val adsReady by AdMobHelper.adsReady.collectAsState()
    if (!adsReady) return

    Surface {
        Column(
            Modifier.fillMaxWidth().navigationBarsPadding()
        ) {
            HorizontalDivider()
            BoxWithConstraints(Modifier.fillMaxWidth().padding(horizontal = 8.dp)) {
                val widthDp = maxWidth.value.toInt().coerceAtLeast(1)
                key(widthDp) {
                    AndroidView(
                        modifier = Modifier.fillMaxWidth(),
                        factory = { context ->
                            AdView(context).apply {
                                visibility = View.GONE
                                setAdSize(AdMobHelper.adaptiveBannerSize(context, widthDp))
                                adUnitId = AdMobHelper.BANNER_TEST_ID
                                adListener = object : AdListener() {
                                    override fun onAdLoaded() {
                                        visibility = View.VISIBLE
                                    }
                                }
                                loadAd(AdRequest.Builder().build())
                            }
                        },
                        onReset = null,
                        onRelease = { it.destroy() },
                    )
                }
            }
        }
    }
}
