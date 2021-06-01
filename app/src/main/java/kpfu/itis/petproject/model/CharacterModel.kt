package kpfu.itis.petproject.model

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import kpfu.itis.petproject.api.Api
import kpfu.itis.petproject.api.model.Character
import kpfu.itis.petproject.api.paging.CharacterFlowPagingSource

class CharacterModel(
    private val api: Api
) {

    fun getCharacters(): Flow<PagingData<Character>> = Pager(
        config = PagingConfig(pageSize = PAGE_SIZE),
        pagingSourceFactory = { CharacterFlowPagingSource(api) }
    ).flow

    companion object {
        const val PAGE_SIZE = 15
    }
}
