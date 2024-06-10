package com.example.com_tam.repository

import com.example.com_tam_ph42640.UserModel
import com.example.com_tam_ph42640.database.AppDatabase


class RepositoryUser(val userDB : AppDatabase) {
    suspend fun addUser(userModel: UserModel){
        userDB.userDAO().addUser(userModel)
    }

    fun getAll () = userDB.userDAO().getListUser()

    suspend fun getUserByEmail(email: String): UserModel? {
        return userDB.userDAO().getUser(email)
    }

}