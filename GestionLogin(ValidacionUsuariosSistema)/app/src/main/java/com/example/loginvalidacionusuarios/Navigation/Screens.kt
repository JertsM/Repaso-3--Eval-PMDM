package com.example.loginvalidacionusuarios.Navigation

sealed class Screens(val route: String) {
    object NuevosUsuarios: Screens("Nuevos Usuarios")
}