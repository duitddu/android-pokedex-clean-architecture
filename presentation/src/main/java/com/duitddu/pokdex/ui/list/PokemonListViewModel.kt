package com.duitddu.pokdex.ui.list

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.duitddu.domain.usecase.GetPokemonListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonListViewModel @Inject constructor(
    getPokemonListUseCase: GetPokemonListUseCase
) : ViewModel() {

    val pokemonList = getPokemonListUseCase
        .invoke(POKEMON_LIST_LIMIT)
        .cachedIn(viewModelScope)

    private val _isLoading: MutableState<Boolean> = mutableStateOf(false)
    val isLoading: State<Boolean> = _isLoading

    companion object {
        private const val POKEMON_LIST_LIMIT = 50
    }
}