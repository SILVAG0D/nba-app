package com.example.nba.presentation.teamslist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.nba.R

// Sample data
val teams = listOf(
    "Lakers",
    "Warriors",
    "Nets",
    "Bucks",
    "Clippers"
)

@Composable
fun TeamsListScreen() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.LightGray)
            .padding(8.dp)
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(teams) { team ->
                TeamItem(teamName = team)
            }
        }
    }
}

@Composable
fun TeamItem(teamName: String) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        onClick = {
            // Handle item click here
        }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .align(Alignment.CenterHorizontally),
            horizontalArrangement = Arrangement.SpaceBetween,

        ) {
            Text(text = teamName)
            Icon(
                painter = painterResource(id = R.drawable.ic_launcher_foreground), // replace with your icon resource
                contentDescription = null
            )
            Text(text = "dsadsa")
        }
    }
}
