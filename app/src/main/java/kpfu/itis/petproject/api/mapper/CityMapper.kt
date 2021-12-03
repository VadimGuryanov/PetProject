package kpfu.itis.petproject.api.mapper

import kpfu.itis.petproject.api.model.City
import query.AndroidGetCitisQuery

class CityMapper {

    fun mapCity(fragment: AndroidGetCitisQuery.City): City =
        fragment.fragments.cityGqlFragment.run {
            City(
                id = id,
                name = name,
                slug = slug,
                type = type
            )
        }
}
