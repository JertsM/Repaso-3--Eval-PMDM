package com.example.loginvalidacionusuarios.NewUsers.state

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.loginvalidacionusuarios.Login.data.Model.Usuarios
import com.example.loginvalidacionusuarios.NewUsers.data.repository.NewUserRepository

class NewUserViewModel : ViewModel() {
    private val NewUserRepository = NewUserRepository()
}