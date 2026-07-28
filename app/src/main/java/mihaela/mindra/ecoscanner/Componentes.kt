package mihaela.mindra.ecoscanner

import android.R.attr.tint
import android.view.Surface
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.BatteryUnknown
import androidx.compose.material.icons.filled.BarChart
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewBotonReutilizable() {
    Column() {
        BotonReutilizable(value = "Aceptar", onClick = {})
        CampoTexto(
            value = "",
            onValueChange = {},
            placeholder = "Introduce tu nombre"
        )
        BotonAtras(onClick = {})
        BotonIcono(
            onClick = {},
            imagen = Icons.AutoMirrored.Filled.BatteryUnknown,
            descripcion = "Bateria"
        )
    }
}


@Composable
fun BotonReutilizable(
    value: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    colors: ButtonColors = ButtonDefaults.buttonColors(
        containerColor = Color(0xFF4CAF50),
        contentColor = Color.White
    )
) {
    Button(
        modifier = modifier,
        onClick = onClick,
        shape = RoundedCornerShape(10.dp),
        colors = colors,
        elevation = ButtonDefaults.buttonElevation(defaultElevation = 8.dp)
    ) {
        Text(text = value)
    }
}


@Composable
fun BotonAtras(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {

    IconButton(onClick = onClick, modifier = modifier) {
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
            contentDescription = "Atrás"
        )
    }

}


@Composable
fun CampoTexto(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    esContrasenia: Boolean = false,
    modifier: Modifier = Modifier
) {
    var contraseniaVisible by remember { mutableStateOf(true) }

    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        placeholder = { Text(text = placeholder) },
        shape = RoundedCornerShape(10.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = Color(0xFFF1F8E9),
            unfocusedContainerColor = Color(0xFFF1F8E9),
            focusedBorderColor = Color.Gray,
            unfocusedBorderColor = Color.Gray
        ),
        visualTransformation =
            if (esContrasenia && contraseniaVisible)
                PasswordVisualTransformation()
            else
                VisualTransformation.None,

        trailingIcon = {
            if (esContrasenia) {
                Icon(
                    imageVector =
                        if (contraseniaVisible)
                            Icons.Default.Visibility
                        else
                            Icons.Default.VisibilityOff,
                    contentDescription = "Mostrar/ocultar contraseña",
                    modifier = Modifier.clickable {
                        contraseniaVisible = !contraseniaVisible
                    }
                )
            }
        }
    )
    Spacer(modifier = Modifier.height(16.dp))
}


@Composable
fun BotonIcono(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    imagen: ImageVector,
    descripcion: String,
    tint: Color = Color(0xFF4A4A4A)
) {
    val configuracion = LocalConfiguration.current
    val tamanioPantalla = configuracion.screenHeightDp

    val tamanioIcono = (tamanioPantalla * 0.06f).dp
    val tamanioBoton = (tamanioPantalla * 0.08f).dp


    IconButton(
        onClick = onClick,
        modifier = modifier.size(tamanioBoton)
    ) {
        Icon(
            imageVector = imagen,
            contentDescription = descripcion,
            modifier = Modifier.size(tamanioIcono),
            tint = tint
        )
    }
}


@Composable
fun ScaffoldConBarra(
    navController: NavController,
    content: @Composable (PaddingValues) -> Unit
) {
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route
    Scaffold(
        bottomBar = {
            Row(modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFF1F8E9)))
            {

                BotonIcono(
                    onClick = { navController.navigate("home") },
                    modifier = Modifier.weight(1f),
                    imagen = Icons.Filled.Home,
                    descripcion = "Home",
                    tint = if (currentRoute == "home") Color(0xFF4CAF50) else Color.DarkGray
                )

                BotonIcono(
                    onClick = { navController.navigate("estadistica") },
                    modifier = Modifier.weight(1f),
                    imagen = Icons.Filled.BarChart,
                    descripcion = "Estadistica",
                    tint = if (currentRoute == "estadistica") Color(0xFF4CAF50) else Color.DarkGray
                )

                BotonIcono(
                    onClick = { navController.navigate("historial") },
                    modifier = Modifier.weight(1f),
                    imagen = Icons.Filled.History,
                    descripcion = "Historial",
                    tint = if (currentRoute == "historial") Color(0xFF4CAF50) else Color.DarkGray
                )

                BotonIcono(
                    onClick = { navController.navigate("perfil") },
                    modifier = Modifier.weight(1f),
                    imagen = Icons.Filled.Person,
                    descripcion = "Perfil",
                    tint = if (currentRoute == "perfil") Color(0xFF4CAF50) else Color.DarkGray
                )
            }
        }
    ) { padding ->
        content(padding)
    }
}




@Composable
fun ProductoCard(
    nombreProducto: String,
    ahorro: Int,
    paisOrigen: String,
    esLocal: Boolean,
    imagenRes: Int
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(
                elevation = 12.dp,
                shape = RoundedCornerShape(16.dp)
            )
            .clip(RoundedCornerShape(16.dp))
            .background(Color(0xFFF1F8F3))
            .padding(16.dp)
    ) {

        Image(
            painter = painterResource(id = imagenRes),
            contentDescription = "Imagen del producto",
            modifier = Modifier
                .size(64.dp)
                .clip(RoundedCornerShape(8.dp))
        )

        Spacer(modifier = Modifier.width(12.dp))

        Column(modifier = Modifier.fillMaxWidth()) {

            Text(
                text = nombreProducto,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF1E5C3A)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = "Ahorra: $ahorro km",
                    fontSize = 14.sp,
                )

                Row(
                    modifier = Modifier
                        .shadow(
                            elevation = 4.dp,
                            shape = RoundedCornerShape(16.dp)
                        )
                        .clip(RoundedCornerShape(16.dp))
                        .background(
                            color = if (esLocal) Color(0xFF2E7D32)
                            else Color(0xFFFF9800)
                        )
                        .padding(horizontal = 12.dp, vertical = 6.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = paisOrigen,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = if (esLocal) Color.White else Color.Black
                    )
                }
            }
        }
    }
}














