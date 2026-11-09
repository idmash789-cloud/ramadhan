# R8 rules for the release build.
# Data classes: keep content models and their fields.
-keep class com.sembilansembilan.pertanyaanseputarramadhan.data.** { *; }
-keepclassmembers class com.sembilansembilan.pertanyaanseputarramadhan.data.** { *; }
# AdMob / Play services: keep public APIs used via reflection.
-keep class com.google.android.gms.ads.** { *; }
