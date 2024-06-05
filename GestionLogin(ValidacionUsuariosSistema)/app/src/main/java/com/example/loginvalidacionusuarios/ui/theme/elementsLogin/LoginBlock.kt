package com.example.compose_components.examples.List.loginudf.ui.elements

import android.util.Patterns
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation

@Composable
fun LoginBlock(
    logginError: Boolean,
    onLoggin: (String, String) -> Unit, // (OJO.1)
) {
    var emailString by rememberSaveable { mutableStateOf("") }
    var passwordString by rememberSaveable { mutableStateOf("") }

    if (logginError)
        Text(
            text = "Email o contraseña inválidos"
        )
    OutlinedTextField(
        value = emailString, onValueChange = { emailString = it.trim() },
        label = { Text(text = "Email") },
        isError = logginError
    )
    OutlinedTextField(
        value = passwordString, onValueChange = { passwordString = it },
        label = { Text(text = "Contraseña") },
        isError = logginError,
        visualTransformation = PasswordVisualTransformation(), //(OJO.2) Para mostrar puntos en campo contraseña
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
    )
    Button(
        onClick = { onLoggin(emailString, passwordString) },
        enabled = emailString.isValidEmail() && passwordString.isValidPassword()//(OJO.3)
    ) {
        Text(text = "LogIn")
    }

}

private const val MIN_SIZE_PASSWORD = 4
fun String.isValidPassword() = this.length > MIN_SIZE_PASSWORD
fun String.isValidEmail() = Patterns.EMAIL_ADDRESS.matcher(this).matches()

/**
 * (OJO.1)
 * Con el estado en esta función se puede apreciar que cuando el usuario se desloguea,
 * las variables de los TextFields vuelven a vaciarse.
 * (OJO.3)
 * El botón estará sólo habilitado para loguearse cuando ambos campos cumplan requisitos
 */