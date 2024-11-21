package com.example.questnavigasimvvm_073.ui.theme.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.questnavigasimvvm_073.model.DataMahasiswa

@Composable
fun DataMahasiswaView(
    modifier: Modifier = Modifier,
    uiStateMahasiswa: DataMahasiswa,
    onClickButton: () -> Boolean
)
{
    val listDataMhs = listOf(
        Pair("Nama", uiStateMahasiswa.nama),
        Pair("NIM", uiStateMahasiswa.nim),
        Pair("Gender", uiStateMahasiswa.gender),
        Pair("Email", uiStateMahasiswa.email),
        Pair("Alamat", uiStateMahasiswa.alamat),
        Pair("NoHP", uiStateMahasiswa.noHp),
    )

    Column(modifier = modifier
        .fillMaxSize()
        .padding(16.dp)
    ){
        listDataMhs.forEach{ items ->
            CardSection(
                judulParam = items.first,
                isiParam = items.second
            )
        }
        Button(onClick = {onClickButton()}) {
            Text(text = "Kembali")
        }
    }
}

@Composable
fun CardSection(judulParam: String, isiParam: String) {
    Column {
        Row(
            modifier = Modifier.fillMaxWidth().padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = judulParam, modifier = Modifier.weight(0.8f))
            Text(text = ":", modifier = Modifier.weight(0.2f))
            Text(
                text = "$isiParam",
                modifier = Modifier.weight(2f)
            )
        }
    }
}