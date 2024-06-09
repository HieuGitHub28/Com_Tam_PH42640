package com.example.com_tam_ph42640.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.com_tam.DAO.HoaDonDAO
import com.example.com_tam.DAO.LoaiMonAnDAO
import com.example.com_tam.DAO.MonAnDAO
import com.example.com_tam.DAO.UserDAO
import com.example.com_tam_ph42640.HoaDonModel
import com.example.com_tam_ph42640.LoaiMonAnModel
import com.example.com_tam_ph42640.MonAnModel
import com.example.com_tam_ph42640.UserModel

@Database(
    entities = [UserModel::class, LoaiMonAnModel::class, MonAnModel::class, HoaDonModel::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDAO(): UserDAO
    abstract fun loaimonDAO(): LoaiMonAnDAO
    abstract fun monanDAO(): MonAnDAO
    abstract fun hoadonDAO(): HoaDonDAO

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "comtam.db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
