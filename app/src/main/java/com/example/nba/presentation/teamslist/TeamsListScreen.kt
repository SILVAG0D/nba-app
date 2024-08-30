package com.example.nba.presentation.teamslist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.nba.R

@Composable
fun TeamsListScreen(
    viewModel: TeamListViewModel
) {

//    collectAsStateWithLifecycle
    val state by viewModel.state.collectAsState()

    when (state) {
        is State.Error -> {
            Text(
                text = (state as State.Error).message,
                color = Color.Red
            )
        }

        State.Loading -> {
            Text(
                text = "Carregando...",
                color = Color.Red
            )
        }

        is State.Success -> {
            val times = (state as State.Success).times

            LazyColumn {
                items(times.size) {
                    TeamItem(teamName = times[it].name)
                }
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
            Text(text = "apenas testando emulador")
        }
    }
}
