package com.duitddu.data.di

import com.duitddu.data.remote.mapper.PokemonMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MapperModule {
    @Provides
    @Singleton
    fun providePokemonMapper(): PokemonMapper = PokemonMapper()
}