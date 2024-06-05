package com.example.compose_components.examples.List.loginudf.data.sources

import com.example.loginvalidacionusuarios.Login.data.Model.Usuarios

class ApiDataSourceMock {

    var validUsersInRemoteServer = mapOf(
        "mauri@iesteis.gal" to Usuarios("mauri@iesteis.gal", "abcd"),
        "miguez@iesteis.gal" to Usuarios("miguez@iesteis.gal", "abcdef")
    )

}
