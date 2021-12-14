package kpfu.itis.petproject.di.module

import kpfu.itis.petproject.details.Repository
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider

fun repModule() = Kodein.Module(name = "repModule") {
    bind<Repository>() with provider {
        Repository(instance())
    }
}