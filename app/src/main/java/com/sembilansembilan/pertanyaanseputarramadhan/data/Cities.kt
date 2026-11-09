package com.sembilansembilan.pertanyaanseputarramadhan.data

/**
 * Daftar kota Indonesia untuk jadwal imsakiyah. Koordinat adalah pusat kota
 * yang umum diketahui (dibulatkan 2–4 desimal — cukup untuk jadwal salat,
 * bukan presisi survei). [City.timezoneHours]: WIB 7.0, WITA 8.0, WIT 9.0.
 */
val CITIES: List<City> = listOf(
    City("Jakarta", -6.2088, 106.8456, 7.0),
    City("Bandung", -6.9175, 107.6191, 7.0),
    City("Surabaya", -7.2575, 112.7521, 7.0),
    City("Medan", 3.5952, 98.6722, 7.0),
    City("Semarang", -6.9667, 110.4167, 7.0),
    City("Yogyakarta", -7.7956, 110.3695, 7.0),
    City("Makassar", -5.1477, 119.4327, 8.0),
    City("Palembang", -2.9919, 104.7566, 7.0),
    City("Denpasar", -8.6705, 115.2126, 8.0),
    City("Balikpapan", -1.2379, 116.8529, 8.0),
    City("Pontianak", -0.0263, 109.3425, 7.0),
    City("Banjarmasin", -3.3194, 114.5908, 8.0),
    City("Manado", 1.4748, 124.8421, 8.0),
    City("Padang", -0.9471, 100.4172, 7.0),
    City("Pekanbaru", 0.5071, 101.4478, 7.0),
    City("Batam", 1.0456, 104.0305, 7.0),
    City("Bandar Lampung", -5.3971, 105.2668, 7.0),
    City("Malang", -7.9666, 112.6326, 7.0),
    City("Solo", -7.5755, 110.8243, 7.0),
    City("Bogor", -6.5971, 106.806, 7.0),
    City("Bekasi", -6.2383, 106.9756, 7.0),
    City("Tangerang", -6.1702, 106.6403, 7.0),
    City("Depok", -6.4025, 106.7942, 7.0),
    City("Cirebon", -6.732, 108.5523, 7.0),
    City("Serang", -6.1169, 106.1537, 7.0),
    City("Jambi", -1.6101, 103.6131, 7.0),
    City("Bengkulu", -3.7928, 102.2608, 7.0),
    City("Palu", -0.8992, 119.8707, 8.0),
    City("Kendari", -3.9985, 122.5125, 8.0),
    City("Kupang", -10.1772, 123.607, 8.0),
    City("Ambon", -3.6554, 128.1908, 9.0),
    City("Jayapura", -2.5337, 140.7181, 9.0),
    City("Mataram", -8.5833, 116.1167, 8.0),
    City("Banda Aceh", 5.5483, 95.3238, 7.0),
    City("Samarinda", -0.5022, 117.1536, 8.0),
)

/** Cari kota berdasarkan nama (case-insensitive, trim). Tidak ketemu → Jakarta. */
fun cityByName(name: String): City {
    val query = name.trim()
    return CITIES.firstOrNull { it.name.equals(query, ignoreCase = true) }
        ?: CITIES.first() // Jakarta
}
