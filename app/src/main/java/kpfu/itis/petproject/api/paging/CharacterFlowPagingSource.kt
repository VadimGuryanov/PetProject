package kpfu.itis.petproject.api.paging

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import kpfu.itis.petproject.api.Api
import kpfu.itis.petproject.api.model.Character

class CharacterFlowPagingSource(
    private val api: Api
) : PagingSource<Int, Character>() {

    override fun getRefreshKey(state: PagingState<Int, Character>): Int? =
        state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Character> {
        Log.e("ee", "ee")
        val page = params.key ?: 1
        return try {
            api.getCharacters(page).results.toLoadResult(page)
        } catch (error: Exception) {
            LoadResult.Error(error)
        }
    }

    private fun List<Character>.toLoadResult(position: Int): LoadResult<Int, Character> =
        LoadResult.Page(
            data = this,
            prevKey = null,
            nextKey = if (isEmpty()) null else position + 1
        )
}
