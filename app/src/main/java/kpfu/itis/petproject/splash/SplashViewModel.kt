package kpfu.itis.petproject.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kpfu.itis.petproject.navigate.Router

class SplashViewModel(
    private val router: Router
) : ViewModel() {

    fun navigateToCharacters() {
        viewModelScope.launch {
            delay(1000)
            router.navigateToCharacters()
        }
    }
}
