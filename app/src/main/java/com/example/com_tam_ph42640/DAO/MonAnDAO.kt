package com.example.com_tam_ph42640.DAO

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.com_tam_ph42640.MonAnModel


@Dao
interface MonAnDAO{
    @Query("SELECT * FROM MonAn")
    fun getListMonAn() : List<MonAnModel>

    @Query("SELECT * FROM MonAn WHERE id = :id LIMIT 1")
    fun getMon(id : Int) : MonAnModel?

    @Insert
    fun addMon(vararg mon : MonAnModel)

    @Delete
    fun deleteMon(mon: MonAnModel)

    @Update
    fun updateMon(mon: MonAnModel)
}