package kpfu.itis.petproject.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SplashViewModel : ViewModel() {

    private val _navToCharacters = MutableStateFlow<Boolean>(false)
    val navToCharacters = _navToCharacters.asStateFlow()

    fun navigateToCharacters() {
        viewModelScope.launch {
            delay(1000)
            _navToCharacters.value = true
        }
    }
}
