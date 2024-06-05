package com.example.loginvalidacionusuarios.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = Screens.NuevosUsuarios.route) {
        composable(route = Screens.NuevosUsuarios.route) {

        }
    }
}