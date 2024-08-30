package com.example.nba.presentation.routes

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.nba.presentation.home.HomeScreen
import com.example.nba.presentation.playerdetail.PlayerDetailsScreen
import com.example.nba.presentation.playerslist.PlayersListScreen
import com.example.nba.presentation.teamslist.TeamListViewModel
import com.example.nba.presentation.teamslist.TeamsListScreen

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
                HomeScreen(navController)
            }
            composable(route = RoutesEnum.TeamsListScreen.name) {
                val viewModel = viewModel<TeamListViewModel>()
                TeamsListScreen(viewModel)
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
