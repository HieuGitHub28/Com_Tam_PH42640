package com.example.com_tam_ph42640

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "LoaiMon")
data class LoaiMonAnModel(
    @PrimaryKey(autoGenerate = true) var id : Int = 0,
    @ColumnInfo(name = "tenLoaiMon") var tenLoaiMon : String?
) {
    fun getThongtinLoaiMon(): String {
        return "Loai mon an : $tenLoaiMon \n"
    }
}