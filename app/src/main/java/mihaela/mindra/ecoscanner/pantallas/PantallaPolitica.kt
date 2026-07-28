package mihaela.mindra.ecoscanner.pantallas

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import mihaela.mindra.ecoscanner.BotonReutilizable


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewPantallaPolitica() {
    val navController = NavController(LocalContext.current)
    PantallaPolitica(navController)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaPolitica(navController: NavController) {
    val politicaPrivacidad = """
POLÍTICA DE PRIVACIDAD
EcoScanner – Asistente de Petjada de Transport i Km 0.

Última actualización: 16 de abril de 2026

En EcoScanner respetamos tu privacidad y nos comprometemos a proteger tus datos personales conforme al Reglamento General de Protección de Datos (RGPD) y la normativa vigente.

1. Información que recopilamos

Recopilamos los siguientes datos:

• Datos de registro: nombre, apellido, correo electrónico y contraseña (necesarios para crear tu cuenta).
• Datos de ubicación (GPS): coordenadas del dispositivo solo en el momento de escanear un producto.
• Datos de cámara: acceso temporal a la cámara para escanear códigos de barras.
• Historial de escaneos: productos escaneados, distancia calculada y CO₂ estimado (solo si decides guardarlo).
• Datos de uso anónimos: estadísticas para mejorar la aplicación.

Importante:
- Nunca guardamos las fotos tomadas con la cámara.
- El GPS solo se activa durante el escaneo y se elimina inmediatamente después del cálculo.
- No almacenamos tu ubicación de forma continua.

2. Finalidad del tratamiento

Utilizamos tus datos para:
- Gestionar tu cuenta y el inicio de sesión.
- Calcular la distancia real y las emisiones de CO₂ del producto escaneado.
- Mostrarte tu historial personal de impacto ecológico.
- Mejorar la experiencia de usuario (datos anónimos).

3. Base legal

El tratamiento de tus datos se basa en:
- Tu consentimiento explícito al registrarte y al aceptar esta política.
- La ejecución del contrato (uso de la aplicación).

4. Compartición de datos

No vendemos tus datos a terceros.

Solo compartimos la información estrictamente necesaria con:
- Open Food Facts (o nuestra API mockeada) para obtener el origen del producto.
- Firebase Authentication para gestionar el login de forma segura.

Nunca compartimos tu historial de escaneos ni tus datos de ubicación.

5. Almacenamiento y seguridad

- Tus datos se almacenan de forma encriptada en Firebase.
- El historial de escaneos se guarda tanto en tu dispositivo como en la nube (opcional).
- Aplicamos medidas técnicas y organizativas para evitar accesos no autorizados.

6. Tus derechos

Puedes ejercer los siguientes derechos en cualquier momento:
- Acceder a tus datos personales
- Rectificarlos si son incorrectos
- Suprimirlos (derecho al olvido)
- Oponerte al tratamiento
- Limitar su uso
- Solicitar la portabilidad

Para ejercer cualquiera de estos derechos, envíanos un correo a: ecoscanner.app@gmail.com

7. Retención de datos

Mantendremos tus datos mientras tengas una cuenta activa. Si eliminas tu cuenta, borraremos todos tus datos en un plazo máximo de 30 días.

8. Cambios en la política

Podemos actualizar esta política. Te notificaremos cualquier cambio importante a través de la aplicación o por correo electrónico.

9. Contacto

Si tienes cualquier duda sobre esta Política de Privacidad, puedes contactarnos en:
ecoscanner.app@gmail.com

Al usar EcoScanner aceptas esta Política de Privacidad.
""".trimIndent()

    Scaffold(
        containerColor = Color(0xFFF1F8E9),
        topBar = {
            TopAppBar(
                title = { Text("Política de Privacidad") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFFF1F8E9)
                )
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Text(
                text = politicaPrivacidad,
                style = MaterialTheme.typography.bodyMedium,
                lineHeight = 20.sp
            )

            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center){
                BotonReutilizable(
                    value = "Entendido",
                    onClick = { navController.popBackStack()},
                    modifier = Modifier.fillMaxWidth(0.7f),
                )
            }
        }
    }
}