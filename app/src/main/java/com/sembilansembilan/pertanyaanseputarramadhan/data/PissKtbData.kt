package com.sembilansembilan.pertanyaanseputarramadhan.data

/**
 * 20 tanya-jawab fikih puasa/Ramadhan dari PISS-KTB
 * (https://www.piss-ktb.com — arsip tanya-jawab dari grup Facebook PISS-KTB).
 * Jawaban diparafrase dengan kata-kata sendiri dari jawaban di situs;
 * referensi kitab ditulis persis seperti tercantum di sumber; tiap entri
 * mencantumkan URL halaman asalnya sebagai atribusi.
 * Satu entri dilunakkan bahasanya agar layak semua umur (No. 5: judul dan
 * pertanyaan disusun ulang tanpa mengubah hukumnya).
 * Isi 3 halaman sempat dicek langsung (No. 2, 9, 19); sisanya dari cuplikan
 * pencarian situs yang menampilkan isi halaman — periksa ulang tiap URL
 * sebelum rilis bila sempat.
 */
val pissKtbQuestions: List<PissQuestion> = listOf(
    PissQuestion(
        id = 1,
        title = """Sepuluh Hal yang Membatalkan Puasa""",
        question = """Apa saja hal-hal yang membatalkan puasa?""",
        answer = """Menurut kitab Fathul Qorib bab shaum, ada 10 hal yang membatalkan puasa: (1) masuknya suatu benda ke dalam tubuh dengan sengaja melalui lubang yang terbuka (mulut, hidung, dan sebagainya); (2) masuknya benda melalui jalan yang tertutup, misalnya sampai ke otak melalui luka di kepala; (3) pengobatan yang dimasukkan melalui dua jalan (qubul dan dubur); (4) muntah dengan sengaja — muntah yang tidak disengaja tidak membatalkan; (5) bersetubuh dengan sengaja — bersetubuh karena lupa tidak membatalkan; (6) keluar mani karena bersentuhan kulit, baik dengan cara yang haram (misalnya dengan tangan sendiri) maupun tidak haram (misalnya dengan tangan istri) — sedangkan keluar mani karena mimpi basah tidak membatalkan; (7) haid; (8) nifas; (9) gila; (10) murtad. Jika salah satu dari sepuluh hal itu terjadi di tengah puasa, puasanya batal.""",
        reference = """Fathul Qorib, bab Shaum""",
        source = """https://www.piss-ktb.com/2013/07/2474-puasa-hal-hal-yang-membatalkan.html""",
    ),
    PissQuestion(
        id = 2,
        title = """Niat Puasa Sebulan Penuh Sekaligus""",
        question = """Bolehkah niat puasa Ramadhan dilakukan sekaligus untuk sebulan penuh pada malam pertama?""",
        answer = """Berniat puasa sebulan penuh pada malam pertama Ramadhan hukumnya disunnahkan. Namun menurut madzhab Syafi'iyah, niat itu hanya mencukupi untuk puasa hari pertama saja, sehingga setiap hari berikutnya tetap wajib diniati; bila tidak diniati, puasanya tidak sah kecuali hari pertama. Menurut Imam Malik, niat sebulan penuh sudah mencukupi untuk hari-hari berikutnya, sehingga bila seseorang lupa berniat di malam berikutnya, puasanya tetap sah. Kitab Kasyifatus Saja mengutip: apabila seseorang berniat pada malam awal Ramadhan untuk berpuasa sebulan penuh, maka menurut Madzhab Syafi'i hal itu tidak mencukupi untuk selain hari pertama — tetapi dianjurkan melakukannya agar puasa pada hari yang lupa diniati tetap sah menurut Imam Malik.""",
        reference = """Hasyiyah Qulyubi wa 'Umairoh 2/67; Al-Majmu' Syarah Muhadzab 6/303; Hasyiyah al-Bajuri 1/288; Kasyifatus Saja""",
        source = """https://www.piss-ktb.com/2012/07/1702-hukum-niat-puasa-ramadhan-sebulan.html""",
    ),
    PissQuestion(
        id = 3,
        title = """Makan Sahur sebagai Pengganti Niat""",
        question = """Seseorang sudah makan sahur tetapi belum berniat puasa Ramadhan — apakah sahurnya itu sudah terhitung sebagai niat?""",
        answer = """Menurut qaul mu'tamad (pendapat yang dijadikan pegangan), makan sahur dengan tujuan hendak berpuasa keesokan harinya sudah mencukupi sebagai niat, dengan syarat terbersit dalam hati hal-hal yang wajib ada dalam niat puasa, yaitu gambaran puasa beserta sifat-sifatnya (misalnya "besok akan puasa fardhu Ramadhan"). Hal yang sama berlaku bagi orang yang minum untuk menolak haus di siang hari, atau menahan diri dari makan, minum, dan jimak karena khawatir fajar telah terbit — semuanya terhitung niat bila di dalam hatinya terlintas puasa dengan sifat-sifat syar'inya.""",
        reference = """Al-Bujairomi 'alal Minhaj; Mughni al-Muhtaj 2/148; Majmu' Syarah al-Muhadzab; Tanwirul Qulub hlm. 228""",
        source = """http://www.piss-ktb.com/2018/05/5485-puasa-makan-sahur-mencukupi-niat.html""",
    ),
    PissQuestion(
        id = 4,
        title = """Makan Sahur Saat Sudah Masuk Waktu Subuh""",
        question = """Bagaimana hukum makan sahur ketika ternyata fajar sudah terbit, padahal yang bersangkutan menyangka fajar belum terbit?""",
        answer = """Jika pada saat makan itu ternyata memang sudah masuk waktu Subuh, puasanya tidak sah (batal), walaupun ia menyangka waktu itu masih malam. Perlu diketahui, ulama Indonesia menetapkan waktu imsak sebagai batas akhir sahur: waktu Subuh sendiri sudah ditambah beberapa menit sebagai waktu ikhtiyat (kehati-hatian), lalu dikurangi beberapa menit lagi sebagai waktu imsak.""",
        reference = """Kitab Iqna' / Bujairomi (Faraidhus Shoum)""",
        source = """https://www.piss-ktb.com/2012/02/737-puasa-makan-sahur-saat-sudah-subuh.html""",
    ),
    PissQuestion(
        id = 5,
        title = """Keluar Mani karena Melihat Tayangan yang Membangkitkan Syahwat""",
        question = """Seseorang sedang berpuasa lalu melihat tayangan yang membangkitkan syahwat sampai keluar mani, hanya dengan melihat tanpa sentuhan — apakah puasanya batal?""",
        answer = """Secara fikih, puasanya tidak batal, kecuali bila sudah menjadi kebiasaannya bahwa melihat hal seperti itu membuatnya keluar mani — maka puasanya batal. Alasannya, keluar mani karena melihat atau memikirkan sesuatu tidak membatalkan puasa selama tidak ada mubasyarah (sentuhan kulit secara langsung); hukumnya disamakan dengan mimpi basah. Meski demikian, puasa sambil melihat tayangan seperti itu sudah keluar dari tujuan diwajibkannya puasa, yaitu agar menjadi orang yang bertakwa (QS. Al-Baqarah: 183).""",
        reference = """I'anatut Tholibin 2/228; Tuhfatul Habib 'ala Syarhil Khotib 3/115""",
        source = """https://www.piss-ktb.com/2013/04/1112-puasa-keluar-mani-karena-nonton.html""",
    ),
    PissQuestion(
        id = 6,
        title = """Haid Datang di Tengah Hari saat Berpuasa""",
        question = """Seorang wanita sedang berpuasa, lalu di pertengahan hari ia kedatangan darah haid — apakah puasanya harus dibatalkan atau diteruskan sampai Maghrib?""",
        answer = """Puasa wanita haid dan nifas tidak sah, tidak wajib bagi mereka, bahkan haram bagi mereka berpuasa, tetapi wajib mengqadha di hari lain — dan ini telah disepakati para ulama. Puasanya otomatis batal begitu haid datang, walau hanya setetes darah, karena syarat puasa adalah suci dari haid dan nifas. Ia tidak wajib membatalkan puasanya dengan makan atau minum; cukup dengan tidak adanya niat puasa, kedudukan puasanya sudah gugur. Yang berdosa adalah bila ia tetap imsak (menahan diri) dengan niat puasa.""",
        reference = """Is'adur Rafiq I/114; Tuhfatul Muhtaj fi Syarhil Minhaj 13/373; Tuhfatul Habib 'ala Syarhil Khotib juz 3 hlm. 104; Al-Majmu'""",
        source = """http://www.piss-ktb.com/2012/07/1714-haid-disaat-berpuasa.html""",
    ),
    PissQuestion(
        id = 7,
        title = """Status Puasa Orang Tua yang Pikun""",
        question = """Bagaimana status puasa orang tua yang pikun?""",
        answer = """Orang yang pikun tidak wajib berpuasa. Adapun orang yang sudah sangat tua dan tidak kuat berpuasa karena uzur, ia boleh tidak berpuasa dan membayar fidyah sebesar 1 mud untuk setiap hari yang ditinggalkan.""",
        reference = """Fathul Mu'in Hamisy I'anatut Tholibin II/242–243; II/220""",
        source = """http://www.piss-ktb.com/2013/07/2471-orang-tua-yang-pikun-dalam-puasa.html""",
    ),
    PissQuestion(
        id = 8,
        title = """Orang Jompo yang Tak Berdaya dan Fidyahnya""",
        question = """Nenek saya sudah tidak bisa apa-apa lagi, bahkan buang air kecil dan besar di tempat tidur dan bergantung pada infus — apakah ia masih wajib puasa? Bila tidak, berapa fidyahnya per hari?""",
        answer = """Ia tidak wajib berpuasa dan diganti dengan fidyah. Ukurannya 1 mud per hari (sekitar 6 ons lebih 25 gram — seperempat dari ukuran zakat fitrah), yang di Indonesia ditunaikan dalam bentuk beras.""",
        reference = """Iqna' li as-Syarbiny I/242""",
        source = """https://www.piss-ktb.com/2012/02/288-jompo-tak-berdaya-puasa-ramadhan.html""",
    ),
    PissQuestion(
        id = 9,
        title = """Cara Mengqadha Puasa yang Tidak Diketahui Jumlahnya""",
        question = """Seseorang dulu sering bolong-bolong puasa Ramadhan dan kini ingin mengqadhanya, tetapi sudah lupa berapa banyak puasa yang ditinggalkan — apa yang harus dilakukan?""",
        answer = """Ia wajib mengqadha puasa sampai yakin seluruhnya sudah dikerjakan. Kaidahnya: peganglah jumlah yang diyakini sudah dikerjakan, lalu qadha sisanya sampai mencapai keyakinan bahwa tidak ada lagi tanggungan puasa yang tersisa.""",
        reference = """Hawasyi asy-Syarwani III/396 (Dar Ihya' at-Turats al-'Arabi)""",
        source = """https://www.piss-ktb.com/2015/01/3729-puasa-cara-meng-qodlo-puasa-yang.html""",
    ),
    PissQuestion(
        id = 10,
        title = """Membatalkan Puasa Ramadhan Tanpa Uzur""",
        question = """Orang yang sengaja membatalkan puasa Ramadhan tanpa uzur itu wajib qadha saja, atau wajib qadha dan fidyah?""",
        answer = """Ia berdosa dan wajib mengqadha puasa yang ditinggalkan, tetapi tidak wajib membayar fidyah. Berbeda halnya bila puasa dibatalkan dengan jimak, maka wajib qadha sekaligus membayar kafarat. Menurut madzhab Hanafi, makan dan minum dengan sengaja mewajibkan qadha dan kafarat; menurut Imam Syafi'i hanya wajib qadha saja. Tidak ada kafarat bagi orang yang merusak puasa dengan selain jimak, seperti makan atau istimna'.""",
        reference = """Syarah Muhadzab juz 1 hlm. 331; Kitab Raudhah 2/370; Kasyifatus Saja; Al-Mabsuth juz 3 hlm. 74""",
        source = """https://www.piss-ktb.com/2015/03/3859-puasa-hukum-membatalkan-puasa.html""",
    ),
    PissQuestion(
        id = 11,
        title = """Menunda Qadha Puasa hingga Ramadhan Berikutnya""",
        question = """Seseorang bertahun-tahun tidak dapat mengqadha puasanya — apakah qadha tetap 1 hari diganti 1 hari, atau menjadi berlipat bila sudah melewati dua kali Ramadhan tanpa diqadha?""",
        answer = """Qadha puasa tidak dapat diganti dengan fidyah semata; fidyah sebagai ganti puasa hanya diperuntukkan bagi orang tua renta yang tidak mampu berpuasa. Bagi yang sengaja meninggalkan puasa sampai terlewat Ramadhan berikutnya, hukumnya justru diperberat: menurut jumhur ia wajib qadha ditambah fidyah (memberi makan satu orang miskin untuk setiap hari), sedangkan menurut Hanafiyah dan satu versi Hanabilah cukup qadha saja. Menunda qadha Ramadhan ke Ramadhan berikutnya tanpa uzur hukumnya berdosa menurut jumhur.""",
        reference = """Al-Mausu'ah al-Fiqhiyah al-Kuwaitiyah juz 28 hlm. 76; As-Siraaj al-Wahhaaj I/145""",
        source = """https://www.piss-ktb.com/2012/02/289-problematika-tkw-dalam-ibadah.html""",
    ),
    PissQuestion(
        id = 12,
        title = """Berjimak di Bulan Puasa karena Tidak Tahu Hukumnya""",
        question = """Bagaimana hukum jimak di bulan puasa bila pelakunya sama sekali tidak mengetahui hukumnya — apakah puasanya batal dan apakah masih wajib kafarat?""",
        answer = """Puasanya tidak batal dan tidak wajib membayar kafarat. Orang yang berjimak di bulan Ramadhan karena tidak tahu hukumnya (jahil) atau karena lupa tidak wajib membayar kafarat, asalkan memang benar-benar tidak tahu; tetapi bila sudah tahu hukumnya, kafarat tetap wajib.""",
        reference = """Mausu'ah Fiqhiyah; Tuhfatul Muhtaj; Hasyiyah Syarwani""",
        source = """https://www.piss-ktb.com/2020/05/5873.html""",
    ),
    PissQuestion(
        id = 13,
        title = """Hal-Hal yang Dapat Menggugurkan Pahala Puasa""",
        question = """Benarkah ada perbuatan yang bisa membatalkan pahala puasa, misalnya dusta, ghibah, adu domba, sumpah palsu, dan melihat dengan syahwat?""",
        answer = """Jumhur fuqaha dari madzhab Syafi'iyah, Hanafiyah, Malikiyah, dan Hanbaliyah berpendapat bahwa maksiat seperti dusta, ghibah, adu domba, sumpah palsu, dan melihat dengan syahwat tidak membatalkan puasa itu sendiri, tetapi menggugurkan pahalanya. Hadits "lima perkara yang membatalkan orang yang berpuasa" dinilai batil/dhaif dan tidak dapat dijadikan hujah untuk menetapkan batalnya puasa; para ulama seperti Imam al-Mawardi dan al-Mutawalli menakwilkannya sebagai pembatal pahala, bukan pembatal puasa. Imam al-Awza'i berpendapat ghibah membatalkan puasa dan wajib diqadha — pendapat ini menyelisihi jumhur. Dalil penguatnya antara lain hadits riwayat Bukhari: "Barangsiapa tidak meninggalkan ucapan dusta dan berbuat dusta, maka Allah tidak peduli ia meninggalkan makan dan minumnya.""",
        reference = """Al-Majmu' Syarah Muhadzab 6/356""",
        source = """https://www.piss-ktb.com/2014/07/3365-fiqih-puasa-hal-hal-yang-dapat.html""",
    ),
    PissQuestion(
        id = 14,
        title = """Jumlah Rakaat Shalat Tarawih menurut Ulama Ahlus Sunnah""",
        question = """Berapa jumlah rakaat shalat tarawih — 8, 20, atau 36 rakaat?""",
        answer = """Shalat tarawih hukumnya sangat disunnahkan (sunnah muakkadah) dan lebih utama berjamaah — demikian pendapat masyhur para sahabat dan ulama. Tentang jumlah rakaatnya ada beberapa pendapat: ada yang mengatakan tidak ada batasan bilangan (boleh 8, 20, atau 36 rakaat), ada yang menetapkan 8, 20, atau 36 rakaat. Yang mengerjakan 8 rakaat + witir 3 rakaat mengikuti hadits Aisyah (HR. Bukhari): Rasulullah SAW tidak pernah menambah shalat malam, baik di Ramadhan maupun di luar Ramadhan, melebihi 11 rakaat. Ulama Syafi'iyah menjelaskan hadits itu adalah dalil shalat witir (maksimal 11 rakaat), bukan dalil tarawih 11 rakaat. Pada masa Umar bin Khaththab, tarawih dikerjakan 20 rakaat ditambah witir; Umar bin Abdul Aziz menambahnya menjadi 36 rakaat bagi orang di luar Makkah. Rasulullah SAW sendiri keluar shalat malam berjamaah di masjid pada malam ke-3, ke-5, dan ke-27 Ramadhan sebanyak 8 rakaat, lalu para sahabat menyempurnakan sisanya di rumah.""",
        reference = """Dalilul Falihin (Syekh Muhammad bin 'Allan); HR. Bukhari dan Muslim (hadits Aisyah); riwayat Imam Baihaqi (hadits Saib bin Yazid)""",
        source = """https://www.piss-ktb.com/2012/02/297-jumlah-rakaat-tarawih.html""",
    ),
    PissQuestion(
        id = 15,
        title = """Bolehkah Shalat Witir Dua Kali dalam Semalam?""",
        question = """Bolehkah witir dikerjakan dua kali dalam satu malam di bulan Ramadhan?""",
        answer = """Ada dua pendapat. Pendapat yang membolehkan: witir adalah shalat sunnah yang tidak disunnahkan berjamaah kecuali di bulan Ramadhan, sehingga di bulan Ramadhan boleh diulang (i'adah) karena disunnahkan berjamaah — sebagaimana keterangan dalam kitab Al-Majmu'. Bahkan ada pendapat yang membolehkan pengulangan tanpa batas selama waktunya belum keluar; sahabat Abu Bakar dan Utsman diriwayatkan mengerjakan witir sebelum tidur lalu bangun untuk tahajud, sedangkan Umar dan Ali tidur dulu lalu bangun, tahajud, dan witir. Pendapat yang tidak membolehkan: menurut Nihayatul Muhtaj dan Tuhfah, witir tidak dituntut diulang; bila diulang dengan niat witir secara sengaja dan mengetahui ketidakbolehannya, hukumnya haram dan tidak sah, berdasarkan hadits "tidak ada dua witir dalam satu malam".""",
        reference = """Al-Majmu'; Nihayatul Muhtaj; Tuhfah; Hasyiyah al-Bajuri juz I""",
        source = """https://www.piss-ktb.com/2013/07/2487-khusus-malam-ramadhan-boleh-shalat.html""",
    ),
    PissQuestion(
        id = 16,
        title = """Hukum Mengakhirkan Pembayaran Zakat Fitrah Setelah Hari Raya""",
        question = """Bagaimana hukum mengakhirkan pembayaran zakat fitrah sampai setelah hari raya Idul Fitri?""",
        answer = """Mengakhirkan zakat fitrah setelah hari raya tanpa uzur hukumnya haram/berdosa menurut madzhab Syafi'iyah, Malikiyah, dan Hanabilah — tetapi kewajiban zakatnya tidak gugur; zakat itu seperti utang yang tetap harus ditunaikan kepada mustahiqnya. Empat madzhab sepakat kewajiban zakat fitrah tidak gugur karena diakhirkan. Waktu mengeluarkan zakat ada lima: (1) waktu jawaz (boleh): 1 Ramadhan sampai hari terakhir Ramadhan sebelum matahari terbenam; (2) waktu wajib: sejak terbenam matahari akhir Ramadhan sampai sebelum Subuh 1 Syawal; (3) waktu sunnah (afdhal): setelah Subuh 1 Syawal sampai sebelum shalat Id; (4) waktu makruh: setelah shalat Id sampai sebelum matahari terbenam 1 Syawal; (5) waktu haram (tahrim): setelah terbenam matahari 1 Syawal. Menurut madzhab Hanafiyah, waktu wajibnya longgar (boleh kapan saja), hanya disunnahkan sebelum berangkat shalat Id. Bila kelalaian berasal dari wakil, yang berdosa adalah wakilnya; bila dari keduanya, keduanya ikut berdosa.""",
        reference = """Al-Majmu' 7 hlm. 165; Al-Mausu'ah al-Fiqhiyah""",
        source = """http://www.piss-ktb.com/2012/08/1754-hukum-mengakhirkan-pembayaran.html""",
    ),
    PissQuestion(
        id = 17,
        title = """Janin dalam Kandungan dan Zakat Fitrah""",
        question = """Apakah janin yang masih dalam kandungan sudah wajib dikenakan zakat fitrah?""",
        answer = """Tidak wajib zakat fitrah bagi janin, sebab salah satu syarat wajib zakat fitrah adalah orang yang dizakati mendapati terbenamnya matahari pada hari terakhir Ramadhan (mendapati sebagian akhir Ramadhan dan sebagian awal Syawal). Maka bayi yang lahir setelah terbenamnya matahari akhir Ramadhan tidak wajib dizakati, dan orang yang meninggal sebelum terbenamnya matahari akhir Ramadhan juga tidak wajib dizakati. Bahkan bila janin baru keluar separuh sebelum terbenamnya matahari dan sisanya setelah terbenam, ia tetap tidak wajib dizakati karena kelahirannya belum sempurna.""",
        reference = """I'anatut Tholibin juz II hlm. 191 (Darul Fikr); Syarqawi 'ala at-Tahrir juz 1 hlm. 369; Nihayah az-Zain I/174; Tuhfatul Habib III/66""",
        source = """https://www.piss-ktb.com/2012/02/348-janin-dan-zakat-fitrah.html""",
    ),
    PissQuestion(
        id = 18,
        title = """Puasa 6 Hari di Bulan Syawal""",
        question = """Bagaimana hukum dan keutamaan puasa 6 hari di bulan Syawal, dan bolehkah digabung niatnya dengan qadha Ramadhan?""",
        answer = """Puasa 6 hari di bulan Syawal hukumnya sunnah. Dasarnya sabda Nabi SAW: "Barangsiapa berpuasa penuh di bulan Ramadhan lalu menyambungnya dengan (puasa) enam hari di bulan Syawal, maka (pahalanya) seperti ia berpuasa selama satu tahun" (HR. Muslim). Ini menjadi pijakan madzhab Syafi'i, Ahmad bin Hanbal, dan Dawud; Abu Hanifah memakruhkannya agar tidak timbul prasangka bahwa puasa itu wajib. Yang lebih utama menjalankannya berurutan mulai hari kedua Syawal, tetapi bila dipisah-pisah atau dilakukan di akhir Syawal pun keutamaannya tetap didapat. Alasan disamakan dengan puasa setahun: satu kebaikan menyamai sepuluh kebaikan — Ramadhan (1 bulan × 10 = 10 bulan) ditambah 6 hari Syawal (6 × 10 = 60 hari = 2 bulan). Menggabung niat puasa Syawal dengan qadha Ramadhan: menurut Imam Romli boleh dan mendapatkan pahala keduanya; menurut Abu Makhromah tidak mendapatkan pahala keduanya, bahkan tidak sah.""",
        reference = """Syarh Nawawi 'ala Muslim VIII/56; I'anah at-Tholibin II/271; Bughyah al-Mustarsyidin hlm. 113–114""",
        source = """https://www.piss-ktb.com/2012/03/f0095-puasa-6-hari-di-bulan-syawal.html""",
    ),
    PissQuestion(
        id = 19,
        title = """Hukum Suntik dan Infus Saat Berpuasa""",
        question = """Apakah suntik dan infus membatalkan puasa?""",
        answer = """Ada lima lubang bagi laki-laki dan enam bagi perempuan yang bila dimasuki sesuatu yang tampak (ainiyah) membatalkan puasa: hidung, telinga, mulut, dubur, kemaluan, dan susu (bagi perempuan). Kulit bukan termasuk lubang terbuka, sehingga memasukkan jarum suntik tidak membatalkan puasa menurut madzhab Syafi'i. Tentang suntik, ulama berbeda pendapat: (1) membatalkan secara mutlak karena sampai ke dalam tubuh; (2) tidak membatalkan secara mutlak karena tidak melalui lubang terbuka; (3) diperinci — bila suntikan berisi suplemen/pengganti makanan atau vitamin, membatalkan puasa; bila hanya obat, diperinci lagi: lewat pembuluh darah membatalkan, lewat urat yang tidak berongga tidak membatalkan. Hasil Bahtsul Masaail PP Nurul Huda (1997): orang puasa yang disuntik tidak batal karena obat masuk ke dalam daging, bukan ke rongga badan; sedangkan infus dibedakan antara infus obat dan infus makanan.""",
        reference = """Kitab Sabilul Muhtadin; Raudhah at-Tholibin wa 'Umdah al-Muftin juz 1 hlm. 274; Al-Mahali, hamisy dari Kitab Al-Qalyubi juz 2 hlm. 56; Hasil Bahtsul Masaail PP Nurul Huda 1997/35""",
        source = """https://www.piss-ktb.com/2012/03/247-suntik-infus-dan-puasa.html""",
    ),
    PissQuestion(
        id = 20,
        title = """Pengertian I'tikaf""",
        question = """Apa itu i'tikaf dan berapa lama waktu minimalnya?""",
        answer = """Secara bahasa, i'tikaf berarti berdiam diri, menetap, dan menjalani sesuatu secara terus-menerus, baik perbuatan baik maupun buruk. Secara istilah, menurut madzhab Syafi'iyah i'tikaf adalah berdiam diri di dalam masjid yang dilakukan seseorang dengan disertai niat. Menurut Hanafiyah, i'tikaf adalah berdiam di masjid yang dipakai shalat berjamaah dengan disertai puasa dan niat (bagi wanita di tempat shalat yang ia tentukan di rumahnya). Menurut Malikiyah, i'tikaf adalah menetapnya seorang muslim yang telah tamyiz untuk beribadah di masjid dengan disertai puasa, menahan diri dari senggama dan foreplay-nya, minimal sehari semalam, dengan niat. Menurut Hanabilah, i'tikaf adalah menetapi masjid untuk taat kepada Allah, dilakukan seorang muslim yang berakal meski baru tamyiz dan suci dari hal yang mewajibkan mandi, dengan masa paling sedikit sesaat. Kesimpulannya, mayoritas ulama menyatakan i'tikaf cukup dilakukan dalam masa sesaat, sedangkan Malikiyah mensyaratkan minimal sehari semalam. I'tikaf disunnahkan di setiap waktu, baik di bulan Ramadhan maupun di luar Ramadhan — terutama pada 10 malam terakhir Ramadhan.""",
        reference = """Al-Fiqh al-Islami III/123–124""",
        source = """https://www.piss-ktb.com/2012/04/1376-pengertian-itikaf.html""",
    ),
)
