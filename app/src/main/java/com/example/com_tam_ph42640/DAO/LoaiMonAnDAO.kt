package com.example.com_tam_ph42640.DAO

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.com_tam_ph42640.LoaiMonAnModel

@Dao
interface LoaiMonAnDAO{

    @Query("SELECT * FROM LoaiMon")
    fun getListLoaiMon() : List<LoaiMonAnModel>

    @Query("SELECT * FROM LoaiMon WHERE id = :id LIMIT 1")
    fun getLoaiMon(id : Int) : LoaiMonAnModel?

    @Insert
    fun addLoaiMon(vararg loaiMon : LoaiMonAnModel)

    @Delete
    fun deleteLoaiMon(loaiMon: LoaiMonAnModel)

    @Update
    fun updateLoaiMon(loaiMon: LoaiMonAnModel)
}