package com.example.questnavigasimvvm_073.ui.theme.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.unit.dp

@Composable
fun FormMahasiswaView(
    modifier: Modifier = Modifier,
    listJk: List<String>,
    onSubmitClicked: (MutableList<String>) ->Unit

){
    var nama by rememberSaveable { mutableStateOf("") }
    var gender by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }

    val dataMahasiswa : MutableList<String> = mutableListOf(nama ,gender,alamat)

    Column (
        Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally){
        OutlinedTextField(
            value = nama,
            onValueChange = {nama = it},
            label = { Text("Nama") },
            placeholder = { Text("Masukkan Nama") },
            modifier = Modifier.fillMaxWidth().padding(5.dp)
        )

        Row (){
            listJk.forEach { item ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(
                        selected = gender == item,
                        onClick = {
                            gender = item
                        })
                    Text(item)
                }
            }


        }
        OutlinedTextField(
            value = alamat,
            onValueChange = {alamat = it},
            label = { Text("Alamat") },
            placeholder = { Text("Masukkan Alamat") },
            modifier = Modifier.fillMaxWidth().padding(5.dp)
        )
        Button(onClick = { onSubmitClicked(dataMahasiswa)})
        { Text("Simpan") }
    }

}
@Composable
fun CardSection(judulParam : String, Isiparams : String){
    Column(
        horizontalAlignment = Alignment.Start
    ) {

        Row(
            modifier = Modifier.fillMaxWidth().padding(5.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = judulParam, modifier = Modifier.weight(0.8f))
            Text(text = ":", modifier = Modifier.weight(0.2f))
            Text(text = "$Isiparams", modifier = Modifier.weight(2f))
        }

    }
}
