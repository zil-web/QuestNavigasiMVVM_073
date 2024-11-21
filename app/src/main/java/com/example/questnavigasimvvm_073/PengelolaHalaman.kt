package com.example.questnavigasimvvm_073

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.questnavigasimvvm_073.model.DataKelamin
import com.example.questnavigasimvvm_073.model.DataMahasiswa
import com.example.questnavigasimvvm_073.ui.theme.view.DataMahasiswaView
import com.example.questnavigasimvvm_073.ui.theme.view.FormMahasiswaView
import com.example.questnavigasimvvm_073.ui.theme.viewmodel.MahasiswaViewModel


enum class Halaman{
    Formulir,
    Detail,
}


@Composable
fun PengelolaanHalaman(
    modifier: Modifier = Modifier,
    navHost: NavHostController = rememberNavController(),
    viewModel: MahasiswaViewModel = viewModel()
){
    Scaffold { isipadding ->
        val uiState by viewModel.uiState.collectAsState()
        NavHost(
            modifier = modifier.padding(isipadding),
            navController = navHost, startDestination = Halaman.Formulir.name
        ) {
            composable(route = Halaman.Formulir.name) {
                val konteks = LocalContext.current
                FormMahasiswaView(
                    listJk = DataKelamin.listJk.map {
                            isi -> konteks.resources.getString(isi)
                    },
                    onSubmitClicked = {
                        viewModel.saveDataMahasiswa(it)
                        navHost.navigate(Halaman.Detail.name)
                    }
                )
            }
            composable(route = Halaman.Detail.name){
                DataMahasiswaView(
                    uiStateMahasiswa = uiState,
                    onClickButton = {
                        navHost.popBackStack()
                    }
                )
            }
            }
        }
}