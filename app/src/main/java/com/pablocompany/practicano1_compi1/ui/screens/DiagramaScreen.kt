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
import com.pablocompany.practicano1_compi1.compiler.models.enumsprogam.TipoConfiguracion
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

//Metodo que permite dibujar el diagrama en el canvas
fun DrawScope.DiagramaCanvas(lista: List<NodoDiagrama>) {
    val centerX = size.width / 2
    var currentY = 150f
    val verticalSpacing = 200f
    val nivelSpacing = 350f

    val posiciones = mutableListOf<Pair<Float, Float>>()
    val dimensiones = mutableListOf<Size>()

    // Variables de control para estructuras
    var nodoOrigenBucleIdx: Int? = null
    val saltosPendientes = mutableListOf<Pair<Int, Offset>>()

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

        val padding = 60f
        var anchoDinamico = maxOf(400f, anchoTextoMax + padding * 2)
        var altoDinamico = maxOf(140f, altoTextoTotal + padding)

        if (nodo.figura == TipoFigura.CIRCULO) {
            val diametro = maxOf(anchoDinamico, altoDinamico) + 40f
            anchoDinamico = diametro
            altoDinamico = diametro
        }

        val halfW = anchoDinamico / 2
        val halfH = altoDinamico / 2

        if (index > 0) {
            val prevNodo = lista[index - 1]
            val (prevX, prevY) = posiciones[index - 1]
            val prevDim = dimensiones[index - 1]

            when {
                prevNodo.nivel == 0 && nodo.nivel == 1 -> {
                    drawLine(Color.White, Offset(prevX, prevY + prevDim.height), Offset(posX, posY), 6f)
                }
                prevNodo.nivel == 1 && nodo.nivel == 0 -> {
                    val pathRetorno = androidx.compose.ui.graphics.Path().apply {
                        moveTo(prevX, prevY + prevDim.height)
                        lineTo(prevX, posY - verticalSpacing / 2)
                        lineTo(posX, posY - verticalSpacing / 2)
                        lineTo(posX, posY)
                    }
                    drawPath(pathRetorno, Color.White, style = Stroke(6f))
                }
                else -> {
                    drawLine(Color.White, Offset(prevX, prevY + prevDim.height), Offset(posX, posY), 6f)
                }
            }
        }

        val saltosHoy = saltosPendientes.filter { it.first == index }
        saltosHoy.forEach { salto ->
            val inicio = salto.second
            val pathFalso = androidx.compose.ui.graphics.Path().apply {
                val escapeX = centerX + nivelSpacing + 450f

                moveTo(inicio.x, inicio.y)
                lineTo(escapeX, inicio.y)
                lineTo(escapeX, posY - verticalSpacing / 2)
                lineTo(posX, posY - verticalSpacing / 2)
                lineTo(posX, posY)
            }
            drawPath(pathFalso, Color.White, style = Stroke(6f))

            val punta = androidx.compose.ui.graphics.Path().apply {
                moveTo(posX - 15f, posY - 20f)
                lineTo(posX, posY)
                lineTo(posX + 15f, posY - 20f)
                close()
            }
            drawPath(punta, Color.White)
        }
        saltosPendientes.removeAll(saltosHoy)

        val colorFondo = nodo.colorFondo.toComposeColor()
        val topLeft = Offset(posX - halfW, posY)
        val sizeFigura = Size(anchoDinamico, altoDinamico)

        when (nodo.figura) {
            TipoFigura.RECTANGULO -> {
                drawRect(colorFondo, topLeft, sizeFigura)
                drawRect(Color.White, topLeft, sizeFigura, style = Stroke(6f))
            }
            TipoFigura.ROMBO -> {
                val path = androidx.compose.ui.graphics.Path().apply {
                    moveTo(posX, posY)
                    lineTo(posX + halfW + 40f, posY + halfH)
                    lineTo(posX, posY + altoDinamico)
                    lineTo(posX - halfW - 40f, posY + halfH)
                    close()
                }
                drawPath(path, colorFondo)
                drawPath(path, Color.White, style = Stroke(6f))
            }
            TipoFigura.CIRCULO -> {
                drawCircle(colorFondo, halfW, Offset(posX, posY + halfW))
                drawCircle(Color.White, halfW, Offset(posX, posY + halfW), style = Stroke(6f))
            }
            TipoFigura.PARALELOGRAMO -> {
                val inc = 40f
                val path = androidx.compose.ui.graphics.Path().apply {
                    moveTo(posX - halfW + inc, posY)
                    lineTo(posX + halfW + inc, posY)
                    lineTo(posX + halfW - inc, posY + altoDinamico)
                    lineTo(posX - halfW - inc, posY + altoDinamico)
                    close()
                }
                drawPath(path, colorFondo)
                drawPath(path, Color.White, style = Stroke(6f))
            }
            else -> { // Elipse y Redondeado
                val rad = if(nodo.figura == TipoFigura.ELIPSE) CornerRadius(halfH, halfH) else CornerRadius(40f, 40f)
                drawRoundRect(colorFondo, topLeft, sizeFigura, rad)
                drawRoundRect(Color.White, topLeft, sizeFigura, rad, style = Stroke(6f))
            }
        }

        if (nodo.tipoInstruccion == TipoConfiguracion.INSTRUCCION_SI ||
            nodo.tipoInstruccion == TipoConfiguracion.INSTRUCCION_MIENTRAS) {

            if (nodo.tipoInstruccion == TipoConfiguracion.INSTRUCCION_MIENTRAS) {
                nodoOrigenBucleIdx = index
            }

            // Programar salto del "Falso" al siguiente nivel 0
            val sigCeroIdx = lista.drop(index + 1).indexOfFirst { it.nivel == 0 }
            if (sigCeroIdx != -1) {
                val destinoIdx = index + 1 + sigCeroIdx
                saltosPendientes.add(destinoIdx to Offset(posX + halfW + 40f, posY + halfH))
            }
        }

        if (nodo.tipoInstruccion == TipoConfiguracion.INSTRUCCION_BLOQUE && nodoOrigenBucleIdx != null) {
            val (origX, origY) = posiciones[nodoOrigenBucleIdx!!]
            val origDim = dimensiones[nodoOrigenBucleIdx!!]

            val pathRegreso = androidx.compose.ui.graphics.Path().apply {
                moveTo(posX - halfW, posY + halfH)
                val escapeX = minOf(posX - halfW, origX - (origDim.width / 2)) - 80f
                lineTo(escapeX, posY + halfH)
                lineTo(escapeX, origY + (origDim.height / 2))
                lineTo(origX - (origDim.width / 2), origY + (origDim.height / 2))
            }
            drawPath(pathRegreso, Color.White, style = Stroke(6f))

            val entX = origX - (origDim.width / 2)
            val entY = origY + (origDim.height / 2)
            val punta = androidx.compose.ui.graphics.Path().apply {
                moveTo(entX - 15f, entY - 10f); lineTo(entX, entY); lineTo(entX - 15f, entY + 10f); close()
            }
            drawPath(punta, Color.White)

            nodoOrigenBucleIdx = null
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