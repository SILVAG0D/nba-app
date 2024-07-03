package com.example.nba.presentation.routes

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.nba.presentation.playerslist.PlayersListScreen
import com.example.nba.presentation.teamslist.TeamsListScreen
import com.example.nba.presentation.home.HomeScren
import com.example.nba.presentation.playerdetail.PlayerDetailsScreen

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
                HomeScren(navController)
            }
            composable(route = RoutesEnum.TeamsListScreen.name) {
                TeamsListScreen()
            }
            composable(route = RoutesEnum.PlayersListScreen.name) {
                PlayersListScreen()
            }
            composable(route = RoutesEnum.PlayerDetailsScreen.name) {
                PlayerDetailsScreen()
            }

        }
    }
}
