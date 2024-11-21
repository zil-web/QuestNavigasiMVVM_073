package com.example.questnavigasimvvm_073.ui.theme.viewmodel

import androidx.lifecycle.ViewModel
import com.example.questnavigasimvvm_073.model.DataMahasiswa
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MahasiswaViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(DataMahasiswa())
    val uiState: StateFlow<DataMahasiswa> = _uiState.asStateFlow()

    fun saveDataMahasiswa(ls: MutableList<String>) {
        _uiState.update { data ->
            data.copy(
                nama = ls[0],
                nim = ls[1],
                gender = ls[2],
                alamat = ls[3],
                email = ls[4],
                noHp = ls[5]
            )
        }
    }
}