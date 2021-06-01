package kpfu.itis.petproject.api.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import kpfu.itis.petproject.api.Api
import kpfu.itis.petproject.api.model.Character

class CharacterFlowPagingSource(
    private val api: Api
) : PagingSource<Int, Character>() {

    private var lastMonth = -1

    override fun getRefreshKey(state: PagingState<Int, Character>): Int? =
        state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Character> {
        val page = params.key ?: 1
        if (page == 1) clearLastMonth()
        return try {
            api.getCharacters(page).results.toLoadResult(page)
        } catch (error: Exception) {
            LoadResult.Error(error)
        }
    }

    private fun clearLastMonth() {
        lastMonth = -1
    }

    private fun List<Character>.toLoadResult(position: Int): LoadResult<Int, Character> =
        LoadResult.Page(
            data = this,
            prevKey = null,
            nextKey = if (isEmpty()) null else position + 1
        )
}
