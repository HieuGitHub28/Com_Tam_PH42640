package com.example.com_tam_ph42640.repository

import com.example.com_tam_ph42640.LoaiMonAnModel
import com.example.com_tam_ph42640.database.AppDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RepositoryLoaiMon(val loaiMonDB: AppDatabase) {

    suspend fun getAll() = withContext(Dispatchers.IO) {
        loaiMonDB.loaimonDAO().getListLoaiMon()
    }

    suspend fun addLoaiMon(loaiMonAnModel: LoaiMonAnModel) = withContext(Dispatchers.IO) {
        loaiMonDB.loaimonDAO().addLoaiMon(loaiMonAnModel)
    }

    suspend fun deleteLoaiMon(loaiMonAnModel: LoaiMonAnModel) = withContext(Dispatchers.IO) {
        loaiMonDB.loaimonDAO().deleteLoaiMon(loaiMonAnModel)
    }

    suspend fun updateLoaiMon(loaiMonAnModel: LoaiMonAnModel) = withContext(Dispatchers.IO) {
        loaiMonDB.loaimonDAO().updateLoaiMon(loaiMonAnModel)
    }

    suspend fun getLoaiMonByID(idLoaiMon: Int) = withContext(Dispatchers.IO) {
        loaiMonDB.loaimonDAO().getLoaiMon(idLoaiMon)
    }
}
