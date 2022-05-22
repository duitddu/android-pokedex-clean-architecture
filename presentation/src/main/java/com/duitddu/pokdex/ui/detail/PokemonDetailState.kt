package com.duitddu.pokdex.ui.detail

import com.duitddu.domain.entity.PokemonDetailEntity

sealed class PokemonDetailState {
    object Loading : PokemonDetailState()
    data class Success(val pokemon: PokemonDetailEntity) : PokemonDetailState()
    object Failure : PokemonDetailState()
}