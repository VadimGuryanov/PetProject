package kpfu.itis.petproject.navigate

import androidx.navigation.NavController
import kpfu.itis.petproject.R

class AppRouter(val navController: NavController) : Router {

    override fun navigateToCharacters() {
        navController.navigate(R.id.action_splashFragment_to_charactersFragment)
    }

    override fun navigateToCharacterDetails(id: Int) {
        
    }
}
