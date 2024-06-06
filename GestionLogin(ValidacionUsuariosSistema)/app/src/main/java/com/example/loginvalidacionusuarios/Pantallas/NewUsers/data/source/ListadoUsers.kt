package com.example.loginvalidacionusuarios.Pantallas.NewUsers.data.source

import com.example.loginvalidacionusuarios.Pantallas.Login.data.Model.Usuarios
import com.example.loginvalidacionusuarios.Pantallas.NewUsers.data.Model.NewUser

class ListadoUsers {
    val ListadoUsuarios = mapOf(
        "mauri@iesteis.gal" to NewUser("Mauricio", "mauri@iesteis.gal", "abcd", "abcd"),
        "miguez@iesteis.gal" to NewUser("Miguez", "miguez@iesteis.gal", "abcdef", "abcdef")
    ).toMutableMap()

    fun addUser(user: NewUser): Boolean {
        return if (ListadoUsuarios.containsKey(user.email)) {
            System.err.println("ERROR: El usuario con el email ${user.email} ya existe.")
            false
        } else if (user.pass != user.pass2) {
            System.err.println("ERROR: Las contraseñas no coinciden.")
            return false
        } else {
            ListadoUsuarios[user.email] = user
            true
        }
    }
}