package com.duitddu.pokdex.ui.detail

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.duitddu.domain.entity.PokemonEntity
import com.duitddu.domain.usecase.GetPokemonUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    arguments: SavedStateHandle,
    private val getPokemonUseCase: GetPokemonUseCase
) : ViewModel() {
    private val _uiState: MutableState<PokemonDetailState> = mutableStateOf(PokemonDetailState.Loading)
    val uiState: State<PokemonDetailState> = _uiState

    init {
        arguments.get<String>("name")?.let { loadPokemon(it) }
    }

    private fun loadPokemon(name: String?) {
        if (!name.isNullOrEmpty()) {
            viewModelScope.launch(Dispatchers.Main) {
                runCatching {
                    getPokemonUseCase.invoke(name)
                }.onSuccess {
                    _uiState.value = PokemonDetailState.Success(it)
                }.onFailure {
                    _uiState.value = PokemonDetailState.Failure
                }
            }
        } else {
            _uiState.value = PokemonDetailState.Failure
        }
    }
}