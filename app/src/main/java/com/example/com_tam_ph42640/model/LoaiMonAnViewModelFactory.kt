package com.example.com_tam_ph42640.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.com_tam_ph42640.repository.RepositoryLoaiMon

class LoaiMonAnViewModelFactory(private val repository: RepositoryLoaiMon) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoaiMonAnViewModel::class.java)) {
            return LoaiMonAnViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
