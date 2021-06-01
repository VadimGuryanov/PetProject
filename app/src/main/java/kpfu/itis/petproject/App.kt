package kpfu.itis.petproject

import android.app.Application
import kpfu.itis.petproject.di.diKodein
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware

class App : Application(), KodeinAware {

    override val kodein: Kodein by diKodein(this)

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {

        @Suppress("LateinitUsage")
        lateinit var instance: App
            private set
    }

}
