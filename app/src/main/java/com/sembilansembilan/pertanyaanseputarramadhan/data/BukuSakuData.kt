package com.sembilansembilan.pertanyaanseputarramadhan.data

/**
 * Seluruh 10 seksi Buku Saku, disalin persis dari data web
 * (bukuSakuContent.ts): markdown dipertahankan utuh — judul "## "/"### ",
 * tebal "**...**", miring "*...*", tabel "| ... |", daftar,
 * pemisah "---", dan baris Arab.
 */
val bukuSakuSections: List<BukuSakuSection> = listOf(
    BukuSakuSection(
        id = "pengertian",
        title = """Pengertian Puasa""",
        content = """Puasa dalam bahasa Arab adalah "Shiyam" yang berarti menahan diri. Secara bahasa, puasa berarti menahan diri dari perbuatan dan berbicara.

Adapun puasa secara syara' adalah:
**"Menahan diri dari hal-hal yang membatalkan menurut cara tertentu."**

Dalil wajibnya puasa adalah Firman Allah SWT dalam QS. Al-Baqarah ayat 183:

يَا أَيُّهَا الَّذِينَ آمَنُوا كُتِبَ عَلَيْكُمُ الصِّيَامُ كَمَا كُتِبَ عَلَى الَّذِينَ مِنْ قَبْلِكُمْ لَعَلَّكُمْ تَتَّقُونَ

*"Hai orang-orang yang beriman, diwajibkan atas kamu berpuasa sebagaimana diwajibkan atas orang-orang sebelum kamu agar kamu bertakwa."*

Dalam hadits disebutkan bahwa salah satu dasar Rukun Islam adalah puasa:

بُنِيَ الإِسْلَامُ عَلَى خَمْسٍ شَهَادَةِ أَنْ لَا إِلَهَ إِلَّا اللهُ وَأَنَّ مُحَمَّدًا رَسُولُ اللهِ وَإِقَامِ الصَّلَاةِ وَإِيتَاءِ الزَّكَاةِ وَالحَجِّ وَصَوْمِ رَمَضَانَ

*"Islam itu dibangun atas lima dasar: syahadah, shalat, zakat, haji dan puasa Ramadhan."* (HR. Bukhari)

Puasa Ramadhan diwajibkan pada bulan Sya'ban tahun kedua Hijriyah.""",
    ),
    BukuSakuSection(
        id = "rukun",
        title = """Rukun-Rukun Puasa""",
        content = """Rukun puasa ada tiga (3):

## 1. Niat

Berniat dengan hati pada malam hari (dimulai waktu maghrib hingga terbit fajar/subuh) dan disunnahkan melafadzkan niat dengan lisan. Wajib diulang setiap malam puasa.

Dalil yang mewajibkan berniat setiap malamnya adalah hadits:

مَنْ لَمْ يُبَيِّتِ الصِّيَامَ قَبْلَ الْفَجْرِ فَلَا صِيَامَ لَهُ

*"Barangsiapa yang tidak berniat semenjak waktu malam sebelum terbit fajar maka tidaklah sah puasa baginya."* (HR. Abu Dawud, Ibnu Majah dan Ahmad)

**Lafadz Niat Puasa:**

نَوَيْتُ صَوْمَ غَدٍ عَنْ أَدَاءِ فَرْضِ رَمَضَانَ هٰذِهِ السَّنَةِ لِلّٰهِ تَعَالَى

*"Saya niat puasa esok hari untuk menunaikan fardhu Ramadhan tahun ini karena Allah Ta'ala."*

Untuk puasa sunnah, boleh berniat setelah fajar dengan syarat belum melakukan hal yang membatalkan puasa.

## 2. Menahan Diri dari Hal-Hal yang Membatalkan Puasa

Sejak terbit fajar shadiq sampai terbenam matahari.

## 3. Orang yang Berpuasa (Sha'im)

Syarat orang yang berpuasa:
- Beragama Islam
- Berakal
- Suci dari haid dan nifas bagi wanita""",
    ),
    BukuSakuSection(
        id = "pembatal",
        title = """Hal-Hal yang Membatalkan Puasa""",
        content = """## Hal-Hal yang Membatalkan Puasa:

### 1. Bersetubuh (Jima')
Baik mengeluarkan sperma atau tidak. Jika dilakukan pada siang hari Ramadhan maka wajib membayar kafarah.

### 2. Mengeluarkan Mani dengan Sengaja
Seperti onani atau masturbasi. Adapun keluar mani karena mimpi tidak membatalkan puasa.

### 3. Sengaja Muntah
*"Barangsiapa yang terpaksa muntah tidaklah qadha atasnya dan barangsiapa yang sengaja muntah maka hendaklah diqadhanya."*

### 4. Memasukkan Sesuatu ke Dalam Rongga
Semua lubang yang terbuka: hidung, mulut, telinga, vagina, dubur. Termasuk makan dan minum.

### 5. Air Masuk ke Rongga Telinga
Saat menyelam atau mandi dengan cara yang menyebabkan air masuk.

### 6. Murtad
Keluar dari Islam.

### 7. Gila
Walaupun hanya sesaat di siang hari.

### 8. Haid dan Nifas
Bagi wanita.

---

## Yang Tidak Membatalkan Puasa:

- Makan atau minum karena lupa
- Suntik dan infus (tidak sampai ke rongga)
- Berbekam atau donor darah
- Mimpi basah (ihtilam)
- Mencium bau-bauan
- Mencicipi makanan tanpa menelan
- Menggunakan celak mata
- Berkumur tanpa berlebihan
- Sikat gigi tanpa menelan pasta
- Merokok membatalkan puasa (karena mengandung zat/ain)""",
    ),
    BukuSakuSection(
        id = "syarat",
        title = """Syarat Wajib dan Syarat Sah Puasa""",
        content = """## Syarat Wajib Puasa:

1. **Islam** - Puasa tidak wajib bagi orang kafir
2. **Baligh** - Anak yang belum baligh tidak wajib, namun orang tua wajib melatihnya sejak usia 7 tahun
3. **Berakal** - Orang gila tidak wajib puasa
4. **Mampu** - Tidak dalam keadaan sakit yang membahayakan
5. **Mukim** - Musafir mendapat keringanan untuk tidak puasa

## Syarat Sah Puasa:

1. **Islam** - Sepanjang hari puasa
2. **Tamyiz** - Dapat membedakan yang baik dan buruk
3. **Suci dari Haid dan Nifas** - Bagi wanita
4. **Dalam Waktu yang Dibolehkan** - Tidak pada hari yang diharamkan puasa

## Orang yang Boleh Tidak Puasa:

1. **Orang Sakit** - Yang khawatir sakitnya bertambah parah
2. **Musafir** - Dengan jarak minimal 85 km
3. **Wanita Hamil dan Menyusui** - Yang khawatir terhadap dirinya atau bayinya
4. **Orang Tua Renta** - Yang tidak mampu berpuasa
5. **Orang yang Dipaksa** - Dengan ancaman yang membahayakan

## Kewajiban Pengganti:

| Kondisi | Kewajiban |
|---------|-----------|
| Sakit/Musafir | Qadha saja |
| Hamil/Menyusui (khawatir diri) | Qadha saja |
| Hamil/Menyusui (khawatir bayi) | Qadha + Fidyah |
| Orang tua renta | Fidyah saja |
| Meninggal dengan hutang puasa | Fidyah dari harta/ahli waris |""",
    ),
    BukuSakuSection(
        id = "sunnah",
        title = """Sunnah-Sunnah Puasa""",
        content = """## Sunnah-Sunnah Puasa:

### 1. Makan Sahur
Dianjurkan mengakhirkan sahur mendekati waktu subuh.

*"Bersahurlah karena sesungguhnya pada sahur itu ada keberkahan."* (HR. Bukhari Muslim)

### 2. Menyegerakan Berbuka
Berbuka segera setelah yakin matahari terbenam.

*"Manusia akan senantiasa dalam kebaikan selama mereka menyegerakan berbuka."* (HR. Bukhari Muslim)

### 3. Berbuka dengan Kurma atau Air
Sunnah berbuka dengan kurma basah (ruthab), jika tidak ada maka kurma kering (tamr), jika tidak ada maka dengan air.

### 4. Berdoa Saat Berbuka
ذَهَبَ الظَّمَأُ وَابْتَلَّتِ الْعُرُوقُ وَثَبَتَ الأَجْرُ إِنْ شَاءَ اللهُ

*"Telah hilang dahaga, urat-urat telah basah, dan pahala telah ditetapkan insya Allah."*

### 5. Memperbanyak Sedekah
Nabi SAW adalah orang yang paling dermawan di bulan Ramadhan.

### 6. Memperbanyak Membaca Al-Quran
Dianjurkan mengkhatamkan Al-Quran di bulan Ramadhan.

### 7. Shalat Tarawih
Sunnah muakkadah, lebih utama berjamaah di masjid.

### 8. I'tikaf
Terutama di 10 hari terakhir Ramadhan untuk mencari Lailatul Qadar.

### 9. Menjaga Lisan
Menghindari perkataan yang sia-sia, ghibah, dan dusta.

*"Puasa itu adalah perisai. Jika salah seorang dari kalian berpuasa, janganlah berkata kotor dan jangan pula berteriak-teriak. Jika ada orang yang mencacinya atau mengajaknya berkelahi, hendaklah ia berkata: Aku sedang berpuasa."* (HR. Bukhari Muslim)""",
    ),
    BukuSakuSection(
        id = "makruh",
        title = """Makruh dan Haram dalam Puasa""",
        content = """## Hal-Hal yang Makruh dalam Puasa:

1. **Berlebihan dalam Berkumur dan Istinsyaq**
   Memasukkan air ke hidung dan mulut secara berlebihan

2. **Mencicipi Makanan Tanpa Keperluan**
   Kecuali bagi juru masak yang perlu mencicipi

3. **Mengunyah Permen Karet (yang tidak meleleh)**
   Karena dapat mengumpulkan air liur

4. **Berciuman bagi yang Tidak Mampu Menahan Syahwat**
   Terutama bagi pengantin baru

5. **Berbekam**
   Walaupun tidak membatalkan puasa

6. **Memikirkan Syahwat**
   Yang dapat menimbulkan keluarnya mani

## Hal-Hal yang Haram dalam Puasa:

1. **Membatalkan Puasa Wajib Tanpa Udzur**
   Dosa besar dan wajib meng-qadha

2. **Bersetubuh di Siang Hari Ramadhan**
   Wajib meng-qadha dan membayar kafarah

3. **Berpuasa pada Hari yang Diharamkan:**
   - Hari Raya Idul Fitri
   - Hari Raya Idul Adha
   - Hari Tasyrik (11, 12, 13 Dzulhijjah)
   - Puasa wishal (menyambung puasa tanpa berbuka)

4. **Puasa Wanita Tanpa Izin Suami**
   Untuk puasa sunnah

5. **Puasa Separuh Akhir Sya'ban**
   Kecuali bagi yang sudah terbiasa puasa sebelumnya""",
    ),
    BukuSakuSection(
        id = "qadha",
        title = """Qadha dan Fidyah Puasa""",
        content = """## Qadha Puasa

Qadha adalah mengganti puasa yang ditinggalkan.

### Wajib Qadha:
- Orang yang membatalkan puasa dengan sengaja
- Orang sakit yang sudah sembuh
- Musafir yang sudah mukim
- Wanita yang selesai haid/nifas

### Waktu Qadha:
Boleh dilakukan kapan saja, namun wajib diselesaikan sebelum Ramadhan berikutnya.

### Hukum Menunda Qadha:
Jika menunda sampai Ramadhan berikutnya tanpa udzur, wajib membayar fidyah disamping tetap wajib qadha.

---

## Fidyah Puasa

Fidyah adalah denda berupa makanan sebagai pengganti puasa.

### Ukuran Fidyah:
**1 mud** (sekitar 675 gram) beras atau makanan pokok untuk setiap hari.

### Yang Wajib Fidyah:
1. Menunda qadha sampai Ramadhan berikutnya
2. Orang tua renta yang tidak mampu puasa
3. Orang sakit menahun tanpa harapan sembuh
4. Wanita hamil/menyusui yang khawatir terhadap bayinya

### Penerima Fidyah:
Fakir miskin, sama seperti penerima zakat.

---

## Kafarah Puasa

Kafarah wajib bagi yang membatalkan puasa Ramadhan dengan bersetubuh.

### Urutan Kafarah (Tartib):
1. **Memerdekakan budak mukmin**
2. **Jika tidak mampu:** Puasa 2 bulan berturut-turut
3. **Jika tidak mampu:** Memberi makan 60 orang miskin

Kafarah harus dilakukan secara berurutan, tidak boleh memilih yang mudah.""",
    ),
    BukuSakuSection(
        id = "lailatul",
        title = """Lailatul Qadar""",
        content = """## Lailatul Qadar

Lailatul Qadar adalah malam yang penuh keberkahan, lebih baik dari seribu bulan.

### Dalil:

إِنَّا أَنْزَلْنَاهُ فِي لَيْلَةِ الْقَدْرِ ۞ وَمَا أَدْرَاكَ مَا لَيْلَةُ الْقَدْرِ ۞ لَيْلَةُ الْقَدْرِ خَيْرٌ مِنْ أَلْفِ شَهْرٍ

*"Sesungguhnya Kami telah menurunkannya (Al-Quran) pada malam kemuliaan. Dan tahukah kamu apakah malam kemuliaan itu? Malam kemuliaan itu lebih baik dari seribu bulan."* (QS. Al-Qadr: 1-3)

### Waktu Lailatul Qadar:

Malam Lailatul Qadar terjadi di bulan Ramadhan, terutama di **10 malam terakhir** pada malam-malam ganjil (21, 23, 25, 27, 29).

Hadits Nabi SAW:

*"Carilah Lailatul Qadar di sepuluh malam terakhir Ramadhan."* (HR. Bukhari Muslim)

### Tanda-Tanda Lailatul Qadar:

1. Malam yang tenang, tidak terlalu panas dan tidak terlalu dingin
2. Bulan bersinar terang seperti piring besar
3. Di pagi harinya matahari terbit tanpa sinar yang menyilaukan

### Amalan di Malam Lailatul Qadar:

1. **Shalat malam (Qiyamul Lail)**
2. **Membaca Al-Quran**
3. **Berdoa dengan doa yang diajarkan Nabi:**

اَللّٰهُمَّ إِنَّكَ عَفُوٌّ تُحِبُّ الْعَفْوَ فَاعْفُ عَنِّي

*"Ya Allah, sesungguhnya Engkau Maha Pemaaf, Engkau menyukai maaf, maka maafkanlah aku."*

4. **Berzikir dan beristighfar**
5. **I'tikaf di masjid**

### Keutamaan Mendapatkan Lailatul Qadar:

*"Barangsiapa yang mendirikan malam Lailatul Qadar karena iman dan mengharap pahala, maka diampuni dosa-dosanya yang telah lalu."* (HR. Bukhari Muslim)""",
    ),
    BukuSakuSection(
        id = "zakat",
        title = """Zakat Fitrah""",
        content = """## Zakat Fitrah

Zakat fitrah adalah zakat yang wajib dikeluarkan di bulan Ramadhan sebelum shalat Idul Fitri.

### Dalil:

فَرَضَ رَسُولُ اللهِ صَلَّى اللهُ عَلَيْهِ وَسَلَّمَ زَكَاةَ الْفِطْرِ صَاعًا مِنْ تَمْرٍ أَوْ صَاعًا مِنْ شَعِيرٍ

*"Rasulullah SAW mewajibkan zakat fitrah sebanyak satu sha' kurma atau satu sha' gandum."* (HR. Bukhari Muslim)

### Syarat Wajib Zakat Fitrah:

1. Islam
2. Memiliki kelebihan makanan untuk dirinya dan keluarganya pada hari raya dan malamnya
3. Masih hidup saat terbenam matahari malam Idul Fitri

### Ukuran Zakat Fitrah:

**1 sha'** (sekitar 2.7 kg) beras atau makanan pokok untuk setiap jiwa.

### Waktu Mengeluarkan Zakat Fitrah:

| Waktu | Hukum |
|-------|-------|
| Awal Ramadhan | Boleh (Jawaz) |
| Setelah terbenam matahari malam Idul Fitri | Wajib |
| Sebelum shalat Idul Fitri | Sunnah |
| Setelah shalat Idul Fitri | Makruh |
| Setelah hari raya | Haram (menjadi hutang) |

### Penerima Zakat Fitrah:

8 golongan mustahik:
1. Fakir
2. Miskin
3. Amil zakat
4. Muallaf
5. Hamba sahaya
6. Gharim (orang yang berhutang)
7. Fisabilillah
8. Ibnu sabil

Diutamakan fakir miskin di daerah setempat.

### Bayar dengan Uang:

Menurut mazhab Syafi'i: Tidak sah, harus dengan makanan pokok.
Menurut mazhab Hanafi: Boleh dengan uang senilai makanan pokok.""",
    ),
    BukuSakuSection(
        id = "puasa-sunnah",
        title = """Puasa Sunnah""",
        content = """## Puasa-Puasa Sunnah

### 1. Puasa 6 Hari Syawal

*"Barangsiapa puasa Ramadhan kemudian ditambah 6 hari di bulan Syawal, maka seakan ia puasa setahun penuh."* (HR. Muslim)

Boleh dilakukan berturut-turut atau terpisah selama bulan Syawal.

### 2. Puasa Arafah (9 Dzulhijjah)

*"Puasa hari Arafah menghapus dosa setahun sebelum dan setahun sesudahnya."* (HR. Muslim)

Tidak berlaku bagi jamaah haji yang sedang wukuf.

### 3. Puasa Asyura (10 Muharram)

*"Puasa hari Asyura menghapus dosa setahun sebelumnya."* (HR. Muslim)

Dianjurkan menambah puasa 9 Muharram untuk berbeda dengan Yahudi.

### 4. Puasa Senin-Kamis

*"Amal-amal dihadapkan pada hari Senin dan Kamis, maka aku suka amalku dihadapkan sementara aku berpuasa."* (HR. Tirmidzi)

### 5. Puasa Ayyamul Bidh (13, 14, 15 setiap bulan)

*"Jika kamu puasa 3 hari dalam sebulan, puasalah tanggal 13, 14, dan 15."* (HR. Tirmidzi)

### 6. Puasa Daud

Puasa sehari dan berbuka sehari, puasa yang paling dicintai Allah.

### 7. Puasa Bulan Sya'ban

Nabi SAW memperbanyak puasa di bulan Sya'ban.

---

## Hari yang Haram/Makruh Puasa:

### Haram:
- Idul Fitri dan Idul Adha
- Hari Tasyrik (11, 12, 13 Dzulhijjah)

### Makruh:
- Puasa hari Jumat saja
- Puasa hari Sabtu saja
- Puasa sehari sebelum Ramadhan (yaum syak)""",
    ),
)
