package kpfu.itis.petproject.model

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.coroutines.await
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import kpfu.itis.petproject.api.Api
import kpfu.itis.petproject.api.mapper.CityMapper
import kpfu.itis.petproject.api.model.Character
import kpfu.itis.petproject.api.model.City
import kpfu.itis.petproject.api.paging.CharacterFlowPagingSource
import query.AndroidGetCitisQuery

class CharacterModel(
    private val api: Api,
    private val graphqlApi: ApolloClient,
    private val mapper: CityMapper
) {

    fun getCharacters(): Flow<PagingData<Character>> = Pager(
        config = PagingConfig(pageSize = PAGE_SIZE),
        pagingSourceFactory = { CharacterFlowPagingSource(api) }
    ).flow

    suspend fun getCities(): List<City> = withContext(Dispatchers.IO) {
        graphqlApi.query(AndroidGetCitisQuery())
            .await()
            .saveVehicleParams()
    }

    private fun Response<AndroidGetCitisQuery.Data>.saveVehicleParams(): List<City> =
        data?.cities.let {
            val cities = mutableListOf<City>()
            it?.forEach {
                cities.add(mapper.mapCity(it))
            }
            cities
        }

    companion object {
        const val PAGE_SIZE = 15
    }
}
