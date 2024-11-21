package com.example.questnavigasimvvm_073.model

import com.example.questnavigasimvvm_073.R
//Objek DataKelamin berfungsi untuk menyediakan data jenis kelamin yang digunakan dalam aplikasi.
//Data ini diambil dari file string resources dan disimpan dalam bentuk list.
object DataKelamin {


    val listJk = listOf(
        R.string.laki, // Menyimpan ID resource string untuk "Laki-laki"
        R.string.wanita // Menyimpan ID resource string untuk "Perempuan"
    )
}