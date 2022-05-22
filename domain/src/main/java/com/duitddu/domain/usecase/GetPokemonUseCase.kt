package com.duitddu.domain.usecase

import com.duitddu.domain.entity.PokemonDetailEntity
import com.duitddu.domain.repository.PokemonRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetPokemonUseCase @Inject constructor(
    private val pokemonRepository: PokemonRepository
) {
    suspend operator fun invoke(
        name: String
    ): PokemonDetailEntity = withContext(Dispatchers.IO) {
        pokemonRepository.getPokemonDetail(name)
    }
}