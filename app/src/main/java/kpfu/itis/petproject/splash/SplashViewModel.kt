package kpfu.itis.petproject.splash

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashViewModel : ViewModel() {

    private val _navToCharacters: MutableLiveData<Boolean> = MutableLiveData()
    val navToCharacters: LiveData<Boolean> =  _navToCharacters

    fun navigateToCharacters() {
        viewModelScope.launch {
            delay(1000)
            _navToCharacters.postValue(true)
        }
    }
}
