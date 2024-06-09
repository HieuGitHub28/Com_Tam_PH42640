package com.example.com_tam.DAO

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.com_tam_ph42640.UserModel

@Dao
interface UserDAO {

    @Query("SELECT * FROM User")
    fun getListUser() : List<UserModel>

    @Query("SELECT * FROM User WHERE email = :username LIMIT 1")
    fun getUser(username : String) : UserModel?
    @Insert
    fun addUser(vararg user : UserModel)
}
