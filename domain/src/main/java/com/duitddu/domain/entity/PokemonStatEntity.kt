package com.duitddu.domain.entity

data class PokemonStatEntity(
    val name: String,
    val stat: Int
) {
    val progress: Float
        get() = stat.div(300f)
}