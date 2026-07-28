package mihaela.mindra.ecoscanner.pantallas

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BarChart
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
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
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import mihaela.mindra.ecoscanner.BotonIcono
import mihaela.mindra.ecoscanner.BotonReutilizable
import mihaela.mindra.ecoscanner.CampoTexto
import mihaela.mindra.ecoscanner.R
import mihaela.mindra.ecoscanner.ScaffoldConBarra

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewPantallaPreview() {
    val navController = rememberNavController()

    PantallaPerfil(
        navController = navController
    )
}
@Composable
fun PantallaPerfil(navController: NavController){
    var nombre by remember{ mutableStateOf("Carla") }
    var apellido by remember{ mutableStateOf("Gonzalez Mendez")}
    var email by remember{ mutableStateOf("Cgonza@gmail.com")}
    var fecha by remember{mutableStateOf("16/11/2020")}


    ScaffoldConBarra(navController) { padding ->
        Column(
            modifier = Modifier.fillMaxSize().padding(padding).padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                painter = painterResource(id = R.drawable.imagen_scanner),
                contentDescription = "Imagen icono",
                contentScale = ContentScale.Inside
            )


            CampoTexto(
                value = nombre,
                onValueChange = { nombre = it },
                placeholder = "",
                esContrasenia = false,
                modifier = Modifier.fillMaxWidth()
            )

            CampoTexto(
                value = apellido,
                onValueChange = { apellido = it },
                placeholder = "",
                esContrasenia = false,
                modifier = Modifier.fillMaxWidth()
            )

            CampoTexto(
                value = email,
                onValueChange = { email = it },
                placeholder = "",
                esContrasenia = false,
                modifier = Modifier.fillMaxWidth()
            )

            Column(modifier = Modifier.fillMaxWidth()){
                Row(){
                    Text(
                        text = "Miembro desde",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Row(){
                    Text(
                        text = fecha,
                        fontSize = 18.sp
                    )
                }
            }

            BotonReutilizable(
                value = "Modificar",
                onClick = { },
                modifier = Modifier.fillMaxWidth(0.9f),
            )

            Box(
                modifier = Modifier.weight(1f),
                contentAlignment = Alignment.BottomCenter
            ){
                BotonReutilizable(
                    value = "Cerrar sesión",
                    onClick = { navController.navigate("inicio")},
                    modifier = Modifier.fillMaxWidth(0.4f),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Red,
                        contentColor = Color.White
                    )
                )
            }



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
}
