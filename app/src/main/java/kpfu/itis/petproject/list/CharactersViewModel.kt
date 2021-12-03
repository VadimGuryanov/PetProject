package kpfu.itis.petproject.list

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import kotlinx.coroutines.launch
import kpfu.itis.petproject.model.CharacterModel

class CharactersViewModel(
    private val model: CharacterModel
) : ViewModel() {

    val characterStream
        get() = model.getCharacters()
                .cachedIn(viewModelScope)

    fun fetchCities() {
        viewModelScope.launch {
            val cities = model.getCities()
            Log.e("cities", cities.toString())
        }
    }
}
