package com.example.com_tam.DAO

import android.content.Context
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.Update
import com.example.com_tam_ph42640.HoaDonModel
import com.example.com_tam_ph42640.LoaiMonAnModel
import com.example.com_tam_ph42640.MonAnModel
import com.example.com_tam_ph42640.UserModel


@Database(
    entities = [UserModel::class, LoaiMonAnModel::class, MonAnModel::class, HoaDonModel::class],
    version = 1)
abstract class DBHelper : RoomDatabase(){
    abstract fun userDAO() : UserDAO
    abstract fun loaimonDAO() : LoaiMonAnDAO
    abstract fun monanDAO() : MonAnDAO
    abstract fun hoadonDAO() : HoaDonDAO
}

@Dao
interface UserDAO {

    // get list danh sach user
    @Query("SELECT * FROM User")
    fun getListUser() : List<UserModel>

    // lay 1 user theo username de Dang Nhap
    @Query("SELECT * FROM User WHERE email = :username LIMIT 1")
    fun getUser(username : String) : UserModel?

    // them user
    @Insert
    fun addUser(vararg user : UserModel)
}

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

@Dao
interface MonAnDAO{
    // get list danh sach Mon An
    @Query("SELECT * FROM MonAn")
    fun getListMonAn() : List<MonAnModel>

    // lay 1 Mon An theo id
    @Query("SELECT * FROM MonAn WHERE id = :id LIMIT 1")
    fun getMon(id : Int) : MonAnModel?

    // them mon an
    @Insert
    fun addMon(vararg mon : MonAnModel)

    // xoa mon an
    @Delete
    fun deleteMon(mon: MonAnModel)

    // sửa mon an
    @Update
    fun updateMon(mon: MonAnModel)
}

@Dao
interface HoaDonDAO{
    // get list danh sach Hoa Don
    @Query("SELECT * FROM HoaDon")
    fun getListHoaDon() : List<HoaDonModel>

    // them hoa don
    @Insert
    fun addHoaDon(vararg hd : HoaDonModel)

}