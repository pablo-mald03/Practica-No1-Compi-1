package com.pablocompany.practicano1_compi1.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.pablocompany.practicano1_compi1.compiler.backend.ResultadoAnalisis

@Composable
fun ResultadoScreen(
    navController: NavController,
    resultado: ResultadoAnalisis
){
    val exito = resultado.exito

    val hayErrores = resultado.erroresLexicos.isNotEmpty() ||
            resultado.erroresLexicos.isNotEmpty()


    val gradientBackground = Brush.verticalGradient(
        colors = listOf(
            Color(0xFF0F2027),
            Color(0xFF203A43),
            Color(0xFF2C5364)
        )
    )

    val scrollState = rememberScrollState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(gradientBackground),
        contentAlignment = Alignment.Center,
    ) {

        Card(
            modifier = Modifier
                .padding(24.dp)
                .fillMaxWidth(0.9f),
            shape = RoundedCornerShape(24.dp),
            elevation = CardDefaults.cardElevation(12.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White.copy(alpha = 0.95f)
            )
        ){

            Column(
                modifier = Modifier.padding(28.dp).verticalScroll(scrollState),
                horizontalAlignment = Alignment.CenterHorizontally
            ){

                Text(
                    text = "DIAGRAMA DE FLUJO",
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(20.dp))

                Button(
                    onClick = {
                        navController.navigate("diagrama")
                    },
                    enabled = exito,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (exito) Color(0xFF157D19) else Color.Gray,
                        disabledContainerColor = Color.LightGray
                    )
                ) {
                    Text(
                        text = "Ver Diagrama",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }

                Spacer(modifier = Modifier.height(36.dp))

                Text(
                    text = "REPORTES",
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(20.dp))

                Button(
                    onClick = { navController.navigate("reporte_operadores") },
                    enabled = exito,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(55.dp),
                    shape = RoundedCornerShape(14.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (exito) Color(0xFF1976D2) else Color.Gray,
                        disabledContainerColor = Color.LightGray
                    )
                ) {
                    Text(
                        text = "Ocurrencia de operadores matemáticos",
                        color = Color.White,
                        textAlign = TextAlign.Center
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))

                Button(
                    onClick = { },
                    enabled = exito,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(55.dp),
                    shape = RoundedCornerShape(14.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (exito) Color(0xFF1565C0) else Color.Gray,
                        disabledContainerColor = Color.LightGray
                    )
                ) {
                    Text(
                        text = "Estructuras de Control",
                        color = Color.White,
                        textAlign = TextAlign.Center
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))

                Button(
                    onClick = { },
                    enabled = hayErrores,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(55.dp),
                    shape = RoundedCornerShape(14.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (hayErrores) Color(0xFFD32F2F) else Color.Gray,
                        disabledContainerColor = Color.LightGray
                    )
                ) {
                    Text(
                        text = "Reporte de Errores",
                        color = Color.White,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}