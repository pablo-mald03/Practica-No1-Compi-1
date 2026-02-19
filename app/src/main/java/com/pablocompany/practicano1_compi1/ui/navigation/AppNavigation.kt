package com.pablocompany.practicano1_compi1.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.pablocompany.practicano1_compi1.ui.screens.EditorScreen
import com.pablocompany.practicano1_compi1.ui.screens.HomeScreen

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
/*
        composable("success") {
            SuccessScreen()
        }*/
    }
}