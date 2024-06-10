package com.example.com_tam_ph42640.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.com_tam_ph42640.LoaiMonAnModel
import com.example.com_tam_ph42640.repository.RepositoryLoaiMon
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LoaiMonAnViewModel(val repository: RepositoryLoaiMon) : ViewModel() {

    private val _loaiMonAns = MutableStateFlow<List<LoaiMonAnModel>>(emptyList())
    val loaiMonAns: StateFlow<List<LoaiMonAnModel>> = _loaiMonAns

    init {
        fetchAllLoaiMon()
    }

    private fun fetchAllLoaiMon() {
        viewModelScope.launch {
            _loaiMonAns.value = repository.getAll()
        }
    }

    fun addLoaiMonAn(loaiMonAn: LoaiMonAnModel) {
        viewModelScope.launch {
            repository.addLoaiMon(loaiMonAn)
            fetchAllLoaiMon()
        }
    }

    fun deleteLoaiMonAn(loaiMonAn: LoaiMonAnModel) {
        viewModelScope.launch {
            repository.deleteLoaiMon(loaiMonAn)
            fetchAllLoaiMon()
        }
    }

    fun updateLoaiMonAn(loaiMonAn: LoaiMonAnModel) {
        viewModelScope.launch {
            repository.updateLoaiMon(loaiMonAn)
            fetchAllLoaiMon()
        }
    }

    fun getLoaiMonByID(idLoaiMon: Int) {
        viewModelScope.launch {
            repository.getLoaiMonByID(idLoaiMon)
        }
    }
}
