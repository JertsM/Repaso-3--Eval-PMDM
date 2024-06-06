package com.example.loginvalidacionusuarios.ui.theme.elementsNewUser

import android.annotation.SuppressLint
import android.util.Patterns
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview

@Preview(showSystemUi = true)
@SuppressLint("UnrememberedMutableState")
@Composable
fun NewUserBlock() {
    var nameUser by rememberSaveable{ mutableStateOf("") }
    var emailString by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var pass2 by rememberSaveable { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        OutlinedTextField(
            value = nameUser, onValueChange = { nameUser = it.trim() },
            label = { Text(text = "Nombre de usuario") },
        )

        OutlinedTextField(
            value = emailString, onValueChange = { emailString = it.trim() },
            label = { Text(text = "Email") }
        )

        OutlinedTextField(
            value = password, onValueChange = { password = it },
            label = { Text(text = "Contraseña") },
            visualTransformation = PasswordVisualTransformation(), //(OJO.2) Para mostrar puntos en campo contraseña
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )

        OutlinedTextField(
            value = pass2, onValueChange = { password = it },
            label = { Text(text = "Repetir contraseña") },
            visualTransformation = PasswordVisualTransformation(), //(OJO.2) Para mostrar puntos en campo contraseña
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )
    }


}

private const val MIN_SIZE_USERNAME = 4
private const val MIN_SIZE_PASSWORD = 4

fun String.isValidUserName() = this.length > MIN_SIZE_USERNAME
fun String.isValidPassword() = this.length > MIN_SIZE_PASSWORD
fun String.isValidEmail() = Patterns.EMAIL_ADDRESS.matcher(this).matches()
