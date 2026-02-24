package com.pablocompany.practicano1_compi1.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.pablocompany.practicano1_compi1.data.repository.AnalisisViewModel
import kotlinx.coroutines.delay

@Composable
fun AdvertenciaErroresScreen(
    navController: NavController,
    viewModel: AnalisisViewModel
) {

    val gradientBackground = Brush.verticalGradient(
        colors = listOf(
            Color(0xFF0F2027),
            Color(0xFF203A43),
            Color(0xFF2C5364)
        )
    )

    LaunchedEffect(Unit) {
        delay(2500)
        navController.navigate("resultado") {
            popUpTo("editor")
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(gradientBackground),
        contentAlignment = Alignment.Center
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(32.dp)
        ) {

            Text(
                text = "Se encontraron errores",
                style = MaterialTheme.typography.headlineSmall,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Solo puedes acceder al reporte de errores.",
                textAlign = TextAlign.Center,
                color = Color.White.copy(alpha = 0.85f)
            )
        }
    }
}