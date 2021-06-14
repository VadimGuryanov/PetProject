package kpfu.itis.petproject.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import kpfu.itis.petproject.model.CharacterModel

class CharactersViewModel(
    private val model: CharacterModel
) : ViewModel() {

    val characterStream
        get() = model.getCharacters()
                .cachedIn(viewModelScope)
}
