# 99 Pertanyaan Seputar Ramadhan — Aplikasi Android

Aplikasi Android native (Kotlin + Jetpack Compose, Material 3) berisi panduan
ibadah puasa Ramadhan: **99 tanya-jawab fikih puasa dengan referensi kitab
klasik** (Tuhfatul Muhtaj, I'anah ath-Thalibin, Sullam at-Taufiq, dan
kitab-kitab mu'tabar lainnya) + **Buku Saku 10 seksi** + **jadwal imsakiyah
+ pengingat sahur/berbuka + hitung mundur** + tiga seksi baru:
**Kajian NU Online** (15 artikel), **Tanya Jawab PISS-KTB** (20 tanya-jawab
fikih puasa), dan **Kultum Ramadhan** (30 kultum, satu per malam).
Semua konten tersimpan lokal, tanpa akun, tanpa server.

> **Ini adalah rebuild dari nol.** Aplikasi web sebelumnya (repo
> `annas12/ramadhan`, situs live `ramadhan.drama.my.id`) tetap jalan dan
> tidak diubah. Aplikasi Android ini adalah penggantinya di Play Store
> (package sama, versi 3.0.0).

- **Stack:** Kotlin + Jetpack Compose (Material 3), MVVM + StateFlow,
  DataStore (pengaturan/bookmark/kota), WorkManager (pengingat), AdMob
- **Package:** `com.sembilansembilan.pertanyaanseputarramadhan`
  · minSdk 26 · **target/compile SDK 36 (Android 16)**
- **Version:** 3.0.0 (versionCode 3)

## Cara build

1. Clone repo ini, lalu buka folder proyek di **Android Studio Meerkat Feature Drop (2024.3.2) atau versi yang lebih baru dengan dukungan AGP 8.10.1**.
2. Pasang **Android SDK Platform 36** dan pilih **JDK 17 atau 21** sebagai Gradle JDK. Proyek menyertakan Gradle Wrapper 8.11.1.
3. Tunggu **Gradle sync** selesai, pilih perangkat/emulator, lalu klik **Run ▶**. Sinkronisasi pertama memerlukan internet.
4. Untuk build debug via terminal di Windows, jalankan `./gradlew.bat :app:assembleDebug` di PowerShell. APK tersedia di `app/build/outputs/apk/debug/app-debug.apk`. Di macOS/Linux, jalankan `./gradlew :app:assembleDebug`.
5. Untuk AAB rilis, pilih **Build → Generate Signed App Bundle / APK**, lalu pilih `release` dan gunakan upload key yang terdaftar untuk aplikasi Ramadhan di Play Console. Simpan file JKS dan kata sandinya di luar repo.

## Isi aplikasi

- **Beranda:** jadwal imsakiyah hari ini (kota pilihan), hitung mundur ke
  Imsak / Berbuka, kartu menu, catatan "Panduan fikih umum, bukan fatwa
  personal."
- **99 Pertanyaan:** pencarian (judul + pertanyaan + jawaban), jawaban
  expandable, bookmark, bagikan/salin jawaban.
- **Buku Saku:** 10 seksi panduan puasa; isi dirender lengkap termasuk
  **tabel** dan **bold inline** (dua bug tampilan versi web sudah diperbaiki
  di sini) serta baris Arab (RTL).
- **Bookmark:** pertanyaan, seksi Buku Saku, artikel Kajian NU Online,
  tanya-jawab PISS-KTB, dan kultum yang disimpan.
- **Kajian NU Online:** 15 artikel (niat, doa berbuka, tarawih & witir,
  Lailatul Qadar, zakat fitrah, qadha & fidyah, i'tikaf, tadarus, 10 hari
  terakhir, shalat Id & takbiran) — ditulis ulang dari artikel NU Online,
  tiap artikel mencantumkan URL sumbernya.
- **Tanya Jawab PISS-KTB:** 20 tanya-jawab fikih puasa dari
  piss-ktb.com, diparafrase beserta referensi kitabnya; pencarian,
  jawaban expandable, bookmark, bagikan/salin seperti layar 99 Pertanyaan.
- **Kultum Ramadhan:** 30 kultum orisinal (satu per malam, rata-rata ±520
  kata), masing-masing judul + tema + 1 kutipan terverifikasi + isi;
  bookmark, bagikan/salin.
- **Pengaturan:** mode gelap (Terang/Gelap/Sistem), pilih kota (~35 kota
  Indonesia), pengingat sahur/berbuka, Tentang + disclaimer + tautan
  Play Store + bagikan aplikasi.

## Verifikasi konten

Konten dikonversi utuh dari data web (`ramadhanQuestions.ts` dan
`bukuSakuContent.ts`): **99 pertanyaan (id 1–99, semua dengan referensi
kitab)** dan **10 seksi Buku Saku**. Semua paragraf dipertahankan — tidak
ada yang diringkas. Periksa dengan mencari string di
`data/QuestionsData.kt` dan `data/BukuSakuData.kt`.

**Tiga seksi baru TIDAK menyalin artikel mentah-mentah** (hak cipta):
- `data/NuOnlineData.kt` — 15 artikel ditulis ulang (parafrase) dari
  artikel NU Online (`nu.or.id`, `islam.nu.or.id`, kanal daerah NU
  Online: Jabar/Jatim/Lampung); tiap artikel mencantumkan URL sumber.
  Rincian yang tidak terpetakan dari cuplikan pencarian (domain nu.or.id
  tidak bisa dibuka langsung saat riset) tidak ditulis — mis. rincian
  lengkap keempat amalan Lailatul Qadar dan keempat rukun i'tikaf.
  Daftar URL lengkap ada di `content/riset-nu-online.md` (tidak ikut
  push, hanya referensi).
- `data/PissKtbData.kt` — 20 tanya-jawab diparafrase dari
  `piss-ktb.com` (arsip grup Facebook PISS-KTB); referensi kitab ditulis
  persis seperti di sumber; tiap entri mencantumkan URL halaman asalnya.
  3 halaman sempat dicek langsung (No. 2, 9, 19); sisanya dari cuplikan
  pencarian situs. Satu entri dilunakkan bahasanya agar layak semua umur
  (No. 5) tanpa mengubah hukumnya. 2 entri sensitif/grafis sengaja
  tidak dimasukkan. Daftar lengkap + 9 cadangan ada di
  `content/riset-piss-ktb.md` (tidak ikut push).
- `data/KultumData.kt` — 30 kultum ditulis orisinal untuk aplikasi ini
  (bukan salinan); kutipan hanya ayat/hadits yang dikenal luas, dua di
  antaranya ditandai "(makna)" karena redaksinya parafrase makna hadits.
  Draf lengkap ada di `content/kultum-draft.md` (tidak ikut push).

## Jadwal imsakiyah — PENTING sebelum rilis

Waktu sholat dihitung di dalam aplikasi (algoritma posisi matahari gaya
PrayTimes) dengan parameter **Kemenag/MABIMS**: Subuh 20°, Isya 18°,
Maghrib = terbenam matahari, Ashar Syafi'i (faktor 1), Imsak = Subuh − 10
menit, ihtiyat +2 menit untuk Subuh/Dzuhur/Ashar/Maghrib/Isya.
**Waktu hasil hitungan WAJIB dicocokkan dengan jadwal resmi Kemenag
(Jakarta) sebelum rilis** — lihat `imsakiyah/PrayerTimes.kt`.

Pengingat sahur (30 menit sebelum Imsak) dan berbuka (saat Maghrib)
dijadwalkan via WorkManager. Pengingat dapat tertunda saat Android
membatasi proses latar belakang.

## Iklan (AdMob)

- Semua ID iklan di kode ini adalah **TEST ID resmi Google** — jangan
  rilis ke Play Store dengan ID ini.
- Sebelum rilis: ganti dengan production App ID + Ad Unit ID di
  `AndroidManifest.xml` dan `util/AdMobHelper.kt`, isi
  `docs/app-ads.txt` dengan publisher ID asli (ganti
  `pub-XXXXXXXXXXXXXXXX`), lalu host file itu di root domain yang
  dideklarasikan di Play Console.
- Penempatan sopan: banner adaptive di bawah konten (Beranda + daftar
  Pertanyaan + daftar PISS-KTB); interstitial **maks 1x per sesi DAN jeda
  ≥ 3 menit**, hanya setelah aksi selesai (mis. setelah membagikan jawaban).
  Tidak ada banner di daftar/artikel Kajian NU Online dan Kultum (sama
  seperti Buku Saku).
- UMP Consent SDK aktif: formulir persetujuan Google tampil saat
  pertama dibuka bila diwajibkan.

## Sebelum rilis — checklist

- [ ] Cocokkan jadwal imsakiyah dengan jadwal resmi Kemenag (Jakarta).
- [ ] Cek `versionCode` saat ini di Play Console — naikkan bila angka di
      sana sudah >= 3 (versi Play Store saat ini 2.0).
- [ ] Ganti semua TEST ID AdMob dengan production ID + isi `app-ads.txt`.
- [ ] Uji di HP Android sungguhan: buka-tutup layar, pencarian, bookmark,
      mode gelap, pengingat, dan tampilkan iklan (harus iklan test) —
      termasuk layar baru Kajian NU Online, PISS-KTB, dan Kultum (buka
      artikel/kultum dari Beranda dan dari Bookmark).
- [ ] Isi Data Safety di Play Console (lihat `PRIVACY_POLICY.md`).

## Keterbatasan yang diketahui

- APK debug berhasil dibangun di Windows dengan Gradle 8.11.1, JDK 21,
  dan Android SDK 36. Uji instalasi serta fitur di perangkat masih diperlukan.
- Jadwal imsakiyah adalah hasil hitungan lokal, bukan jadwal resmi
  Kemenag (lihat catatan di atas).
- Fase 2 (belum ada): kalkulator zakat fitrah, tadarus/khatam tracker,
  kuis Ramadhan.
