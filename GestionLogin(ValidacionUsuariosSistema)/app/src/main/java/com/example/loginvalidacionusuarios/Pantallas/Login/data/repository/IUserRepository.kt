package com.example.compose_components.examples.List.loginudf.data.repository

import com.example.loginvalidacionusuarios.Pantallas.Login.data.Model.Usuarios

interface IUserRepository {
    fun authenticateUser(email: String, password: String): Usuarios?
}