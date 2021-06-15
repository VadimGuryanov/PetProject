package kpfu.itis.petproject.model

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kpfu.itis.petproject.api.Api
import kpfu.itis.petproject.api.model.Character
import kpfu.itis.petproject.api.model.Episode
import kpfu.itis.petproject.api.model.Location
import kpfu.itis.petproject.api.model.LocationDetails

class Repository(
    private val api: Api
) {

    fun getEpisodes(episodes: List<String>): Flow<List<Episode>> =
        flow { emit(api.getEpisodes(getIds(episodes))) }
            .flowOn(Dispatchers.IO)

    fun getLocationDetails(location: Location): Flow<LocationDetails> =
        flow { emit(api.getLocation(location.url.split('/').last())) }
            .flowOn(Dispatchers.IO)

    fun getIds(episodes: List<String>): String {
        return buildString {
            episodes.forEach {
                append(it.split('/').last() + ",")
            }
        }
    }

    fun getCharacter(userId: Int): Flow<Character> =
        flow { emit(api.getCharacter(userId)) }
            .flowOn(Dispatchers.IO)

}