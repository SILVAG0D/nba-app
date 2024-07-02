package com.example.nba.presentation.routes

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.nba.presentation.home.HomeScren
import com.example.nba.presentation.routes.RoutesEnum

@Composable
fun RoutesConfig() {
    val navController: NavHostController = rememberNavController()

    Scaffold { padding ->
        NavHost(
            navController = navController,
            startDestination = RoutesEnum.HomeScreen.name,
            modifier = Modifier.padding(padding)
        ) {
            composable(route = RoutesEnum.HomeScreen.name) {
                HomeScren()
            }
        }
    }
}
