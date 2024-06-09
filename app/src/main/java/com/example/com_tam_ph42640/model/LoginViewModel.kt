package com.example.com_tam_ph42640.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.com_tam.DAO.UserDAO
import com.example.com_tam_ph42640.UserModel
import kotlinx.coroutines.launch

class LoginViewModel(private val userDao: UserDAO) : ViewModel() {

    fun login(username: String, password: String, onResult: (Boolean) -> Unit) {
        viewModelScope.launch {
            val user = userDao.getUser(username)
            if (user != null && user.password == password) {
                onResult(true)
            } else {
                onResult(false)
            }
        }
    }
}
