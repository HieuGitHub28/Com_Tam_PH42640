package com.example.com_tam_ph42640.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.com_tam_ph42640.DAO.UserDAO
import com.example.com_tam_ph42640.UserModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginViewModel(private val userDao: UserDAO) : ViewModel() {

    fun login(username: String, password: String, onResult: (Boolean) -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            val user = userDao.getUser(username)
            if (user != null && user.password == password) {
                withContext(Dispatchers.Main) {
                    onResult(true)
                }
            } else {
                withContext(Dispatchers.Main) {
                    onResult(false)
                }
            }
        }


    }
}
