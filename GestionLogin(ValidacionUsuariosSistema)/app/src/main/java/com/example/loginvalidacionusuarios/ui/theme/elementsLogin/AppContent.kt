import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.compose_components.examples.List.loginudf.ui.elements.LoginBlock

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.loginvalidacionusuarios.Login.state.LoginViewModel
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppContentLogin(navController: NavController) {

    val vm: LoginViewModel = viewModel()

    Scaffold(topBar = {
        TopAppBar(
            title = {
                Text(
                    text = vm.loggedUser?.nombre ?: "LogIn"
                )
            },
            actions = {
                vm.loggedUser?.let {
                    Button(onClick = { vm.logOut() }) {
                        Text(text = "LogOut")
                    }
                }
            }
        )
    }) { paddingValues ->
        Column(
            Modifier.padding(paddingValues).fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            vm.loggedUser?.let {
                Text(text = "Acceso Ok")
                // TODO: Contenido para usuarios loggeados
            } ?: LoginBlock(
                logginError = vm.logginError,
                onLoggin = { email, password -> vm.loggin(email, password) },
            )

        }

    }

}