package com.pablocompany.practicano1_compi1.ui.screens

import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.ui.platform.LocalContext
import androidx.compose.foundation.text.selection.LocalTextSelectionColors
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.pablocompany.practicano1_compi1.data.repository.RepositorioArchivo
import com.pablocompany.practicano1_compi1.domain.usecase.AnalizarCodigoUseCase
import com.pablocompany.practicano1_compi1.domain.usecase.LeerArchivoUseCase

@Composable
fun EditorScreen(navController: NavController) {

    var codeText by remember { mutableStateOf("") }


    val context = LocalContext.current

    val leerArchivoUseCase = remember {
        LeerArchivoUseCase(RepositorioArchivo())
    }

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.OpenDocument()
    ) { uri: Uri? ->

        uri?.let {
            val text = leerArchivoUseCase(context, it)
            codeText = text
        }
    }

    val analizarCodigoUseCase = remember { AnalizarCodigoUseCase() }

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
                .padding(horizontal = 16.dp, vertical = 20.dp)
                .fillMaxSize(),
            shape = RoundedCornerShape(24.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 12.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White.copy(alpha = 0.95f)
            )
        ) {

            Column(
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxSize()
            ) {

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {

                    Button(
                        onClick = {
                            launcher.launch(arrayOf("text/plain"))
                        },
                        modifier = Modifier.weight(1f),
                        shape = RoundedCornerShape(14.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF203A43)
                        )
                    ) {
                        Text("Importar archivo")
                    }

                    Button(
                        onClick = {
                            codeText = ""
                        },
                        modifier = Modifier.weight(1f),
                        shape = RoundedCornerShape(14.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFF44336)
                        )
                    ) {
                        Text("Limpiar")
                    }
                }


                Spacer(modifier = Modifier.height(24.dp))

                Text(
                    text = "Escribe tu código aquí:",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(12.dp))

                val scrollState = rememberScrollState()


                val customTextSelectionColors = TextSelectionColors(
                    handleColor = Color.White,
                    backgroundColor = Color.White.copy(alpha = 0.4f)
                )

                CompositionLocalProvider(
                    LocalTextSelectionColors provides customTextSelectionColors
                ) {

                    BasicTextField(
                        value = codeText,
                        onValueChange = { codeText = it },
                        cursorBrush = Brush.verticalGradient(
                            listOf(Color.White, Color.White)
                        ),
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxWidth()
                            .background(
                                Color(0xFF1E1E1E),
                                RoundedCornerShape(16.dp)
                            )
                            .padding(16.dp)
                            .verticalScroll(scrollState),
                        textStyle = TextStyle(
                            color = Color.White,
                            fontSize = 14.sp
                        )
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))

                Button(
                    onClick = {
                        val resultado = analizarCodigoUseCase(codeText)
                        navController.navigate("resultado/$resultado")
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF2C5364)
                    )
                ) {
                    Text(
                        text = "Generar Diagrama",
                        style = MaterialTheme.typography.titleMedium
                    )
                }
            }
        }
    }
}
