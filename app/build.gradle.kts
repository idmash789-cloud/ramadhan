plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.plugin.compose")
}

android {
    namespace = "com.sembilansembilan.pertanyaanseputarramadhan"
    // Play requires new apps to target API 36 (Android 16).
    compileSdk = 36

    defaultConfig {
        applicationId = "com.sembilansembilan.pertanyaanseputarramadhan"
        minSdk = 26
        targetSdk = 36
        // PENTING: cek versionCode saat ini di Play Console sebelum rilis.
        // Aplikasi Play Store saat ini versi 2.0; naikkan versionCode bila
        // angka di Play Console sudah >= 3, agar update bisa diterbitkan.
        versionCode = 3
        versionName = "3.0.0"
    }

    buildTypes {
        release {
            // R8 + resource shrinking for a small, fast release AAB.
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions { jvmTarget = "17" }
    buildFeatures { compose = true }
}

dependencies {
    val composeBom = platform("androidx.compose:compose-bom:2024.09.00")
    implementation(composeBom)
    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.activity:activity-compose:1.9.2")
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.compose.material:material-icons-extended")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.8.4")
    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.8.4")
    implementation("androidx.navigation:navigation-compose:2.7.7")
    // Settings/bookmark/kota live in DataStore (Preferences). No Room needed for MVP.
    implementation("androidx.datastore:datastore-preferences:1.1.1")
    // Pengingat sahur/berbuka.
    implementation("androidx.work:work-runtime-ktx:2.9.0")
    implementation("androidx.core:core-splashscreen:1.0.1")

    // AdMob — Google Mobile Ads SDK + UMP Consent SDK. TEST ad unit IDs only
    // during development; see util/AdMobHelper.kt and util/ConsentManager.kt.
    implementation("com.google.android.gms:play-services-ads:23.3.0")
    implementation("com.google.android.ump:user-messaging-platform:2.2.0")

    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
}
