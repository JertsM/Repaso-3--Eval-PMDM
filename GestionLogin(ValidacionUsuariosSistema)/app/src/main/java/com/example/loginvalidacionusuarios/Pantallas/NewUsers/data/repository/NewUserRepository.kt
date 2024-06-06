package com.example.loginvalidacionusuarios.Pantallas.NewUsers.data.repository

import com.example.compose_components.examples.List.loginudf.data.sources.ApiDataSourceMock
import com.example.loginvalidacionusuarios.Pantallas.NewUsers.data.Model.NewUser
import com.example.loginvalidacionusuarios.Pantallas.NewUsers.data.source.ListadoUsers

class NewUserRepository : INewUserRepository {
    private val apiDataSouce = ListadoUsers()

    override fun passEqualsPass2(pass: String, pass2: String) =
        apiDataSouce.ListadoUsuarios[pass]?.run {
            if (this.pass2 == pass2) this
            else null
    }

    override fun addNewUser(username: String, email: String, password: String, pass2: String): Boolean {
        val nuevoUsuario = NewUser(username, email, password, pass2)
        return apiDataSouce.addUser(nuevoUsuario)
    }
}