package com.duitddu.domain.repository

import androidx.paging.PagingData
import com.duitddu.domain.entity.PokemonDetailEntity
import com.duitddu.domain.entity.PokemonEntity
import kotlinx.coroutines.flow.Flow

interface PokemonRepository {
    fun getPokemonPagingSource(
        limit: Int
    ) : Flow<PagingData<PokemonEntity>>

    suspend fun getPokemonDetail(name: String) : PokemonDetailEntity
}