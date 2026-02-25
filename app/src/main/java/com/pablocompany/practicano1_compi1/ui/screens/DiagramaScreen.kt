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
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.navigation.NavController
import com.pablocompany.practicano1_compi1.compiler.backend.clases.NodoDiagrama
import com.pablocompany.practicano1_compi1.compiler.models.enumsprogam.TipoFigura


@Composable
fun DiagramaScreen(
    navController: NavController,
    listaDiagrama: List<NodoDiagrama>
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

                        this.DiagramaCanvas(listaDiagrama)
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

fun DrawScope.DiagramaCanvas(lista: List<NodoDiagrama>) {
    val centerX = size.width / 2
    var currentY = 150f
    val verticalSpacing = 250f
    val nivelSpacing = 350f

    val posiciones = mutableListOf<Pair<Float, Float>>()

    lista.forEach { nodo ->
        val offsetNivel = (nodo.nivel * nivelSpacing)
        val posX = centerX + offsetNivel
        val posY = currentY

        when (nodo.figura) {

            TipoFigura.ELIPSE -> {

                // FONDO
                drawOval(
                    color = nodo.colorFondo.toComposeColor(),
                    topLeft = Offset(posX - 200f, posY),
                    size = Size(400f, 140f)
                )

                // BORDE
                drawOval(
                    color = Color.White,
                    topLeft = Offset(posX - 200f, posY),
                    size = Size(400f, 140f),
                    style = Stroke(width = 6f)
                )
            }

            TipoFigura.CIRCULO -> {
                //FONDO
                drawCircle(
                    color = nodo.colorFondo.toComposeColor(),
                    radius = 120f,
                    center = Offset(posX, posY + 120f)
                )
                //BORDE
                drawCircle(
                    color = Color.White,
                    radius = 120f,
                    center = Offset(posX, posY + 120f),
                    style = Stroke(width = 6f)
                )
            }

            TipoFigura.PARALELOGRAMO -> {
                val path = Path().apply {
                    moveTo(posX - 220f, posY)
                    lineTo(posX + 220f, posY)
                    lineTo(posX + 180f, posY + 140f)
                    lineTo(posX - 260f, posY + 140f)
                    close()
                }
                //FONDO
                drawPath(
                    path = path,
                    color = nodo.colorFondo.toComposeColor()
                )

                // BORDE
                drawPath(
                    path = path,
                    color = Color.White,
                    style = Stroke(width = 6f)
                )
            }

            TipoFigura.RECTANGULO -> {
                //FONDO
                drawRect(
                    color = nodo.colorFondo.toComposeColor(),
                    topLeft = Offset(posX - 250f, posY),
                    size = Size(500f, 140f)
                )
                //BORDE
                drawRect(
                    color = Color.White,
                    topLeft = Offset(posX - 250f, posY),
                    size = Size(500f, 140f),
                    style = Stroke(width = 6f)
                )
            }

            TipoFigura.ROMBO -> {
                val diamondPath = Path().apply {
                    moveTo(posX, posY)
                    lineTo(posX + 250f, posY + 120f)
                    lineTo(posX, posY + 240f)
                    lineTo(posX - 250f, posY + 120f)
                    close()
                }

                //FONDO
                drawPath(
                    path = diamondPath,
                    color = nodo.colorFondo.toComposeColor()
                )
                //BORDE
                drawPath(
                    path = diamondPath,
                    color = Color.White,
                    style = Stroke(width = 6f)
                )
            }

            TipoFigura.RECTANGULO_REDONDEADO -> {
                // FONDO
                drawRoundRect(
                    color = nodo.colorFondo.toComposeColor(),
                    topLeft = Offset(posX - 250f, posY),
                    size = Size(500f, 140f),
                    cornerRadius = CornerRadius(40f, 40f)
                )

                // BORDE
                drawRoundRect(
                    color = Color.White,
                    topLeft = Offset(posX - 250f, posY),
                    size = Size(500f, 140f),
                    cornerRadius = CornerRadius(40f, 40f),
                    style = Stroke(width = 6f)
                )
            }
        }

        drawContext.canvas.nativeCanvas.drawText(
            nodo.texto,
            posX,
            posY + 80f,
            android.graphics.Paint().apply {
                textAlign = android.graphics.Paint.Align.CENTER
                textSize = nodo.sizeLetra.toFloat()
                color = nodo.colorTexto
                isFakeBoldText = true
            }
        )

        posiciones.add(posX to posY)
        currentY += verticalSpacing
    }

    // Conexiones entre nodos
    for (i in 0 until posiciones.size - 1) {
        val (x1, y1) = posiciones[i]
        val (x2, y2) = posiciones[i + 1]

        drawLine(
            color = Color.White,
            start = Offset(x1, y1 + 140f),
            end = Offset(x2, y2),
            strokeWidth = 6f
        )
    }
}

//Metodo que permite convertir un entero a Color
fun Int.toComposeColor(): Color {
    return Color(this)
}