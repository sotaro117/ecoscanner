package mihaela.mindra.ecoscanner.pantallas

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Label
import androidx.compose.material3.Text
import mihaela.mindra.ecoscanner.R
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import mihaela.mindra.ecoscanner.BotonReutilizable
import mihaela.mindra.ecoscanner.CampoTexto

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewPantallaRegistro(){
    val navController = rememberNavController()

    PantallaRegistro(onEntrar = {}, navController = navController)
}

@Composable
fun PantallaRegistro(onEntrar: () -> Unit, navController: NavController){
    var nombre by remember{ mutableStateOf("") }
    var apellido by remember{ mutableStateOf("")}
    var email by remember{ mutableStateOf("")}
    var contrasenia by remember{ mutableStateOf("")}
    var confirmarContrasenia by remember{ mutableStateOf("")}


    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(id = R.drawable.imagen_scanner),
            contentDescription = "Imagen icono",
            contentScale = ContentScale.Inside
        )


        CampoTexto(
            value = nombre,
            onValueChange = {nombre = it},
            placeholder = "Nombre",
            esContrasenia = false,
            modifier = Modifier.fillMaxWidth()
        )

        CampoTexto(
            value = apellido,
            onValueChange = { apellido = it },
            placeholder = "Apellido",
            esContrasenia = false,
            modifier = Modifier.fillMaxWidth()
        )

        CampoTexto(
            value = email,
            onValueChange = { email = it },
            placeholder = "Correo electrónico",
            esContrasenia = false,
            modifier = Modifier.fillMaxWidth()
        )


        CampoTexto(
            value = contrasenia,
            onValueChange = { contrasenia = it },
            placeholder = "Contraseña",
            esContrasenia = true,
            modifier = Modifier.fillMaxWidth()
        )

        CampoTexto(
            value = confirmarContrasenia,
            onValueChange = { confirmarContrasenia = it },
            placeholder = "Confirma la contraseña",
            esContrasenia = true,
            modifier = Modifier.fillMaxWidth()
        )

        BotonReutilizable(
            value = "Registrar",
            onClick = { onEntrar ()},
            modifier = Modifier.fillMaxWidth(0.7f),
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "¿Ya tienes una cuenta?",
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "Iniciar sesión",
            modifier = Modifier.clickable( onClick = { onEntrar() }),
            color = Color(0xFF4CAF50),
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(16.dp))


        Box(
            modifier = Modifier.weight(1f),
            contentAlignment = Alignment.BottomCenter
        ){
            Text(
                text = "Política de privacidad",
                modifier = Modifier.clickable( onClick = { navController.navigate("politica")})
            )
        }
    }
}




