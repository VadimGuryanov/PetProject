package kpfu.itis.petproject.di.module

import kpfu.itis.petproject.api.mapper.CityMapper
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.provider

fun mapperModule() = Kodein.Module(name = "mapperModule") {
    bind<CityMapper>() with provider {
        CityMapper()
    }
}
