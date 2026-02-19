package com.pablocompany.practicano1_compi1.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.pablocompany.practicano1_compi1.ui.screens.EditorScreen
import com.pablocompany.practicano1_compi1.ui.screens.HomeScreen
import com.pablocompany.practicano1_compi1.ui.screens.ResultadoScreen

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {

        composable("home") {
            HomeScreen(navController)
        }

        composable("editor") {
            EditorScreen(navController)
        }

        composable(
            route = "resultado/{estado}",
            arguments = listOf(navArgument("estado") { type = NavType.BoolType })
        ) { backStackEntry ->

            val estado = backStackEntry.arguments?.getBoolean("estado") ?: false

            ResultadoScreen(navController, estado)
        }
/*
        composable("success") {
            SuccessScreen()
        }*/
    }
}