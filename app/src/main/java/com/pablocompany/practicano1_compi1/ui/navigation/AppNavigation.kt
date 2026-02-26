package com.pablocompany.practicano1_compi1.ui.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.pablocompany.practicano1_compi1.data.repository.AnalisisViewModel
import com.pablocompany.practicano1_compi1.ui.screens.AdvertenciaErroresScreen
import com.pablocompany.practicano1_compi1.ui.screens.DiagramaScreen
import com.pablocompany.practicano1_compi1.ui.screens.EditorScreen
import com.pablocompany.practicano1_compi1.ui.screens.ErrorCriticoScreen
import com.pablocompany.practicano1_compi1.ui.screens.EstructurasControlScreen
import com.pablocompany.practicano1_compi1.ui.screens.HomeScreen
import com.pablocompany.practicano1_compi1.ui.screens.ReporteErroresScreen
import com.pablocompany.practicano1_compi1.ui.screens.ReporteOperadoresScreen
import com.pablocompany.practicano1_compi1.ui.screens.ResultadoScreen

@Composable
fun AppNavigation() {

    val navController = rememberNavController()
    val viewModel: AnalisisViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {

        //Ruta que permite ir a home
        composable("home") {
            HomeScreen(navController)
        }

        //Ruta que permite ir al editor
        composable("editor") {
            EditorScreen(navController, viewModel)
        }

        //Ruta que permite ver el resultado ANALIZADO
        composable("resultado") {
            val resultado = viewModel.resultado
            if (resultado != null) {
                ResultadoScreen(navController, resultado)
            }
        }
        //Ruta que permite ver el diagrama
        composable("diagrama") {
            val resultado = viewModel.resultado
            if (resultado != null) {
                DiagramaScreen(navController, resultado.codigoDiagrama)
            }
        }
        //Ruta para la tabla de operadores matematicos
        composable("reporte_operadores") {
            val resultado = viewModel.resultado

            if (resultado != null) {
                ReporteOperadoresScreen(navController, resultado )
            }
        }

        //Ruta para la tabla de estructuras de control
        composable("reporte_estructuras") {
            val resultado = viewModel.resultado

            if (resultado != null) {
                EstructurasControlScreen(navController, resultado.listaEstructurasControl )
            }
        }

        //Ruta para la tabla de estructuras de control
        composable("reporte-errores") {
            val resultado = viewModel.resultado

            if (resultado != null) {
                ReporteErroresScreen(navController, resultado )
            }
        }

        composable("advertencia_errores") {
            AdvertenciaErroresScreen(navController, viewModel)
        }

        composable("error_critico") {
            ErrorCriticoScreen(navController)
        }

    }
}