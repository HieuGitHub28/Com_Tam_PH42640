package com.example.com_tam_ph42640.DAO

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.com_tam_ph42640.HoaDonModel


@Dao
interface HoaDonDAO{

    @Query("SELECT * FROM HoaDon")
    fun getListHoaDon() : List<HoaDonModel>

    @Insert
    fun addHoaDon(vararg hd : HoaDonModel)

}