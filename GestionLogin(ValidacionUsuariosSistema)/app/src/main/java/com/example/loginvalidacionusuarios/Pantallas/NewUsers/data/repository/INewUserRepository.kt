package com.example.loginvalidacionusuarios.Pantallas.NewUsers.data.repository

import com.example.loginvalidacionusuarios.Pantallas.NewUsers.data.Model.NewUser

interface INewUserRepository {
    fun passEqualsPass2(pass: String, pass2: String): NewUser?
}