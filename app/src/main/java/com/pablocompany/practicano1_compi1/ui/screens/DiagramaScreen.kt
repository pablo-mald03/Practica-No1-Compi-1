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
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.navigation.NavController
import com.pablocompany.practicano1_compi1.compiler.backend.clases.NodoDiagrama
import com.pablocompany.practicano1_compi1.compiler.models.enumsprogam.TipoFigura
import com.pablocompany.practicano1_compi1.compiler.models.enumsprogam.TipoLetra


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
                            >> ${listaDiagrama.size} estructuras detectadas.
                            >>
                            >>
                            >>
                            >> Compilacion Exitosa!.
                            >>
                            >>
                            >> Generando Diagrama...
                            >>
                            >>
                            >>
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
    val dimensiones = mutableListOf<Size>()


    lista.forEachIndexed { index, nodo ->
        val offsetNivel = (nodo.nivel * nivelSpacing)
        val posX = centerX + offsetNivel
        val posY = currentY

        val paint = android.graphics.Paint().apply {
            isAntiAlias = true
            textAlign = android.graphics.Paint.Align.CENTER
            textSize = nodo.sizeLetra.takeIf { it > 0 }?.toFloat() ?: 40f
            typeface = nodo.tipoLetra.toTypeface()
        }

        val lineas = nodo.texto.split("\n")
        val altoLinea = paint.fontMetrics.descent - paint.fontMetrics.ascent
        val altoTextoTotal = lineas.size * altoLinea

        val anchoTextoMax = lineas.maxOfOrNull { paint.measureText(it) } ?: 0f

        val paddingWeb = 60f
        var anchoDinamico = maxOf(400f, anchoTextoMax + paddingWeb * 2)
        var altoDinamico = maxOf(140f, altoTextoTotal + paddingWeb)

        val halfW = anchoDinamico / 2
        val halfH = altoDinamico / 2

        if (index > 0) {
            val (prevX, prevY) = posiciones[index - 1]
            val prevSize = dimensiones[index - 1]
            drawLine(
                color = Color.White,
                start = Offset(prevX, prevY + prevSize.height), // Sale del fondo de la anterior
                end = Offset(posX, posY), // Llega al tope de la actual
                strokeWidth = 6f
            )
        }

        val colorFondo = nodo.colorFondo.toComposeColor()

        when (nodo.figura) {
            TipoFigura.RECTANGULO -> {
                drawRect(color = colorFondo, topLeft = Offset(posX - halfW, posY), size = Size(anchoDinamico, altoDinamico))
                drawRect(color = Color.White, topLeft = Offset(posX - halfW, posY), size = Size(anchoDinamico, altoDinamico), style = Stroke(6f))
            }
            TipoFigura.RECTANGULO_REDONDEADO, TipoFigura.ELIPSE -> {

                val radius = if(nodo.figura == TipoFigura.ELIPSE) CornerRadius(halfH, halfH) else CornerRadius(40f, 40f)
                drawRoundRect(
                    color = colorFondo,
                    topLeft = Offset(posX - halfW, posY),
                    size = Size(anchoDinamico, altoDinamico),
                    cornerRadius = radius
                )
                drawRoundRect(
                    color = Color.White,
                    topLeft = Offset(posX - halfW, posY),
                    size = Size(anchoDinamico, altoDinamico),
                    cornerRadius = radius,
                    style = Stroke(6f)
                )
            }

            TipoFigura.PARALELOGRAMO -> {
                val inclinacion = 40f
                val path = Path().apply {
                    moveTo(posX - halfW + inclinacion, posY)
                    lineTo(posX + halfW + inclinacion, posY)
                    lineTo(posX + halfW - inclinacion, posY + altoDinamico)
                    lineTo(posX - halfW - inclinacion, posY + altoDinamico)
                    close()
                }
                drawPath(path, color = colorFondo)
                drawPath(path, color = Color.White, style = Stroke(6f))
            }

            TipoFigura.ROMBO -> {
                val path = Path().apply {
                    moveTo(posX, posY)
                    lineTo(posX + halfW + 40f, posY + halfH)
                    lineTo(posX, posY + altoDinamico)
                    lineTo(posX - halfW - 40f, posY + halfH)
                    close()
                }
                drawPath(path, color = colorFondo)
                drawPath(path, color = Color.White, style = Stroke(6f))
            }
            TipoFigura.CIRCULO -> {
                val diametro = maxOf(anchoDinamico, altoDinamico)

                val anchoCuadrado = diametro + 40f
                val altoCuadrado = diametro + 40f

                val radio = anchoCuadrado / 2f
                val centroCirculo = Offset(posX, posY + radio)

                // FONDO
                drawCircle(
                    color = colorFondo,
                    radius = radio,
                    center = centroCirculo
                )
                // BORDE
                drawCircle(
                    color = Color.White,
                    radius = radio,
                    center = centroCirculo,
                    style = Stroke(width = 6f)
                )
                anchoDinamico = anchoCuadrado
                altoDinamico = altoCuadrado
            }
            TipoFigura.ELIPSE -> {
                val radioEsquina = altoDinamico / 2f

                drawRoundRect(
                    color = colorFondo,
                    topLeft = Offset(posX - halfW, posY),
                    size = Size(anchoDinamico, altoDinamico),
                    cornerRadius = CornerRadius(radioEsquina, radioEsquina)
                )
                drawRoundRect(
                    color = Color.White,
                    topLeft = Offset(posX - halfW, posY),
                    size = Size(anchoDinamico, altoDinamico),
                    cornerRadius = CornerRadius(radioEsquina, radioEsquina),
                    style = Stroke(width = 6f)
                )
            }

        }

        drawIntoCanvas { canvas ->
            paint.color = nodo.colorTexto
            var yActual = posY + (altoDinamico / 2) - (altoTextoTotal / 2) - paint.fontMetrics.ascent

            lineas.forEach { linea ->
                canvas.nativeCanvas.drawText(linea, posX, yActual, paint)
                yActual += altoLinea
            }
        }

        posiciones.add(posX to posY)
        dimensiones.add(Size(anchoDinamico, altoDinamico))

        currentY += altoDinamico + verticalSpacing
    }
}

//Metodo que permite convertir un entero a Color
fun Int.toComposeColor(): Color {
    return Color(this)
}
//Metodo para poder obtener los tipos de letra configurables
fun TipoLetra?.toTypeface(): android.graphics.Typeface {

    if (this == null) return android.graphics.Typeface.DEFAULT

    return when (this) {
        TipoLetra.ARIAL ->
            android.graphics.Typeface.SANS_SERIF

        TipoLetra.TIMES_NEW_ROMAN ->
            android.graphics.Typeface.SERIF

        TipoLetra.COMIC_SANS ->
            android.graphics.Typeface.create(
                android.graphics.Typeface.SANS_SERIF,
                android.graphics.Typeface.NORMAL
            )

        TipoLetra.VERDANA ->
            android.graphics.Typeface.SANS_SERIF
    }
}