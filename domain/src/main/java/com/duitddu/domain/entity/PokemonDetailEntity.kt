package com.duitddu.domain.entity

data class PokemonDetailEntity(
    val id: Int,
    val name: String,
    val imageUrl: String,
    val weight: Int,
    val height: Int,
    val stats: List<PokemonStatEntity>,
    val types: List<PokemonTypeEntity>
)