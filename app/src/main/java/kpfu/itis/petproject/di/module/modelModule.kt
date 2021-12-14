package kpfu.itis.petproject.di.module

import kpfu.itis.petproject.model.CharacterModel
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider

fun modelModule() = Kodein.Module(name = "modelModule") {

    bind<CharacterModel>() with provider {
        CharacterModel(instance(), instance(tag = APOLLO_CLIENT), instance())
    }
}
