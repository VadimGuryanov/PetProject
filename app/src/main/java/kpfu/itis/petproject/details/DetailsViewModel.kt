package kpfu.itis.petproject.details

import android.util.Log
import androidx.lifecycle.*
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kpfu.itis.petproject.api.model.*

class DetailsViewModel (
    private val repository: Repository
) : ViewModel() {

    private val _character = MutableStateFlow<Character?>(null)
    val character = _character.asStateFlow()

    private val _episodes = MutableStateFlow<List<Episode>>(listOf())
    val episodes = _episodes.asStateFlow()

    private val _locations = MutableStateFlow<LocationDetails?>(null)
    val locations = _locations.asStateFlow()

    fun getData(episodes: List<String>, location: Location) {
        viewModelScope.launch {
            repository.getEpisodes(episodes)
                .zip(repository.getLocationDetails(location)) { episodes, locations ->
                    Pair(episodes, locations)
                }
                .catch { Log.e("getData", it.message.toString()) }
                .collect {
                    _episodes.value = it.first
                    _locations.value = it.second
                }
        }
    }

    fun getCharacterDetails(userId: Int) {
        viewModelScope.launch {
            repository.getCharacter(userId)
                .catch { Log.e("getCharacterDetails", it.message.toString()) }
                .collect { _character.value = it }
        }
    }
}
