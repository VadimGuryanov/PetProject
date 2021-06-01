package kpfu.itis.petproject.api

import kpfu.itis.petproject.api.model.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("/character")
    fun getCharacters(
        @Query("page[number]") pageNumber: Int? = null
    ): Response

}
