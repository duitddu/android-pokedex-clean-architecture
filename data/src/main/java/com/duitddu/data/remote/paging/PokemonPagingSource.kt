package com.duitddu.data.remote.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.duitddu.data.remote.api.PokemonApi
import com.duitddu.data.remote.mapper.PokemonMapper
import com.duitddu.domain.entity.PokemonEntity
import java.lang.Exception

class PokemonPagingSource(
    private val pokemonApi: PokemonApi,
    private val pokemonMapper: PokemonMapper,
    private val limit: Int
) : PagingSource<Int, PokemonEntity>() {
    override fun getRefreshKey(state: PagingState<Int, PokemonEntity>): Int? =
        state.anchorPosition

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PokemonEntity> =
        try {
            val nextPage = params.key ?: 0
            val data = pokemonApi.getPokemonList(limit, nextPage).let {
                pokemonMapper.fromResponse(it)
            }

            LoadResult.Page(
                data = data,
                prevKey = if (nextPage == 0) null else nextPage - limit,
                nextKey = if (data.isEmpty()) null else nextPage + limit
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
}