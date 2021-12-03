package kpfu.itis.petproject.di

import android.app.Application
import androidx.lifecycle.ViewModelProvider
import kpfu.itis.petproject.App
import kpfu.itis.petproject.di.module.*
import kpfu.itis.petproject.utils.factory.ViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

fun diKodein(app: Application = App.instance) = Kodein.lazy {
    import(appModule(app))
    import(netModule())
    import(modelModule())
    import(viewModelModule())
    import(repModule())
    import(mapperModule())
    bind<ViewModelProvider.Factory>() with singleton { ViewModelFactory(this.dkodein) }
}
