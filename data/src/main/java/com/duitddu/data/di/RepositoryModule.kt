package com.duitddu.data.di

import com.duitddu.data.remote.api.PokemonApi
import com.duitddu.data.remote.mapper.PokemonMapper
import com.duitddu.data.repositoryImpl.RemotePokemonRepositoryImpl
import com.duitddu.domain.repository.PokemonRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Singleton
    @Provides
    fun remotePokemonRepository(
        api: PokemonApi,
        mapper: PokemonMapper
    ) : PokemonRepository = RemotePokemonRepositoryImpl(api, mapper)
}