package kpfu.itis.petproject.api

import kpfu.itis.petproject.api.model.Episode
import kpfu.itis.petproject.api.model.Character
import kpfu.itis.petproject.api.model.LocationDetails
import kpfu.itis.petproject.api.model.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {

    @GET("character/")
    suspend fun getCharacters(
        @Query("page") page: Int? = null
    ): Response

    @GET("episode/{ids}")
    suspend fun getEpisodes(@Path("ids") ids: String): List<Episode>

    @GET("location/{id}")
    suspend fun getLocation(@Path("id") id: String): LocationDetails

    @GET("character/{id}/")
    suspend fun getCharacter(@Path("id") id: Int): Character

}
