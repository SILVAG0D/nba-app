import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.media3.common.util.Log
import androidx.media3.common.util.UnstableApi
import com.example.nba.data.service.helpers.RetrofitHelper
import com.example.nba.data.service.model.TimeModel
import com.example.nba.data.service.model.TimesModel
import kotlinx.coroutines.launch
import retrofit2.Response

class TeamsListViewModel : ViewModel() {

    private val apikey = "89998ad4-7af2-4e0e-befb-4f345f0bdded"

    private val _teams = MutableLiveData<List<TimeModel>?>()
    val teams: LiveData<List<TimeModel>?> = _teams

    private val retrofit by lazy {
        RetrofitHelper.retrofit
    }

    @UnstableApi
    fun fetchTeams() {





        viewModelScope.launch {
            try {
                Log.d("TeamsListViewModel", "Iniciando a chamada para buscar os times.")
                val response = retrofit.getTeams(apikey)

                if (response.isSuccessful) {
                    val teamsResponse = response.body()
                    _teams.value = teamsResponse!!.data

                    Log.d("TeamsListViewModel", "Times recebidos com sucesso: ${_teams.value}")
                } else {
                    Log.d("TeamsListViewModel", "Falha na resposta da API: ${response.errorBody()}")
                }

            } catch (e: Exception) {
                Log.e("TeamsListViewModel", "Erro ao buscar os times: ${e.message}")
                e.printStackTrace()
            }
        }
    }
}
