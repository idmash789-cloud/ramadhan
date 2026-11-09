package com.sembilansembilan.pertanyaanseputarramadhan.data

/**
 * 30 kultum Ramadhan (kuliah tujuh menit), satu untuk tiap malam Ramadhan
 * (malam 1-30). Ditulis orisinal dengan kata-kata sendiri untuk aplikasi
 * ini — bukan salinan dari sumber mana pun. Rata-rata sekitar 520 kata
 * per kultum (sekitar 4-5 menit dibaca lantang).
 * [quote] hanya ayat Al-Qur'an/hadits yang dikenal luas; dua kutipan
 * ditandai "(makna)" karena redaksinya adalah parafrase makna hadits,
 * bukan lafal hadits persis — penanda itu dipertahankan apa adanya.
 */
val kultumRamadhan: List<Kultum> = listOf(
    Kultum(
        night = 1,
        title = """Selamat Datang, Ramadhan""",
        theme = """Menyambut Ramadhan dengan hati yang gembira""",
        quote = """Wahai orang-orang yang beriman, diwajibkan atas kamu berpuasa sebagaimana diwajibkan atas orang-orang sebelum kamu agar kamu bertakwa.""",
        quoteSource = """QS Al-Baqarah: 183""",
        content = """Alhamdulillah, malam ini kita kembali dipertemukan dengan bulan yang paling kita rindukan. Ramadhan datang lagi, dan itu bukan hal kecil. Betapa banyak orang yang tahun lalu berpuasa bersama kita, tahun ini sudah tidak ada lagi. Ada yang mendahului kita, ada yang sakit dan tidak sanggup lagi berpuasa, ada yang sibuknya membuat Ramadhan lewat begitu saja. Maka kalau malam ini kita masih diberi kesempatan duduk di majelis ini, masih diberi kesehatan, masih diberi waktu, itu adalah nikmat yang patut kita syukuri dengan sungguh-sungguh, bukan sekadar diucapkan di bibir.

Ramadhan sering kita sambut dengan persiapan lahiriah. Kita membersihkan rumah, menyiapkan stok makanan, mengatur jadwal belanja, bahkan menyiapkan baju baru untuk Lebaran yang masih sebulan lagi. Semua itu tidak salah, selama tidak membuat kita lupa pada persiapan yang paling penting, yaitu persiapan hati. Sebab Ramadhan bukan sekadar bulan menahan lapar dan haus. Allah sendiri menjelaskan tujuan puasa dalam ayat yang baru kita dengar: agar kamu bertakwa. Puasa adalah latihan. Lapar mengajarkan kita bahwa tubuh ini bisa dikendalikan. Haus mengajarkan kita bahwa keinginan tidak selalu harus dituruti. Dan menahan diri dari yang halal saja di siang hari melatih kita untuk lebih mudah menahan diri dari yang haram di sepanjang waktu.

Maka mari kita sambut Ramadhan kali ini dengan niat yang diperbarui. Bukan sekadar ikut-ikutan, bukan sekadar karena sudah menjadi kebiasaan tahunan, tetapi karena kita sadar bahwa bulan ini adalah kesempatan. Kesempatan untuk memperbaiki salat kita yang selama ini terburu-buru. Kesempatan untuk kembali membaca Al-Qur'an yang sudah lama berdebu di rak. Kesempatan untuk meminta maaf kepada orang tua, pasangan, dan saudara sebelum kita meminta ampun kepada Allah. Kesempatan untuk menjadi pribadi yang sedikit lebih baik daripada Ramadhan tahun lalu.

Jangan bebani diri dengan target yang mustahil. Tidak perlu berjanji akan khatam berkali-kali jika itu membuat kita putus asa di hari ketiga. Mulailah dengan yang kecil tetapi konsisten: salat tepat waktu, satu halaman Al-Qur'an setiap selesai salat, satu kebaikan kecil setiap hari yang tidak diketahui siapa pun kecuali Allah. Amalan kecil yang terus-menerus jauh lebih berharga daripada amalan besar yang hanya dilakukan sekali lalu berhenti.

Malam pertama ini adalah malam yang baik untuk berdoa. Berdoalah agar Allah menyampaikan kita sampai akhir Ramadhan dalam keadaan sehat dan penuh semangat. Berdoalah agar Allah menerima puasa kita, mengampuni dosa-dosa kita, dan menjadikan bulan ini sebagai titik balik, bukan sekadar bulan yang lewat. Dan berdoalah juga untuk mereka yang tidak bisa bersama kita tahun ini, semoga Allah merahmati mereka.

Agar sambutan kita tidak berhenti pada perasaan senang saja, buatlah satu rencana sederhana malam ini juga. Tuliskan di kertas atau di ponsel: satu amalan yang ingin saya jaga selama Ramadhan, satu kebiasaan buruk yang ingin saya tinggalkan, dan satu orang yang ingin saya bahagiakan. Tempelkan rencana itu di tempat yang mudah terlihat, misalnya di pintu kulkas atau di samping tempat salat. Setiap kali kita melihatnya, kita diingatkan kembali pada niat awal. Ajak pula keluarga untuk membuat rencana yang sama, lalu saling mengingatkan dengan lembut. Ramadhan yang direncanakan dengan baik akan terasa lebih terarah, dan setiap malam yang kita lalui akan terasa lebih bermakna karena kita tahu apa yang sedang kita perjuangkan.

Selamat datang, Ramadhan. Semoga kali ini kita benar-benar menjadi tamu yang baik di bulan yang mulia ini, tamu yang pulang membawa bekal, bukan sekadar kenangan. Semoga Allah memberkahi setiap langkah kita di tiga puluh malam ke depan, dan semoga kita semua dipertemukan dengan malam-malam terbaik di bulan ini. Aamiin.""",
    ),
    Kultum(
        night = 2,
        title = """Niat yang Meluruskan Segalanya""",
        theme = """Memperbaiki niat sebelum beramal""",
        quote = """Sesungguhnya segala amal itu tergantung pada niatnya.""",
        quoteSource = """HR Bukhari dan Muslim""",
        content = """Ada sebuah pertanyaan yang sederhana tetapi menentukan seluruh nilai ibadah kita: untuk siapa kita berpuasa? Pertanyaan ini terdengar mudah, tetapi jawabannya sering bercampur dengan hal-hal lain tanpa kita sadari. Ada yang berpuasa karena takut dicemooh tetangga. Ada yang berpuasa karena ingin terlihat saleh di hadapan keluarga. Ada yang berpuasa karena ingin kurus, karena ingin sehat, karena ingin ikut tren. Semua alasan itu bisa saja menyertai, tetapi jika niat utama kita bukan karena Allah, maka puasa kita kehilangan ruhnya.

Niat itu seperti akar sebuah pohon. Dari luar, yang terlihat adalah batang, daun, dan buahnya. Tetapi kalau akarnya busuk, pohon itu tidak akan bertahan lama. Begitu pula amal. Salat yang panjang, puasa yang penuh, sedekah yang besar, semuanya dinilai dari apa yang ada di dalam hati ketika amal itu dilakukan. Rasulullah mengingatkan bahwa segala amal tergantung pada niatnya. Satu amalan yang sama bisa bernilai sangat tinggi di sisi Allah karena niatnya tulus, dan bisa bernilai sangat rendah karena niatnya bercampur dengan keinginan dipuji manusia.

Di malam kedua ini, mari kita duduk sejenak dan memeriksa hati kita masing-masing. Tidak perlu diumumkan kepada siapa pun. Cukup jujur kepada diri sendiri. Apakah saya berpuasa karena Allah memerintahkan? Apakah saya salat tarawih karena ingin mendekat kepada-Nya, atau karena tidak enak jika pulang lebih awal dari jamaah lain? Apakah saya bersedekah karena ingin membantu, atau karena ingin nama saya disebut? Kejujuran seperti ini mungkin terasa tidak nyaman, tetapi justru itulah awal perbaikan. Hati yang mau diperiksa adalah hati yang masih hidup.

Niat yang baik tidak harus diucapkan dengan kalimat yang panjang dan indah. Cukuplah hati kita mantap bahwa apa yang kita lakukan ini untuk Allah. Ketika sahur, hadirkan dalam hati bahwa kita makan bukan sekadar untuk kuat menahan lapar, tetapi untuk menjalankan perintah Allah. Ketika menahan marah di tengah puasa, ingatkan diri bahwa kita sedang menjaga puasa kita agar tetap utuh di sisi Allah. Ketika memberi, niatkan karena Allah, bukan karena ingin balasan dari manusia.

Dan kabar baiknya, niat itu bisa diperbarui kapan saja. Kalau di hari pertama kita merasa niat kita belum lurus, malam ini adalah waktunya meluruskan. Kalau di tengah Ramadhan nanti kita merasa lelah dan mulai beribadah sekadar rutinitas, berhentilah sejenak, tarik napas, dan perbarui niat. Allah Maha Mengetahui apa yang tersembunyi di dalam hati, dan Dia Maha Menerima hamba yang kembali kepada-Nya dengan tulus.

Ada cara sederhana untuk menjaga niat tetap lurus sepanjang hari. Setiap kali hendak melakukan ibadah, berhentilah sejenak selama beberapa detik dan tanyakan dalam hati: untuk siapa saya melakukan ini? Jika jawabannya karena Allah, lanjutkan dengan tenang. Jika jawabannya bercampur dengan keinginan dipuji, perbarui niat itu di tempat. Latihan ini memang terasa aneh pada awalnya, tetapi lama-lama ia menjadi kebiasaan yang menenangkan. Kita juga perlu berhati-hati dengan pujian manusia. Ketika ada yang memuji ibadah kita, ucapkanlah dalam hati bahwa pujian itu milik Allah, bukan milik kita. Dengan cara itu, pujian tidak membuat kita sombong, dan celaan tidak membuat kita putus asa, karena yang kita cari hanyalah rida Allah semata.

Semoga Ramadhan kali ini mengajarkan kita untuk tidak hanya sibuk memperbanyak amal, tetapi juga sibuk menjaga niat. Sebab amal yang sedikit tetapi ikhlas lebih berat timbangannya daripada amal yang banyak tetapi kosong. Mari kita jaga hati kita sebagaimana kita menjaga puasa kita dari makan dan minum. Semoga Allah menerima setiap amal kita dan mengampuni kekurangan niat kita selama ini. Aamiin.""",
    ),
    Kultum(
        night = 3,
        title = """Puasa Bukan Sekadar Menahan Lapar""",
        theme = """Keutamaan dan makna puasa""",
        quote = """Wahai orang-orang yang beriman, diwajibkan atas kamu berpuasa sebagaimana diwajibkan atas orang-orang sebelum kamu agar kamu bertakwa.""",
        quoteSource = """QS Al-Baqarah: 183""",
        content = """Kalau ada orang bertanya, apa bedanya orang yang berpuasa dengan orang yang sedang diet? Jawabannya sederhana: niat dan tujuan. Orang yang diet menahan makan demi tubuhnya. Orang yang berpuasa menahan makan, minum, dan hawa nafsu demi Allah. Dari luar kelihatannya sama, sama-sama lapar, sama-sama haus, tetapi nilainya di sisi Allah sangat berbeda. Di sinilah letak keistimewaan puasa: ia adalah ibadah yang rahasia, yang hanya Allah dan pelakunya yang benar-benar tahu.

Salat bisa dilihat orang. Sedekah bisa diketahui orang. Haji bisa disaksikan banyak orang. Tetapi puasa, tidak ada yang bisa memastikan apakah seseorang benar-benar berpuasa atau hanya mengaku berpuasa. Seseorang bisa saja makan diam-diam di kamar, lalu keluar dan berkata bahwa ia berpuasa, dan tidak ada manusia yang tahu. Tetapi Allah tahu. Karena itulah puasa melatih kejujuran yang paling dalam: kejujuran ketika tidak ada yang melihat. Orang yang terbiasa jujur kepada Allah dalam puasanya, insya Allah akan terbiasa jujur dalam seluruh hidupnya.

Puasa juga mengajarkan kita merasakan apa yang dirasakan oleh saudara-saudara kita yang kekurangan. Selama ini kita makan tiga kali sehari tanpa berpikir panjang. Kita membuka kulkas dan selalu ada sesuatu di dalamnya. Tetapi di luar sana, ada orang yang setiap hari menahan lapar bukan karena beribadah, melainkan karena memang tidak ada yang bisa dimakan. Ketika perut kita lapar di siang Ramadhan, seharusnya hati kita tergerak. Oh, ternyata seperti ini rasanya. Dan dari rasa itu lahirlah kepedulian, lahirlah keinginan untuk berbagi, lahirlah rasa syukur atas nikmat yang selama ini kita anggap biasa.

Selain itu, puasa melatih pengendalian diri. Berapa banyak masalah dalam hidup ini muncul bukan karena kita tidak tahu yang benar, melainkan karena kita tidak bisa menahan diri? Kita tahu marah itu merugikan, tetapi tetap marah. Kita tahu berbelanja berlebihan itu tidak baik, tetapi tetap melakukannya. Kita tahu bergosip itu dosa, tetapi lidah tetap bergerak. Puasa adalah sekolah pengendalian diri. Siang hari kita dilatih menahan yang halal, agar di luar puasa kita lebih mampu menahan yang haram. Kalau kita berhasil menahan lapar dan haus selama belasan jam, seharusnya kita juga bisa menahan marah selama beberapa menit.

Maka jangan jadikan puasa sekadar rutinitas menahan lapar dari subuh sampai magrib, lalu berbuka dengan berlebihan seolah membalas dendam. Puasa yang baik adalah puasa yang mengubah perilaku. Mata lebih terjaga, lisan lebih terjaga, tangan lebih terjaga, hati lebih lembut. Jika setelah sepekan berpuasa kita masih mudah marah, masih suka menyakiti orang lain dengan kata-kata, masih pelit dan acuh, itu pertanda puasa kita baru sampai di perut, belum sampai ke hati.

Mari kita perhatikan satu hal yang sering luput: puasa juga melatih kita untuk merasakan lapar orang lain, tetapi rasa itu harus diwujudkan dalam tindakan. Jika hari ini kita merasa lapar, ingatlah tetangga yang mungkin lapar setiap hari. Jika hari ini kita merasa haus, ingatlah saudara kita yang kesulitan mendapatkan air bersih. Rasa lapar yang kita alami seharusnya tidak berhenti pada rasa kasihan, melainkan berubah menjadi kepedulian yang nyata. Mulailah dengan langkah kecil: sisihkan sebagian makanan berbuka untuk tetangga, atau sisihkan sebagian uang belanja untuk disedekahkan. Puasa yang baik adalah puasa yang membuat tangan kita lebih ringan memberi dan hati kita lebih peka terhadap penderitaan orang lain di sekitar kita.

Semoga Allah menjadikan puasa kita tahun ini sebagai puasa yang utuh, bukan sekadar menahan lapar dan haus, tetapi juga menahan diri dari segala yang Allah larang. Semoga dengan puasa ini kita menjadi pribadi yang lebih sabar, lebih peduli, dan lebih bertakwa. Aamiin.""",
    ),
    Kultum(
        night = 4,
        title = """Sahur, Keberkahan di Ujung Malam""",
        theme = """Keutamaan sahur dan memulai hari dengan baik""",
        quote = """Bersahurlah kalian, karena sesungguhnya pada sahur itu terdapat keberkahan.""",
        quoteSource = """HR Bukhari dan Muslim""",
        content = """Ada satu momen di bulan Ramadhan yang tidak ada di bulan-bulan lain: sahur. Di saat sebagian besar manusia masih terlelap, rumah-rumah kaum muslimin menyala. Ada yang memasak, ada yang menghangatkan makanan, ada yang duduk bersama keluarga di meja makan pada jam tiga pagi. Momen ini sederhana, tetapi Rasulullah menyebutnya penuh keberkahan. Apa yang membuat sahur begitu istimewa?

Pertama, sahur adalah pembeda. Puasa kita berbeda dengan puasa umat-umat terdahulu, salah satunya karena kita dianjurkan sahur. Sahur menjadi tanda bahwa puasa ini bukan sekadar menahan diri tanpa bekal, melainkan ibadah yang dijalankan dengan persiapan dan kasih sayang Allah kepada hamba-Nya. Allah tidak membebani kita di luar kemampuan kita. Sahur adalah bentuk kemudahan itu: makanlah sebelum berpuasa, agar tubuhmu kuat, agar harimu berjalan dengan baik.

Kedua, sahur adalah waktu yang mustajab untuk berdoa. Ujung malam adalah waktu ketika Allah dekat dengan hamba-Nya yang berdoa dan memohon ampun. Banyak orang yang bangun sahur hanya untuk makan, lalu kembali tidur tanpa sempat berdoa. Padahal, lima atau sepuluh menit setelah sahur, sebelum azan subuh, adalah waktu yang sangat berharga. Gunakanlah untuk beristigfar, untuk berdoa bagi diri sendiri, keluarga, dan orang-orang yang kita cintai. Doa di waktu sahur adalah doa yang diucapkan dalam keadaan perut terisi, hati tenang, dan suasana hening. Jangan lewatkan begitu saja.

Ketiga, sahur mengajarkan kebersamaan keluarga. Di hari-hari biasa, anggota keluarga sering makan pada waktu yang berbeda-beda. Ada yang sarapan sendirian karena berangkat pagi, ada yang makan siang di kantor, ada yang makan malam setelah lembur. Tetapi di Ramadhan, sahur mempertemukan mereka di satu meja pada waktu yang sama. Anak-anak belajar bangun malam, orang tua menyiapkan makanan, dan semua berdoa bersama sebelum memulai puasa. Kenangan seperti ini akan diingat anak-anak sampai mereka dewasa. Maka jangan jadikan sahur sekadar rutinitas makan, jadikan ia momen keluarga.

Ada juga yang merasa berat untuk sahur. Ada yang berkata, saya tidak lapar, saya lebih baik tidur saja. Rasulullah menganjurkan sahur, walau hanya dengan seteguk air. Artinya, yang penting bukan banyaknya makanan, tetapi keberkahannya. Bangunlah, minumlah air, makanlah sedikit, dan niatkan puasa. Tubuh yang diberi bekal akan lebih kuat menjalani hari, dan hati yang bangun di ujung malam akan lebih dekat kepada Allah.

Jangan pula sahur terlalu mepet dengan azan subuh sampai kita makan terburu-buru dan salat subuh pun tergesa-gesa. Aturlah waktu dengan baik. Bangun sedikit lebih awal, sahur dengan tenang, lalu bersiap untuk salat subuh berjamaah. Awal hari yang baik akan menentukan hari yang baik pula. Orang yang memulai harinya dengan sahur, doa, dan salat subuh berjamaah, insya Allah akan menjalani siang harinya dengan lebih sabar dan lebih tenang.

Ada satu kebiasaan baik yang bisa kita bangun dari sahur: bangun lebih awal sepuluh menit untuk salat tahajud dua rakaat sebelum sahur. Tidak harus lama, cukup dua rakaat dengan bacaan yang pendek, lalu berdoa dengan sungguh-sungguh. Malam yang hening adalah waktu yang paling tepat untuk berbicara kepada Allah tanpa gangguan. Banyak orang yang merasa doanya belum terkabul, padahal mereka belum pernah benar-benar meluangkan waktu untuk berdoa di sepertiga malam. Sahur memberi kita alasan untuk bangun di waktu itu, maka manfaatkanlah. Jika kita membiasakan tahajud di bulan Ramadhan, insya Allah kebiasaan itu akan terbawa sampai setelah Ramadhan, dan malam-malam kita tidak lagi berlalu begitu saja tanpa ibadah.

Semoga Allah memberkahi sahur kita, memberkahi makanan kita, dan memberkahi waktu-waktu malam kita. Semoga setiap sahur menjadi penguat, bukan sekadar pengisi perut, tetapi pengisi hati dan iman. Aamiin.""",
    ),
    Kultum(
        night = 5,
        title = """Berbuka dengan Syukur""",
        theme = """Adab berbuka dan mensyukuri nikmat""",
        quote = """Sesungguhnya jika kamu bersyukur, pasti Kami akan menambah (nikmat) kepadamu.""",
        quoteSource = """QS Ibrahim: 7""",
        content = """Ada satu momen dalam sehari di bulan Ramadhan yang ditunggu oleh semua orang yang berpuasa: azan magrib. Setelah belasan jam menahan lapar dan haus, suara azan itu terasa seperti kabar gembira. Segelas air putih yang di hari biasa terasa biasa saja, di saat berbuka terasa begitu nikmat. Sebutir kurma yang kecil terasa begitu manis. Di momen inilah kita belajar, bahwa nikmat yang paling berharga sering kali adalah nikmat yang paling sederhana, yang selama ini kita anggap remeh.

Sayangnya, tidak sedikit orang yang merusak momen berbuka dengan dua hal: berlebihan dan terburu-buru. Ada yang berbuka dengan porsi yang sangat besar, seolah ingin membalas semua lapar seharian dalam satu kali duduk. Akibatnya perut terasa berat, badan terasa lemas, dan salat tarawih pun menjadi berat. Padahal berbuka yang baik adalah berbuka yang secukupnya. Rasulullah mencontohkan berbuka dengan kurma atau air, lalu salat magrib, baru kemudian makan secukupnya. Perut yang tidak terlalu penuh akan membuat tubuh lebih ringan untuk beribadah.

Hal kedua yang sering terlewat adalah doa saat berbuka. Doa orang yang berpuasa ketika berbuka adalah doa yang mustajab, doa yang tidak ditolak. Tetapi berapa banyak dari kita yang langsung menyambar makanan begitu azan berkumandang, tanpa sempat berdoa? Padahal doa itu hanya butuh beberapa detik. Berdoalah sebelum makan, mintalah ampunan, mintalah kebaikan untuk diri dan keluarga, mintalah agar puasa kita diterima. Momen berbuka adalah momen yang penuh rahmat, jangan lewatkan dengan kesibukan menyantap hidangan semata.

Berbuka juga mengajarkan kita untuk berbagi. Betapa indahnya Ramadhan ketika kita berbuka bersama orang lain, ketika kita mengajak tetangga yang tinggal sendiri, ketika kita mengirim makanan ke masjid, ketika kita memberi makan orang yang berpuasa. Memberi makan orang yang berpuasa adalah amalan yang besar pahalanya, dan ia tidak harus mahal. Segelas air, sebutir kurma, sepiring nasi sederhana, semuanya bernilai di sisi Allah jika diberikan dengan ikhlas. Jangan menunggu kaya untuk berbagi. Berbagilah dari apa yang kita punya, sekecil apa pun.

Dan yang paling penting, jadikan berbuka sebagai momen syukur. Syukur karena Allah memberi kita makanan setelah seharian menahan lapar. Syukur karena Allah memberi kita keluarga untuk berbuka bersama. Syukur karena masih banyak saudara kita yang berbuka dengan seadanya, bahkan ada yang tidak tahu akan berbuka dengan apa. Syukur itu bukan sekadar ucapan alhamdulillah di bibir, tetapi kesadaran bahwa semua yang kita miliki adalah pemberian Allah, dan karena itu harus digunakan dengan baik.

Mari kita perbaiki adab berbuka kita mulai malam ini. Berbukalah dengan tenang, berdoalah terlebih dahulu, makanlah secukupnya, dan jangan lupa berbagi. Semoga setiap berbuka menjadi pengingat bahwa nikmat Allah begitu banyak, dan semoga rasa syukur itu membuat nikmat kita semakin bertambah, sebagaimana janji Allah dalam ayat yang kita dengar tadi. Aamiin.

Perhatikan pula cara kita berbuka bersama keluarga. Jadikan meja berbuka sebagai tempat yang hangat, bukan tempat yang penuh dengan keluhan dan pertengkaran. Matikan televisi sejenak, letakkan gawai, dan berbicaralah dengan keluarga. Tanyakan bagaimana puasa mereka hari ini, apa yang mereka syukuri, apa yang mereka harapkan besok. Percakapan sederhana seperti ini mempererat keluarga dan membuat berbuka menjadi momen yang dirindukan, bukan sekadar momen makan. Anak-anak akan mengingat suasana berbuka yang hangat ini sampai mereka dewasa, dan kelak mereka akan menciptakan suasana yang sama untuk keluarga mereka sendiri. Berbuka yang baik adalah berbuka yang mengenyangkan perut sekaligus menghangatkan hati.""",
    ),
    Kultum(
        night = 6,
        title = """Tarawih, Shalat Malam yang Dirindukan""",
        theme = """Keutamaan salat tarawih dan qiyam Ramadhan""",
        quote = """Barangsiapa mendirikan (salat) Ramadhan karena iman dan mengharap pahala, diampuni dosanya yang telah lalu.""",
        quoteSource = """HR Bukhari dan Muslim""",
        content = """Setiap Ramadhan, ada pemandangan yang selalu menghangatkan hati: masjid yang penuh pada malam hari. Anak-anak berlarian di serambi, orang tua berjalan pelan menuju saf, para pemuda duduk menunggu imam memulai salat. Suasana itu tidak kita temukan di bulan-bulan lain. Itulah tarawih, salat malam yang hanya ada di bulan Ramadhan, dan menjadi salah satu ciri paling indah dari bulan ini.

Tarawih sering kali dianggap sekadar pelengkap puasa. Padahal, nilainya sangat besar. Rasulullah menjanjikan ampunan bagi orang yang mendirikan salat Ramadhan dengan iman dan mengharap pahala. Ampunan itu bukan hal kecil. Dosa-dosa yang telah lalu, yang mungkin sudah kita lupakan tetapi masih tercatat, dapat dihapuskan melalui salat-salat malam di bulan ini. Maka sayang sekali jika kita berpuasa dengan sungguh-sungguh di siang hari, tetapi melewatkan tarawih di malam hari tanpa alasan yang jelas.

Namun, kita juga perlu jujur: tidak semua orang bisa tarawih dengan jumlah rakaat yang sama. Ada yang bekerja sampai malam, ada yang menjaga anak kecil di rumah, ada yang tubuhnya tidak kuat berdiri lama. Semua itu dimaklumi. Yang penting bukanlah berlomba-lomba dalam jumlah rakaat, melainkan menjaga kehadiran dan kekhusyukan. Lebih baik tarawih delapan rakaat dengan tenang dan memahami bacaan, daripada dua puluh rakaat dengan terburu-buru dan hati yang tidak hadir. Allah melihat kualitas, bukan sekadar kuantitas.

Bagi yang tarawih di masjid, jagalah adabnya. Datanglah tepat waktu, jangan membuat gaduh, dan jangan mengobrol selama salat berlangsung. Bagi yang tarawih di rumah, jangan merasa lebih rendah. Salat di rumah bersama keluarga juga bernilai, apalagi jika kita menjadi imam bagi istri dan anak-anak. Anak-anak yang melihat ayahnya menjadi imam di rumah akan belajar bahwa ibadah itu dekat, bukan sesuatu yang jauh dan hanya ada di masjid.

Ada satu hal yang sering membuat orang berhenti tarawih di tengah jalan: rasa lelah dan rasa bosan. Di awal Ramadhan masjid penuh, di pertengahan mulai berkurang, di akhir tinggal segelintir orang. Ini adalah ujian konsistensi. Ibadah yang paling dicintai Allah adalah ibadah yang terus-menerus, walau sedikit. Maka jangan targetkan kesempurnaan, targetkan keberlanjutan. Kalau malam ini kita hanya sanggup beberapa rakaat, lakukanlah beberapa rakaat itu dengan baik, dan ulangi esok malam. Sedikit demi sedikit, lama-lama menjadi kebiasaan.

Jadikan tarawih sebagai momen bertemu dengan Allah di malam hari, bukan sekadar kewajiban yang harus digugurkan. Dengarkan bacaan imam dengan saksama. Renungkan ayat-ayat yang dibaca. Mungkin ada satu ayat yang menyentuh hati kita malam ini, yang menjadi jawaban atas kegelisahan kita selama ini. Itulah keindahan salat malam: ia bukan sekadar gerakan, tetapi percakapan antara hamba dan Tuhannya.

Agar tarawih tidak terasa berat, persiapkan diri kita sejak sebelum magrib. Jangan makan terlalu banyak saat berbuka, karena perut yang terlalu penuh membuat tubuh berat dan mengantuk. Beristirahatlah sejenak setelah salat magrib, lalu berangkat ke masjid dengan hati yang tenang. Pilihlah tempat di saf yang membuat kita nyaman dan bisa mendengar bacaan imam dengan jelas. Jika kita merasa lelah di tengah tarawih, tidak apa-apa untuk beristirahat sejenak lalu melanjutkan lagi. Yang penting kita tetap hadir dan tetap berusaha. Jangan jadikan rasa lelah sebagai alasan untuk pulang lebih awal setiap malam, tetapi jangan pula memaksakan diri sampai sakit. Ibadah yang seimbang adalah ibadah yang bisa bertahan sampai akhir Ramadhan.

Semoga Allah memberi kita kekuatan untuk menjaga tarawih sampai akhir Ramadhan, memberi kita kekhusyukan dalam setiap rakaat, dan mengampuni dosa-dosa kita yang telah lalu. Semoga masjid-masjid kita tetap ramai sampai malam terakhir, dan semoga semangat itu terbawa sampai setelah Ramadhan berakhir. Aamiin.""",
    ),
    Kultum(
        night = 7,
        title = """Sabar, Kunci Puasa yang Sempurna""",
        theme = """Melatih kesabaran di bulan Ramadhan""",
        quote = """Sesungguhnya hanya orang-orang yang bersabarlah yang dicukupkan pahala mereka tanpa batas.""",
        quoteSource = """QS Az-Zumar: 10""",
        content = """Kalau ada satu kata yang paling sering disebut ketika berbicara tentang puasa, kata itu adalah sabar. Puasa memang sekolah kesabaran. Sejak subuh sampai magrib, kita bersabar menahan lapar, menahan haus, menahan marah, menahan keinginan untuk membalas kata-kata yang menyakitkan. Semua itu adalah latihan sabar, dan sabar itu sendiri adalah amalan yang pahalanya tidak terbatas, sebagaimana Allah firmankan dalam ayat yang kita dengar tadi.

Tetapi sabar yang dimaksud di sini bukan sekadar diam dan menahan diri dengan wajah masam. Sabar bukan berarti kita memendam kemarahan lalu meledak di saat berbuka. Sabar adalah kemampuan untuk tetap tenang, tetap baik, dan tetap berpikir jernih dalam keadaan yang tidak menyenangkan. Orang yang sabar bukan orang yang tidak pernah marah, melainkan orang yang bisa mengendalikan marahnya. Orang yang sabar bukan orang yang tidak pernah kecewa, melainkan orang yang tidak membiarkan kekecewaannya merusak hubungannya dengan orang lain.

Ramadhan memberi kita banyak kesempatan untuk berlatih sabar. Sabar ketika macet di jalan pulang kerja dan perut sudah lapar. Sabar ketika anak-anak ribut di rumah padahal kita sedang lelah. Sabar ketika ada orang yang berkata kasar kepada kita di tengah puasa. Sabar ketika rencana kita tidak berjalan sebagaimana mestinya. Setiap kali kita berhasil menahan diri dalam situasi seperti itu, kita sedang naik satu tingkat dalam kesabaran. Dan setiap tingkat itu dicatat oleh Allah dengan pahala yang tanpa batas.

Sering kali, ujian kesabaran terbesar justru datang dari orang-orang terdekat. Pasangan yang lupa menyiapkan sahur, anak yang menumpahkan minuman, rekan kerja yang menyebalkan, tetangga yang tidak peka. Kita mudah sabar kepada orang jauh, tetapi sulit sabar kepada orang yang setiap hari bersama kita. Padahal, merekalah yang paling berhak mendapatkan kesabaran kita. Ramadhan adalah waktu yang tepat untuk memperbaiki kesabaran kita di rumah, sebelum kita menuntut kesabaran dari orang lain.

Bagaimana cara melatih sabar? Pertama, sadari bahwa emosi itu datang dan pergi. Ketika marah muncul, jangan langsung bereaksi. Ambillah jeda beberapa detik, tarik napas, dan ingatkan diri bahwa kita sedang berpuasa. Kedua, ubahlah cara pandang kita. Mungkin orang yang menyakiti kita sedang lelah, sedang punya masalah, atau tidak bermaksud buruk. Ketiga, ingatlah pahala sabar. Ketika kita tahu bahwa Allah menyediakan pahala tanpa batas bagi orang yang sabar, kesabaran menjadi lebih mudah.

Sabar juga perlu dilatih dalam hal-hal kecil yang sering kita anggap sepele. Sabar ketika antrean panjang di pasar, sabar ketika internet lambat, sabar ketika rencana berubah mendadak, sabar ketika anak-anak bertanya berkali-kali. Latihan-latihan kecil ini sebenarnya adalah bekal untuk menghadapi ujian yang lebih besar. Orang yang terbiasa sabar dalam hal kecil akan lebih siap ketika menghadapi musibah yang besar. Sebaliknya, orang yang tidak pernah melatih kesabarannya akan mudah panik dan marah ketika menghadapi masalah. Maka jangan remehkan kesempatan untuk bersabar hari ini, karena setiap kesabaran kecil yang kita latih sedang membangun kekuatan hati yang akan kita butuhkan di masa depan, jauh setelah Ramadhan berakhir.

Semoga Ramadhan ini menjadikan kita pribadi yang lebih sabar, bukan hanya selama sebulan, tetapi seterusnya. Semoga kesabaran yang kita latih di bulan ini menjadi bekal untuk menghadapi ujian-ujian hidup di bulan-bulan berikutnya. Dan semoga Allah mencatat kita termasuk orang-orang yang bersabar, yang pahalanya dicukupkan tanpa batas. Aamiin.""",
    ),
    Kultum(
        night = 8,
        title = """Syukur di Tengah Kesederhanaan""",
        theme = """Mensyukuri nikmat Allah dalam kehidupan sehari-hari""",
        quote = """Sesungguhnya jika kamu bersyukur, pasti Kami akan menambah (nikmat) kepadamu.""",
        quoteSource = """QS Ibrahim: 7""",
        content = """Pernahkah kita menghitung nikmat yang Allah berikan kepada kita? Kalau kita mencoba menghitungnya, kita tidak akan sanggup. Nikmat bernapas, nikmat melihat, nikmat mendengar, nikmat berjalan, nikmat punya keluarga, nikmat punya pekerjaan, nikmat punya tempat tinggal, nikmat bisa berpuasa dan beribadah. Semua itu kita terima setiap hari, tetapi sering kali kita baru menyadari nilainya ketika nikmat itu hilang. Kita baru sadar betapa berharganya kesehatan ketika kita sakit. Kita baru sadar betapa berharganya kebersamaan ketika orang yang kita sayangi sudah tiada.

Ramadhan adalah bulan yang mengajarkan kita untuk kembali menyadari nikmat-nikmat itu. Ketika kita lapar, kita sadar bahwa makanan adalah nikmat. Ketika kita haus, kita sadar bahwa air adalah nikmat. Ketika kita berbuka bersama keluarga, kita sadar bahwa kebersamaan adalah nikmat. Puasa membuat kita merasakan kehilangan untuk sementara, agar kita lebih menghargai apa yang kita miliki. Itulah salah satu hikmah puasa yang paling dalam: ia mengajarkan syukur melalui pengalaman, bukan sekadar melalui nasihat.

Tetapi syukur tidak cukup hanya diucapkan. Syukur yang benar terlihat dalam sikap kita. Orang yang bersyukur atas nikmat makanan tidak akan membuang-buang makanan. Orang yang bersyukur atas nikmat waktu tidak akan menghabiskan waktunya untuk hal yang sia-sia. Orang yang bersyukur atas nikmat keluarga akan menjaga dan menyayangi keluarganya. Orang yang bersyukur atas nikmat harta akan menggunakannya untuk kebaikan dan berbagi kepada yang membutuhkan. Syukur adalah sikap hidup, bukan sekadar kata.

Sayangnya, kita sering terjebak dalam kebiasaan membandingkan. Kita melihat tetangga yang rumahnya lebih besar, teman yang mobilnya lebih baru, saudara yang penghasilannya lebih tinggi, lalu kita merasa kekurangan. Padahal, kalau kita membandingkan ke bawah, kita akan melihat bahwa kita jauh lebih beruntung daripada banyak orang. Ada orang yang tidak punya rumah, tidak punya pekerjaan, tidak punya makanan untuk berbuka. Membandingkan ke bawah bukan untuk meremehkan orang lain, tetapi untuk menyadarkan diri bahwa kita sudah diberi banyak.

Di bulan Ramadhan ini, mari kita biasakan mencatat nikmat setiap hari. Sebelum tidur, sebutkan tiga hal yang kita syukuri hari ini. Mungkin hal sederhana: hari ini kita sehat, hari ini kita bisa berbuka bersama keluarga, hari ini ada tetangga yang mengirim makanan. Kebiasaan kecil ini akan mengubah cara kita memandang hidup. Kita akan lebih tenang, lebih bahagia, dan lebih dekat kepada Allah. Dan Allah telah berjanji, siapa yang bersyukur, nikmatnya akan ditambah.

Mari kita biasakan satu latihan syukur yang sederhana tetapi ampuh: setiap kali kita hendak mengeluh, gantilah keluhan itu dengan satu nikmat yang kita miliki. Ketika kita mengeluh tentang pekerjaan yang melelahkan, ingatlah bahwa kita masih punya pekerjaan, sementara banyak orang yang mencarinya. Ketika kita mengeluh tentang rumah yang sempit, ingatlah bahwa kita masih punya tempat berteduh, sementara banyak orang yang tidak punya rumah. Ketika kita mengeluh tentang makanan yang itu-itu saja, ingatlah bahwa kita masih bisa makan, sementara banyak orang yang tidak tahu akan makan apa hari ini. Latihan ini tidak membuat masalah kita hilang, tetapi ia mengubah cara kita memandang masalah, dan hati yang pandai bersyukur akan selalu menemukan alasan untuk tenang dan bahagia.

Semoga Allah menjadikan kita hamba-hamba yang pandai bersyukur, yang tidak hanya pandai meminta, tetapi juga pandai menghargai apa yang sudah diberi. Semoga syukur kita di bulan Ramadhan ini berlanjut sampai setelah Ramadhan, dan semoga Allah menambah nikmat-Nya kepada kita semua. Aamiin.""",
    ),
    Kultum(
        night = 9,
        title = """Al-Qur'an, Sahabat di Bulan Ramadhan""",
        theme = """Membaca dan merenungkan Al-Qur'an""",
        quote = """Bulan Ramadhan adalah (bulan) yang di dalamnya diturunkan Al-Qur'an sebagai petunjuk bagi manusia.""",
        quoteSource = """QS Al-Baqarah: 185""",
        content = """Ada satu peristiwa besar yang terjadi di bulan Ramadhan, yang menjadi alasan mengapa bulan ini begitu mulia: di bulan inilah Al-Qur'an diturunkan. Al-Qur'an bukan sekadar kitab yang dibaca, melainkan petunjuk hidup bagi manusia. Ia diturunkan di bulan Ramadhan, maka tidak ada bulan yang lebih tepat untuk kembali mendekatkan diri kepada Al-Qur'an selain bulan ini. Itulah sebabnya, di mana-mana kita melihat orang berlomba-lomba membaca Al-Qur'an di bulan Ramadhan, ada yang khatam sekali, ada yang khatam dua kali, ada yang mengisi malam-malamnya dengan tadarus bersama.

Tetapi membaca Al-Qur'an bukan sekadar mengejar jumlah halaman atau jumlah khatam. Yang lebih penting adalah bagaimana bacaan itu memengaruhi hati kita. Ada orang yang membaca banyak, tetapi tidak ada yang berubah dalam dirinya. Ada orang yang membaca sedikit, tetapi satu ayat yang dibacanya membuat ia menangis dan berubah. Maka jangan hanya bertanya, sudah berapa juz saya baca hari ini? Bertanyalah juga, apa yang saya pahami dari yang saya baca hari ini? Ayat apa yang menyentuh hati saya? Pesan apa yang Allah sampaikan kepada saya melalui ayat itu?

Bagi banyak orang, membaca Al-Qur'an terasa sulit. Ada yang belum lancar membaca, ada yang merasa tidak punya waktu, ada yang merasa sudah terlambat untuk belajar. Jangan biarkan perasaan itu menghentikan kita. Orang yang membaca Al-Qur'an dengan terbata-bata tetap mendapatkan pahala, bahkan pahala yang berlipat karena usahanya. Tidak ada kata terlambat untuk belajar. Mulailah dengan satu halaman sehari, atau bahkan beberapa ayat sehari. Yang penting kita memulainya, dan kita melakukannya dengan konsisten.

Tadarus bersama juga memiliki keutamaan tersendiri. Ketika kita membaca bersama di masjid atau di rumah, kita saling menyemangati. Yang lancar membantu yang belum lancar. Yang mengantuk terbangun karena mendengar suara temannya. Suasana tadarus menciptakan kebersamaan yang indah, yang sulit didapatkan ketika kita membaca sendirian. Jika ada kesempatan untuk ikut tadarus di masjid, ikutilah. Jika tidak, buatlah tadarus kecil di rumah bersama keluarga, walau hanya lima belas menit setelah salat tarawih.

Selain membaca, luangkan waktu untuk merenungkan makna Al-Qur'an. Bacalah terjemahannya, dengarkan penjelasannya, atau sekadar renungkan satu ayat yang kita baca hari itu. Al-Qur'an diturunkan sebagai petunjuk, maka ia harus dipahami, bukan sekadar dibaca. Ketika kita membaca ayat tentang kesabaran, tanyakan pada diri kita, apakah saya sudah sabar hari ini? Ketika kita membaca ayat tentang sedekah, tanyakan, apakah saya sudah berbagi hari ini? Dengan cara itu, Al-Qur'an menjadi cermin yang menuntun kita memperbaiki diri setiap hari.

Bagi yang merasa bacaannya belum lancar, jangan malu untuk belajar kembali. Carilah guru, ikutilah kelompok belajar Al-Qur'an di masjid, atau mintalah anak atau pasangan untuk mengajari kita dengan sabar. Belajar Al-Qur'an di usia berapa pun adalah kemuliaan, bukan aib. Ada orang yang baru belajar membaca Al-Qur'an di usia lima puluh tahun, dan ia tetap mendapatkan pahala yang besar karena usahanya. Ada pula yang sudah lancar, tetapi ia menggunakan kelancarannya untuk mengajari orang lain, dan itu pun pahala yang besar. Yang terpenting bukanlah seberapa cepat kita membaca, melainkan seberapa tulus kita berusaha mendekat kepada Al-Qur'an. Setiap huruf yang kita baca dengan susah payah tetap dicatat sebagai kebaikan oleh Allah.

Semoga Ramadhan ini menjadi bulan kembalinya kita kepada Al-Qur'an, bukan sekadar bulan membaca, tetapi bulan memahami dan mengamalkan. Semoga Al-Qur'an menjadi penolong kita di dunia dan di akhirat, menjadi cahaya di saat gelap, dan menjadi penenang di saat gelisah. Aamiin.""",
    ),
    Kultum(
        night = 10,
        title = """Menjaga Lisan di Bulan Suci""",
        theme = """Menjaga ucapan dari ghibah, dusta, dan kata kasar""",
        quote = """Barangsiapa beriman kepada Allah dan hari akhir, hendaklah ia berkata baik atau diam.""",
        quoteSource = """HR Bukhari dan Muslim""",
        content = """Puasa mengajarkan kita untuk menjaga banyak hal: menjaga perut dari makanan, menjaga mata dari pandangan yang tidak baik, menjaga tangan dari perbuatan yang tidak baik, dan yang tidak kalah penting, menjaga lisan dari ucapan yang tidak baik. Rasulullah mengingatkan, siapa yang beriman kepada Allah dan hari akhir, hendaklah ia berkata baik atau diam. Kalimat ini sederhana, tetapi sangat dalam. Ia mengajarkan bahwa diam itu lebih baik daripada berbicara yang menyakiti, dan berkata baik itu lebih baik daripada diam yang acuh.

Lisan adalah anggota tubuh yang kecil, tetapi dampaknya bisa sangat besar. Satu kalimat yang kasar bisa merusak hubungan yang dibangun bertahun-tahun. Satu gosip yang disebarkan bisa menghancurkan nama baik seseorang. Satu kebohongan bisa menimbulkan masalah yang berkepanjangan. Dan sebaliknya, satu kalimat yang baik bisa menenangkan hati yang gelisah, satu pujian yang tulus bisa membangkitkan semangat seseorang, satu permintaan maaf bisa memperbaiki hubungan yang retak. Lisan bisa menjadi sumber pahala, bisa juga menjadi sumber dosa. Pilihannya ada di tangan kita setiap kali kita membuka mulut.

Di bulan Ramadhan, menjaga lisan menjadi lebih penting karena puasa kita bisa rusak oleh ucapan yang buruk. Ada orang yang berpuasa dari makan dan minum, tetapi tidak berpuasa dari bergosip, dari berkata kasar, dari berdusta. Padahal, tujuan puasa adalah takwa, dan takwa tidak mungkin tercapai jika lisan kita masih liar. Maka Ramadhan adalah waktu yang tepat untuk melatih lisan kita. Kalau kita terbiasa bergosip, berhentilah. Kalau kita terbiasa berkata kasar ketika marah, latihlah diri untuk diam sejenak sebelum berbicara. Kalau kita terbiasa berbohong untuk hal-hal kecil, biasakanlah berkata jujur walau pahit.

Menjaga lisan bukan berarti kita tidak boleh berbicara sama sekali. Kita tetap perlu berbicara, tetapi pilihlah kata-kata yang baik, yang bermanfaat, dan yang tidak menyakiti. Ketika kita tidak tahu sesuatu, lebih baik kita berkata tidak tahu daripada mengarang. Ketika kita mendengar gosip, lebih baik kita tidak meneruskannya. Ketika kita marah, lebih baik kita diam sampai tenang. Diam yang seperti ini bukan kelemahan, melainkan kekuatan. Orang yang bisa menahan lisannya adalah orang yang kuat.

Ada satu kebiasaan yang baik untuk dilatih di bulan Ramadhan: sebelum berbicara, tanyakan pada diri sendiri tiga hal. Apakah yang akan saya katakan ini benar? Apakah ini bermanfaat? Apakah ini akan menyakiti orang lain? Jika jawabannya meragukan, lebih baik diam. Kebiasaan ini memang butuh latihan, tetapi lama-lama akan menjadi tabiat. Dan ketika Ramadhan berakhir, kebiasaan baik ini akan terbawa ke bulan-bulan berikutnya.

Semoga Allah menjaga lisan kita, sebagaimana Dia menjaga puasa kita. Semoga setiap kata yang keluar dari mulut kita menjadi kata yang baik, yang membawa pahala, dan yang tidak menyakiti siapa pun. Semoga Ramadhan ini menjadikan lisan kita lebih lembut, lebih jujur, dan lebih bermanfaat. Aamiin.

Menjaga lisan juga berarti menjaga apa yang kita tulis di media sosial. Di zaman sekarang, lisan kita tidak hanya berbicara, tetapi juga mengetik. Komentar yang kasar, status yang menyindir, pesan yang menyebarkan gosip, semuanya adalah bentuk ucapan yang akan dimintai pertanggungjawaban. Di bulan Ramadhan, mari kita bersihkan juga media sosial kita. Berhentilah mengikuti akun yang memancing emosi dan gosip. Berhentilah berkomentar pada hal-hal yang tidak kita ketahui kebenarannya. Gunakanlah media sosial untuk menyebarkan kebaikan: membagikan pengingat yang bermanfaat, menyebarkan informasi yang benar, atau sekadar menyapa saudara dengan kata-kata yang baik. Lisan yang terjaga, baik yang diucapkan maupun yang ditulis, adalah tanda puasa yang utuh.""",
    ),
    Kultum(
        night = 11,
        title = """Sedekah di Bulan yang Dilipatgandakan""",
        theme = """Keutamaan bersedekah di Ramadhan""",
        quote = """Sedekah itu dapat menghapus dosa sebagaimana air memadamkan api.""",
        quoteSource = """HR Tirmidzi""",
        content = """Di antara amalan yang paling dianjurkan di bulan Ramadhan adalah sedekah. Rasulullah adalah orang yang paling dermawan, dan kedermawanannya semakin bertambah di bulan Ramadhan. Beliau memberi seperti angin yang berembus, tidak pernah menahan, tidak pernah menghitung-hitung. Mengapa Ramadhan menjadi bulan yang paling tepat untuk bersedekah? Karena di bulan ini, setiap kebaikan dilipatgandakan pahalanya, hati manusia lebih lembut, dan kebutuhan orang-orang di sekitar kita juga semakin terasa.

Sedekah tidak harus besar. Banyak orang yang menunda bersedekah karena menunggu kaya, menunggu gajian, menunggu ada kelebihan. Padahal, sedekah yang paling baik adalah sedekah yang diberikan saat kita sendiri merasa berkecukupan, walau sedikit. Segelas air untuk orang yang berbuka, sepiring makanan untuk tetangga, selembar uang untuk anak yatim, semuanya adalah sedekah yang bernilai. Jangan remehkan sedekah yang kecil, karena di sisi Allah, yang dinilai adalah keikhlasan, bukan besarnya jumlah.

Sedekah juga memiliki manfaat yang kembali kepada pemberinya. Rasulullah mengibaratkan sedekah dapat menghapus dosa sebagaimana air memadamkan api. Dosa-dosa yang kita lakukan, yang mungkin kita sadari atau tidak, dapat dihapuskan melalui sedekah yang ikhlas. Selain itu, sedekah membersihkan harta kita, menenangkan hati kita, dan menjauhkan kita dari sifat kikir. Orang yang terbiasa memberi akan merasakan kebahagiaan yang tidak bisa dibeli dengan uang. Ada rasa lega, ada rasa syukur, ada rasa dekat dengan Allah.

Di bulan Ramadhan, peluang bersedekah ada di mana-mana. Ada kotak amal di masjid, ada program berbagi takjil, ada santunan anak yatim, ada paket sembako untuk fakir miskin, ada donasi untuk pembangunan masjid. Pilihlah yang paling dekat dengan kita. Mulailah dari tetangga yang kita tahu keadaannya. Mungkin ada tetangga yang berbuka dengan seadanya, mungkin ada anak yatim di lingkungan kita yang butuh perhatian, mungkin ada saudara kita sendiri yang sedang kesulitan tetapi malu untuk meminta. Sedekah yang paling utama adalah sedekah kepada yang paling dekat dan paling membutuhkan.

Jangan lupa, sedekah tidak hanya berupa uang dan makanan. Senyuman adalah sedekah. Membantu tetangga mengangkat barang adalah sedekah. Menenangkan hati orang yang sedang sedih adalah sedekah. Mengajarkan ilmu yang bermanfaat adalah sedekah. Di bulan Ramadhan ini, perbanyaklah segala bentuk kebaikan, karena setiap kebaikan adalah sedekah, dan setiap sedekah akan kembali kepada kita dengan balasan yang lebih baik.

Agar sedekah menjadi kebiasaan, bukan sekadar amalan sesekali, buatlah anggaran sedekah yang sederhana. Sisihkan sebagian kecil dari penghasilan atau uang belanja setiap hari khusus untuk sedekah, walau hanya beberapa ribu rupiah. Letakkan di tempat khusus, misalnya di sebuah kotak kecil di rumah, lalu salurkan setiap beberapa hari kepada yang membutuhkan. Dengan cara ini, kita tidak perlu menunggu ada kelebihan besar untuk bersedekah, karena sedekah sudah menjadi bagian dari pengeluaran kita sehari-hari. Anak-anak pun bisa dilibatkan: berikan mereka uang saku khusus untuk sedekah, dan ajak mereka memilih sendiri kepada siapa sedekah itu diberikan. Kebiasaan memberi yang ditanamkan sejak kecil akan tumbuh menjadi sifat dermawan ketika mereka dewasa.

Semoga Allah melapangkan rezeki kita, melembutkan hati kita untuk berbagi, dan menerima setiap sedekah yang kita berikan di bulan Ramadhan ini. Semoga harta yang kita sedekahkan menjadi penolong kita di akhirat, dan semoga tidak ada satu pun dari kita yang pulang dari Ramadhan dengan tangan yang kosong dari kebaikan. Aamiin.""",
    ),
    Kultum(
        night = 12,
        title = """Keluarga, Madrasah Pertama di Ramadhan""",
        theme = """Membangun kebersamaan dan ibadah keluarga""",
        quote = """Wahai orang-orang yang beriman, peliharalah dirimu dan keluargamu dari api neraka.""",
        quoteSource = """QS At-Tahrim: 6""",
        content = """Ramadhan adalah bulan keluarga. Di bulan ini, keluarga berkumpul untuk sahur, berkumpul untuk berbuka, salat tarawih bersama, dan tadarus bersama. Momen-momen seperti ini tidak terjadi di bulan-bulan lain, dan karena itu, Ramadhan adalah kesempatan emas untuk memperkuat keluarga kita, bukan hanya sebagai tempat tinggal bersama, tetapi sebagai tempat belajar dan beribadah bersama.

Allah memerintahkan kita untuk menjaga diri dan keluarga kita dari api neraka. Ayat ini mengingatkan bahwa tanggung jawab kita tidak berhenti pada diri sendiri. Sebagai orang tua, kita bertanggung jawab untuk mengenalkan anak-anak kita kepada Allah, kepada salat, kepada puasa, kepada Al-Qur'an. Sebagai suami atau istri, kita bertanggung jawab untuk saling mengingatkan dalam kebaikan. Sebagai anak, kita bertanggung jawab untuk berbakti dan mendoakan orang tua kita. Keluarga adalah madrasah pertama, tempat nilai-nilai agama ditanamkan sebelum anak-anak mempelajarinya di tempat lain.

Tetapi, bagaimana caranya membangun keluarga yang dekat dengan ibadah di bulan Ramadhan? Mulailah dengan hal-hal yang sederhana dan menyenangkan. Ajaklah anak-anak sahur bersama, walau mereka belum wajib berpuasa. Biarkan mereka merasakan suasana sahur, bangun malam, dan makan bersama. Ajaklah mereka ke masjid untuk salat tarawih, walau hanya beberapa rakaat. Jangan memaksa mereka untuk sempurna, tetapi biasakan mereka untuk hadir dan merasakan. Anak-anak yang tumbuh dengan kenangan indah tentang Ramadhan akan merindukan Ramadhan ketika mereka dewasa.

Buatlah kegiatan keluarga yang sederhana di bulan Ramadhan. Misalnya, membaca satu halaman Al-Qur'an bersama setelah berbuka, atau mendengarkan satu kultum bersama sebelum tarawih, atau menyiapkan takjil bersama untuk dibagikan ke tetangga. Kegiatan seperti ini tidak membutuhkan biaya besar, tetapi dampaknya sangat besar. Anak-anak akan belajar bahwa ibadah itu menyenangkan, bukan beban. Mereka akan belajar bahwa keluarga adalah tempat yang hangat, tempat mereka bisa bertanya tentang agama tanpa takut dimarahi.

Jangan lupa juga untuk memperbaiki hubungan di dalam keluarga. Ramadhan adalah waktu yang tepat untuk meminta maaf kepada pasangan, kepada anak-anak, kepada orang tua. Mungkin selama ini kita terlalu sibuk bekerja sampai lupa mendengarkan anak-anak. Mungkin kita terlalu lelah sampai mudah marah kepada pasangan. Ramadhan mengajarkan kita untuk melambat, untuk hadir, untuk mendengarkan. Gunakan bulan ini untuk memperbaiki komunikasi, untuk lebih banyak memuji daripada mengkritik, untuk lebih banyak memeluk daripada memarahi.

Ada satu hal yang sering dilupakan dalam membangun keluarga di bulan Ramadhan: mendengarkan. Orang tua sering sibuk memberi nasihat, tetapi lupa mendengarkan cerita anak-anak. Pasangan sering sibuk dengan urusannya masing-masing, tetapi lupa mendengarkan keluh kesah pasangannya. Padahal, mendengarkan adalah bentuk perhatian yang paling sederhana dan paling berharga. Di bulan Ramadhan ini, luangkan waktu untuk mendengarkan tanpa menghakimi, tanpa memotong pembicaraan, tanpa sibuk dengan gawai. Dengarkan anak yang bercerita tentang harinya, dengarkan pasangan yang bercerita tentang pekerjaannya, dengarkan orang tua yang bercerita tentang masa lalunya. Keluarga yang saling mendengarkan adalah keluarga yang saling memahami, dan keluarga yang saling memahami akan lebih mudah menjaga ibadah bersama.

Semoga Allah memberkahi keluarga kita, menjadikan rumah kita rumah yang penuh dengan ibadah dan kasih sayang, dan menjadikan anak-anak kita anak-anak yang saleh dan salehah. Semoga Ramadhan ini menjadi bulan yang mempererat keluarga kita, bukan sekadar bulan yang kita lewati bersama, tetapi bulan yang mengubah kita menjadi keluarga yang lebih baik. Aamiin.""",
    ),
    Kultum(
        night = 13,
        title = """Meminta Maaf Sebelum Meminta Ampun""",
        theme = """Memperbaiki hubungan dengan sesama manusia""",
        quote = """Barangsiapa beriman kepada Allah dan hari akhir, hendaklah ia memuliakan tetangganya.""",
        quoteSource = """HR Bukhari dan Muslim, makna""",
        content = """Ada dua jenis hubungan yang harus kita jaga dalam hidup ini: hubungan dengan Allah dan hubungan dengan manusia. Kita sering sibuk memperbaiki hubungan dengan Allah melalui salat, puasa, dan doa, tetapi lupa memperbaiki hubungan dengan manusia. Padahal, keduanya sama-sama penting. Dosa kepada Allah dapat diampuni dengan tobat, tetapi kesalahan kepada manusia membutuhkan maaf dari orang yang bersangkutan. Karena itu, Ramadhan adalah waktu yang tepat untuk memperbaiki hubungan dengan sesama, sebelum kita meminta ampun kepada Allah.

Mungkin ada tetangga yang kita sakiti dengan kata-kata kita. Mungkin ada saudara yang sudah lama tidak kita sapa karena salah paham. Mungkin ada teman yang kita kecewakan. Mungkin ada orang tua yang hatinya terluka karena sikap kita. Semua itu adalah beban yang kita bawa ke dalam Ramadhan, dan beban itu tidak akan hilang hanya dengan berpuasa. Ia hanya akan hilang ketika kita berani meminta maaf dan memperbaiki hubungan itu.

Meminta maaf memang tidak mudah. Ada rasa gengsi, ada rasa takut ditolak, ada rasa malu mengakui kesalahan. Tetapi meminta maaf adalah tanda kekuatan, bukan kelemahan. Orang yang berani meminta maaf adalah orang yang berani jujur kepada dirinya sendiri. Dan orang yang memberi maaf adalah orang yang berhati besar. Allah menyukai hamba yang mudah memaafkan, dan Allah menjanjikan pahala yang besar bagi mereka yang menahan amarah dan memaafkan kesalahan orang lain.

Mulailah dari yang paling dekat. Minta maaflah kepada pasangan kita, kepada anak-anak kita, kepada orang tua kita. Jangan menunggu Lebaran untuk meminta maaf. Lebaran memang menjadi momen bermaaf-maafan, tetapi mengapa harus menunggu sebulan lagi jika kita bisa melakukannya sekarang? Ramadhan adalah bulan ampunan, maka jadikan bulan ini sebagai bulan untuk saling memaafkan. Kirimkan pesan kepada saudara yang sudah lama tidak kita hubungi. Kunjungilah tetangga yang mungkin tersinggung oleh kita. Ucapkan maaf dengan tulus, tanpa alasan, tanpa menyalahkan orang lain.

Selain meminta maaf, kita juga perlu belajar memaafkan. Mungkin ada orang yang menyakiti kita, yang berutang kepada kita, yang mengecewakan kita. Menyimpan dendam hanya akan membuat hati kita berat dan ibadah kita tidak tenang. Memaafkan bukan berarti melupakan, tetapi berarti membebaskan diri kita dari beban kebencian. Ketika kita memaafkan, kita sedang memberi hadiah kepada diri sendiri: hati yang tenang dan lapang.

Meminta maaf tidak harus selalu dilakukan dengan kata-kata yang panjang. Kadang, sebuah pesan singkat yang tulus sudah cukup untuk membuka kembali pintu yang tertutup. Kadang, sebuah kunjungan singkat dengan membawa makanan sudah cukup untuk mencairkan suasana yang beku. Kadang, sebuah pelukan sudah cukup untuk mengatakan apa yang sulit diucapkan. Yang penting adalah ketulusan dan keberanian untuk memulai. Jangan menunggu orang lain yang meminta maaf terlebih dahulu, karena kita tidak tahu apakah kesempatan itu akan datang lagi. Mulailah dari diri kita, walau kita merasa bukan kita yang bersalah. Orang yang memulai perdamaian adalah orang yang paling mulia di sisi Allah, karena ia mengutamakan persaudaraan di atas ego dan gengsinya.

Semoga Allah melembutkan hati kita untuk meminta maaf dan memberi maaf. Semoga Ramadhan ini membersihkan hubungan kita dengan sesama, sebagaimana ia membersihkan hubungan kita dengan Allah. Dan semoga kita semua sampai di Hari Raya dengan hati yang bersih, tanpa dendam, tanpa permusuhan, dan tanpa beban. Aamiin.""",
    ),
    Kultum(
        night = 14,
        title = """Berbakti kepada Orang Tua""",
        theme = """Memuliakan ayah dan ibu, terutama di Ramadhan""",
        quote = """Dan Tuhanmu telah memerintahkan supaya kamu jangan menyembah selain Dia dan hendaklah kamu berbuat baik pada ibu bapakmu dengan sebaik-baiknya.""",
        quoteSource = """QS Al-Isra: 23""",
        content = """Di antara amalan yang paling besar pahalanya adalah berbakti kepada orang tua. Allah menyebutkannya langsung setelah perintah untuk menyembah-Nya, sebagaimana dalam ayat yang kita dengar tadi. Ini menunjukkan betapa tinggi kedudukan orang tua di sisi Allah. Mereka adalah orang yang paling berhak mendapatkan kebaikan kita, dan Ramadhan adalah waktu yang tepat untuk meningkatkan bakti kita kepada mereka.

Bagi yang orang tuanya masih hidup, Ramadhan adalah kesempatan untuk lebih memperhatikan mereka. Mungkin selama ini kita sibuk dengan pekerjaan, dengan urusan sendiri, sampai lupa menanyakan kabar mereka. Di bulan Ramadhan ini, luangkan waktu untuk berbuka bersama mereka, untuk sahur bersama mereka, untuk salat tarawih bersama mereka. Tanyakan apa yang mereka butuhkan. Bantu mereka menyiapkan makanan. Duduklah bersama mereka walau sebentar, dengarkan cerita mereka, dan doakan mereka. Kebahagiaan orang tua sering kali sederhana: mereka hanya ingin anak-anaknya hadir dan peduli.

Bagi yang orang tuanya sudah tiada, Ramadhan tetap menjadi waktu untuk berbakti. Berbakti tidak berhenti ketika orang tua meninggal. Kita masih bisa mendoakan mereka, bersedekah atas nama mereka, menjaga silaturahmi dengan keluarga dan sahabat mereka, dan melanjutkan kebaikan-kebaikan yang mereka ajarkan. Doa anak yang saleh untuk orang tuanya adalah salah satu amalan yang pahalanya terus mengalir, bahkan setelah orang tua tiada. Maka jangan lewatkan setiap selesai salat untuk mendoakan mereka, dan jangan lupa untuk berbuat baik atas nama mereka.

Berbakti kepada orang tua bukan hanya tentang memberikan uang atau membelikan barang. Yang lebih penting adalah sikap kita: berkata lembut, tidak membentak, tidak menyakiti hati mereka, dan mendengarkan nasihat mereka dengan sabar. Ada anak yang memberi banyak uang kepada orang tuanya, tetapi kata-katanya kasar dan menyakitkan. Ada anak yang memberi sedikit, tetapi selalu lembut dan penuh perhatian. Yang kedua lebih berharga di sisi Allah. Karena berbakti adalah tentang hati, bukan sekadar tentang materi.

Ramadhan juga mengajarkan kita untuk merenungkan pengorbanan orang tua. Ibu yang mengandung dan menyusui kita, ayah yang bekerja keras untuk menafkahi keluarga. Mereka berkorban tanpa meminta balasan, mereka mendoakan kita tanpa henti, mereka bahagia ketika kita bahagia. Maka sudah selayaknya kita membalas kebaikan mereka dengan kebaikan, walau kita tidak akan pernah bisa membalasnya sepenuhnya. Yang bisa kita lakukan adalah berusaha sebaik mungkin, dan berdoa agar Allah membalas kebaikan mereka dengan surga.

Bagi yang tinggal jauh dari orang tua, Ramadhan adalah waktu yang tepat untuk lebih sering menghubungi mereka. Teleponlah mereka sebelum berbuka, tanyakan kabar mereka, doakan mereka, dan dengarkan suara mereka. Bagi orang tua yang sudah sepuh, panggilan telepon dari anaknya adalah kebahagiaan yang tidak bisa digantikan oleh uang atau hadiah. Jika memungkinkan, kirimkan makanan untuk berbuka atau sahur mereka, walau hanya makanan sederhana. Jika ada kesempatan untuk pulang dan berbuka bersama mereka, jangan sia-siakan. Waktu bersama orang tua adalah waktu yang tidak bisa dibeli kembali. Gunakanlah Ramadhan ini untuk mendekat kepada mereka, sebelum jarak dan waktu membuat kita menyesal karena terlambat menyadari betapa berharganya kehadiran mereka.

Semoga Allah memberkahi orang tua kita yang masih hidup, memberi mereka kesehatan dan umur yang panjang dalam ketaatan. Dan semoga Allah mengampuni orang tua kita yang sudah tiada, melapangkan kubur mereka, dan mengumpulkan kita bersama mereka di surga kelak. Aamiin.""",
    ),
    Kultum(
        night = 15,
        title = """Pertengahan Ramadhan, Jangan Kendor""",
        theme = """Menjaga semangat ibadah di tengah bulan""",
        quote = """Karena itu, ingatlah kamu kepada-Ku, niscaya Aku ingat (pula) kepadamu.""",
        quoteSource = """QS Al-Baqarah: 152""",
        content = """Kita sudah sampai di pertengahan Ramadhan. Malam kelima belas. Kalau kita jujur, mungkin semangat kita sudah tidak sama seperti di awal. Di awal Ramadhan, masjid penuh, tadarus semangat, sahur bangun tepat waktu. Sekarang, mulai ada yang telat bangun sahur, mulai ada yang bolong tarawihnya, mulai ada yang tadarusnya tertinggal. Ini adalah hal yang wajar, tetapi jangan dibiarkan. Pertengahan Ramadhan adalah ujian konsistensi, dan ujian inilah yang menentukan apakah Ramadhan kita akan berakhir dengan baik atau tidak.

Banyak orang yang memulai dengan semangat besar, tetapi berhenti di tengah jalan. Ada yang berjanji akan khatam Al-Qur'an, tetapi di hari kesepuluh sudah menyerah. Ada yang berjanji akan tarawih setiap malam, tetapi di minggu kedua sudah jarang ke masjid. Ada yang berjanji akan bersedekah setiap hari, tetapi setelah beberapa hari lupa. Ini bukan karena mereka tidak baik, tetapi karena mereka terlalu mengandalkan semangat awal, bukan kebiasaan yang terjaga. Semangat itu seperti api: kalau tidak dijaga, ia akan padam. Kebiasaan adalah kayu bakar yang menjaga api tetap menyala.

Maka di pertengahan ini, mari kita evaluasi diri kita. Bukan untuk menyalahkan diri sendiri, tetapi untuk memperbaiki. Tanyakan pada diri kita: amalan apa yang sudah saya jaga dengan baik? Amalan apa yang mulai kendor? Apa penyebabnya? Mungkin kita terlalu lelah, mungkin kita terlalu banyak target, mungkin kita kurang tidur, mungkin kita kurang menjaga niat. Setelah tahu penyebabnya, perbaikilah dengan langkah kecil. Kalau tadarus tertinggal, kejarlah sedikit demi sedikit, jangan menunggu sampai bisa membaca banyak sekaligus. Kalau tarawih bolong, mulailah lagi malam ini, jangan menunggu besok. Kalau sedekah terlupa, bersedekahlah hari ini, walau sedikit.

Ingatlah, Allah tidak meminta kita untuk sempurna, Allah meminta kita untuk terus berusaha. Ayat yang kita dengar tadi mengingatkan bahwa ketika kita mengingat Allah, Allah akan mengingat kita. Artinya, setiap kali kita kembali kepada Allah, Allah menyambut kita. Tidak ada kata terlambat untuk kembali. Kalau kita sudah tertinggal, kembalilah. Kalau kita sudah kendor, bangkitlah lagi. Ramadhan masih tersisa setengah bulan, dan setengah bulan itu masih sangat panjang untuk memperbaiki diri.

Sepuluh malam terakhir sudah di depan mata. Malam-malam yang paling istimewa di bulan Ramadhan akan segera datang. Maka jangan habiskan energi kita untuk menyesali yang sudah lewat. Gunakan sisa Ramadhan ini dengan sebaik-baiknya. Perbaiki salat kita, perbanyak doa kita, jaga puasa kita, dan bersiaplah menyambut malam-malam terbaik. Semoga Allah memberi kita kekuatan untuk menyelesaikan Ramadhan ini dengan baik, dan semoga kita termasuk orang-orang yang diampuni di bulan ini. Aamiin.

Untuk menjaga semangat di sisa Ramadhan, carilah teman yang bisa saling mengingatkan. Ajaklah satu atau dua orang sahabat untuk membuat kesepakatan sederhana: saling mengingatkan untuk tarawih, saling berbagi bacaan Al-Qur'an hari ini, saling mendoakan agar tetap istiqamah. Teman yang baik adalah teman yang mengingatkan kita ketika kita mulai kendor, bukan teman yang mengajak kita untuk bermalas-malasan. Jika kita merasa sulit menjaga semangat sendirian, jangan malu untuk meminta dukungan. Ibadah yang dilakukan bersama-sama terasa lebih ringan dan lebih menyenangkan. Dan ketika Ramadhan berakhir, persahabatan yang dibangun di atas kebaikan ini akan tetap berlanjut, menjadi pengingat yang baik untuk kita di bulan-bulan berikutnya.

Dan ingatlah, tidak ada kata terlambat untuk kembali. Jika hari ini kita tertinggal, besok kita bisa mengejarnya. Yang penting kita tidak berhenti berusaha dan tidak menyerah pada rasa malas.""",
    ),
    Kultum(
        night = 16,
        title = """Doa, Senjata Orang Beriman""",
        theme = """Memperbanyak doa di bulan Ramadhan""",
        quote = """Dan apabila hamba-hamba-Ku bertanya kepadamu tentang Aku, maka (jawablah), bahwasanya Aku adalah dekat. Aku mengabulkan permohonan orang yang berdoa apabila ia memohon kepada-Ku.""",
        quoteSource = """QS Al-Baqarah: 186""",
        content = """Ada satu amalan yang sering kita anggap sepele, padahal nilainya sangat besar: doa. Doa adalah cara kita berbicara kepada Allah, cara kita menyampaikan harapan, keluh kesah, dan permohonan kita. Di bulan Ramadhan, doa memiliki kedudukan yang istimewa. Allah sendiri berfirman bahwa Dia dekat, dan Dia mengabulkan doa orang yang berdoa. Ayat ini terletak di antara ayat-ayat tentang puasa, seolah Allah ingin mengingatkan bahwa puasa dan doa adalah dua hal yang tidak terpisahkan.

Kapan waktu terbaik untuk berdoa di bulan Ramadhan? Ada banyak waktu yang mustajab. Saat berbuka, doa orang yang berpuasa tidak ditolak. Di ujung malam, saat sahur, Allah dekat dengan hamba-Nya yang berdoa. Di dalam salat, terutama saat sujud, kita berada dalam keadaan paling dekat dengan Allah. Di malam-malam terakhir Ramadhan, terutama di malam Lailatul Qadar, doa memiliki nilai yang luar biasa. Maka jangan lewatkan waktu-waktu ini dengan diam. Gunakanlah untuk berdoa, walau hanya beberapa menit.

Tetapi, berdoa bukan sekadar meminta. Doa juga adalah bentuk pengakuan bahwa kita lemah dan membutuhkan Allah. Ketika kita berdoa, kita mengakui bahwa kita tidak bisa menyelesaikan masalah kita sendiri, bahwa rezeki kita ada di tangan Allah, bahwa kesehatan kita adalah pemberian Allah, bahwa masa depan kita ditentukan oleh Allah. Pengakuan seperti ini membuat hati kita lebih tenang, karena kita menyerahkan beban kita kepada Yang Maha Kuasa. Orang yang rajin berdoa adalah orang yang hatinya tenang, karena ia tahu ada tempat untuk mengadu.

Apa yang sebaiknya kita doakan di bulan Ramadhan? Doakanlah diri kita sendiri: agar Allah mengampuni dosa-dosa kita, menerima puasa kita, dan memberi kita kekuatan untuk istiqamah. Doakanlah keluarga kita: agar mereka sehat, bahagia, dan dekat dengan Allah. Doakanlah orang tua kita, pasangan kita, anak-anak kita. Doakanlah saudara-saudara kita yang sedang kesulitan, yang sedang sakit, yang sedang mencari pekerjaan, yang sedang punya masalah. Dan jangan lupa mendoakan umat Islam di mana pun mereka berada, agar Allah memberi mereka kemudahan dan keselamatan.

Jangan pula berdoa dengan tergesa-gesa atau asal-asalan. Berdoalah dengan sungguh-sungguh, dengan hati yang hadir, dengan keyakinan bahwa Allah mendengar. Mulailah doa dengan memuji Allah, lalu bersalawat kepada Rasulullah, lalu sampaikan permohonan kita. Dan setelah berdoa, yakinlah bahwa Allah akan mengabulkannya dengan cara yang terbaik, walau mungkin tidak sesuai dengan yang kita bayangkan. Kadang Allah mengabulkan doa kita dengan memberi apa yang kita minta. Kadang Allah menggantinya dengan yang lebih baik. Kadang Allah menundanya sampai waktu yang tepat. Semua itu adalah bentuk kasih sayang Allah.

Agar doa kita lebih khusyuk, biasakanlah berdoa dengan bahasa yang kita pahami dan dengan hati yang hadir. Tidak harus menggunakan kalimat yang indah dan panjang, cukup sampaikan apa yang ada di dalam hati dengan jujur. Ceritakan kepada Allah apa yang kita rasakan, apa yang kita takutkan, apa yang kita harapkan. Allah Maha Mendengar, bahkan sebelum kita mengucapkannya, Allah sudah mengetahui isi hati kita. Tetapi ketika kita mengucapkannya, hati kita menjadi lebih tenang, karena kita merasa didengar. Luangkan waktu khusus untuk berdoa setiap hari, misalnya setelah salat, sebelum berbuka, atau di ujung malam. Jadikan doa sebagai kebiasaan, bukan sekadar pelengkap ibadah, karena doa adalah ibadah itu sendiri dan cara terdekat seorang hamba untuk berbicara dengan Tuhannya.

Semoga Allah mengabulkan doa-doa kita di bulan Ramadhan ini, mengampuni dosa-dosa kita, dan memberi kita apa yang terbaik untuk dunia dan akhirat kita. Semoga kita menjadi hamba yang rajin berdoa, bukan hanya di bulan Ramadhan, tetapi juga di bulan-bulan lainnya. Aamiin.""",
    ),
    Kultum(
        night = 17,
        title = """Menjaga Hati dari Iri dan Dengki""",
        theme = """Membersihkan hati dari penyakit hati""",
        quote = """Ya Tuhan kami, ampunilah kami dan saudara-saudara kami yang telah beriman lebih dahulu dari kami, dan janganlah Engkau membiarkan kedengkian dalam hati kami terhadap orang-orang yang beriman.""",
        quoteSource = """QS Al-Hasyr: 10""",
        content = """Puasa tidak hanya menahan lapar dan haus, tetapi juga menahan hati dari penyakit-penyakit yang merusaknya. Salah satu penyakit hati yang paling berbahaya adalah iri dan dengki. Iri adalah perasaan tidak senang ketika melihat orang lain mendapatkan nikmat. Dengki adalah keinginan agar nikmat itu hilang dari orang tersebut. Dua perasaan ini mungkin tersembunyi di dalam hati, tidak terlihat oleh orang lain, tetapi dampaknya sangat besar: ia merusak ketenangan hati, merusak hubungan dengan orang lain, dan menghanguskan pahala kebaikan.

Mengapa iri dan dengki begitu berbahaya? Karena ia membuat kita tidak bisa bersyukur. Orang yang iri selalu merasa kurang, walau sebenarnya ia sudah diberi banyak. Ia melihat tetangganya punya mobil baru, lalu ia merasa mobilnya sendiri tidak cukup baik. Ia melihat temannya naik jabatan, lalu ia merasa pekerjaannya sendiri tidak berharga. Ia melihat saudaranya bahagia, lalu ia merasa hidupnya sendiri penuh masalah. Padahal, setiap orang memiliki rezeki dan ujiannya masing-masing. Apa yang terlihat baik dari luar belum tentu baik di dalamnya, dan apa yang kita anggap kurang pada diri kita mungkin justru adalah nikmat yang tidak kita sadari.

Ramadhan adalah waktu yang tepat untuk membersihkan hati dari iri dan dengki. Ketika kita berpuasa, kita belajar bahwa rezeki itu sudah diatur oleh Allah. Allah memberi kepada siapa yang Dia kehendaki, dan Allah menahan dari siapa yang Dia kehendaki, dengan hikmah yang mungkin tidak kita pahami. Tugas kita bukanlah mempertanyakan pembagian Allah, melainkan bersyukur atas apa yang kita terima dan berusaha dengan cara yang baik. Jika kita melihat orang lain sukses, doakanlah kebaikan untuknya, bukan mengharapkan kegagalannya. Jika kita melihat orang lain bahagia, ikutlah bahagia, bukan merasa tersaingi.

Bagaimana cara membersihkan hati dari iri? Pertama, sadari bahwa perasaan itu ada, dan jangan membiarkannya tumbuh. Ketika perasaan iri muncul, segera beristigfar dan berdoa agar Allah membersihkan hati kita. Kedua, biasakan mendoakan kebaikan untuk orang lain. Doa yang kita panjatkan untuk orang lain akan kembali kepada kita. Ketiga, fokuslah pada nikmat yang kita miliki, bukan pada nikmat orang lain. Buatlah daftar nikmat kita setiap hari, dan syukurilah. Keempat, jauhi perbandingan yang tidak sehat, terutama di media sosial, yang sering menampilkan sisi terbaik orang lain dan membuat kita merasa tertinggal.

Ayat yang kita dengar tadi mengajarkan doa yang indah: jangan biarkan ada kedengkian dalam hati kami terhadap orang-orang yang beriman. Doa ini menunjukkan bahwa membersihkan hati adalah sesuatu yang perlu dimintakan kepada Allah, karena hati itu mudah berubah dan mudah ternoda. Maka perbanyaklah doa ini, terutama di bulan Ramadhan, agar Allah membersihkan hati kita dari segala penyakit.

Ada satu obat yang ampuh untuk iri dan dengki: mendoakan kebaikan untuk orang yang kita irikan. Ketika kita melihat tetangga membeli mobil baru, doakanlah agar mobil itu membawa berkah baginya. Ketika kita melihat teman naik jabatan, doakanlah agar ia amanah dalam jabatannya. Ketika kita melihat saudara bahagia, doakanlah agar kebahagiaannya bertahan lama. Doa seperti ini memang terasa berat pada awalnya, karena hati kita masih dipenuhi iri. Tetapi lama-lama, doa itu akan membersihkan hati kita, dan iri itu akan berubah menjadi rasa syukur atas nikmat orang lain. Orang yang terbiasa mendoakan kebaikan untuk orang lain akan merasakan hatinya lebih lapang, lebih tenang, dan lebih mudah bahagia, karena ia tidak lagi membandingkan hidupnya dengan hidup orang lain.

Semoga Allah membersihkan hati kita dari iri, dengki, dan segala penyakit hati lainnya. Semoga Ramadhan ini menjadikan hati kita lebih bersih, lebih tenang, dan lebih mudah bahagia melihat kebahagiaan orang lain. Aamiin.""",
    ),
    Kultum(
        night = 18,
        title = """Waktu, Modal yang Tak Kembali""",
        theme = """Memanfaatkan waktu Ramadhan dengan sebaik-baiknya""",
        quote = """Demi masa. Sesungguhnya manusia itu benar-benar dalam kerugian, kecuali orang-orang yang beriman dan mengerjakan amal saleh dan nasihat-menasihati supaya menaati kebenaran dan nasihat-menasihati supaya menetapi kesabaran.""",
        quoteSource = """QS Al-'Ashr: 1–3""",
        content = """Ada satu modal yang diberikan Allah kepada semua manusia dalam jumlah yang sama setiap harinya: waktu. Setiap orang mendapatkan dua puluh empat jam sehari, tidak lebih, tidak kurang. Orang kaya dan orang miskin sama-sama mendapatkan dua puluh empat jam. Orang yang sibuk dan orang yang luang sama-sama mendapatkan dua puluh empat jam. Yang membedakan adalah bagaimana mereka menggunakannya. Dan di bulan Ramadhan, waktu menjadi semakin berharga, karena setiap detiknya dilipatgandakan pahalanya.

Allah bersumpah demi masa dalam surah Al-'Ashr, dan bersumpah bahwa manusia berada dalam kerugian, kecuali mereka yang beriman, beramal saleh, saling menasihati dalam kebenaran, dan saling menasihati dalam kesabaran. Ayat ini mengingatkan bahwa waktu adalah sesuatu yang terus berjalan dan tidak akan kembali. Waktu yang sudah lewat tidak bisa diulang. Ramadhan yang sudah lewat tidak bisa diulang. Maka orang yang merugi adalah orang yang menyia-nyiakan waktunya, sedangkan orang yang beruntung adalah orang yang menggunakan waktunya untuk kebaikan.

Di bulan Ramadhan, kita sering merasa waktu berjalan sangat cepat. Tiba-tiba sudah seminggu, tiba-tiba sudah setengah bulan, tiba-tiba sudah sepuluh malam terakhir. Perasaan ini seharusnya membuat kita lebih waspada. Jangan sampai kita baru menyadari bahwa Ramadhan sudah berakhir, padahal kita belum melakukan apa-apa yang berarti. Jangan sampai kita menghabiskan Ramadhan dengan hal-hal yang tidak bermanfaat: terlalu lama menonton, terlalu lama bermain, terlalu lama tidur, terlalu lama mengobrol tanpa tujuan. Semua itu boleh dilakukan secukupnya, tetapi jangan sampai mengambil waktu ibadah kita.

Bagaimana cara memanfaatkan waktu Ramadhan dengan baik? Pertama, buatlah jadwal sederhana. Tentukan waktu untuk salat, untuk membaca Al-Qur'an, untuk beristirahat, untuk bekerja, dan untuk keluarga. Jadwal tidak harus kaku, tetapi ia membantu kita untuk tidak kehilangan arah. Kedua, manfaatkan waktu-waktu luang yang kecil. Waktu menunggu berbuka, waktu di perjalanan, waktu sebelum tidur, semuanya bisa digunakan untuk berzikir, membaca Al-Qur'an, atau mendengarkan kajian. Ketiga, kurangi hal-hal yang membuang waktu. Tanyakan pada diri kita, apakah kegiatan ini bermanfaat? Apakah ini mendekatkan saya kepada Allah? Jika tidak, kurangi porsinya.

Mari kita hitung waktu kita dengan jujur. Dalam sehari, berapa jam kita habiskan untuk hal yang bermanfaat, dan berapa jam kita habiskan untuk hal yang sia-sia? Berapa jam untuk salat dan membaca Al-Qur'an, dan berapa jam untuk menonton dan bermain gawai tanpa tujuan? Pertanyaan ini mungkin terasa tidak nyaman, tetapi ia perlu ditanyakan agar kita sadar ke mana waktu kita pergi. Waktu Ramadhan adalah waktu yang istimewa, tetapi ia juga cepat berlalu. Jika kita tidak mengaturnya dengan baik, ia akan habis tanpa kita sadari. Mulailah dengan mengurangi satu jam dari kegiatan yang kurang bermanfaat, dan gantilah dengan satu jam untuk ibadah atau keluarga. Perubahan kecil ini, jika dilakukan setiap hari, akan membuat sisa Ramadhan kita jauh lebih bermakna dan lebih berkah.

Waktu yang kita miliki hari ini tidak akan pernah kembali. Gunakanlah ia untuk hal-hal yang mendekatkan kita kepada Allah, karena itulah investasi yang tidak akan pernah merugi.

Waktu Ramadhan adalah waktu yang istimewa, tetapi ia juga cepat berlalu. Semoga kita tidak termasuk orang-orang yang menyesal setelah Ramadhan berakhir. Semoga setiap hari yang tersisa kita isi dengan kebaikan, dan semoga Allah memberkahi waktu kita, memberi kita keberkahan dalam setiap jam, setiap menit, dan setiap detik di bulan ini. Aamiin.""",
    ),
    Kultum(
        night = 19,
        title = """Ukhuwah, Indahnya Persaudaraan""",
        theme = """Menjaga silaturahmi dan persaudaraan sesama muslim""",
        quote = """Tidaklah beriman salah seorang di antara kalian hingga ia mencintai saudaranya sebagaimana ia mencintai dirinya sendiri.""",
        quoteSource = """HR Bukhari dan Muslim""",
        content = """Salah satu keindahan Ramadhan adalah suasana kebersamaannya. Masjid yang ramai, buka puasa bersama, tadarus bersama, salat tarawih bersama, semuanya menciptakan rasa persaudaraan yang kuat. Di bulan ini, kita merasakan bahwa kita adalah satu keluarga besar, satu umat yang saling peduli dan saling menyayangi. Itulah yang disebut ukhuwah, persaudaraan karena Allah, yang tidak didasarkan pada darah, suku, atau kepentingan, melainkan pada keimanan.

Rasulullah mengajarkan bahwa keimanan seseorang belum sempurna sampai ia mencintai saudaranya sebagaimana ia mencintai dirinya sendiri. Artinya, kita tidak boleh egois. Kita tidak boleh hanya memikirkan diri sendiri. Jika kita ingin bahagia, kita harus menginginkan kebahagiaan untuk saudara kita juga. Jika kita tidak ingin disakiti, kita tidak boleh menyakiti saudara kita. Jika kita ingin dimaafkan, kita harus mau memaafkan saudara kita. Persaudaraan seperti ini adalah persaudaraan yang tulus, yang tidak mengharapkan balasan, yang hanya mengharap rida Allah.

Tetapi persaudaraan tidak tumbuh dengan sendirinya. Ia perlu dirawat. Ia dirawat dengan silaturahmi, dengan saling mengunjungi, dengan saling menanyakan kabar, dengan saling membantu ketika ada yang kesulitan. Di bulan Ramadhan, ada banyak cara untuk merawat persaudaraan. Berbuka bersama tetangga, mengirim makanan ke masjid, mengajak teman untuk tarawih bersama, menanyakan kabar saudara yang sudah lama tidak dihubungi, semua itu adalah bentuk silaturahmi yang bernilai ibadah.

Sayangnya, di zaman sekarang, persaudaraan sering kali renggang karena kesibukan dan karena media sosial. Kita punya banyak teman di media sosial, tetapi sedikit teman yang benar-benar kita kenal dan kita pedulikan. Kita tahu kabar banyak orang dari status mereka, tetapi kita tidak pernah menanyakan kabar mereka secara langsung. Ramadhan mengajak kita untuk kembali ke persaudaraan yang nyata: bertemu, berbicara, makan bersama, salat bersama. Persaudaraan yang nyata jauh lebih hangat daripada persaudaraan di layar.

Jangan lupa juga untuk menjaga persaudaraan dengan cara menjaga lisan dan sikap kita. Jangan menyakiti saudara kita dengan gosip, dengan ejekan, dengan prasangka buruk. Jangan memutus silaturahmi karena perselisihan kecil. Perselisihan itu wajar, tetapi jangan biarkan ia merusak persaudaraan. Kalau ada salah paham, selesaikan dengan baik-baik. Kalau ada yang bersalah, maafkanlah. Kalau kita yang bersalah, mintalah maaf. Persaudaraan yang dijaga dengan baik akan menjadi penolong kita di dunia dan di akhirat.

Persaudaraan juga diuji ketika ada perbedaan pendapat. Di dalam keluarga, di dalam masjid, di dalam masyarakat, perbedaan pendapat itu wajar dan tidak bisa dihindari. Ada yang berbeda pilihan dalam hal-hal kecil, ada yang berbeda cara pandang dalam hal-hal tertentu. Tetapi perbedaan itu tidak boleh merusak persaudaraan. Kita bisa berbeda pendapat tanpa saling membenci, kita bisa berdiskusi tanpa saling menyakiti, kita bisa tidak setuju tanpa memutus silaturahmi. Ramadhan mengajarkan kita untuk mengutamakan persatuan di atas perbedaan, untuk mencari persamaan daripada memperbesar perbedaan. Jika kita bisa menjaga persaudaraan di tengah perbedaan, maka persaudaraan kita akan semakin kuat, dan umat ini akan semakin bersatu dalam kebaikan.

Jaga persaudaraan kita dengan saling mendoakan. Doa yang kita panjatkan untuk saudara kita adalah bukti cinta yang paling tulus, karena ia diucapkan tanpa diketahui oleh orang yang didoakan.

Semoga Allah mempererat persaudaraan di antara kita, menghilangkan permusuhan dan kebencian, dan menjadikan Ramadhan ini sebagai bulan yang memperkuat ukhuwah kita. Semoga kita semua menjadi saudara yang saling mencintai karena Allah, saling membantu, dan saling mendoakan. Aamiin.""",
    ),
    Kultum(
        night = 20,
        title = """Bersiap Menyambut Sepuluh Malam Terakhir""",
        theme = """Persiapan memasuki fase terbaik Ramadhan""",
        quote = """Sesungguhnya Kami telah menurunkannya (Al-Qur'an) pada malam kemuliaan. Dan tahukah kamu apakah malam kemuliaan itu? Malam kemuliaan itu lebih baik dari seribu bulan.""",
        quoteSource = """QS Al-Qadr: 1–3""",
        content = """Kita sudah berada di penghujung dua pertiga Ramadhan. Sepuluh malam terakhir sudah di depan mata. Inilah fase yang paling istimewa dari bulan Ramadhan, fase yang ditunggu-tunggu oleh orang-orang yang bersungguh-sungguh. Di sepuluh malam terakhir inilah terdapat satu malam yang lebih baik dari seribu bulan, malam Lailatul Qadar, malam ketika Al-Qur'an diturunkan, malam ketika para malaikat turun ke bumi, malam yang penuh dengan keberkahan dan ampunan.

Mengapa sepuluh malam terakhir begitu istimewa? Karena Rasulullah sendiri memberikan contoh yang luar biasa di sepuluh malam terakhir. Beliau mengencangkan ibadahnya, membangunkan keluarganya, dan bersungguh-sungguh dalam beribadah melebihi hari-hari sebelumnya. Beliau tidak bersantai di akhir Ramadhan, justru beliau semakin giat. Ini adalah pelajaran bagi kita: semakin dekat dengan garis akhir, semakin kita harus bersungguh-sungguh, bukan semakin santai.

Tetapi, bersiap menyambut sepuluh malam terakhir bukan hanya tentang begadang dan salat malam. Persiapan itu dimulai dari sekarang, dari malam ini. Persiapan yang pertama adalah persiapan fisik: jagalah kesehatan kita, tidurlah yang cukup di siang hari agar malamnya kita bisa beribadah dengan baik, makanlah dengan secukupnya agar tubuh tidak lemas. Persiapan yang kedua adalah persiapan hati: bersihkan hati dari dendam, dari iri, dari prasangka buruk, agar ibadah kita di sepuluh malam terakhir diterima dengan hati yang bersih. Persiapan yang ketiga adalah persiapan rencana: tentukan apa yang akan kita lakukan di sepuluh malam terakhir, berapa banyak Al-Qur'an yang akan kita baca, berapa rakaat salat malam yang akan kita dirikan, doa apa yang akan kita panjatkan.

Jangan sampai kita memasuki sepuluh malam terakhir tanpa rencana, lalu menghabiskannya dengan kebingungan. Buatlah rencana yang sederhana tetapi nyata. Misalnya, setiap malam membaca beberapa halaman Al-Qur'an, mendirikan salat malam walau hanya beberapa rakaat, berdoa dengan sungguh-sungguh, dan bersedekah setiap hari. Rencana yang sederhana tetapi dilakukan dengan konsisten jauh lebih baik daripada rencana yang besar tetapi tidak pernah dilakukan.

Dan yang paling penting, jangan hanya fokus mencari Lailatul Qadar di malam-malam ganjil saja. Kita tidak tahu pasti malam yang mana. Maka bersungguh-sungguhlah di semua sepuluh malam terakhir, agar kita tidak melewatkan malam yang mulia itu. Orang yang bersungguh-sungguh di semua malam tidak akan kecewa, karena ia pasti mendapatkan malam itu, walau ia tidak tahu malam yang mana.

Semoga Allah menyampaikan kita ke sepuluh malam terakhir dalam keadaan sehat dan penuh semangat. Semoga Allah memberi kita kekuatan untuk beribadah dengan sungguh-sungguh, dan semoga Allah mempertemukan kita dengan Lailatul Qadar, malam yang lebih baik dari seribu bulan. Aamiin.

Agar persiapan kita lebih nyata, buatlah daftar sederhana untuk sepuluh malam terakhir. Tuliskan tiga hal: ibadah apa yang akan saya perbanyak, doa apa yang paling ingin saya panjatkan, dan kepada siapa saya ingin bersedekah. Tempelkan daftar itu di tempat yang mudah terlihat, dan periksalah setiap malam sebelum tidur. Daftar ini akan membantu kita untuk tidak kehilangan arah di tengah kesibukan, dan akan mengingatkan kita bahwa sepuluh malam terakhir adalah kesempatan yang tidak boleh disia-siakan. Ajak pula keluarga untuk membuat daftar yang sama, lalu saling mengingatkan dan saling mendoakan. Sepuluh malam terakhir yang direncanakan dengan baik akan terasa lebih khusyuk, dan kita akan menyambutnya dengan hati yang siap, bukan dengan hati yang bingung dan terburu-buru.""",
    ),
    Kultum(
        night = 21,
        title = """Lailatul Qadar, Malam yang Lebih Baik dari Seribu Bulan""",
        theme = """Keutamaan dan cara menghidupkan Lailatul Qadar""",
        quote = """Sesungguhnya Kami telah menurunkannya (Al-Qur'an) pada malam kemuliaan. Dan tahukah kamu apakah malam kemuliaan itu? Malam kemuliaan itu lebih baik dari seribu bulan.""",
        quoteSource = """QS Al-Qadr: 1–3""",
        content = """Ada satu malam di bulan Ramadhan yang nilainya melebihi seribu bulan. Seribu bulan itu kurang lebih delapan puluh tiga tahun, lebih panjang dari umur kebanyakan manusia. Artinya, satu malam ibadah yang dilakukan dengan ikhlas di malam itu bisa bernilai lebih dari seumur hidup beribadah. Malam itu adalah Lailatul Qadar, malam kemuliaan, malam ketika Al-Qur'an diturunkan, malam ketika para malaikat turun membawa keberkahan dan keselamatan sampai terbit fajar.

Allah merahasiakan kapan tepatnya Lailatul Qadar itu. Kita hanya tahu bahwa ia ada di sepuluh malam terakhir Ramadhan, dan lebih mungkin ada di malam-malam ganjil. Mengapa Allah merahasiakannya? Agar kita bersungguh-sungguh di semua malam, bukan hanya di satu malam. Kalau kita tahu pasti malamnya, mungkin kita hanya beribadah di malam itu saja dan bermalas-malasan di malam-malam lainnya. Dengan dirahasiakan, Allah mengajak kita untuk bersungguh-sungguh di sepuluh malam terakhir secara keseluruhan. Dan orang yang bersungguh-sungguh di semua malam pasti akan mendapatkan malam itu, insya Allah.

Lalu, apa yang sebaiknya kita lakukan untuk menghidupkan Lailatul Qadar? Pertama, dirikanlah salat malam. Salat malam adalah ibadah utama di malam itu. Tidak harus panjang, tidak harus banyak rakaat, yang penting dilakukan dengan khusyuk dan ikhlas. Kedua, perbanyaklah membaca Al-Qur'an. Malam itu adalah malam diturunkannya Al-Qur'an, maka membacanya di malam itu adalah cara yang indah untuk mengenang dan menghormati peristiwa besar itu. Ketiga, perbanyaklah doa. Ada satu doa yang diajarkan Rasulullah untuk malam ini, yang maknanya: Ya Allah, sesungguhnya Engkau Maha Pemaaf dan menyukai pemberian maaf, maka maafkanlah aku. Doa ini singkat, tetapi sangat dalam. Ia mengajarkan kita bahwa yang paling kita butuhkan di malam itu bukanlah harta atau jabatan, melainkan ampunan Allah.

Keempat, perbanyaklah istigfar dan zikir. Ucapkanlah kalimat-kalimat yang mendekatkan kita kepada Allah, dengan hati yang hadir, bukan sekadar di bibir. Kelima, bersedekahlah. Sedekah di malam Lailatul Qadar bernilai seperti sedekah selama seribu bulan. Maka jangan lewatkan kesempatan untuk berbagi, walau sedikit.

Jangan pula kita terlalu sibuk mencari tanda-tanda Lailatul Qadar, sampai lupa beribadah. Ada yang sibuk memperhatikan cuaca, memperhatikan matahari terbit, memperhatikan suasana malam, lalu lupa salat dan berdoa. Tanda-tanda itu bukan yang utama. Yang utama adalah ibadah kita. Fokuslah pada ibadah, dan biarkan Allah yang menentukan apakah kita mendapatkan malam itu atau tidak. Yang penting kita sudah berusaha dengan sungguh-sungguh.

Jangan lupa, Lailatul Qadar bukan hanya tentang ibadah malam itu, tetapi juga tentang perubahan setelahnya. Orang yang mendapatkan Lailatul Qadar seharusnya pulang dengan hati yang lebih bersih, dengan tekad yang lebih kuat untuk menjadi lebih baik, dengan hubungan yang lebih baik kepada Allah dan kepada manusia. Maka setelah malam itu, perhatikanlah diri kita: apakah kita menjadi lebih sabar, lebih dermawan, lebih rajin beribadah? Jika ya, itu adalah tanda bahwa malam itu benar-benar membawa berkah bagi kita. Jika belum, jangan putus asa, karena perubahan itu membutuhkan waktu. Yang penting kita terus berusaha, dan kita jadikan malam itu sebagai titik awal untuk menjadi pribadi yang lebih baik, bukan sekadar malam yang kita lewati lalu kita lupakan.

Semoga Allah mempertemukan kita dengan Lailatul Qadar tahun ini. Semoga Allah mengampuni dosa-dosa kita, menerima ibadah kita, dan menjadikan malam itu sebagai malam yang mengubah hidup kita menjadi lebih baik. Semoga kita termasuk orang-orang yang mendapatkan keberkahan seribu bulan dalam satu malam. Aamiin.""",
    ),
    Kultum(
        night = 22,
        title = """I'tikaf, Menyendiri Bersama Allah""",
        theme = """Keutamaan dan makna i'tikaf di sepuluh malam terakhir""",
        quote = """Carilah Lailatul Qadar pada sepuluh malam terakhir Ramadhan.""",
        quoteSource = """HR Bukhari dan Muslim, makna""",
        content = """Di sepuluh malam terakhir Ramadhan, ada satu ibadah yang istimewa, yang dilakukan oleh Rasulullah setiap tahun dan tidak pernah beliau tinggalkan: i'tikaf. I'tikaf adalah berdiam diri di masjid dengan niat beribadah, memutus diri sejenak dari kesibukan dunia, dan mengkhususkan waktu untuk Allah. Rasulullah beri'tikaf di sepuluh malam terakhir Ramadhan, dan beliau melakukannya dengan sungguh-sungguh, sebagai cara untuk mencari Lailatul Qadar dan mendekatkan diri kepada Allah.

Mengapa i'tikaf begitu istimewa? Karena ia adalah bentuk pengorbanan waktu dan kenyamanan demi Allah. Orang yang beri'tikaf meninggalkan rumahnya yang nyaman, meninggalkan keluarganya untuk sementara, meninggalkan pekerjaannya, dan memilih untuk tinggal di masjid, tidur di masjid, makan di masjid, beribadah di masjid. Semua itu dilakukan bukan karena terpaksa, melainkan karena cinta kepada Allah. Dan Allah tidak akan menyia-nyiakan pengorbanan hamba-Nya.

Tetapi, tidak semua orang bisa beri'tikaf penuh sepuluh malam. Ada yang bekerja, ada yang menjaga keluarga, ada yang punya tanggung jawab yang tidak bisa ditinggalkan. Semua itu dimaklumi. I'tikaf tidak harus sepuluh malam penuh. Ada yang beri'tikaf satu malam, ada yang beri'tikaf beberapa jam, ada yang beri'tikaf di antara dua salat. Yang penting adalah niatnya: kita berdiam di masjid untuk beribadah, bukan sekadar duduk-duduk. Bahkan berdiam sebentar di masjid dengan niat i'tikaf sudah bernilai ibadah.

Bagi yang tidak bisa beri'tikaf di masjid, jangan berkecil hati. Kita masih bisa mengambil ruh i'tikaf di rumah: menyendiri sejenak untuk beribadah, mematikan gawai untuk beberapa jam, mengkhususkan waktu untuk salat malam dan membaca Al-Qur'an tanpa gangguan. Ruh i'tikaf adalah memutus diri dari kesibukan dunia dan fokus kepada Allah. Itu bisa dilakukan di mana saja, walau bentuknya tidak sama dengan i'tikaf di masjid.

Yang terpenting dalam i'tikaf bukanlah lamanya, melainkan kualitasnya. Jangan beri'tikaf hanya untuk tidur di masjid, atau hanya untuk berkumpul dengan teman-teman. Isilah i'tikaf dengan salat, membaca Al-Qur'an, berdoa, berzikir, dan merenungkan diri. Jadikan i'tikaf sebagai waktu untuk mengevaluasi diri: sudah sejauh mana perjalanan Ramadhan saya? Apa yang perlu saya perbaiki? Apa yang ingin saya doakan? I'tikaf yang baik adalah i'tikaf yang membuat kita pulang dengan hati yang lebih bersih dan semangat yang lebih kuat.

Bagi yang beri'tikaf, jagalah adab selama di masjid. Hormatilah jamaah lain yang juga sedang beribadah, jangan membuat gaduh, jangan mengobrol terlalu lama, dan jagalah kebersihan masjid. I'tikaf adalah waktu untuk mendekat kepada Allah, bukan waktu untuk bersantai atau berkumpul tanpa tujuan. Bawalah perlengkapan secukupnya, jangan membawa barang yang berlebihan sampai mengganggu jamaah lain. Dan jangan lupa untuk tetap menjaga kesehatan: makan dan minumlah secukupnya, tidurlah secukupnya, agar ibadah kita bisa berjalan dengan baik. I'tikaf yang baik adalah i'tikaf yang membuat kita pulang dengan hati yang tenang dan semangat yang baru, bukan i'tikaf yang membuat kita lelah dan justru malas beribadah setelahnya.

I'tikaf adalah kesempatan langka yang hanya datang sekali setahun. Jika tahun ini kita belum bisa, niatkanlah untuk tahun depan, dan persiapkan diri sejak sekarang.

Semoga Allah memberi kita kesempatan untuk beri'tikaf, walau hanya sebentar, di sepuluh malam terakhir ini. Semoga Allah menerima i'tikaf kita, mengampuni dosa-dosa kita, dan mempertemukan kita dengan Lailatul Qadar. Dan bagi yang tidak bisa beri'tikaf, semoga Allah tetap memberi mereka pahala yang sama karena niat dan usaha mereka. Aamiin.""",
    ),
    Kultum(
        night = 23,
        title = """Memperbanyak Ibadah di Akhir Ramadhan""",
        theme = """Meningkatkan amal di sepuluh malam terakhir""",
        quote = """Karena itu, ingatlah kamu kepada-Ku, niscaya Aku ingat (pula) kepadamu.""",
        quoteSource = """QS Al-Baqarah: 152""",
        content = """Ada sebuah kebiasaan yang sering terjadi di akhir Ramadhan: semangat ibadah mulai menurun, sementara kesibukan menyambut Lebaran mulai meningkat. Pasar mulai ramai, pusat perbelanjaan mulai padat, rumah mulai dibersihkan, kue Lebaran mulai dibuat. Semua itu tidak salah, tetapi jangan sampai kesibukan menyambut Lebaran membuat kita lupa bahwa sepuluh malam terakhir adalah malam-malam terbaik di bulan Ramadhan. Jangan sampai kita sibuk menyiapkan baju baru, tetapi lupa menyiapkan bekal akhirat.

Rasulullah justru semakin giat beribadah di sepuluh malam terakhir. Beliau mengencangkan ibadahnya, membangunkan keluarganya, dan bersungguh-sungguh melebihi hari-hari sebelumnya. Ini adalah teladan yang sangat jelas: akhir Ramadhan bukanlah waktu untuk bersantai, melainkan waktu untuk semakin bersungguh-sungguh. Ibarat seorang pelari, semakin dekat dengan garis finis, semakin ia mempercepat larinya, bukan semakin melambat.

Lalu, ibadah apa saja yang bisa kita perbanyak di sepuluh malam terakhir? Pertama, salat malam. Dirikanlah salat malam, walau hanya beberapa rakaat, dengan khusyuk dan tenang. Kedua, membaca Al-Qur'an. Perbanyaklah bacaan kita, dan renungkan maknanya. Ketiga, berdoa. Perbanyaklah doa, terutama doa memohon ampunan, karena sepuluh malam terakhir adalah malam-malam ampunan. Keempat, bersedekah. Bersedekahlah setiap hari, walau sedikit, karena sedekah di malam-malam ini dilipatgandakan pahalanya. Kelima, berzikir dan beristigfar. Basahilah lisan kita dengan zikir, agar hati kita selalu ingat kepada Allah.

Selain memperbanyak ibadah, kita juga perlu menjaga kualitas ibadah kita. Jangan salat malam dengan terburu-buru, jangan membaca Al-Qur'an dengan asal-asalan, jangan berdoa dengan hati yang tidak hadir. Ibadah yang sedikit tetapi khusyuk lebih baik daripada ibadah yang banyak tetapi lalai. Luangkan waktu untuk benar-benar hadir dalam ibadah kita. Matikan gawai sejenak, jauhkan diri dari gangguan, dan fokuslah kepada Allah.

Jangan pula lupa untuk mengajak keluarga kita. Bangunkan anak-anak untuk salat malam bersama, ajaklah pasangan untuk tadarus bersama, ajaklah keluarga untuk berdoa bersama. Sepuluh malam terakhir adalah waktu yang tepat untuk beribadah bersama keluarga, karena keberkahan itu akan terasa lebih kuat ketika dilakukan bersama-sama.

Ada satu hal yang perlu kita waspadai di sepuluh malam terakhir: godaan untuk sibuk dengan urusan dunia. Semakin dekat Lebaran, semakin banyak tawaran belanja, semakin banyak undangan, semakin banyak urusan yang menuntut perhatian kita. Semua itu boleh diurus, tetapi jangan sampai mengambil waktu ibadah kita di malam-malam terbaik ini. Aturlah urusan Lebaran di siang hari, dan luangkan malam hari untuk ibadah. Belanja bisa ditunda, tetapi Lailatul Qadar tidak bisa ditunda. Membersihkan rumah bisa dilakukan besok, tetapi malam-malam terakhir Ramadhan tidak akan kembali. Bijaklah dalam membagi waktu, dan dahulukanlah yang paling berharga, karena kesempatan untuk beribadah di malam-malam ini hanya datang sekali dalam setahun.

Jangan sia-siakan malam-malam ini. Setiap malam yang berlalu tidak akan kembali, dan setiap ibadah yang kita lakukan di malam ini akan menjadi bekal yang menemani kita kelak.

Malam-malam terakhir ini adalah kesempatan emas yang tidak boleh disia-siakan. Perbanyaklah salat, bacaan Al-Qur'an, doa, dan sedekah, karena setiap amalan di malam-malam ini dilipatgandakan pahalanya oleh Allah.

Semoga Allah memberi kita kekuatan untuk memperbanyak ibadah di sepuluh malam terakhir ini, memberi kita kekhusyukan dalam setiap ibadah, dan menerima semua amal kita. Semoga kita tidak termasuk orang-orang yang menyesal setelah Ramadhan berakhir, karena menyia-nyiakan malam-malam terbaiknya. Aamiin.""",
    ),
    Kultum(
        night = 24,
        title = """Ampunan Allah Selalu Terbuka""",
        theme = """Tobat dan harapan akan ampunan di akhir Ramadhan""",
        quote = """Janganlah kamu berputus asa dari rahmat Allah. Sesungguhnya Allah mengampuni dosa-dosa semuanya.""",
        quoteSource = """QS Az-Zumar: 53""",
        content = """Ada satu perasaan yang sering muncul di akhir Ramadhan: perasaan bahwa kita sudah terlambat, bahwa kita sudah banyak bolong puasanya, bahwa kita sudah banyak tertinggal tadarusnya, bahwa kita sudah tidak maksimal. Perasaan ini bisa membuat kita putus asa dan berhenti berusaha. Padahal, perasaan itu adalah bisikan yang harus kita lawan. Allah berfirman, janganlah kamu berputus asa dari rahmat Allah, sesungguhnya Allah mengampuni dosa-dosa semuanya. Ayat ini adalah kabar gembira bagi siapa pun yang merasa dirinya banyak dosa dan banyak kekurangan.

Tobat itu tidak mengenal kata terlambat, selama nyawa masih ada dan selama Ramadhan masih tersisa. Allah Maha Pengampun, Maha Penyayang, Maha Menerima tobat hamba-Nya. Bahkan orang yang berbuat dosa besar sekalipun, jika ia bertobat dengan sungguh-sungguh, Allah akan mengampuninya. Maka jangan pernah berpikir bahwa dosa kita terlalu besar untuk diampuni, atau bahwa kita sudah terlalu jauh untuk kembali. Selama kita mau kembali, Allah akan menerima kita.

Apa itu tobat yang sungguh-sungguh? Pertama, kita menyesali dosa yang kita lakukan. Penyesalan itu adalah tanda bahwa hati kita masih hidup. Kedua, kita berhenti dari dosa itu, tidak mengulanginya lagi. Ketiga, kita bertekad untuk tidak kembali kepada dosa itu. Dan jika dosa itu berkaitan dengan orang lain, kita meminta maaf dan mengembalikan haknya. Tobat yang seperti ini adalah tobat yang benar, tobat yang diterima oleh Allah.

Ramadhan adalah bulan yang paling tepat untuk bertobat. Di bulan ini, pintu-pintu surga dibuka, pintu-pintu neraka ditutup, dan setan-setan dibelenggu. Suasana Ramadhan membuat hati lebih lembut dan lebih mudah untuk bertobat. Maka gunakanlah sisa Ramadhan ini untuk bertobat dengan sungguh-sungguh. Duduklah sejenak sendirian, renungkan dosa-dosa kita, dan mohonlah ampun kepada Allah dengan tulus. Tidak perlu diumumkan kepada siapa pun, cukup antara kita dan Allah.

Jangan pula kita bertobat hanya di bibir, tetapi hati dan perbuatan kita tidak berubah. Tobat yang benar akan terlihat dalam perubahan. Orang yang bertobat dari bergosip akan menjaga lisannya. Orang yang bertobat dari malas salat akan menjaga salatnya. Orang yang bertobat dari pelit akan lebih dermawan. Perubahan itu mungkin tidak langsung sempurna, tetapi ia harus dimulai. Tobat adalah awal perubahan, bukan akhir perubahan.

Tobat juga berarti memperbaiki apa yang sudah kita rusak. Jika kita pernah menyakiti seseorang, mintalah maaf kepadanya. Jika kita pernah mengambil hak orang lain, kembalikanlah. Jika kita pernah lalai dalam kewajiban, tunaikanlah. Tobat yang hanya diucapkan tanpa perbaikan tidaklah cukup. Allah Maha Pengampun, tetapi Allah juga Maha Adil. Maka jangan hanya menangis dan beristigfar, tetapi juga bergeraklah untuk memperbaiki kesalahan kita. Mulailah dengan satu langkah kecil hari ini: hubungi orang yang pernah kita sakiti, kembalikan apa yang pernah kita ambil, tunaikan kewajiban yang pernah kita lalaikan. Langkah kecil ini adalah bukti bahwa tobat kita sungguh-sungguh, dan Allah akan memberkahi setiap langkah yang kita ambil untuk memperbaiki diri.

Allah Maha Pengampun dan Maha Penyayang. Selama kita mau kembali kepada-Nya dengan tulus, pintu ampunan-Nya selalu terbuka, tidak pernah tertutup bagi hamba yang bertobat.

Semoga Allah menerima tobat kita, mengampuni dosa-dosa kita, dan membersihkan hati kita di sisa Ramadhan ini. Semoga kita keluar dari Ramadhan sebagai orang yang bersih, seperti bayi yang baru lahir, tanpa dosa dan tanpa beban. Dan semoga kita bisa menjaga kebersihan itu sampai Ramadhan berikutnya. Aamiin.""",
    ),
    Kultum(
        night = 25,
        title = """Istiqamah, Setelah Ramadhan Berlalu""",
        theme = """Menjaga kebaikan setelah Ramadhan""",
        quote = """Amalan yang paling dicintai Allah adalah amalan yang terus-menerus, walaupun sedikit.""",
        quoteSource = """HR Bukhari dan Muslim""",
        content = """Setiap tahun, ada pemandangan yang selalu berulang: di bulan Ramadhan masjid penuh, Al-Qur'an dibaca di mana-mana, sedekah mengalir deras. Tetapi setelah Ramadhan berakhir, masjid mulai sepi, Al-Qur'an kembali berdebu di rak, dan sedekah kembali jarang. Ini adalah masalah yang dihadapi banyak orang: kita bisa menjadi baik di bulan Ramadhan, tetapi sulit untuk tetap baik setelah Ramadhan. Padahal, tujuan Ramadhan bukanlah membuat kita baik selama sebulan saja, melainkan melatih kita untuk menjadi baik selamanya.

Rasulullah mengingatkan bahwa amalan yang paling dicintai Allah adalah amalan yang terus-menerus, walaupun sedikit. Artinya, Allah lebih menyukai orang yang salat malam dua rakaat setiap malam secara konsisten, daripada orang yang salat malam banyak sekali di bulan Ramadhan tetapi tidak pernah lagi setelahnya. Allah lebih menyukai orang yang membaca satu halaman Al-Qur'an setiap hari secara konsisten, daripada orang yang khatam sekali di bulan Ramadhan tetapi tidak pernah membaca lagi setelahnya. Konsistensi adalah kunci, bukan jumlah yang besar tetapi tidak bertahan lama.

Mengapa istiqamah itu sulit? Karena setelah Ramadhan, suasana yang mendukung kita sudah tidak ada lagi. Tidak ada lagi tarawih berjamaah yang menyemangati, tidak ada lagi tadarus bersama yang mengingatkan, tidak ada lagi suasana Ramadhan yang membuat hati lembut. Kita kembali ke rutinitas biasa, ke kesibukan biasa, ke godaan biasa. Di saat itulah, kebiasaan yang kita bangun di bulan Ramadhan diuji: apakah ia sudah menjadi bagian dari diri kita, atau hanya sekadar suasana?

Agar kebaikan Ramadhan bisa bertahan, kita perlu membuat rencana setelah Ramadhan. Tentukan satu atau dua amalan yang akan kita jaga setelah Ramadhan. Misalnya, salat lima waktu tepat waktu, membaca Al-Qur'an setiap hari walau hanya satu halaman, bersedekah setiap Jumat, atau salat malam dua rakaat setiap malam. Pilihlah amalan yang realistis, yang bisa kita lakukan secara konsisten, bukan amalan yang besar tetapi mustahil untuk dipertahankan. Lebih baik sedikit tetapi terus-menerus, daripada banyak tetapi berhenti.

Jangan pula menunggu Ramadhan berikutnya untuk menjadi baik. Ramadhan memang istimewa, tetapi Allah ada di setiap bulan, bukan hanya di bulan Ramadhan. Kebaikan bisa dilakukan kapan saja, di mana saja. Maka jadikan Ramadhan sebagai titik awal, bukan titik akhir. Jadikan Ramadhan sebagai latihan, dan sebelas bulan berikutnya sebagai pertandingan yang sesungguhnya.

Semoga Allah memberi kita kekuatan untuk istiqamah, untuk menjaga kebaikan yang sudah kita bangun di bulan Ramadhan, dan untuk terus menjadi lebih baik setiap harinya. Semoga Ramadhan tahun ini bukan sekadar bulan yang lewat, tetapi bulan yang mengubah hidup kita selamanya. Aamiin.

Agar istiqamah lebih mudah, jangan berjalan sendirian. Carilah lingkungan yang mendukung kebaikan kita. Ikutilah kajian rutin di masjid, bergabunglah dengan kelompok tadarus, bertemanlah dengan orang-orang yang rajin beribadah. Lingkungan yang baik akan menjaga kita ketika semangat kita mulai menurun, dan akan mengingatkan kita ketika kita mulai lalai. Sebaliknya, lingkungan yang buruk akan menarik kita kembali kepada kebiasaan lama. Maka setelah Ramadhan, jangan tinggalkan masjid dan jangan tinggalkan teman-teman baik yang kita temui di bulan Ramadhan. Jaga silaturahmi dengan mereka, dan jadikan mereka sebagai pengingat yang baik untuk kita di sepanjang tahun, agar kebaikan Ramadhan tidak hilang begitu Ramadhan berakhir.

Istiqamah memang sulit, tetapi ia bukan mustahil. Mulailah dengan langkah kecil, jagalah satu amalan, dan mintalah pertolongan Allah setiap hari agar kita tetap kuat.""",
    ),
    Kultum(
        night = 26,
        title = """Zakat Fitrah, Membersihkan Puasa Kita""",
        theme = """Makna dan kewajiban zakat fitrah""",
        quote = """Dan dirikanlah salat, tunaikanlah zakat, dan rukuklah beserta orang-orang yang rukuk.""",
        quoteSource = """QS Al-Baqarah: 43""",
        content = """Menjelang akhir Ramadhan, ada satu kewajiban yang harus kita tunaikan: zakat fitrah. Zakat fitrah adalah zakat yang wajib dibayarkan oleh setiap muslim, baik laki-laki maupun perempuan, dewasa maupun anak-anak, pada akhir bulan Ramadhan, sebelum salat Idul Fitri. Zakat ini berbeda dengan zakat harta. Zakat fitrah dibayarkan dalam bentuk makanan pokok, atau uang yang setara dengan nilai makanan pokok itu, dan jumlahnya sudah ditentukan: satu sha, atau sekitar dua setengah sampai tiga kilogram beras untuk setiap jiwa.

Mengapa zakat fitrah diwajibkan? Ada dua hikmah besar di dalamnya. Pertama, zakat fitrah membersihkan puasa kita. Selama berpuasa, mungkin kita melakukan hal-hal yang mengurangi kesempurnaan puasa kita: berkata yang tidak perlu, melihat yang tidak perlu, atau lalai dalam ibadah. Zakat fitrah menjadi penyempurna dan pembersih bagi puasa kita, agar puasa kita diterima oleh Allah dalam keadaan yang lebih bersih. Kedua, zakat fitrah memberi kebahagiaan kepada fakir miskin di Hari Raya. Di hari ketika kita bergembira dengan pakaian baru dan makanan yang lezat, saudara-saudara kita yang kurang mampu juga berhak untuk bergembira. Zakat fitrah memastikan bahwa tidak ada orang yang kelaparan di Hari Raya, bahwa semua orang bisa merayakan Idul Fitri dengan layak.

Karena itu, jangan menunda-nunda pembayaran zakat fitrah sampai menit terakhir. Bayarkanlah lebih awal, agar panitia atau lembaga yang mengelolanya bisa menyalurkannya tepat waktu kepada yang berhak. Zakat fitrah yang dibayarkan sebelum salat Idul Fitri terhitung sebagai zakat, sedangkan yang dibayarkan setelah salat Idul Fitri terhitung sebagai sedekah biasa. Perbedaan ini menunjukkan pentingnya waktu: tunaikanlah kewajiban ini sebelum waktunya habis.

Selain zakat fitrah, jangan lupa juga zakat harta bagi yang sudah mencapai nisab dan haulnya. Ramadhan adalah waktu yang tepat untuk menghitung dan menunaikan zakat harta, karena pahalanya dilipatgandakan di bulan ini. Jika kita ragu apakah harta kita sudah wajib dizakati, tanyakanlah kepada orang yang berilmu atau kepada lembaga zakat yang terpercaya. Jangan biarkan keraguan membuat kita menunda kewajiban.

Dalam menunaikan zakat fitrah, perhatikan pula siapa yang berhak menerimanya. Zakat fitrah diperuntukkan bagi fakir miskin dan orang-orang yang berhak menerima zakat lainnya. Jika kita menyalurkannya sendiri, pastikan ia sampai kepada orang yang benar-benar membutuhkan, bukan kepada orang yang hanya meminta-minta tanpa kebutuhan. Jika kita menyalurkannya melalui masjid atau lembaga zakat, pilihlah lembaga yang amanah dan transparan, yang kita percaya akan menyalurkannya dengan benar. Jangan asal menyalurkan tanpa memastikan, karena zakat adalah amanah yang harus sampai kepada yang berhak. Dan jangan lupa untuk meniatkan zakat kita dengan ikhlas, karena zakat yang ikhlas akan membersihkan harta dan hati kita, serta membawa kebahagiaan bagi yang menerimanya.

Tunaikanlah zakat fitrah tepat waktu, agar ia sampai kepada yang berhak sebelum Hari Raya, dan agar mereka pun bisa merayakan Idul Fitri dengan penuh kebahagiaan.

Zakat fitrah adalah kewajiban yang ringan tetapi besar pahalanya. Tunaikanlah dengan ikhlas, dan semoga Allah membersihkan puasa kita serta memberi kebahagiaan kepada saudara-saudara kita yang menerimanya.

Zakat bukanlah beban, melainkan pembersih harta dan penolong bagi yang membutuhkan. Harta yang kita zakati akan menjadi berkah, dan harta yang tidak dizakati justru akan menjadi beban di akhirat. Maka tunaikanlah zakat fitrah kita dengan ikhlas, dan tunaikanlah zakat harta kita jika sudah wajib. Semoga Allah menerima zakat kita, membersihkan puasa kita, dan memberi kebahagiaan kepada saudara-saudara kita yang menerima zakat itu. Aamiin.""",
    ),
    Kultum(
        night = 27,
        title = """Berbagi Kebahagiaan di Hari Raya""",
        theme = """Menyiapkan Idul Fitri dengan berbagi dan silaturahmi""",
        quote = """Tidaklah beriman salah seorang di antara kalian hingga ia mencintai saudaranya sebagaimana ia mencintai dirinya sendiri.""",
        quoteSource = """HR Bukhari dan Muslim""",
        content = """Hari Raya Idul Fitri sudah semakin dekat. Di mana-mana, orang mulai mempersiapkan diri: membeli baju baru, membuat kue, membersihkan rumah, dan merencanakan mudik. Semua itu adalah bagian dari kegembiraan menyambut Hari Raya, dan semuanya boleh dilakukan selama tidak berlebihan. Tetapi, di tengah kesibukan menyiapkan Hari Raya untuk diri sendiri dan keluarga, jangan lupa untuk menyiapkan kebahagiaan bagi orang lain juga.

Idul Fitri adalah hari kemenangan, hari ketika kita kembali kepada fitrah, hari ketika kita merayakan keberhasilan menyelesaikan puasa sebulan penuh. Kemenangan itu akan terasa lebih indah jika dibagikan. Bayangkan, betapa bahagianya seorang anak yatim ketika ia menerima baju baru di Hari Raya. Betapa leganya seorang fakir miskin ketika ia bisa menyajikan makanan yang layak untuk keluarganya di Hari Raya. Betapa tenangnya seorang janda ketika ada yang membantunya menyiapkan kebutuhan Lebaran. Kebahagiaan mereka adalah kebahagiaan kita juga, karena Rasulullah mengajarkan bahwa keimanan kita belum sempurna sampai kita mencintai saudara kita sebagaimana kita mencintai diri sendiri.

Berbagi kebahagiaan di Hari Raya tidak harus dengan uang yang banyak. Kita bisa berbagi dengan mengirim makanan kepada tetangga, dengan memberikan pakaian layak pakai kepada yang membutuhkan, dengan mengajak anak yatim untuk berbelanja keperluan Lebaran, atau dengan sekadar mengunjungi saudara yang sudah lama tidak kita kunjungi. Yang penting adalah kepedulian kita, bukan besarnya pemberian kita. Orang yang memberi dengan ikhlas, walau sedikit, akan mendapatkan pahala yang besar di sisi Allah.

Selain berbagi, Hari Raya juga adalah waktu untuk silaturahmi. Kunjungilah orang tua kita, saudara-saudara kita, tetangga-tetangga kita. Minta maaflah dan berilah maaf. Jangan biarkan Hari Raya berlalu dengan hati yang masih menyimpan dendam dan permusuhan. Hari Raya adalah hari yang fitri, hari yang bersih, maka bersihkanlah hati kita dari segala kebencian dan kesalahpahaman.

Dan jangan lupa, persiapkan Hari Raya dengan niat yang baik. Belilah baju baru secukupnya, jangan berlebihan sampai berutang. Buatlah kue secukupnya, jangan sampai makanan terbuang percuma. Rayakanlah Hari Raya dengan sederhana tetapi penuh makna: salat Idul Fitri berjamaah, bersilaturahmi, berbagi, dan bersyukur kepada Allah atas nikmat Ramadhan yang sudah kita lewati.

Persiapan Hari Raya juga termasuk mempersiapkan diri untuk memaafkan dan meminta maaf. Sebelum Hari Raya tiba, bersihkanlah hati kita dari dendam dan permusuhan. Hubungi saudara yang sudah lama tidak kita sapa, kunjungi tetangga yang mungkin tersinggung oleh kita, dan maafkanlah orang yang pernah menyakiti kita. Hari Raya yang dirayakan dengan hati yang bersih akan terasa jauh lebih indah daripada Hari Raya yang dirayakan dengan hati yang penuh dendam. Jangan biarkan perselisihan kecil merusak kegembiraan Hari Raya. Maafkanlah dengan tulus, dan mintalah maaf dengan rendah hati. Dengan hati yang bersih, kita akan menyambut Hari Raya dengan penuh kebahagiaan, dan kebahagiaan itu akan terasa lebih bermakna karena kita merayakannya bersama orang-orang yang kita sayangi.

Kebahagiaan Hari Raya akan terasa lebih sempurna ketika kita berbagi. Berbagilah dari apa yang kita punya, dan rasakanlah kebahagiaan yang lahir dari memberi.

Semoga Allah memberi kita kesempatan untuk merayakan Idul Fitri dengan penuh kebahagiaan, memberi kita rezeki untuk berbagi, dan menerima semua amal kita di bulan Ramadhan. Semoga Hari Raya tahun ini menjadi Hari Raya yang penuh berkah, bukan hanya untuk kita, tetapi juga untuk semua orang di sekitar kita. Aamiin.""",
    ),
    Kultum(
        night = 28,
        title = """Perpisahan dengan Ramadhan""",
        theme = """Mengucapkan selamat tinggal kepada bulan mulia""",
        quote = """Bulan Ramadhan adalah (bulan) yang di dalamnya diturunkan Al-Qur'an sebagai petunjuk bagi manusia.""",
        quoteSource = """QS Al-Baqarah: 185""",
        content = """Tidak terasa, Ramadhan sudah hampir berakhir. Malam ini adalah salah satu malam terakhir di bulan yang mulia ini. Besok atau lusa, kita akan mengucapkan selamat tinggal kepada Ramadhan, dan kita tidak tahu apakah kita akan dipertemukan lagi dengan Ramadhan tahun depan. Perasaan ini seharusnya membuat kita merenung: sudahkah kita memanfaatkan Ramadhan ini dengan sebaik-baiknya? Sudahkah kita menjadi pribadi yang lebih baik daripada sebelum Ramadhan? Atau apakah Ramadhan ini hanya lewat begitu saja, tanpa meninggalkan bekas?

Perpisahan dengan Ramadhan adalah perpisahan yang menyedihkan bagi orang-orang yang mencintai bulan ini. Mereka bersedih karena bulan yang penuh ampunan akan pergi, bulan yang penuh keberkahan akan berakhir, bulan ketika doa-doa dikabulkan dan dosa-dosa diampuni akan berlalu. Tetapi kesedihan itu bukanlah kesedihan yang membuat putus asa, melainkan kesedihan yang memotivasi untuk memanfaatkan sisa waktu yang ada. Selama Ramadhan belum berakhir, selama masih ada malam yang tersisa, selama masih ada kesempatan untuk beribadah, jangan sia-siakan.

Di malam-malam terakhir ini, mari kita lakukan evaluasi yang jujur. Apa yang sudah kita capai di bulan Ramadhan ini? Apakah salat kita lebih baik? Apakah bacaan Al-Qur'an kita lebih banyak? Apakah sedekah kita lebih sering? Apakah lisan kita lebih terjaga? Apakah hati kita lebih lembut? Jika jawabannya ya, bersyukurlah kepada Allah dan berdoalah agar kebaikan itu bisa dipertahankan. Jika jawabannya belum, jangan putus asa. Masih ada waktu. Masih ada malam ini, masih ada esok hari. Gunakanlah sisa waktu ini dengan sebaik-baiknya, walau hanya beberapa jam, karena Allah Maha Menerima amalan hamba-Nya, walau sedikit, jika dilakukan dengan ikhlas.

Perpisahan dengan Ramadhan juga mengajarkan kita tentang perpisahan dalam hidup ini. Semua yang ada di dunia ini akan berakhir: masa muda akan berakhir, kesehatan akan berakhir, kehidupan itu sendiri akan berakhir. Ramadhan yang datang setiap tahun dan pergi setiap tahun adalah pengingat bahwa waktu terus berjalan dan tidak akan kembali. Maka jangan sia-siakan waktu yang kita miliki. Gunakanlah setiap kesempatan untuk berbuat baik, karena kita tidak tahu kapan kesempatan itu akan berakhir.

Di malam-malam terakhir ini, ada satu amalan yang jangan sampai kita lewatkan: berdoa agar Ramadhan kita diterima. Kita tidak tahu apakah puasa kita diterima atau tidak, apakah salat kita diterima atau tidak, apakah sedekah kita diterima atau tidak. Yang bisa kita lakukan adalah berusaha dengan sungguh-sungguh, lalu berdoa agar Allah menerima semua amal kita. Berdoalah dengan rendah hati, dengan mengakui kekurangan kita, dan dengan berharap pada rahmat Allah yang luas. Jangan sombong dengan amal kita, karena amal yang disertai kesombongan tidak akan diterima. Dan jangan putus asa dengan kekurangan kita, karena Allah Maha Pengampun. Berdoalah agar Allah menerima Ramadhan kita, mengampuni dosa-dosa kita, dan memberi kita kesempatan untuk bertemu Ramadhan berikutnya dalam keadaan yang lebih baik.

Gunakan sisa waktu Ramadhan ini dengan sebaik-baiknya. Berdoalah, beribadahlah, dan mohonlah kepada Allah agar Ramadhan kita diterima dan dosa-dosa kita diampuni.

Semoga Allah menerima puasa kita, salat kita, sedekah kita, dan semua amal kita di bulan Ramadhan ini. Semoga Allah mengampuni dosa-dosa kita, dan semoga Allah mempertemukan kita kembali dengan Ramadhan tahun depan dalam keadaan yang lebih baik. Dan jika ini adalah Ramadhan terakhir kita, semoga Allah menjadikan Ramadhan ini sebagai Ramadhan yang terbaik dalam hidup kita. Aamiin.""",
    ),
    Kultum(
        night = 29,
        title = """Menjaga Hati Setelah Ramadhan""",
        theme = """Membawa semangat Ramadhan ke sebelas bulan berikutnya""",
        quote = """Karena itu, ingatlah kamu kepada-Ku, niscaya Aku ingat (pula) kepadamu.""",
        quoteSource = """QS Al-Baqarah: 152""",
        content = """Ramadhan hampir berakhir, tetapi perjalanan kita sebagai hamba Allah tidak berakhir. Setelah Ramadhan, ada sebelas bulan lain yang menanti, sebelas bulan yang akan menguji apakah kebaikan yang kita bangun di bulan Ramadhan benar-benar melekat dalam diri kita, atau hanya sekadar suasana yang hilang begitu Ramadhan pergi. Maka malam ini, mari kita berbicara tentang bagaimana menjaga hati setelah Ramadhan.

Hati adalah pusat dari segala amal. Jika hati kita baik, amal kita akan baik. Jika hati kita rusak, amal kita akan rusak. Di bulan Ramadhan, hati kita dilatih untuk menjadi lebih lembut, lebih sabar, lebih dermawan, lebih dekat kepada Allah. Tetapi setelah Ramadhan, hati kita akan diuji oleh kesibukan, oleh godaan, oleh rutinitas yang membuat kita lupa. Maka kita perlu menjaga hati kita dengan sengaja, bukan sekadar berharap ia akan terjaga dengan sendirinya.

Bagaimana cara menjaga hati setelah Ramadhan? Pertama, jagalah salat lima waktu. Salat adalah tiang agama, dan salat yang dijaga dengan baik akan menjaga hati kita dari perbuatan yang buruk. Kedua, jagalah bacaan Al-Qur'an. Bacalah Al-Qur'an setiap hari, walau hanya beberapa ayat, agar hati kita selalu terhubung dengan firman Allah. Ketiga, jagalah zikir. Basahilah lisan kita dengan zikir, agar hati kita selalu ingat kepada Allah, sebagaimana Allah berfirman, ingatlah kamu kepada-Ku, niscaya Aku ingat kepadamu. Keempat, jagalah pergaulan. Bertemanlah dengan orang-orang yang mengingatkan kita kepada kebaikan, bukan dengan orang-orang yang menjauhkan kita dari kebaikan. Kelima, jagalah sedekah. Bersedekahlah secara rutin, walau sedikit, agar hati kita tetap lembut dan tidak kikir.

Jangan pula kita merasa bahwa setelah Ramadhan, kita sudah bebas dari ujian. Justru setelah Ramadhan, ujian yang sesungguhnya dimulai. Di bulan Ramadhan, setan dibelenggu dan suasana mendukung kita untuk beribadah. Setelah Ramadhan, setan dilepaskan dan suasana kembali normal. Di saat itulah, keimanan kita diuji: apakah kita tetap salat ketika tidak ada tarawih? Apakah kita tetap membaca Al-Qur'an ketika tidak ada tadarus? Apakah kita tetap bersedekah ketika tidak ada suasana Ramadhan? Jawaban atas pertanyaan-pertanyaan inilah yang menentukan kualitas Ramadhan kita.

Ada satu kebiasaan yang baik untuk dibawa dari Ramadhan ke bulan-bulan berikutnya: meluangkan waktu khusus untuk diri sendiri dan Allah setiap hari. Di bulan Ramadhan, kita terbiasa bangun malam, membaca Al-Qur'an, dan berdoa. Setelah Ramadhan, jangan hilangkan kebiasaan itu sepenuhnya. Luangkanlah walau hanya sepuluh atau lima belas menit setiap hari untuk beribadah dengan tenang, tanpa gangguan. Bacalah beberapa ayat Al-Qur'an, berdoalah, atau sekadar duduk merenung dan berzikir. Waktu singkat ini akan menjaga hati kita tetap dekat dengan Allah, dan akan menjadi pengingat bahwa hidup ini bukan hanya tentang bekerja dan mencari nafkah, tetapi juga tentang mendekat kepada Allah. Hati yang dijaga setiap hari akan tetap lembut, walau Ramadhan sudah lama berlalu.

Jagalah hati kita setiap hari, walau hanya dengan beberapa menit berzikir dan berdoa. Hati yang dijaga akan tetap lembut dan dekat dengan Allah, walau Ramadhan sudah berlalu.

Semoga Allah menjaga hati kita setelah Ramadhan, memberi kita kekuatan untuk istiqamah, dan menjadikan Ramadhan ini sebagai awal perubahan yang bertahan lama. Semoga kita tidak kembali kepada kebiasaan buruk yang sudah kita tinggalkan di bulan Ramadhan, dan semoga kita terus menjadi lebih baik setiap harinya. Aamiin.""",
    ),
    Kultum(
        night = 30,
        title = """Ramadhan Pergi, Takwa Tetap Tinggal""",
        theme = """Penutup — bekal takwa untuk sebelas bulan ke depan""",
        quote = """Wahai orang-orang yang beriman, diwajibkan atas kamu berpuasa sebagaimana diwajibkan atas orang-orang sebelum kamu agar kamu bertakwa.""",
        quoteSource = """QS Al-Baqarah: 183""",
        content = """Malam ini adalah malam terakhir Ramadhan. Besok, kita akan merayakan Idul Fitri, hari kemenangan bagi orang-orang yang telah menyelesaikan puasa sebulan penuh. Tetapi sebelum kita merayakan, mari kita berhenti sejenak dan merenungkan satu pertanyaan: apa yang kita bawa pulang dari Ramadhan tahun ini? Apakah kita pulang dengan tangan kosong, atau kita pulang dengan bekal yang akan menemani kita selama sebelas bulan ke depan?

Allah menjelaskan tujuan puasa dalam ayat yang sudah sering kita dengar sepanjang bulan ini: agar kamu bertakwa. Takwa adalah bekal yang seharusnya kita bawa pulang dari Ramadhan. Takwa bukanlah sesuatu yang bisa dibeli, bukan sesuatu yang bisa dipamerkan, melainkan sesuatu yang ada di dalam hati: kesadaran bahwa Allah selalu melihat kita, kesadaran bahwa setiap perbuatan kita akan dimintai pertanggungjawaban, kesadaran bahwa kita harus menjauhi yang dilarang dan menjalankan yang diperintahkan, baik ketika ada orang yang melihat maupun ketika tidak ada.

Takwa yang kita latih selama Ramadhan terlihat dalam banyak hal. Kita menahan lapar dan haus karena Allah, walau tidak ada yang melihat. Kita menahan marah karena sedang berpuasa. Kita menjaga lisan karena takut merusak puasa. Kita bersedekah karena ingin mendekat kepada Allah. Kita salat malam karena ingin mendapatkan ampunan. Semua itu adalah latihan takwa. Dan latihan itu tidak boleh berhenti ketika Ramadhan berakhir. Takwa harus tetap tinggal dalam hati kita, menemani kita di setiap langkah, di setiap keputusan, di setiap hari.

Apa tanda bahwa takwa kita sudah tumbuh? Tanda yang pertama adalah kita lebih mudah menjauhi yang haram, walau tidak ada yang melihat. Tanda yang kedua adalah kita lebih rajin menjalankan yang wajib, walau sedang sibuk. Tanda yang ketiga adalah kita lebih cepat bertobat ketika berbuat salah, tidak menunda-nunda. Tanda yang keempat adalah kita lebih peduli kepada orang lain, lebih dermawan, lebih pemaaf. Jika tanda-tanda ini ada dalam diri kita, bersyukurlah, karena itu berarti Ramadhan kita berhasil. Jika tanda-tanda ini belum ada, jangan berkecil hati. Takwa itu tumbuh sedikit demi sedikit, dan kita masih punya waktu untuk menumbuhkannya.

Ramadhan akan pergi, tetapi Allah tidak pernah pergi. Allah ada di bulan Ramadhan, dan Allah ada di sebelas bulan lainnya. Maka jangan jadikan kebaikan kita hanya milik Ramadhan. Jadikan kebaikan itu milik sepanjang tahun. Salatlah tepat waktu setelah Ramadhan, bacalah Al-Qur'an setelah Ramadhan, bersedekahlah setelah Ramadhan, jagalah lisan setelah Ramadhan, berbaktilah kepada orang tua setelah Ramadhan. Ramadhan adalah sekolah, dan sebelas bulan berikutnya adalah kehidupan yang sesungguhnya.

Terima kasih, Ramadhan, atas semua pelajaran yang Engkau berikan melalui bulan ini. Terima kasih atas ampunan, atas keberkahan, atas kesempatan untuk memperbaiki diri. Semoga Allah menerima semua amal kita di bulan ini, mengampuni semua dosa kita, dan mempertemukan kita kembali dengan Ramadhan tahun depan dalam keadaan yang lebih baik, lebih sehat, dan lebih bertakwa. Selamat Hari Raya Idul Fitri, mohon maaf lahir dan batin. Semoga Allah memberkahi kita semua. Aamiin.""",
    ),
)
