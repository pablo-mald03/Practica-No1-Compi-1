package com.pablocompany.practicano1_compi1.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController) {

    val gradientBackground = Brush.verticalGradient(
        colors = listOf(
            Color(0xFF0F2027),
            Color(0xFF203A43),
            Color(0xFF2C5364)
        )
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(gradientBackground),
        contentAlignment = Alignment.Center
    ) {

        Card(
            modifier = Modifier
                .padding(32.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(24.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 12.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White.copy(alpha = 0.95f)
            )
        ) {

            Column(
                modifier = Modifier
                    .padding(32.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "Generador de\nDiagramas de Flujo",
                    style = MaterialTheme.typography.headlineMedium,
                    textAlign = TextAlign.Center,
                    color = Color(0xFF1B1B1B)
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Diseña, organiza y programa tus ideas visualmente.",
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.Center,
                    color = Color.Gray
                )

                Spacer(modifier = Modifier.height(32.dp))

                Button(
                    onClick = { navController.navigate("editor") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF2C5364)
                    )
                ) {
                    Text(
                        text = "Iniciar",
                        style = MaterialTheme.typography.titleMedium
                    )
                }
            }
        }
    }
}