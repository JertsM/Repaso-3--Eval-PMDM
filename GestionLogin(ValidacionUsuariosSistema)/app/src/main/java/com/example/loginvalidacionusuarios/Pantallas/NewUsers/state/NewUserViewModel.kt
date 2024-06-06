package com.example.loginvalidacionusuarios.Pantallas.NewUsers.state

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.loginvalidacionusuarios.Pantallas.Login.data.Model.Usuarios
import com.example.loginvalidacionusuarios.Pantallas.NewUsers.data.Model.NewUser
import com.example.loginvalidacionusuarios.Pantallas.NewUsers.data.repository.NewUserRepository

class NewUserViewModel : ViewModel() {
    private val newUserRepository = NewUserRepository()

    private var _loggedUser: NewUser? by mutableStateOf(null)
    val loggedUser get() = _loggedUser

    private var _logginError by mutableStateOf(false)
    val loggingError get() = _logginError

    fun addUser(usernameString: String, emailString: String, password: String, pass2: String) {

    }
}