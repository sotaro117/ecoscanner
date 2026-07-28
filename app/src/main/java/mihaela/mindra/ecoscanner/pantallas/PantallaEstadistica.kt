package mihaela.mindra.ecoscanner.pantallas

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BarChart
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Scaffold
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
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import mihaela.mindra.ecoscanner.BotonIcono
import mihaela.mindra.ecoscanner.R
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.toArgb
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import mihaela.mindra.ecoscanner.ScaffoldConBarra
import java.util.Scanner
import kotlin.math.abs


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewPantallaEstadistica() {
    val navController = rememberNavController()

    PantallaEstadistica(
        navController = navController
    )
}

@Composable
fun PantallaEstadistica(navController: NavController) {
    var productosKmCero by remember { mutableStateOf(value = 80f) }
    var otrosProductos by remember { mutableStateOf(value = 20f) }

    var dioxidoCarbono by remember { mutableStateOf(value = 450) }
    var kmCoche by remember { mutableStateOf(value = 10000) }
    var kmTransporteReducidos by remember { mutableStateOf(value = 4000) }





    val values = listOf(productosKmCero, otrosProductos)
    val colors = listOf(Color.Green, Color.LightGray)
    val total = values.sum()


    ScaffoldConBarra(navController) { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically

            ) {
                Image(
                    painter = painterResource(id = R.drawable.imagen_letras),
                    contentDescription = "Imagen icono",
                    contentScale = ContentScale.Inside
                )
            }

            Text(
                text = "Tu impacto y evolución",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF4A4A4A)
            )

            //Grafico circular
            Canvas(modifier = Modifier.size(250.dp)) {

                val values = listOf(otrosProductos, productosKmCero)
                val total = values.sum()

                var startAngle = -90f

                values.forEachIndexed { index, value ->
                    val sweepAngle = (value / total) * 360f

                    drawArc(
                        color = if (index == 0) Color.LightGray else Color(0xFF4CAF50),
                        startAngle = startAngle,
                        sweepAngle = sweepAngle,
                        useCenter = true,
                        size = size
                    )

                    startAngle += sweepAngle
                }

                //agujero
                drawCircle(
                    color = Color.White,
                    radius = size.minDimension / 3f
                )

                //texto de dentro
                drawIntoCanvas { canvas ->

                    val paint = android.graphics.Paint().apply {
                        textAlign = android.graphics.Paint.Align.CENTER
                        textSize = 40f
                        isFakeBoldText = true
                        color = android.graphics.Color.BLACK
                    }

                    val percent0 = (values[0] / total * 100).toInt()
                    val percent1 = (values[1] / total * 100).toInt()

                    canvas.nativeCanvas.drawText(
                        "0 km: $percent0%",
                        center.x,
                        center.y - 20f,
                        paint
                    )

                    canvas.nativeCanvas.drawText(
                        "Otros: $percent1%",
                        center.x,
                        center.y + 40f,
                        paint
                    )
                }
            }

            Spacer(modifier = Modifier.weight(0.1f))

            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.Center
            ){
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .shadow(elevation = 12.dp, shape = RoundedCornerShape(16.dp))
                        .clip(RoundedCornerShape(16.dp))
                        .background(Color.White),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {
                    Text(
                        text = "CO2 ahorrado hasta ahora"
                    )

                    Text(
                        text = "$dioxidoCarbono kg",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = "Equivale a ${kmCoche} km en coche evitados"
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
                ) {
                    Text(
                        text = "Kilómetros de transporte reducidos"
                    )

                    Text(
                        text = "$kmTransporteReducidos kg",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = "Con tu ayuda el circulo crece"
                    )
                }
            }
        }
    }
}







