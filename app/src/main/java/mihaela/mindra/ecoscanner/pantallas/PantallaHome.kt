package mihaela.mindra.ecoscanner.pantallas

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Geocoder
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageAnalysis
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import mihaela.mindra.ecoscanner.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddLocation
import androidx.compose.material.icons.filled.Addchart
import androidx.compose.material.icons.filled.BarChart
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Map
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import mihaela.mindra.ecoscanner.BotonIcono
import mihaela.mindra.ecoscanner.BotonReutilizable
import mihaela.mindra.ecoscanner.ScaffoldConBarra
import java.util.Locale



@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewPantallaHome() {
    val navController = rememberNavController()

    PantallaHome(
        onProducto = {},
        navController = navController
    )
}

@Composable
fun PantallaHome(onProducto: () -> Unit, navController: NavController) {
    val context = LocalContext.current
    val fusedLocationClient =
        LocationServices.getFusedLocationProviderClient(context)

    var ubicacion by remember { mutableStateOf("Buscando...") }



    fun obtenerCiudadYPais(latitude: Double, longitude: Double) {

        val geocoder = Geocoder(context, Locale.getDefault())

        try {
            val addresses = geocoder.getFromLocation(latitude, longitude, 1)

            if (!addresses.isNullOrEmpty()) {

                val ciudad = addresses[0].locality ?: "Ciudad desconocida"
                val pais = addresses[0].countryName ?: "País desconocido"

                ubicacion = "$ciudad, $pais"

            } else {
                ubicacion = "No se encontró ubicación"
            }

        } catch (e: Exception) {
            ubicacion = "Error obteniendo ciudad"
        }
    }

    fun obtenerUbicacion() {

        fusedLocationClient.lastLocation.addOnSuccessListener { location ->
            if (location != null) {

                obtenerCiudadYPais(
                    location.latitude,
                    location.longitude
                )

            } else {
                ubicacion = "Ubicación no disponible"
            }
        }
    }

    val permissionLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { granted ->
        if (granted) {
            obtenerUbicacion()
        } else {
            ubicacion = "Sin permiso"
        }
    }

    LaunchedEffect(Unit) {
        permissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
    }



    ScaffoldConBarra(navController) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
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

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start
            ) {
                BotonIcono(
                    onClick = { },
                    modifier = Modifier,
                    imagen = Icons.Filled.AddLocation,
                    descripcion = "Profile"
                )

                Text(
                    text = ubicacion
                )
            }


            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .height(400.dp)
                    .shadow(
                        elevation = 8.dp,
                        shape = RoundedCornerShape(30.dp)
                    )
                    .clip(RoundedCornerShape(10.dp))
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(30.dp)
                    )
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.weight(0.05f))

                Text(
                    text = "Scanner",
                    modifier = Modifier,
                    fontSize = 44.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.weight(0.06f))


                Box(
                    modifier = Modifier
                        .fillMaxWidth(0.7f)
                        .aspectRatio(1f)
                        .border(
                            width = 3.dp,
                            color = Color(0xFF4CAF50),
                            shape = RoundedCornerShape(10.dp)
                        )
                        .background(
                            color = Color.LightGray,
                            shape = RoundedCornerShape(10.dp)
                        )
                )

                Spacer(modifier = Modifier.weight(0.06f))

                Text(
                    text = "Haz una foto al código de barras",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.weight(0.05f))


                BotonReutilizable(
                    value = "ESCANEAR PRODUCTO",
                    onClick = { onProducto() }
                )


                Spacer(modifier = Modifier.weight(0.05f))

            }
        }

    }
}




