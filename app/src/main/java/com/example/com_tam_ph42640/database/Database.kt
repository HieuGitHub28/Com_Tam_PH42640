package com.example.com_tam_ph42640.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.com_tam.DAO.HoaDonDAO
import com.example.com_tam.DAO.LoaiMonAnDAO
import com.example.com_tam.DAO.MonAnDAO
import com.example.com_tam.DAO.UserDAO
import com.example.com_tam_ph42640.HoaDonModel
import com.example.com_tam_ph42640.LoaiMonAnModel
import com.example.com_tam_ph42640.MonAnModel
import com.example.com_tam_ph42640.UserModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

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
                )
                    .addCallback(object : RoomDatabase.Callback() {
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)
                            INSTANCE?.let { database ->
                                CoroutineScope(Dispatchers.IO).launch {
                                    populateInitialData(database.userDAO())
                                }
                            }
                        }
                    })
                    .build()
                INSTANCE = instance
                instance
            }
        }

        fun populateInitialData(userDAO: UserDAO) {
            // Tạo người dùng mẫu
            val user = UserModel(
                email = "hieu@gmail.com",
                password = "1234",
                hoTen = "Phạm Minh Hiếu",
                soDienThoai = "0366350859",
                role = 1
            )
            userDAO.addUser(user)
        }
    }
}
