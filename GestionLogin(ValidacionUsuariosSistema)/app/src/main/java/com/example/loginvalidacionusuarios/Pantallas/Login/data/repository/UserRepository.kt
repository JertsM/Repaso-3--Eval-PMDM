package com.example.compose_components.examples.List.loginudf.data.repository

import com.example.compose_components.examples.List.loginudf.data.sources.ApiDataSourceMock
import com.example.loginvalidacionusuarios.Pantallas.NewUsers.data.source.ListadoUsers

class UserRepository() : IUserRepository {
    private val apiDataSource = ApiDataSourceMock()

    override fun authenticateUser(email: String, password: String) =
        apiDataSource.validUsersInRemoteServer[email]?.run {
            if (this.contrasena == password) this
            else null
        }
}