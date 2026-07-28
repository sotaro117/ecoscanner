package mihaela.mindra.ecoscanner.pantallas

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BarChart
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import mihaela.mindra.ecoscanner.BotonIcono
import mihaela.mindra.ecoscanner.ProductoCard
import mihaela.mindra.ecoscanner.R
import mihaela.mindra.ecoscanner.ScaffoldConBarra

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewPantallaHistorial(){
    val navController = NavController(LocalContext.current)
    PantallaHistorial(navController)
}
@Composable
fun PantallaHistorial(navController: NavController){
    ScaffoldConBarra(navController) { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Historial",
                color = Color.DarkGray,
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp
            )
            ProductoCard(
                nombreProducto = "Yogur de fresa",
                ahorro = 1200,
                paisOrigen = "Peru",
                esLocal = false,
                imagenRes = R.drawable.yogur_fresa
            )
        }
    }

}