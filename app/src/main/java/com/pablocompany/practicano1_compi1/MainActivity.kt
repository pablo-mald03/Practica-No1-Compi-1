package com.pablocompany.practicano1_compi1

import android.os.Bundle

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.pablocompany.practicano1_compi1.ui.navigation.AppNavigation


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppNavigation()
        }
    }
}



