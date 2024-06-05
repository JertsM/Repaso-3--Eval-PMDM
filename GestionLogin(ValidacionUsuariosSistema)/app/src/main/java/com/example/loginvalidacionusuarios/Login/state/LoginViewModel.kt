package com.example.loginvalidacionusuarios.Login.state

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.compose_components.examples.List.loginudf.data.repository.UserRepository
import com.example.loginvalidacionusuarios.Login.data.Model.Usuarios

class LoginViewModel : ViewModel() {

    private val userRepository = UserRepository()

    private var _loggedUser: Usuarios? by mutableStateOf(null)
    val loggedUser get() = _loggedUser

    private var _logginError by mutableStateOf(false)
    val logginError get() = _logginError


    fun loggin(emailString: String, passwordString: String) {
        _loggedUser = userRepository.authenticateUser(emailString, passwordString)
        _logginError = _loggedUser?.let { false } ?: true
    }

    fun logOut() {
        _loggedUser = null
    }

}