package com.example.com_tam_ph42640.repository

import com.example.com_tam_ph42640.MonAnModel
import com.example.com_tam_ph42640.database.AppDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class RepositoryMonAn(val monAnDB : AppDatabase) {
    suspend fun getAll(): List<MonAnModel> {
        return withContext(Dispatchers.IO) {
            monAnDB.monanDAO().getListMonAn()
        }
    }

    suspend fun addMonAn(monAnModel: MonAnModel){
        withContext(Dispatchers.IO) {
            monAnDB.monanDAO().addMon(monAnModel)
        }
    }


    suspend fun deleteMonAn(monAnModel: MonAnModel){
        monAnDB.monanDAO().deleteMon(monAnModel)
    }

    suspend fun updateMonAn(monAnModel: MonAnModel){
        monAnDB.monanDAO().updateMon(monAnModel)
    }

    fun getMonAnByID(idMonAn : Int){
        monAnDB.monanDAO().getMon(idMonAn)
    }
}