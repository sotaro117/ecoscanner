package mihaela.mindra.ecoscanner

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import mihaela.mindra.ecoscanner.pantallas.PantallaAlternativas
import mihaela.mindra.ecoscanner.pantallas.PantallaEstadistica
import mihaela.mindra.ecoscanner.pantallas.PantallaHistorial
import mihaela.mindra.ecoscanner.pantallas.PantallaHome
import mihaela.mindra.ecoscanner.pantallas.PantallaInicio
import mihaela.mindra.ecoscanner.pantallas.PantallaPerfil
import mihaela.mindra.ecoscanner.pantallas.PantallaPolitica
import mihaela.mindra.ecoscanner.pantallas.PantallaProducto
import mihaela.mindra.ecoscanner.pantallas.PantallaRegistro


@Composable
fun Navegador() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "inicio"
    ) {

        composable("registro") {
            PantallaRegistro(
                onEntrar = { navController.navigate("inicio") },
                navController
            )
        }

        composable("inicio") {
            PantallaInicio(
                onEntrar = { navController.navigate("home") },
                onRegistro = { navController.navigate("registro") },
                navController
            )
        }

        composable("home") {
            PantallaHome(
                onProducto = { navController.navigate("producto") },
                navController
            )
        }

        composable("estadistica") {
            PantallaEstadistica(navController)
        }

        composable("historial") {
            PantallaHistorial(navController)
        }

        composable("perfil") {
            PantallaPerfil(navController)
        }

        composable("producto") {
            PantallaProducto(
                onSalir = { navController.popBackStack() },
                navController
            )
        }

        composable("politica") {
            PantallaPolitica(navController)
        }

        composable("alternativas") {
            PantallaAlternativas(
                onSalir = { navController.popBackStack() },
                navController
            )
        }
    }
}












