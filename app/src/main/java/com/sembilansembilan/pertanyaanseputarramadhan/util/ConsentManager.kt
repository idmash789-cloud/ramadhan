package com.sembilansembilan.pertanyaanseputarramadhan.util

import android.app.Activity
import com.google.android.ump.ConsentInformation
import com.google.android.ump.ConsentRequestParameters
import com.google.android.ump.UserMessagingPlatform

/**
 * UMP Consent SDK: cek apakah persetujuan diperlukan saat aplikasi dibuka,
 * tampilkan formulir persetujuan Google bila perlu, baru kemudian inisialisasi iklan.
 * Permintaan iklan hanya diizinkan jika UMP menyatakan iklan boleh diminta.
 */
object ConsentManager {
    fun requestConsent(activity: Activity, onDone: () -> Unit) {
        val consentInformation: ConsentInformation =
            UserMessagingPlatform.getConsentInformation(activity)
        val params = ConsentRequestParameters.Builder().build()
        consentInformation.requestConsentInfoUpdate(
            activity,
            params,
            {
                UserMessagingPlatform.loadAndShowConsentFormIfRequired(activity) { _ ->
                    if (consentInformation.canRequestAds()) onDone()
                }
            },
            { _ -> if (consentInformation.canRequestAds()) onDone() }
        )
    }
}
