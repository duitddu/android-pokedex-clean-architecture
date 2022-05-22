package com.duitddu.domain.di

import com.duitddu.domain.repository.PokemonRepository
import com.duitddu.domain.usecase.GetPokemonListUseCase
import com.duitddu.domain.usecase.GetPokemonUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    @Singleton
    fun provideGetPokemonListUseCase(
        pokemonRepository: PokemonRepository
    ): GetPokemonListUseCase = GetPokemonListUseCase(pokemonRepository)

    @Provides
    @Singleton
    fun provideGetPokemonUseCase(
        pokemonRepository: PokemonRepository
    ): GetPokemonUseCase = GetPokemonUseCase(pokemonRepository)
}