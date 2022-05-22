package com.duitddu.domain.usecase

import com.duitddu.domain.repository.PokemonRepository
import javax.inject.Inject

class GetPokemonListUseCase @Inject constructor(
    private val pokemonRepository: PokemonRepository
) {
    operator fun invoke(
        limit: Int,
    ) = pokemonRepository.getPokemonPagingSource(limit)

}