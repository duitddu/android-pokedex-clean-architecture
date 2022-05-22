package com.duitddu.data.remote.mapper

import com.duitddu.data.remote.response.PokemonDetailResponse
import com.duitddu.data.remote.response.PokemonListItemResponse
import com.duitddu.data.remote.response.PokemonListResponse
import com.duitddu.data.remote.response.PokemonTypeResponse
import com.duitddu.domain.entity.PokemonDetailEntity
import com.duitddu.domain.entity.PokemonEntity
import com.duitddu.domain.entity.PokemonStatEntity
import com.duitddu.domain.entity.PokemonTypeEntity

class PokemonMapper {

    fun fromResponse(
        response: PokemonDetailResponse
    ): PokemonDetailEntity = PokemonDetailEntity(
        response.id,
        response.name,
        response.id.toPokemonImageUrl(),
        response.weight,
        response.height,
        response.stats.map { PokemonStatEntity(it.stat.statName, it.baseStat) },
        response.types.map { it.findEntity() }
    )

    fun fromResponse(
        response: PokemonListResponse
    ): List<PokemonEntity> = response.results.map { fromResponse(it) }

    fun fromResponse(
        response: PokemonListItemResponse
    ) : PokemonEntity = PokemonEntity(
        response.id,
        response.name,
        response.id.toPokemonImageUrl()
    )

    private fun Int.toPokemonImageUrl(): String =
        POKEMON_IMAGE_BASE_URL + String.format("%03d.png", this)

    private fun PokemonTypeResponse.findEntity(): PokemonTypeEntity =
        PokemonTypeEntity.values().find { it.type == type.name } ?: PokemonTypeEntity.NORMAL

    companion object {
        private const val POKEMON_IMAGE_BASE_URL = "https://assets.pokemon.com/assets/cms2/img/pokedex/detail/"
    }
}