package kpfu.itis.petproject.xml2compose

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

sealed class MainGraphComposedScreen(val route: String) {
	object ListFragment: MainGraphComposedScreen("listFragment")
	object DetailsFragment: MainGraphComposedScreen("detailsFragment")
}

@ExperimentalMaterialApi
@Composable
fun NavGraph() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = MainGraphComposedScreen.ListFragment.route) { 
        composable(route = MainGraphComposedScreen.ListFragment.route, ) { ListFragmentComposed(navController) }
        composable(route = MainGraphComposedScreen.DetailsFragment.route, ) { DetailsFragmentComposed() }
    }
}
