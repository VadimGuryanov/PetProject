package kpfu.itis.petproject.api.model

import kotlinx.coroutines.flow.Flow
import java.io.Serializable

data class ResponceEpisode(
    val info: Info,
    val results: List<Episode>
)

data class Episode(
    val air_date: String,
    val characters: List<String>,
    val created: String,
    val episode: String,
    val id: Int,
    val name: String,
    val url: String
)

data class CharacterDto(
    var character: Character,
    var episodes: List<Episode>
)