package com.pablocompany.practicano1_compi1.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.ui.graphics.Path
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.navigation.NavController
import com.pablocompany.practicano1_compi1.compiler.models.NodoInstruccion
import com.pablocompany.practicano1_compi1.compiler.models.NodoPrograma


@Composable
fun DiagramaScreen(
    navController: NavController,
    codigoProcesado: NodoPrograma
) {

    var scale by remember { mutableStateOf(1f) }
    var offsetX by remember { mutableStateOf(0f) }
    var offsetY by remember { mutableStateOf(0f) }

    var mostrarConsola by remember { mutableStateOf(false) }
    val alturaMaximaConsola = 0.45f

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
            .background(gradientBackground)
    ) {

        // CONTENIDO PRINCIPAL
        Column(
            modifier = Modifier.fillMaxSize()
        ) {

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "DIAGRAMA GENERADO:",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
                    .background(
                        Color(0xFF1E1E1E),
                        shape = RoundedCornerShape(20.dp)
                    )
                    .clip(RoundedCornerShape(20.dp))
                    .pointerInput(Unit) {
                        detectTransformGestures { _, pan, zoom, _ ->
                            scale *= zoom
                            offsetX += pan.x
                            offsetY += pan.y
                        }
                    }
            ) {

                // Canvas interactivo
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .graphicsLayer(
                            scaleX = scale,
                            scaleY = scale,
                            translationX = offsetX,
                            translationY = offsetY
                        )
                ) {

                    Canvas(modifier = Modifier.fillMaxSize()) {

                        val centerX = size.width / 2
                        var currentY = 150f

                        drawRoundRect(
                            color = Color.Black,
                            topLeft = Offset(centerX - 200f, currentY),
                            size = Size(400f, 120f),
                            cornerRadius = CornerRadius(100f, 100f),
                            style = Stroke(width = 6f)
                        )
                        drawContext.canvas.nativeCanvas.drawText(
                            "INICIO",
                            centerX,
                            currentY + 75f,
                            android.graphics.Paint().apply {
                                textAlign = android.graphics.Paint.Align.CENTER
                                textSize = 40f
                                color = android.graphics.Color.WHITE
                                isFakeBoldText = true
                            }
                        )

                        currentY += 250f
                        //Proceso (rectángulo)
                        drawRect( color = Color(0xFF1976D2),
                            topLeft = Offset(centerX - 250f, currentY),
                            size = Size(500f, 140f),
                            style = Stroke(width = 6f)
                        )
                        drawContext.canvas.nativeCanvas.drawText(
                            "x = 10",
                            centerX,
                            currentY + 85f,
                            android.graphics.Paint().apply {
                                textAlign = android.graphics.Paint.Align.CENTER
                                textSize = 40f
                                color = android.graphics.Color.WHITE
                            }
                        )
                        currentY += 250f
                    // Decisión (rombo)
                    val diamondPath = Path().apply {
                        moveTo(centerX, currentY)
                        lineTo(centerX + 250f, currentY + 120f)
                        lineTo(centerX, currentY + 240f)
                        lineTo(centerX - 250f, currentY + 120f)
                        close()
                    }
                        drawPath(
                            path = diamondPath,
                            color = Color(0xFFFF9800),
                            style = Stroke(width = 6f),
                            )
                        drawContext.canvas.nativeCanvas.drawText(
                            "x > 5?", centerX,
                            currentY + 150f,
                            android.graphics.Paint().apply {
                                textAlign = android.graphics.Paint.Align.CENTER
                                textSize = 40f
                                color = android.graphics.Color.WHITE
                            }
                        )


                    }
                }
            }
        }

        // CONSOLA OVERLAY
        AnimatedVisibility(
            visible = mostrarConsola,
            modifier = Modifier.align(Alignment.BottomCenter)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(alturaMaximaConsola)
                    .background(
                        Color(0xFF121212).copy(alpha = 0.97f),
                        shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
                    )
                    .border(
                        1.dp,
                        Color(0xFF455A64),
                        shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
                    )
                    .padding(16.dp)
            ) {

                Column(
                    modifier = Modifier.fillMaxSize()
                ) {

                    Text(
                        text = "Consola:",
                        color = Color(0xFF64B5F6),
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    val scrollState = rememberScrollState()

                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .verticalScroll(scrollState)
                    ) {

                        Text(
                            text = """
                            >> Compilando...
                            >> Analizando tokens...
                            >> 3 operadores detectados.
                            >> Diagrama generado correctamente.
                        """.trimIndent(),
                            color = Color(0xFFB0BEC5)
                        )
                    }
                }
            }
        }

        // BOTÓN FLOTANTE
        Button(
            onClick = { mostrarConsola = !mostrarConsola },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 20.dp)
        ) {
            Text(if (mostrarConsola) "Ocultar Consola" else "Mostrar Consola")
        }
    }
}