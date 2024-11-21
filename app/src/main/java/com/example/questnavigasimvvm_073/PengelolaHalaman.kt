package com.example.questnavigasimvvm_073

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.questnavigasimvvm_073.ui.theme.viewmodel.MahasiswaViewModel

enum class  Halaman {
    Formulir,
    Detail,
}
@Composable
fun PengelolaHalaman(
    navController: NavController = rememberNavController(),
    viewModel: MahasiswaViewModel = viewModel()
){
    val stateUi by view
    NavHost(navController = navController, startDestination = Halaman.Formulir.name) {
        composable(route = Halaman.Formulir.name)
        val konteks = LocalContext.current
        MainScren(
            listJK = DataJenisKelamin.listJK.map{id->
                konteks.resources.getString()
            }
        )
    }
}