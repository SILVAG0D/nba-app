package com.example.nba.presentation.home

import android.util.Log
import androidx.annotation.OptIn
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.media3.common.util.UnstableApi
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.nba.data.service.TimeAPI
import com.example.nba.data.service.helpers.RetrofitInstance
import com.example.nba.data.service.model.TimeModel
import com.example.nba.presentation.routes.RoutesEnum
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

@OptIn(UnstableApi::class)
@Composable
fun HomeScreen(navController: NavController) {

//    val viewModelTimes: TeamsListViewModel = viewModel()
    var times: TimeModel?
    val coroutineScope = rememberCoroutineScope()



    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.LightGray),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Card(
                modifier = Modifier
                    .size(height = 150.dp, width = 150.dp)
                    .padding(8.dp),
                onClick = {
                    CoroutineScope(Dispatchers.Main).launch  {

                        times = getTimes()

                    }
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


suspend fun getTimes():TimeModel?{
    val retrofit by lazy {
        RetrofitInstance.retrofit
    }
    var time: TimeModel? = null
    var retorno: Response<TimeModel>? = null
    val apiKey = "89998ad4-7af2-4e0e-befb-4f345f0bdded"

    try {
        val teamApi = retrofit.create(TimeAPI::class.java)
        retorno = teamApi.getTimes(apiKey)
    }
    catch (e: Exception){
        e.printStackTrace()
        Log.i("Lista Times", "erro ao recuperar lista de times")
    }

    if(retorno != null){
        if (retorno.isSuccessful){
             time = retorno.body()

        }
    }
    return time;
}

@Preview
@Composable
fun HomeScreenPreview() {
    val navController = rememberNavController()
    HomeScreen(navController)
}


