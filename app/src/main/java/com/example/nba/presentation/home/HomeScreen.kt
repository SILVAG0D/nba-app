package com.example.nba.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.nba.presentation.routes.RoutesEnum

@Composable
fun HomeScren(navController: NavController) {
   Column(
       modifier = Modifier
           .fillMaxSize()
           .background(color = Color.LightGray),
       verticalArrangement = Arrangement.Center,
       horizontalAlignment = Alignment.CenterHorizontally

   ) {
       ElevatedButton(
           onClick = {
               navController.navigate(RoutesEnum.TeamsListScreen.name)
           }
       ) {
            Text(text = "Teams List")
       }
   }
}

@Preview
@Composable
fun HomeScreenPreview(){
    val navController = rememberNavController()
    HomeScren(navController)
}