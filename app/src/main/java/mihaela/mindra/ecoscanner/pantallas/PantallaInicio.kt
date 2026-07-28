package mihaela.mindra.ecoscanner.pantallas

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
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
import mihaela.mindra.ecoscanner.R

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewPantallaInicio(){
    val navController = rememberNavController()

    PantallaInicio(onEntrar = {}, onRegistro = {}, navController = navController)
}

@Composable
fun PantallaInicio(onEntrar: () -> Unit, onRegistro: () -> Unit, navController: NavController){
    var email by remember{ mutableStateOf("")}
    var contrasenia by remember{ mutableStateOf("")}

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Image(
            painter = painterResource(id = R.drawable.imagen_scanner),
            contentDescription = "Imagen icono",
            contentScale = ContentScale.Inside
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

        Spacer(modifier = Modifier.height(36.dp))

        BotonReutilizable(
            value = "Iniciar sesión",
            onClick = { onEntrar() },
            modifier = Modifier.fillMaxWidth(0.7f),
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "¿Aún no tienes una cuenta?",
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "Rregistrate",
            modifier = Modifier.clickable( onClick = { onRegistro() }),
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
