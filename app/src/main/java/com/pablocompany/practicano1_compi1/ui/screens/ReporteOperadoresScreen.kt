package com.pablocompany.practicano1_compi1.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.pablocompany.practicano1_compi1.compiler.backend.clases.ReportesOperadores

@Composable
fun ReporteOperadoresScreen(
    navController: NavController,
    resultado: List<ReportesOperadores>
) {

    val gradientBackground = Brush.verticalGradient(
        colors = listOf(
            Color(0xFF0F2027),
            Color(0xFF203A43),
            Color(0xFF2C5364)
        )
    )

    val horizontalScroll = rememberScrollState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(gradientBackground)
            .padding(16.dp)
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(20.dp))
                .background(Color(0xFF331E28).copy(alpha = 0.95f))
                .padding(16.dp)
        ) {


            Text(
                text = "Reporte de Ocurrencia de Operadores Matemáticos",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleLarge.copy(
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            )

            Spacer(modifier = Modifier.height(20.dp))

                LazyColumn(
                    modifier = Modifier.fillMaxSize()
                )  {

                    stickyHeader {
                        Row(
                            modifier = Modifier
                                .horizontalScroll(horizontalScroll)
                                .background(Color(0xFF4B4F37))
                        ) {
                            CeldaHeader("Operador")
                            CeldaHeader("Línea")
                            CeldaHeader("Columna")
                            CeldaHeader("Ocurrencia")
                        }
                    }

                    itemsIndexed(resultado) { index, operador ->
                        val backgroundColor = if (index % 2 == 0)
                            Color(0xFF24273D)
                        else
                            Color(0xFF1E332C)

                        Row(
                            modifier = Modifier
                                .horizontalScroll(horizontalScroll)
                                .background(backgroundColor)
                        ) {
                            Celda(operador.operador)
                            Celda(operador.linea.toString())
                            Celda(operador.columna.toString())
                            Celda(operador.ocurrencia)
                        }
                    }



            }
        }
    }
}

@Composable
fun CeldaHeader(texto: String) {
    Box(
        modifier = Modifier
            .width(300.dp)
            .border(
                width = 1.dp,
                color = Color(0xFFFFFFFF)
            )
            .padding(vertical = 10.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = texto,
            color = Color(0xFFE3F2FD),
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun Celda(texto: String) {
    Box(
        modifier = Modifier
            .width(300.dp)
            .border(
                width = 1.dp,
                color = Color(0xFFFFFFFF)
            )
            .padding(8.dp)
    ) {
        Text(
            text = texto,
            color = Color(0xFFCFD8DC),
            textAlign = TextAlign.Start,
            softWrap = true,
            maxLines = Int.MAX_VALUE
        )
    }
}