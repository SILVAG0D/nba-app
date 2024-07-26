package com.example.nba.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.nba.presentation.routes.RoutesEnum
import com.example.nba.presentation.teamslist.TeamsListViewModel
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(navController: NavController) {
    // Use the viewModel() function to obtain the ViewModel instance
    val viewModelTimes: TeamsListViewModel = viewModel()
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.LightGray),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp), // Espaçamento entre os cards
        ) {
            Card(
                modifier = Modifier
                    .size(height = 150.dp, width = 150.dp)
                    .padding(8.dp), // Espaçamento ao redor de cada card
                onClick = {
                    navController.navigate(RoutesEnum.TeamsListScreen.name)
                }
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "Teams List")
                }
            }
            Card(
                modifier = Modifier
                    .size(height = 150.dp, width = 150.dp)
                    .padding(8.dp),
                onClick = {
                    coroutineScope.launch {
                        viewModelTimes.fetchTeams()
                    }
                    navController.navigate(RoutesEnum.PlayersListScreen.name)
                }
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "Players List")
                }
            }
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    val navController = rememberNavController()
    HomeScreen(navController)
}
