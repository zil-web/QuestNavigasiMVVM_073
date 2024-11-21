package com.example.questnavigasimvvm_073.ui.theme.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun FormMahasiswaView(
    modifier: Modifier = Modifier,
    listJk: List<String>,
    onSubmitClicked: (MutableList<String>) ->Unit

){
    // Menyimpan state untuk setiap field input
    var nama by rememberSaveable { mutableStateOf("") }
    var nim by rememberSaveable { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var noHP by remember { mutableStateOf("") }
    var selectedGender by rememberSaveable { mutableStateOf("") }

    // Mengumpulkan data mahasiswa ke dalam list

    val dataMahasiswa: MutableList<String> = mutableListOf(nama, nim, selectedGender, email, alamat, noHP)
    // Kolom utama form dengan padding dan alignment
    Column (Modifier.fillMaxSize().padding(16.dp)
        , horizontalAlignment = Alignment.CenterHorizontally){
        OutlinedTextField(
            value = nama,
            onValueChange = {nama = it},
            placeholder = { Text("Massukkan nama")},
            label = {Text("Nama")},
            modifier = Modifier.fillMaxWidth().padding(5.dp)
        )

        OutlinedTextField(
            value = nim,
            onValueChange = {nim = it},
            placeholder = { Text("Massukkan NIM")},
            label = {Text("NIM")},
            modifier = Modifier.fillMaxWidth().padding(5.dp)
        )

        Row {
            listJk.forEach { item ->
                Row (verticalAlignment = Alignment.CenterVertically){
                    RadioButton(selected = selectedGender == item,
                        onClick = {
                            selectedGender = item
                        }
                    )
                    Text(item)
                }
            }
        }

        OutlinedTextField(
            value = email,
            onValueChange = {email = it},
            placeholder = { Text("Massukkan email")},
            label = {Text("Email")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier.fillMaxWidth().padding(5.dp)
        )

        OutlinedTextField(
            value = alamat,
            onValueChange = {alamat = it},
            placeholder = { Text("Massukkan alamat")},
            label = {Text("Alamat")},
            modifier = Modifier.fillMaxWidth().padding(5.dp)
        )

        OutlinedTextField(
            value = noHP,
            onValueChange = {noHP = it},
            placeholder = { Text("Massukkan noHP")},
            label = {Text("No HP")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth().padding(5.dp)
        )
        // Tombol Simpan untuk mengirim data
        Button(onClick = { onSubmitClicked(dataMahasiswa) })
        {
            Text("Simpan")

        }

    }
}
