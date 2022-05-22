package com.duitddu.data.repositoryImpl

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.duitddu.data.remote.api.PokemonApi
import com.duitddu.data.remote.mapper.PokemonMapper
import com.duitddu.data.remote.paging.PokemonPagingSource
import com.duitddu.domain.entity.PokemonDetailEntity
import com.duitddu.domain.entity.PokemonEntity
import com.duitddu.domain.repository.PokemonRepository
import javax.inject.Inject

class RemotePokemonRepositoryImpl @Inject constructor(
    private val pokemonApi: PokemonApi,
    private val pokemonMapper: PokemonMapper
) : PokemonRepository {
    override suspend fun getPokemonDetail(
        name: String
    ): PokemonDetailEntity =
        pokemonMapper.fromResponse(pokemonApi.getPokemonDetail(name))

    override fun getPokemonPagingSource(
        limit: Int,
    ) = Pager(
        config = PagingConfig(50)
    ) {
        PokemonPagingSource(pokemonApi, pokemonMapper, limit)
    }.flow
}