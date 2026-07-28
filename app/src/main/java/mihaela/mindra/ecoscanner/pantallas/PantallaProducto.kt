package mihaela.mindra.ecoscanner.pantallas

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DirectionsCarFilled
import androidx.compose.material.icons.filled.Park
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import mihaela.mindra.ecoscanner.BotonAtras
import mihaela.mindra.ecoscanner.BotonReutilizable
import mihaela.mindra.ecoscanner.R

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewPantallaProducto() {
    val navController = NavController(LocalContext.current)
    PantallaProducto(onSalir = {}, navController = NavController(LocalContext.current))
}

@Composable
fun PantallaProducto(onSalir: () -> Unit, navController: NavController) {
    var nombreProducto by remember { mutableStateOf(value = "Yogurt de fresa") }
    var paisOrigen by remember { mutableStateOf(value = "") }
    var dioxidoCarbono by remember { mutableStateOf(value = 45) }
    var litrosAgua by remember { mutableStateOf(value = 1000) }
    var viajes by remember { mutableStateOf(value = 4) }
    var arboles by remember { mutableStateOf(value = 10) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Detalles del producto",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "Nombre del producto: $nombreProducto",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )

        Row(
            modifier = Modifier.fillMaxWidth(0.3f)
        ) {
            Image(
                painter = painterResource(id = R.drawable.yogur_fresa),
                contentDescription = "Imagen del producto",
                contentScale = ContentScale.Inside
            )
        }


        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.Center
        ){
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .shadow(
                        elevation = 12.dp,
                        shape = RoundedCornerShape(16.dp)
                    )
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color.White)
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly
            )  {
                Text(
                    text = "País de origen: $paisOrigen",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.weight(0.1f))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .shadow(
                        elevation = 12.dp,
                        shape = RoundedCornerShape(16.dp)
                    )
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color.White)
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly
            )   {
                Text(
                    text = "Calculo de contaminación: ",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )


            }

            Spacer(modifier = Modifier.weight(0.2f))

            Text(
                text = "Equivalencias visuales de contaminacion: ",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )

            Row(modifier = Modifier.fillMaxWidth(0.8f)) {
                Column(
                    modifier = Modifier.weight(1f),
                    horizontalAlignment = Alignment.Start

                ) {
                    Row() {
                        Icon(
                            imageVector = Icons.Filled.DirectionsCarFilled,
                            contentDescription = "Icono coche"
                        )
                        Text(
                            text = "$viajes viajes en coche",
                            fontWeight = FontWeight.Bold
                        )
                    }
                }

                Column(
                    modifier = Modifier.weight(1f),
                    horizontalAlignment = Alignment.End
                ) {
                    Row() {
                        Icon(
                            imageVector = Icons.Filled.Park,
                            contentDescription = "Icono arboles"
                        )

                        Text(
                            text = "$arboles arboles",
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }

        }

        Spacer(modifier = Modifier.weight(0.1f))

        Box(modifier = Modifier.fillMaxWidth()) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start
            ) {
                BotonAtras(onClick = { onSalir () })
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                BotonReutilizable(
                    value = "Escoger alternativa km 0",
                    onClick = { navController.navigate("alternativas") }
                )
            }
        }
    }
}