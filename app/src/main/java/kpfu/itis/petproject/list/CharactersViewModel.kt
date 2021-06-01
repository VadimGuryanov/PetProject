package kpfu.itis.petproject.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import kpfu.itis.petproject.navigate.Router
import kpfu.itis.petproject.model.CharacterModel

class CharactersViewModel(
    private val model: CharacterModel,
    private val router: Router
) : ViewModel() {

    val characterStream
        get() = model.getCharacters()
                .cachedIn(viewModelScope)


    fun navigateToDetails(id: Int) {
        router.navigateToCharacterDetails(id)
    }
}
