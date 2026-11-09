package com.sembilansembilan.pertanyaanseputarramadhan.ui.components

import android.content.Context
import android.graphics.Typeface
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.google.android.gms.ads.AdLoader
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.nativead.MediaView
import com.google.android.gms.ads.nativead.NativeAd
import com.google.android.gms.ads.nativead.NativeAdView
import com.sembilansembilan.pertanyaanseputarramadhan.util.AdMobHelper
import kotlin.math.roundToInt

fun <T> LazyListScope.itemsWithNativeAds(
    entries: List<T>,
    every: Int,
    key: (T) -> Any,
    precedingItems: Int = 0,
    content: @Composable (T) -> Unit,
) {
    entries.forEachIndexed { index, entry ->
        val entryKey = key(entry)
        item(key = entryKey) { content(entry) }
        if ((precedingItems + index + 1) % every == 0) {
            item(key = "native:$entryKey", contentType = "native") { AdNativeCard() }
        }
    }
}

@Composable
fun AdNativeCard() {
    val adsReady by AdMobHelper.adsReady.collectAsState()
    if (!adsReady) return
    val context = LocalContext.current
    var ad by remember { mutableStateOf<NativeAd?>(null) }
    DisposableEffect(context) {
        var active = true
        var loadedAd: NativeAd? = null
        AdLoader.Builder(context, AdMobHelper.NATIVE_TEST_ID)
            .forNativeAd { result ->
                if (active) {
                    loadedAd = result
                    ad = result
                } else {
                    result.destroy()
                }
            }
            .build()
            .loadAd(AdRequest.Builder().build())
        onDispose {
            active = false
            loadedAd?.destroy()
        }
    }

    val loaded = ad ?: return
    val background = MaterialTheme.colorScheme.surfaceVariant.toArgb()
    val foreground = MaterialTheme.colorScheme.onSurfaceVariant.toArgb()
    AndroidView(
        modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
        factory = { NativeCardView(it) },
        update = { it.bind(loaded, background, foreground) },
        onReset = null,
        onRelease = { it.destroy() },
    )
}

private class NativeCardView(context: Context) : FrameLayout(context) {
    private val adView = NativeAdView(context)
    private val label = TextView(context).apply { text = "Iklan"; textSize = 12f }
    private val headline = TextView(context).apply {
        textSize = 16f
        setTypeface(null, Typeface.BOLD)
    }
    private val icon = ImageView(context).apply { scaleType = ImageView.ScaleType.FIT_CENTER }
    private val media = MediaView(context)
    private val body = TextView(context)
    private val action = Button(context)
    private var boundAd: NativeAd? = null

    init {
        val padding = dp(12)
        addView(adView, ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT))
        adView.addView(LinearLayout(context).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(padding, padding, padding, padding)
            addView(label)
            addView(LinearLayout(context).apply {
                gravity = android.view.Gravity.CENTER_VERTICAL
                addView(icon, LinearLayout.LayoutParams(dp(40), dp(40)).apply { marginEnd = dp(8) })
                addView(headline, LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f))
            })
            addView(media, LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, dp(160)))
            addView(body)
            addView(action)
        }, ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT))
        adView.headlineView = headline
        adView.iconView = icon
        adView.mediaView = media
        adView.bodyView = body
        adView.callToActionView = action
    }

    fun bind(ad: NativeAd, background: Int, foreground: Int) {
        setBackgroundColor(background)
        label.setTextColor(foreground)
        headline.setTextColor(foreground)
        body.setTextColor(foreground)
        if (boundAd === ad) return
        headline.text = ad.headline
        val iconDrawable = ad.icon?.drawable
        icon.setImageDrawable(iconDrawable)
        icon.visibility = if (iconDrawable == null) View.GONE else View.VISIBLE
        body.text = ad.body
        body.visibility = if (ad.body.isNullOrBlank()) View.GONE else View.VISIBLE
        action.text = ad.callToAction
        action.visibility = if (ad.callToAction.isNullOrBlank()) View.GONE else View.VISIBLE
        val mediaContent = ad.mediaContent
        media.visibility = if (mediaContent == null) View.GONE else View.VISIBLE
        if (mediaContent != null) media.setMediaContent(mediaContent)
        adView.setNativeAd(ad)
        boundAd = ad
    }

    fun destroy() = adView.destroy()

    private fun dp(value: Int): Int = (value * resources.displayMetrics.density).roundToInt()
}
