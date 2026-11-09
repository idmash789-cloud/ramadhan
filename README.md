# 99 Pertanyaan Seputar Ramadhan — Aplikasi Android

Aplikasi Android native (Kotlin + Jetpack Compose, Material 3) berisi panduan
ibadah puasa Ramadhan: **99 tanya-jawab fikih puasa dengan referensi kitab
klasik** (Tuhfatul Muhtaj, I'anah ath-Thalibin, Sullam at-Taufiq, dan
kitab-kitab mu'tabar lainnya) + **Buku Saku 10 seksi** + **jadwal imsakiyah
+ pengingat sahur/berbuka + hitung mundur** + tiga seksi baru:
**Kajian NU Online** (15 artikel), **Tanya Jawab PISS-KTB** (20 tanya-jawab
fikih puasa), dan **Kultum Ramadhan** (30 kultum, satu per malam).
Ditambah 5 Quick Wins (v3.0): prompt rating sopan, **Kalkulator Zakat**,
**Puasa Sunnah** (kalender + pengingat), **Bagikan Jadwal sebagai Gambar**,
dan **Tadarus 30 Juz**.
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
- **Prompt rating sopan (QW-1):** dialog "Suka aplikasi ini?" muncul SEKALI
  di layar daftar pertanyaan setelah pengguna membuka 3 jawaban atau
  membagikan 1 jawaban — tidak pernah di Beranda (agar tidak mengganggu
  saat membaca jadwal). Tombol: "Beri rating" (buka Play Store),
  "Nanti" (hitungan dibuka di-nol-kan, boleh muncul lagi nanti),
  "Jangan tanya lagi". Status tersimpan di DataStore (key
  `rating_prompt_state`, `detail_open_count`, `shared_once`).
- **Kalkulator Zakat (QW-2):** satu layar — Zakat Fitrah (2,5 kg beras/jiwa
  × harga beras/kg, bisa diubah, default Rp15.000/kg), Zakat Maal (cek nisab
  85 gram emas × harga emas/gram, bisa diubah, default Rp2.000.000/gram;
  zakat 2,5% bila mencapai nisab, bila belum tampil pesan "belum wajib" +
  selisih ke nisab), Fidyah (jumlah hari × harga satu kali makan, bisa
  diubah, default Rp20.000). Harga tersimpan di DataStore (key
  `zakat_rice_price_per_kg`, `zakat_gold_price_per_gram`,
  `zakat_fidyah_meal_price`). Hasil bisa dibagikan via share sheet (teks
  rapi siap WA). Standar umum BAZNAS; hasil adalah perkiraan, bukan fatwa
  personal. Tanpa iklan.
- **Puasa Sunnah (QW-4):** layar "Puasa Sunnah" menampilkan daftar tanggal
  puasa sunnah 12 bulan ke depan, dihitung dinamis dari tanggal Hijriah —
  bukan hardcode tahunan: Senin–Kamis, Ayyamul Bidh (13–15 Hijriah), Arafah
  (9 Dzulhijjah), Puasa Syawal (6 hari, 2–7 Syawal), Tarwiyah (8 Dzulhijjah),
  Tasu'a & Asyura (9–10 Muharram). Tiap jenis punya titik warna berbeda;
  tiap entri menampilkan tanggal Masehi + tanggal Hijriah + nama jenis +
  keterangan. Ada filter per jenis dan kartu "Puasa sunnah berikutnya".
  Senin–Kamis dan Ayyamul Bidh tidak ditampilkan selama Ramadhan, dan tidak
  ada puasa sunnah yang ditampilkan pada 1 Syawal / 10–13 Dzulhijjah.
  Pengingat: toggle "Pengingat puasa sunnah" di Pengaturan (DataStore key
  `sunnah_reminders_enabled`, default AKTIF). Bila aktif, WorkManager
  (unique work `sunnah_reminder`, terpisah dari `ramadhan_reminder`)
  menampilkan notifikasi pukul 19:00 sehari sebelum tiap puasa sunnah:
  "Besok puasa sunnah: <nama> (<tanggal>)". Best-effort, dijadwalkan ulang
  saat aplikasi dibuka dan setelah restart HP.
- **Bagikan Jadwal sebagai Gambar (QW-5):** dari Beranda, tombol "Bagikan
  sebagai Gambar" merender kartu jadwal imsakiyah hari ini (tanggal Masehi +
  Hijriah perkiraan, 7 waktu, kota, hitung mundur) menjadi gambar PNG
  1080×1500 lalu membagikannya via FileProvider (siap kirim WA/Status).
  Tanggal Hijriah dihitung lokal dengan algoritma Kuwaiti dan SELALU
  berlabel "(perkiraan)" — bisa meleset ±1 hari dari penanggalan resmi.
- **Tadarus 30 Juz (QW-5):** layar "Tadarus" — centang per juz (nama surah
  awal tiap juz ditampilkan), persentase khatam, target tanggal khatam
  (DatePicker) dengan hitungan "X juz/hari agar khatam tepat waktu" dan
  perkiraan tanggal selesai bila membaca 1 juz/hari. Progress tersimpan
  di DataStore (key `tadarus_completed`, `tadarus_target_date`,
  `tadarus_reminder_enabled`). Pengingat dapat diaktifkan dari layar Tadarus
  dan mulai dijadwalkan sekitar pukul 19.00 waktu perangkat. Android dapat
  menunda pengiriman saat membatasi proses latar belakang.
- **Pengaturan:** mode gelap (Terang/Gelap/Sistem), pilih kota (~35 kota
  Indonesia), pengingat sahur/berbuka, pengingat puasa sunnah, Tentang +
  disclaimer + tautan Play Store + bagikan aplikasi.

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

## Jadwal imsakiyah — validasi vs Kemenag (QW-3, SELESAI 9 Nov 2026)

Waktu sholat dihitung di dalam aplikasi (algoritma posisi matahari gaya
PrayTimes) dengan parameter **Kemenag/MABIMS**: Subuh 20°, Isya 18°,
Maghrib = terbenam matahari, Ashar Syafi'i (faktor 1), Imsak = Subuh − 10
menit, ihtiyat +2 menit untuk Subuh/Dzuhur/Ashar/Maghrib/Isya.

**Validasi SUDAH dilakukan 9 Nov 2026** terhadap jadwal resmi SIHAT Kemenag
(`bimasislam.kemenag.go.id/api/sihat`, KOTA JAKARTA — lintang 6°10'12.32"S,
bujur 106°49'51.78"E). Metode: port Python dari `PrayerTimes.kt` yang sama
persis, dihitung untuk koordinat Jakarta aplikasi (-6.2088, 106.8456, WIB),
dibandingkan per waktu. Selisih = aplikasi − Kemenag (menit):

| Tanggal        | Imsak | Subuh | Terbit | Dzuhur | Ashar | Maghrib | Isya |
|----------------|-------|-------|--------|--------|-------|---------|------|
| 9 Nov 2026     | -1    | -1    | +3     | -2     | -1    | -1      | -1   |
| 1 Feb 2027     | -1    | -1    | +3     | -2     | -1    | -2      | -1   |
| 8 Feb 2027 (1 Ramadhan 1448H, prakiraan) | -1 | -1 | +4 | -1 | -1 | -1 | 0 |

Kesimpulan: selisih MAKSIMAL 4 menit (Terbit), selebihnya 0–2 menit.
Aplikasi cenderung 1 menit LEBIH AWAL pada Subuh/Maghrib/Isya — arah yang
aman untuk puasa (Imsak lebih awal; berbuka 1 menit lebih awal masih dalam
toleransi ihtiyat). Terbit aplikasi 3–4 menit LEBIH LAMBAT dari Kemenag
(kemungkinan perbedaan model refraksi/ketinggian pengamat); Terbit bukan
patokan ibadah puasa/salat, jadi dampaknya kecil. Tabel yang sama ada di
KDoc `imsakiyah/PrayerTimes.kt`. Validasi ulang disarankan bila parameter
dihitung diubah. Catatan: 1 Ramadhan 1448H = 8 Feb 2027 masih PRAKIRAAN —
penetapan resmi menunggu sidang isbat Kemenag.

Beranda menampilkan tanggal Hijriah hari ini di bawah tanggal Masehi
(mis. "1 Ramadhan 1448 H (perkiraan)") — dihitung lokal dengan algoritma
Kuwaiti di `imsakiyah/HijriCalendar.kt`. Validasi konversi Hijriah: tepat
(0 hari) untuk 1 Ramadhan 1448H = 8 Feb 2027, 1 Syawal 1448H = 10 Mar 2027,
1 Ramadhan 1446H = 1 Mar 2025, 1 Syawal 1447H = 20 Mar 2026, Arafah 1447H =
26 Mei 2026, Iduladha 1447H = 27 Mei 2026; meleset 1 hari (algoritma 1 hari
lebih lambat) untuk 1 Muharram 1448H, Tasu'a/Asyura 1448H, dan 1 Ramadhan
1447H. Selisih maksimum 1 hari — karena itu semua tanggal Hijriah di
aplikasi berlabel "(perkiraan)".

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
  seperti Buku Saku). Layar Kalkulator Zakat, Puasa Sunnah, dan Tadarus
  juga TANPA iklan.
- UMP Consent SDK aktif: formulir persetujuan Google tampil saat
  pertama dibuka bila diwajibkan.
- QW-3: `AdMobHelper.initialize` memasang `RequestConfiguration` dengan
  `maxAdContentRating = "G"` (General audiences — paling aman untuk
  aplikasi keluarga) SEBELUM `MobileAds.initialize`. Rating "G" saja TIDAK
  cukup untuk memblokir kategori sensitif — SEBELUM ganti ke production ID,
  Dwi WAJIB memblokir kategori sensitif di konsol AdMob:
  AdMob → Blokir kontrol (Blocking controls) → Kategori sensitif
  (Sensitive categories) → blokir antara lain: Perjudian & taruhan,
  Pinjaman (payday loan), Alkohol, Konten dewasa, Kencan. Ulangi untuk
  tiap Ad Unit production setelah dibuat. Tanpa langkah ini, iklan judi /
  pinjol masih bisa muncul meski rating sudah "G".

## Sebelum rilis — checklist

- [x] Cocokkan jadwal imsakiyah dengan jadwal resmi Kemenag (Jakarta) —
      SELESAI 9 Nov 2026, selisih maks 4 menit (lihat atas).
- [ ] Cek `versionCode` saat ini di Play Console — naikkan bila angka di
      sana sudah >= 3 (versi Play Store saat ini 2.0).
- [ ] Ganti semua TEST ID AdMob dengan production ID + isi `app-ads.txt`.
- [ ] Blokir kategori sensitif di konsol AdMob (judi, pinjol, dll. —
      lihat seksi Iklan di atas).
- [ ] Uji di HP Android sungguhan: buka-tutup layar, pencarian, bookmark,
      mode gelap, pengingat, dan tampilkan iklan (harus iklan test) —
      termasuk layar baru Kajian NU Online, PISS-KTB, dan Kultum (buka
      artikel/kultum dari Beranda dan dari Bookmark).
- [ ] Uji 5 Quick Wins di HP: prompt rating (buka 3 jawaban → dialog
      muncul sekali; "Jangan tanya lagi" → tidak muncul lagi), Kalkulator
      Zakat (ubah harga → tutup-buka aplikasi → harga tersimpan; tombol
      Bagikan), Puasa Sunnah (daftar + filter + toggle pengingat),
      "Bagikan sebagai Gambar" (chooser muncul, PNG terbaca), Tadarus
      (centang juz tersimpan, target tanggal + hitungan juz/hari).
- [ ] Isi Data Safety di Play Console (lihat `PRIVACY_POLICY.md`).

## Keterbatasan yang diketahui

- APK debug berhasil dibangun di Windows dengan Gradle 8.11.1, JDK 21,
  dan Android SDK 36. Uji instalasi serta fitur di perangkat masih diperlukan.
- Jadwal imsakiyah adalah hasil hitungan lokal, bukan jadwal resmi
  Kemenag — tapi sudah divalidasi terhadap jadwal resmi SIHAT Kemenag
  (selisih maks 4 menit, lihat atas).
- Tanggal Hijriah di aplikasi adalah perkiraan algoritma Kuwaiti — bisa
  selisih ±1 hari dari penetapan resmi pemerintah; semua tampilan Hijriah
  berlabel "(perkiraan)".
- Fase 2 (belum ada): kuis Ramadhan.
