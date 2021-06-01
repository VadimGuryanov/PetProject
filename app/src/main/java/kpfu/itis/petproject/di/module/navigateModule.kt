package kpfu.itis.petproject.di.module

import android.content.Context
import androidx.navigation.NavController
import kpfu.itis.petproject.R
import kpfu.itis.petproject.navigate.AppRouter
import kpfu.itis.petproject.navigate.Router
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

fun navigateModule(context: Context) = Kodein.Module("navigateModule") {

    bind<Router>() with singleton {
        AppRouter(
            NavController(context)
        )
    }
}
