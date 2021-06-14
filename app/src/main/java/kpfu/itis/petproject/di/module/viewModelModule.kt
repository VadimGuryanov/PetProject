package kpfu.itis.petproject.di.module

import androidx.lifecycle.ViewModel
import kpfu.itis.petproject.details.DetailsViewModel
import kpfu.itis.petproject.list.CharactersViewModel
import kpfu.itis.petproject.splash.SplashViewModel
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider

fun viewModelModule() = Kodein.Module(name = "viewModelModule") {
    bind<ViewModel>(tag = CharactersViewModel::class.java.simpleName) with provider {
        CharactersViewModel(instance())
    }
    bind<ViewModel>(tag = SplashViewModel::class.java.simpleName) with provider {
        SplashViewModel()
    }
    bind<ViewModel>(tag = DetailsViewModel::class.java.simpleName) with provider {
        DetailsViewModel(instance())
    }
}
