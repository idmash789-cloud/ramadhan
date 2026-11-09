package com.sembilansembilan.pertanyaanseputarramadhan.data

/**
 * 15 artikel Kajian NU Online (https://www.nu.or.id, https://islam.nu.or.id
 * dan kanal daerah NU Online). Isi ditulis ulang (parafrase) dengan
 * kata-kata sendiri dari artikel sumber — bukan salinan mentah; tiap entri
 * mencantumkan URL artikel asalnya sebagai atribusi. Lafal niat/doa dalam
 * bahasa Arab dicantumkan karena memang dibutuhkan sebagai materi, beserta
 * latin dan artinya. Kutipan Al-Qur'an/hadits hanya yang tercantum jelas
 * di sumber atau sudah dikenal luas.
 * Catatan verifikasi: domain nu.or.id tidak dapat dibuka langsung saat
 * riset (diblokir kebijakan alat), sehingga isi diverifikasi dari cuplikan
 * pencarian yang mengutip artikel NU Online secara langsung; rincian yang
 * tidak terpetakan dari cuplikan tidak ditulis (mis. rincian keempat
 * amalan Lailatul Qadar dan rincian lengkap keempat rukun i'tikaf).
 */
val nuOnlineArticles: List<NuArticle> = listOf(
    NuArticle(
        id = "nu-01",
        title = """Niat Puasa Ramadhan dalam 6 Versi""",
        content = """NU Online memuat enam redaksi lafal niat puasa Ramadhan yang bersumber dari kitab-kitab fikih, sehingga pembaca bisa memilih salah satu yang paling mudah dihafal.

**Redaksi pertama** — dari Kitab *Minhajut Thalibin* dan *Perukunan Melayu*:

نَوَيْتُ صَوْمَ غَدٍ عَنْ أَدَاءِ فَرْضِ شَهْرِ رَمَضَانَ هَذِهِ السَّنَةِ لِلَّهِ تَعَالَى

*"Nawaitu shauma ghadin 'an adā'i fardhi syahri Ramadhāna hādzihis sanati lillāhi ta'ālā."*

*"Aku berniat puasa esok hari demi menunaikan kewajiban bulan Ramadhan tahun ini karena Allah ta'ala."*

Redaksi lain berasal dari *Hasyiyatul Jamal* dan *Irsyadul Anam*, dua redaksi dari *Asnal Mathalib*, serta dua redaksi yang lebih pendek dari *I'anatut Thalibin* karya Sayyid Abi Bakar Syatha ad-Dimyathi, antara lain:

نَوَيْتُ صَوْمَ رَمَضَانَ

*"Nawaitu shauma Ramadhāna."* — *"Aku berniat puasa bulan Ramadhan."*

نَوَيْتُ صَوْمَ غَدٍ مِنْ رَمَضَانَ

*"Nawaitu shauma ghadin min Ramadhāna."* — *"Aku berniat puasa esok hari pada bulan Ramadhan."*

**Waktu berniat:** niat puasa Ramadhan dilakukan pada malam hari, yaitu setelah matahari terbenam sampai sebelum terbit fajar shadiq (waktu imsak). Pelafalan bisa diucapkan dengan lisan, tetapi yang terpenting adalah niat hadir di dalam hati.

**Perbedaan mazhab:** menurut mazhab Syafi'i, niat wajib dilakukan setiap malam (satu niat untuk satu hari puasa). Menurut mazhab Maliki, diperbolehkan berniat satu kali untuk sebulan penuh di awal bulan.""",
        source = """https://www.nu.or.id/nasional/niat-puasa-ramadhan-dalam-6-versi-nomor-5-paling-pendek-diADO""",
    ),
    NuArticle(
        id = "nu-02",
        title = """Panduan Lengkap Puasa Ramadhan""",
        content = """Panduan menyeluruh tentang puasa Ramadhan: pengertian, hukum, tata cara, dan keutamaannya.

**Hukum dan waktu puasa:** puasa Ramadhan wajib bagi Muslim yang sudah baligh, mampu, sehat, dan tidak sedang bepergian jauh (jarak sekitar 82 km). Waktunya dari terbit fajar sampai terbenam matahari selama sebulan penuh.

**Lafal niat:**

نَوَيْتُ صَوْمَ غَدٍ عَنْ أَدَاءِ فَرْضِ شَهْرِ رَمَضَانَ هَذِهِ السَّنَةِ لِلَّهِ تَعَالَى

*"Nawaitu shauma ghadin 'an adā'i fardhi syahri Ramadhāna hādzihis sanati lillāhi ta'ālā."*

*"Aku berniat puasa esok hari demi menunaikan kewajiban bulan Ramadhan tahun ini karena Allah ta'ala."*

Ada pula niat puasa sebulan penuh mengikuti Imam Malik, dari kitab *Sabīl al-Hudā* karya KH A. Idris Marzuki:

نَوَيْتُ صَوْمَ جَمِيعِ شَهْرِ رَمَضَانَ هَذِهِ السَّنَةِ تَقْلِيدًا لِلْإِمَامِ مَالِكٍ فَرْضًا لِلَّهِ تَعَالَى

*"Nawaitu shauma jamī'i syahri Ramadhāna hādzihis sanati taqlīdan lil Imām Mālikin fardhan lillāhi ta'ālā."*

*"Aku berniat puasa sebulan penuh bulan Ramadhan tahun ini mengikuti Imam Malik, fardhu karena Allah ta'ala."*

**Rukun puasa:** berniat pada malam hari, menahan diri dari hal-hal yang membatalkan sejak terbit fajar sampai terbenam matahari, dan orang yang berpuasa.

**Keutamaan puasa Ramadhan** — mengutip Syekh 'Izzuddin (w. 1181 M) dalam *Maqāshidush Shaum*:

1. Diangkatnya derajat di sisi Allah karena banyaknya amal ibadah berpahala besar.
2. Puasa menjadi kontrol syahwat, sehingga terhindar dari godaan setan (syahwat disebut pintu masuk utama setan).
3. Pahala dilipatgandakan: setiap amal kebaikan dibalas sepuluh kebaikan yang semisal hingga tujuh ratus kali lipat, sampai besaran yang Allah kehendaki.

Rasulullah saw bersabda: *"Ketika Ramadhan tiba, dibukalah pintu-pintu surga, ditutuplah pintu-pintu neraka dan setan pun dibelenggu."* (HR Imam Muslim)""",
        source = """https://islam.nu.or.id/ramadhan/panduan-lengkap-puasa-ramadhan-dalil-tata-cara-dan-ketentuannya-y9BJv""",
    ),
    NuArticle(
        id = "nu-03",
        title = """Doa Buka Puasa: 4 Lafal yang Bisa Dipilih""",
        content = """NU Online menyajikan empat versi doa berbuka puasa beserta sumbernya, sehingga pembaca bisa memilih salah satu.

**1. Riwayat sahabat Mu'adz bin Zuhrah:**

اللَّهُمَّ لَكَ صُمْتُ وَعَلَى رِزْقِكَ أَفْطَرْتُ

*"Allāhumma laka shumtu wa 'alā rizqika afthartu."*

*"Ya Allah, hanya untuk-Mu kami berpuasa dan atas rezeki yang Engkau berikan kami berbuka."*

**2. Riwayat sahabat Abdullah bin 'Umar:**

ذَهَبَ الظَّمَأُ وَابْتَلَّتِ الْعُرُوقُ وَثَبَتَ الْأَجْرُ إِنْ شَاءَ اللَّهُ

*"Dzahabazh-zhama'u wabtallatil-'urūqu wa tsabatal-ajru insyā-Allāh."*

*"Telah hilang rasa haus dan urat-urat telah basah serta pahala tetap, insyaallah."*

**3. Kitab *Fathul Mu'in* (juz 2, h. 279):** disunnahkan membaca doa setelah selesai berbuka dengan lafal riwayat Mu'adz bin Zuhrah; bagi yang berbuka dengan air ditambahkan doa riwayat Abdullah bin 'Umar.

**4. Sulaiman al-Bujairimi dalam *Hasyiyah Iqna'*:** doa gabungan yang lebih panjang, memuat unsur iman dan tawakal (*"wa bika āmantu, wa bika wa 'alaika tawakkaltu"*), ditutup dengan *"Yā wāsi'al-fadhli ighfir lī"* dan *"Alhamdulillāhilladzī hadānī fashumtu, wa razaqanī fa-afthartu."*

Doa-doa di atas juga dirangkai para ulama menjadi satu bacaan panjang yang umum diamalkan di Indonesia:

اللَّهُمَّ لَكَ صُمْتُ وَبِكَ آمَنْتُ وَعَلَى رِزْقِكَ أَفْطَرْتُ بِرَحْمَتِكَ يَا أَرْحَمَ الرَّاحِمِينَ

*"Allāhumma laka shumtu wa bika āmantu wa 'alā rizqika afthartu birahmatika yā arhamar-rāhimīn."*

*"Ya Allah, untuk-Mu aku berpuasa, dengan-Mu aku beriman, dan atas rezeki-Mu aku berbuka, dengan rahmat-Mu wahai Yang Maha Pengasih."*""",
        source = """https://nu.or.id/nasional/doa-buka-puasa-berbagai-versi-dan-waktu-membacanya-kOu9a""",
    ),
    NuArticle(
        id = "nu-04",
        title = """Doa Buka Puasa: Dibaca Sesudah Berbuka atau Sebelumnya?""",
        content = """Kapan waktu yang tepat membaca doa berbuka: sebelum berbuka atau sesudahnya?

Menurut Syekh Abu Bakar Muhammad Syatha dalam *Hasyiyah I'anatut Thalibin* (juz 2, h. 279), waktu membaca doa berbuka adalah **setelah** berbuka, bukan sebelum atau saat berbuka — merujuk pada makna yang terkandung dalam doa itu sendiri.

Syekh Said bin Muhammad Ba'ali dalam kitab *Busyra al-Karim* (h. 598) menjelaskan: disunnahkan membaca doa ketika hendak berbuka, tetapi yang **lebih utama** adalah setelah berbuka.

Membaca doa sebelum berbuka tetap mendapatkan kesunnahan pokok (*hushul ashli as-sunnah*), tetapi membaca setelah selesai berbuka dinilai lebih sempurna (*kamal as-sunnah*).

Jadi, yang paling utama: berbuka dulu, lalu membaca doa. Membaca doa sebelum berbuka pun tetap baik dan tetap mendapatkan kesunnahan.""",
        source = """https://nu.or.id/ramadhan/doa-buka-puasa-dibaca-sesudah-berbuka-atau-sebelumnya-NKzEr""",
    ),
    NuArticle(
        id = "nu-05",
        title = """Lafal Doa Malam Lailatul Qadar""",
        content = """Doa yang diajarkan Rasulullah saw kepada Sayyidah Aisyah ra ketika beliau bertanya doa apa yang dibaca jika menjumpai Lailatul Qadar.

Aisyah ra bertanya: *"Wahai Rasulullah, jika aku kedapatan menjumpai Lailatul Qadar, bagaimana doa yang harus kubaca?"* Rasulullah saw menjawab: *"Bacalah: Allāhumma innaka 'afuwwun karīmun tuhibbul 'afwa fa'fu 'annī."* (HR At-Tirmidzi No. 3513, Ibnu Majah No. 3850)

**Redaksi pertama:**

اللَّهُمَّ إِنَّكَ عَفُوٌّ كَرِيمٌ تُحِبُّ الْعَفْوَ فَاعْفُ عَنِّي

*"Allāhumma innaka 'afuwwun karīmun tuhibbul 'afwa fa'fu 'annī."*

*"Ya Allah, sungguh Engkau Maha Pemaaf yang Pemurah. Engkau juga menyukai maaf. Oleh karena itu, maafkanlah aku."*

**Redaksi kedua** (tanpa kata "karīm"):

اللَّهُمَّ إِنَّكَ عَفُوٌّ تُحِبُّ الْعَفْوَ فَاعْفُ عَنِّي

*"Allāhumma innaka 'afuwwun tuhibbul 'afwa fa'fu 'annī."*

*"Ya Allah, sesungguhnya Engkau Maha Pemaaf, mencintai pemaafan, maka maafkanlah aku."*

Bila dibaca berjamaah, kata *"annī"* (aku) diganti *"annā"* (kami).

Lailatul Qadar tidak diketahui pasti waktunya, tetapi dianjurkan mencarinya pada 10 malam terakhir Ramadhan, khususnya malam-malam ganjil (21, 23, 25, 27, 29).""",
        source = """https://www.nu.or.id/nasional/lafal-doa-malam-lailatul-qadar-lengkap-dengan-latin-dan-terjemah-l6aaw""",
    ),
    NuArticle(
        id = "nu-06",
        title = """Amalan Lailatul Qadar""",
        content = """Lailatul Qadar adalah malam yang lebih baik dari seribu bulan (sekitar 83 tahun 4 bulan). Rasulullah saw bersabda: *"Carilah Lailatul Qadar pada tanggal ganjil dari 10 hari terakhir bulan Ramadhan."* (HR Bukhari, dari Aisyah ra)

Amalan-amalan utama yang dianjurkan pada malam Lailatul Qadar menurut sunnah Nabi:

**1. Shalat malam.** Rasulullah saw bersabda: *"Barangsiapa shalat malam karena iman dan mengharapkan pahala, maka diampuni dosa-dosanya yang telah lampau."* (HR Imam Ahmad)

**2. Membaca Al-Qur'an.** Memperbanyak tilawah pada malam-malam terakhir Ramadhan, meneladani Rasulullah saw yang bertadarus Al-Qur'an bersama Malaikat Jibril setiap malam Ramadhan.

**3. Berdoa.** Terutama dengan doa yang diajarkan Nabi kepada Aisyah ra:

اللَّهُمَّ إِنَّكَ عَفُوٌّ كَرِيمٌ تُحِبُّ الْعَفْوَ فَاعْفُ عَنِّي

*"Allāhumma innaka 'afuwwun karīmun tuhibbul 'afwa fa'fu 'annī."* (HR At-Tirmidzi No. 3513, Ibnu Majah No. 3850)

**4. I'tikaf.** Berdiam diri di masjid dengan niat beribadah — shalat, dzikir, dan membaca Al-Qur'an — terutama pada 10 malam terakhir Ramadhan untuk memburu Lailatul Qadar.

Kuncinya: hidupkan malam-malam ganjil di 10 hari terakhir dengan ibadah, sebagaimana teladan Rasulullah saw.""",
        source = """https://www.nu.or.id/ramadhan/4-amalan-paling-utama-lailatul-qadar-menurut-sunah-nabi-nomor-4-sering-terlewatkan-C7wa2""",
    ),
    NuArticle(
        id = "nu-07",
        title = """Niat dan Tata Cara Shalat Tarawih Sendiri di Rumah""",
        content = """Shalat tarawih adalah shalat sunnah khusus malam Ramadhan, dikerjakan setelah shalat Isya dan sebelum witir; bukan ibadah wajib.

**Jumlah rakaat:** umumnya 8 atau 20 rakaat, ditutup witir 3 rakaat. Rakaat yang dikerjakan Nabi Muhammad saw adalah 8 rakaat ditutup 3 rakaat witir (total 11 rakaat). Untuk 8 rakaat, formasi yang bisa dipakai antara lain 4-4-3, 2-2-2-2-2-1, atau 4-4-2-1. Untuk 20 rakaat dikerjakan 2 rakaat salam sebanyak 10 kali, lalu witir 2 rakaat + 1 rakaat (dua kali salam).

**Niat tarawih sendiri:**

أُصَلِّي سُنَّةَ التَّرَاوِيحِ رَكْعَتَيْنِ مُسْتَقْبِلَ الْقِبْلَةِ أَدَاءً لِلَّهِ تَعَالَى

*"Ushallī sunnatat-tarāwīhi rak'ataini mustaqbilal-qiblati adā'an lillāhi ta'ālā."*

*"Aku niat shalat sunnah tarawih dua rakaat menghadap kiblat karena Allah ta'ala."*

**Tata cara per dua rakaat** (menurut mazhab Syafi'i): melafalkan niat, niat di dalam hati saat takbiratul ihram, mengucap takbir, membaca ta'awudz dan Surat Al-Fatihah lalu salah satu surat pendek Al-Qur'an dengan lantang, kemudian rukuk, i'tidal, sujud, duduk di antara dua sujud, sujud kedua, lalu salam pada rakaat kedua; diulang sampai jumlah rakaat terpenuhi.

Dianjurkan membaca istighfar dan doa kamilin setelah selesai tarawih.""",
        source = """https://www.nu.or.id/nasional/niat-dan-tata-cara-shalat-tarawih-sendiri-di-rumah-MpiPI""",
    ),
    NuArticle(
        id = "nu-08",
        title = """Tata Cara dan Bacaan Shalat Witir""",
        content = """Witir adalah shalat penutup malam, dikerjakan setelah Isya sampai menjelang Subuh. Rasulullah saw mengerjakan witir pada akhir malam (HR Imam Ahmad).

**Witir 3 rakaat** bisa dikerjakan dengan dua cara:

1. **2 rakaat + 1 rakaat** (dua kali salam) — cara ini lebih utama.
2. **3 rakaat sekaligus** dengan 1 salam (tanpa tasyahud di rakaat kedua, agar tidak menyerupai shalat Maghrib).

**Bacaan surat yang dianjurkan:** rakaat pertama Al-Fatihah + Al-A'la, rakaat kedua Al-Fatihah + Al-Kafirun, rakaat ketiga Al-Fatihah + Al-Ikhlas, Al-Falaq, dan An-Nas. Jika witir 1 rakaat: Al-Fatihah lalu Al-Ikhlas, Al-Falaq, dan An-Nas.

**Niat witir 2 rakaat:**

أُصَلِّي سُنَّةَ الْوِتْرِ رَكْعَتَيْنِ لِلَّهِ تَعَالَى

*"Ushallī sunnatal-witri rak'ataini lillāhi ta'ālā."* — *"Aku niat shalat sunnah witir dua rakaat karena Allah ta'ala."*

**Niat witir 1 rakaat:**

أُصَلِّي سُنَّةَ الْوِتْرِ رَكْعَةً لِلَّهِ تَعَالَى

*"Ushallī sunnatal-witri rak'atan lillāhi ta'ālā."* — *"Aku niat shalat sunnah witir satu rakaat karena Allah ta'ala."*

Tata cara gerakannya sama seperti shalat fardhu pada umumnya; yang membedakan adalah niat dan jumlah rakaat. Setelah salam terakhir, dilanjutkan membaca doa witir yang masyhur:

اللَّهُمَّ اهْدِنِي فِيمَنْ هَدَيْتَ وَعَافِنِي فِيمَنْ عَافَيْتَ وَتَوَلَّنِي فِيمَنْ تَوَلَّيْتَ وَبَارِكْ لِي فِيمَا أَعْطَيْتَ وَقِنِي شَرَّ مَا قَضَيْتَ

*"Allāhumma ihdinī fīman hadaita wa 'āfinī fīman 'āfaita wa tawallanī fīman tawallaita wa bārik lī fīmā a'thaita wa qinī syarra mā qadhaita."*

*"Ya Allah, berilah aku petunjuk sebagaimana orang yang telah Engkau beri petunjuk, berilah aku keselamatan sebagaimana orang yang telah Engkau beri keselamatan, jadilah wali bagiku sebagaimana orang yang telah Engkau jadikan wali, berkahilah apa yang telah Engkau berikan kepadaku, dan lindungilah aku dari keburukan apa yang telah Engkau tetapkan."*""",
        source = """https://www.nu.or.id/nasional/tata-cara-dan-bacaan-shalat-witir-lengkap-dengan-niat-dan-doa-Zt0Om""",
    ),
    NuArticle(
        id = "nu-09",
        title = """Tuntunan Praktis Zakat Fitrah""",
        content = """Zakat fitrah adalah kewajiban setiap Muslim saat Idul Fitri; kewajiban ini mulai berlaku sejak tahun kedua Hijriah, tepat sebelum disyariatkannya kewajiban puasa Ramadhan. Zakat fitrah menjadi penyempurna ibadah puasa Ramadhan.

Rasulullah saw bersabda (dari Ibnu 'Umar ra): *"Rasulullah shallallahu 'alaihi wa sallam telah mewajibkan zakat fitrah sebesar satu sha' kurma atau satu sha' gandum atas hamba sahaya, orang merdeka, laki-laki maupun perempuan, anak kecil atau dewasa, dari orang-orang Islam, dan beliau menyuruh menunaikannya sebelum orang-orang keluar untuk shalat hari raya."* (HR Bukhari, No. 1432)

**Syarat wajib:** beragama Islam, merdeka (bukan hamba sahaya), dan memiliki makanan pokok pada saat Idul Fitri (untuk siang dan malamnya). Wajib atas setiap Muslim — laki-laki maupun perempuan, anak kecil maupun dewasa — untuk dirinya dan orang-orang yang nafkahnya menjadi tanggungannya.

**Takaran:** satu sha' makanan pokok (di Indonesia umumnya beras; sebagian lain sagu atau gandum), sekitar **2,7–3,0 kilogram per jiwa**. Sebagai kehati-hatian, sebagian ulama menyarankan 2,5–3 kg.

**Waktu menunaikan** dibagi lima: mubah (boleh), wajib, sunnah, makruh, dan haram. Sudah boleh dibayarkan sejak awal Ramadhan; wajib ditunaikan sebelum orang-orang keluar untuk shalat Id; haram bila dibayarkan sehari setelah Idul Fitri tanpa uzur.

**Niat** wajib ada di dalam hati dan dianjurkan dilafalkan. Niat untuk diri sendiri:

نَوَيْتُ أَنْ أُخْرِجَ زَكَاةَ الْفِطْرِ عَنْ نَفْسِي فَرْضًا لِلَّهِ تَعَالَى

*"Nawaitu an ukhrija zakātal fithri 'an nafsī fardhan lillāhi ta'ālā."*

*"Aku niat mengeluarkan zakat fitrah untuk diriku sendiri, fardhu karena Allah Ta'ala."*

Artikel sumber juga memuat niat zakat fitrah untuk istri, anak laki-laki, anak perempuan, serta diri sendiri dan keluarga.

**Penerima zakat (mustahiq):** salah satu dari delapan golongan — fakir, miskin, amil, muallaf, budak (riqab), orang yang terlilit utang (gharim), orang yang berjuang di jalan Allah (fi sabilillah), dan musafir (ibnu sabil).

Penerima zakat dianjurkan mendoakan pemberi zakat (muzakki); contoh doanya termaktub dalam kitab *Taqriratus Sadidah* karya Habib Hasan Ahmad Muhammad al-Kaf.

**Catatan fikih:** menurut jumhur ulama termasuk mazhab Syafi'i, zakat fitrah sebaiknya diberikan dalam bentuk makanan pokok, bukan uang. Mazhab Hanafi membolehkan dengan uang senilai makanan pokok. Lembaga Bahtsul Masail PBNU pernah membahas hal ini.

Besaran zakat fitrah dalam bentuk uang per daerah ditetapkan BAZNAS provinsi/kabupaten dan berubah tiap tahun mengikuti harga beras setempat — cek pengumuman BAZNAS daerah masing-masing.""",
        source = """https://islam.nu.or.id/syariah/tuntunan-praktis-zakat-fitrah-jWpVw""",
    ),
    NuArticle(
        id = "nu-10",
        title = """Hal-Hal yang Membatalkan Puasa""",
        content = """Berdasarkan kitab *Fath al-Qarib* dan *Fath al-Mu'in* (juz 1, h. 259), berikut hal-hal yang membatalkan puasa:

1. **Masuknya sesuatu ke dalam tubuh dengan sengaja** melalui lubang yang berpangkal pada organ dalam (*jauf*) — seperti mulut, hidung, telinga — sampai ke tenggorokan. Bila tidak sengaja (mis. lupa makan/minum), puasa tetap sah.
2. **Berobat dengan memasukkan obat/benda melalui qubul** (jalan depan) **atau dubur** (jalan belakang), mis. pengobatan ambeien atau pemasangan kateter urin.
3. **Muntah dengan sengaja** (mis. memasukkan jari ke tenggorokan). Muntah yang tidak disengaja tidak membatalkan, selama tidak ada muntahan yang tertelan kembali dengan sengaja.
4. **Berhubungan suami-istri (jima') di siang hari dengan sengaja** — tidak hanya membatalkan, tetapi juga dikenai denda (kafarat), yaitu berpuasa dua bulan berturut-turut.
5. **Keluar air mani (sperma) karena bersentuhan kulit** (mis. onani atau bersentuhan dengan lawan jenis). Berbeda bila keluar karena mimpi basah (*ihtilam*), puasa tetap sah.
6. **Haid atau nifas di siang hari** — puasanya batal dan wajib diqadha setelah Ramadhan.
7. **Gila (*junun*) atau hilang akal saat berpuasa** — puasanya batal dan wajib diqadha bila sudah sembuh.
8. **Murtad (keluar dari Islam)**, mis. menyekutukan Allah atau mengingkari hukum syariat yang telah disepakati ulama (*mujma' 'alaih*).

Versi terbaru artikel sumber memuat 10 hal dengan tambahan rincian, antara lain pingsan sepanjang hari dan penegasan soal makan-minum dengan sadar.

Tentang muntah, Rasulullah saw bersabda: *"Siapa saja yang muntah, maka ia tidak berkewajiban qadha (puasa). Tetapi siapa saja yang sengaja muntah, maka ia berkewajiban qadha (puasa)."* (HR Bukhari, Muslim, Abu Dawud, At-Tirmidzi, dan An-Nasa'i)""",
        source = """https://nu.or.id/ramadhan/10-hal-yang-membatalkan-puasa-m0mSh""",
    ),
    NuArticle(
        id = "nu-11",
        title = """Qadha dan Fidyah Puasa""",
        content = """Ada empat golongan hukum bagi orang yang membatalkan atau meninggalkan puasa (merujuk Kitab *Safinatun Najah* karya Syekh Salim bin Sumair dan penjelasan Syekh Nawawi):

1. **Wajib qadha + fidyah:** orang yang membatalkan puasa karena mengkhawatirkan keselamatan orang lain (mis. ibu hamil/menyusui yang kuat berpuasa tetapi membatalkannya demi kesehatan anaknya), dan orang yang sengaja menunda qadha sampai masuk Ramadhan berikutnya.
2. **Wajib qadha saja:** orang sakit (sakit sementara), musafir, lupa niat, atau sengaja berbuka tanpa alasan syar'i — tidak ada fidyah karena tidak ada dalil yang mengharuskan.
3. **Wajib fidyah tanpa qadha:** lansia yang sudah tidak mampu berpuasa dan penderita sakit permanen yang kecil kemungkinan sembuh.
4. **Tidak wajib qadha maupun fidyah:** anak kecil yang belum baligh, orang gila yang tidak disengaja, dan non-Muslim.

**Fidyah:** satu mud makanan pokok (sekitar 675 gram / 6,75 ons beras, dibulatkan 7 ons) untuk setiap hari puasa yang ditinggalkan, diberikan kepada fakir/miskin. Boleh diberikan kepada satu orang miskin sekaligus untuk banyak hari.

**Kriteria lansia yang boleh tidak berpuasa:** orang berusia di atas 40 tahun yang tidak mampu menyelesaikan puasa sampai Maghrib karena tekanan fisik yang amat berat (*masyaqqah syadidah*) — bukan sekadar usia tua. Bila setelah itu ia mampu berpuasa lagi, ia tidak wajib mengqadha puasa yang telah lalu (menurut mayoritas ulama, *Tuhfah al-Muhtaj* juz 3 h. 483). Bila tidak mampu membayar fidyah sekalipun, ia tidak terkena kewajiban apa pun.

**Ibu hamil/menyusui:** menurut mazhab Syafi'i, bila khawatir membahayakan dirinya dan/atau anaknya, ia wajib meninggalkan puasa dan wajib mengqadha; bila kekhawatiran hanya pada keselamatan anaknya saja, ia wajib qadha **dan** fidyah (Al-Juzairi, *al-Fiqh 'ala Madzahib al-Arba'ah*, h. 521).

**Niat qadha puasa:**

نَوَيْتُ صَوْمَ غَدٍ عَنْ قَضَاءِ فَرْضِ شَهْرِ رَمَضَانَ لِلَّهِ تَعَالَى

*"Nawaitu shauma ghadin 'an qadhā'i fardhi syahri Ramadhāna lillāhi ta'ālā."*

*"Aku berniat untuk mengqadha puasa bulan Ramadhan esok hari karena Allah swt."*

**Utang puasa tidak berlipat ganda:** jumlah hari qadha sama dengan jumlah hari yang ditinggalkan. Yang membengkak bila menunda sampai Ramadhan berikutnya adalah fidyahnya (1 mud per hari per tahun keterlambatan, menurut satu pendapat; menurut pendapat lain fidyah tetap 1 mud per hari). Bila uzur berlanjut terus (tetap musafir/sakit/hamil/menyusui) sampai Ramadhan berikutnya, tidak ada kewajiban fidyah (Syekh Khatib asy-Syirbini, *Mughni al-Muhtaj*).

**Waktu mengqadha:** dari Syawal sampai Sya'ban, kecuali hari-hari yang diharamkan berpuasa (1 Syawal/Idul Fitri, 10 Dzulhijjah/Idul Adha, dan hari tasyrik).

Allah SWT berfirman: *"Dan bagi orang yang berat menjalankannya, wajib membayar fidyah, yaitu memberi makan seorang miskin."* (QS Al-Baqarah: 184)

*"Maka barang siapa di antara kamu sakit atau dalam perjalanan (lalu tidak berpuasa), maka (wajib mengganti) sebanyak hari (yang dia tidak berpuasa itu) pada hari-hari yang lain."* (QS Al-Baqarah: 185)""",
        source = """https://jabar.nu.or.id/ubudiyah/lansia-yang-tidak-wajib-puasa-dengan-kriteria-sebagai-berikut-osVdP""",
    ),
    NuArticle(
        id = "nu-12",
        title = """I'tikaf: Hukum, Rukun, dan Syarat""",
        content = """I'tikaf adalah berdiam diri di masjid dengan niat beribadah mendekatkan diri kepada Allah (shalat, dzikir, membaca Al-Qur'an), sangat dianjurkan terutama pada 10 malam terakhir Ramadhan untuk memburu Lailatul Qadar.

**Hukum:** sunnah; dapat dikerjakan setiap waktu, terutama 10 hari terakhir Ramadhan. Rasulullah saw beri'tikaf pada 10 hari terakhir Ramadhan hingga wafat, lalu dilanjutkan istri-istri beliau. Pada tahun wafatnya, beliau beri'tikaf 20 hari.

Aisyah ra meriwayatkan: *"Sesungguhnya Nabi saw melakukan i'tikaf pada sepuluh hari terakhir bulan Ramadhan hingga beliau wafat, kemudian istri-istrinya mengerjakan i'tikaf sepeninggal beliau."* (HR Bukhari No. 1886 dan Muslim No. 2006)

**Rukun i'tikaf** (menurut Syekh Nawawi al-Bantani dalam *Nihayatuz Zain*) antara lain: niat i'tikaf (sunnah atau nadzar), berdiam di masjid, dan menetap di tempat i'tikaf.

**Syarat i'tikaf:** (1) Muslim, (2) berakal, (3) suci dari hadats besar.

**Macam i'tikaf** (Syekh Nawawi): i'tikaf mutlak, i'tikaf terikat waktu tanpa terus-menerus, dan i'tikaf terikat waktu dan terus-menerus.

**Niat i'tikaf:**

نَوَيْتُ الْاِعْتِكَافَ فِي هَذَا الْمَسْجِدِ لِلَّهِ تَعَالَى

*"Nawaitul i'tikāfa fī hādzal masjidi lillāhi ta'ālā."*

*"Aku berniat i'tikaf di masjid ini karena Allah ta'ala."*

**Kesunnahan saat i'tikaf** (menurut Syekh Musthafa Sa'id Khan, *al-Fiqhul Manhaji* 2/108): memperbanyak amal sunnah (dzikir, baca Al-Qur'an, mempelajari ilmu), dilakukan dalam keadaan berpuasa, dilakukan di masjid jami' (masjid yang dipakai shalat Jumat), dan tidak berbicara hal yang tidak baik.

**Yang membatalkan i'tikaf:** gila, pingsan, mabuk, murtad, haid, nifas, keluar masjid tanpa keperluan syar'i, keluar untuk kewajiban yang bisa ditunda, dan berhubungan suami-istri (jima'). Dalil larangan jima' saat i'tikaf: *"…Dan janganlah kamu campuri mereka (istri-istrimu), sedang kamu beriktikaf dalam masjid…"* (QS Al-Baqarah: 187)

Lihat juga tata cara i'tikaf selengkapnya di NU Online Jatim: https://jatim.nu.or.id/keislaman/ibadah-i-tikaf-rukun-syarat-dan-tata-caranya-pcxPg""",
        source = """https://jabar.nu.or.id/ubudiyah/panduan-lengkap-hukum-rukun-dan-syarat-itikaf-di-bulan-ramadhan-66t6s""",
    ),
    NuArticle(
        id = "nu-13",
        title = """Tadarus Al-Qur'an di Bulan Ramadhan""",
        content = """Ramadhan adalah bulan diturunkannya Al-Qur'an (bulan paling berkah), sehingga memperbanyak membaca Al-Qur'an sangat dianjurkan di bulan ini.

Allah SWT berfirman: *"Bulan Ramadhan adalah (bulan) yang di dalamnya diturunkan Al-Qur'an sebagai petunjuk bagi manusia dan penjelasan-penjelasan mengenai petunjuk itu serta pembeda (antara yang hak dan yang batil)."* (QS Al-Baqarah: 185)

**Teladan Nabi:** setiap malam Ramadhan, Malaikat Jibril menemui Rasulullah saw untuk bertadarus Al-Qur'an; Nabi mengkhatamkan Al-Qur'an sekali setiap Ramadhan bersama Jibril, kecuali pada tahun terakhir menjelang wafat beliau mengkhatamkannya dua kali.

Ibnu 'Abbas ra meriwayatkan: *"Rasulullah saw adalah manusia yang paling lembut, terutama pada bulan Ramadhan ketika Malaikat Jibril menemuinya… Jibril mendatanginya setiap malam di bulan Ramadhan, di mana Jibril mengajarkannya Al-Qur'an. Sungguh Rasulullah saw orang yang paling lembut daripada angin yang berhembus."* (HR Bukhari)

Menurut Ibnu Rajab al-Hanbali (*Bughyah al-Insan fi Wadza'if Ramadhan*, h. 42), hadits ini menunjukkan kesunnahan bertadarus Al-Qur'an pada malam Ramadhan secara berjamaah dan menyetorkan hafalan kepada orang yang lebih hafal; memperbanyak bacaan di malam hari lebih utama karena malam adalah waktu yang tenang dan bebas dari kesibukan.

**Keutamaan membaca Al-Qur'an:**

- Setiap huruf diganjar satu kebaikan yang dilipatgandakan sepuluh kali. Ibnu Mas'ud ra meriwayatkan: *"Barangsiapa membaca satu huruf dari Al-Qur'an kitabullah, maka baginya satu kebaikan, sedangkan satu kebaikan dibalas oleh Allah ta'ala dengan sepuluh kebaikan. Tidak dikatakan Alif Lam Mim satu huruf, akan tetapi Alif satu huruf, Lam satu huruf dan Mim satu huruf."* (HR At-Tirmidzi)
- Al-Qur'an memberi syafaat bagi pembacanya di hari kiamat: *"Bacalah Al-Qur'an, karena ia akan datang pada hari kiamat sebagai pemberi syafaat bagi pembacanya."* (HR Muslim)
- Sebaik-baik manusia adalah yang mempelajari dan mengajarkan Al-Qur'an.
- Pembaca yang mahir bersama para malaikat, sedangkan yang terbata-bata mendapat dua pahala.
- Hati menjadi tenteram dengan mengingat Allah (QS Ar-Ra'd: 28).

Tadarus di Indonesia umumnya dilakukan setelah shalat tarawih berjamaah sampai tengah malam, baik bersamaan maupun bergantian.""",
        source = """https://lampung.nu.or.id/syiar/ini-keutamaan-membaca-al-qur-an-di-bulan-ramadhan-uYkXk""",
    ),
    NuArticle(
        id = "nu-14",
        title = """Amalan dan Keutamaan 10 Hari Terakhir Ramadhan""",
        content = """Ramadhan dibagi tiga fase: 10 hari pertama = fase rahmat, 10 hari kedua = fase maghfirah (ampunan), 10 hari ketiga = fase *itqun minan nar* (pembebasan dari api neraka). Fase 10 hari terakhir adalah yang paling istimewa.

**Tiga amalan utama pada 10 hari terakhir** (menurut Kitab *Fathul Mu'in*):

1. **Memperbanyak sedekah**, mencukupi kebutuhan keluarga, dan berbuat baik kepada karib-kerabat dan tetangga.
2. **Memperbanyak membaca Al-Qur'an** — Imam An-Nawawi menjelaskan membaca Al-Qur'an di akhir malam lebih baik daripada awal malam, dan bacaan terbaik di siang hari adalah setelah shalat Subuh.
3. **Memperbanyak i'tikaf.**

**Amalan Rasulullah saw di 10 malam terakhir:** menghidupkan malam dengan ibadah (shalat malam), membangunkan keluarganya untuk shalat malam (khususnya malam 23, 25, 27, dan 29), mengencangkan ikat pinggang (menjauhi tempat tidur/istri), mandi dan memakai wewangian menjelang Isya' dengan harapan memperoleh Lailatul Qadar, serta beri'tikaf di masjid. Pada satu malam beliau pernah menyambung puasa tanpa berbuka sampai Maghrib berikutnya (puasa wishal).

Aisyah ra meriwayatkan: *"Ketika memasuki sepuluh akhir Ramadhan, Nabi fokus beribadah, mengisi malamnya dengan ibadah, dan membangunkan keluarganya untuk ikut ibadah."* (HR Al-Bukhari)

*"Rasulullah saw sangat bersungguh-sungguh (beribadah) pada sepuluh hari terakhir (bulan Ramadhan), melebihi kesungguhan beribadah di selain (malam) tersebut."* (HR Muslim)""",
        source = """https://jabar.nu.or.id/ubudiyah/amalan-dan-keutamaan-10-hari-terakhir-puasa-ramadhan-V7EMe""",
    ),
    NuArticle(
        id = "nu-15",
        title = """Persiapan Lebaran: Shalat Idul Fitri dan Takbiran""",
        content = """Shalat Idul Fitri dilaksanakan pada 1 Syawal; hukumnya sunnah muakkadah (sangat dianjurkan) dan selalu dilakukan Rasulullah saw. Dianjurkan berjamaah di masjid atau lapangan terbuka sebagai syiar Islam dan mempererat ukhuwah.

**Waktu:** pagi hari setelah matahari terbit sampai sebelum masuk waktu Dzuhur; waktu terbaik ketika matahari sudah naik setinggi satu tombak. Berbeda dengan Idul Adha yang dianjurkan lebih awal, shalat Idul Fitri disunnahkan sedikit ditunda — memberi kesempatan yang belum menunaikan zakat fitrah untuk segera melaksanakannya sebelum shalat dimulai.

Shalat Idul Fitri terdiri dari 2 rakaat dengan tambahan takbir.

**Niat (makmum):**

أُصَلِّي سُنَّةً لِعِيدِ الْفِطْرِ رَكْعَتَيْنِ مُسْتَقْبِلَ الْقِبْلَةِ مَأْمُومًا لِلَّهِ تَعَالَى

*"Ushallī sunnatan li'īdil fithri rak'ataini mustaqbilal qiblati ma'mūman lillāhi ta'ālā."*

*"Aku niat shalat sunnah Idul Fitri dua rakaat menghadap kiblat (sebagai makmum) karena Allah ta'ala."*

Niat imam memakai kata *"imāman"* sebagai ganti *"ma'mūman"*.

**Sunnah sebelum shalat Id:** mandi sunnah (boleh sejak tengah malam Idul Fitri, lebih utama setelah fajar), berhias dan memakai pakaian bersih/terbaik, memakai wewangian, makan terlebih dahulu (disunnahkan makan kurma), berjalan kaki ke tempat shalat, dan menunaikan zakat fitrah sebelum shalat.

**Niat mandi sunnah Idul Fitri:**

نَوَيْتُ الْغُسْلَ سُنَّةً لِعِيدِ الْفِطْرِ لِلَّهِ تَعَالَى

*"Nawaitul ghusla sunnatan li 'īdil fithri lillāhi ta'ālā."*

*"Aku niat mandi sunnah Idul Fitri karena Allah ta'ala."*

**Takbiran:** mengumandangkan takbir dianjurkan sejak masuk malam 1 Syawal (setelah Maghrib) sampai imam shalat Id takbiratul ihram (pendapat lain: sampai waktu dianjurkannya shalat Id). Setelah shalat: mendengarkan khutbah sampai selesai, saling bermaafan, dan menjaga silaturahmi.

Allah SWT berfirman: *"Dan hendaklah kamu mencukupkan bilangannya dan hendaklah kamu mengagungkan Allah atas petunjuk-Nya yang diberikan kepadamu, supaya kamu bersyukur."* (QS Al-Baqarah: 185) — dasar anjuran takbir Idul Fitri.

Malam takbiran juga dianjurkan dihidupkan dengan ibadah (shalat malam, tadarus Al-Qur'an, dzikir) menurut Syekh Sa'id bin Muhammad Ba'asyin dalam *Busyra al-Karim*; Ketua PBNU Bidang Keagamaan KH Ahmad Fahrur Rozi (Gus Fahrur) menegaskan hal ini.

Bacaan takbiran selengkapnya: https://www.nu.or.id/nasional/bacaan-takbiran-idul-fitri-arab-latin-dan-artinya-Zjrip""",
        source = """https://nu.or.id/nasional/tata-cara-sholat-idul-fitri-lengkap-dengan-niat-dan-artinya-YnBoy""",
    ),
)
