package com.duitddu.pokdex.ui.list

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.paging.CombinedLoadStates
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.duitddu.domain.entity.PokemonEntity
import com.duitddu.pokdex.ui.common.LoadingIndicator
import com.duitddu.pokdex.ui.common.PokemonImageView
import com.duitddu.pokdex.ui.theme.PokedexColorPalette
import com.duitddu.pokdex.utils.extensions.items
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map

@Composable
fun PokemonListScreen(
    viewModel: PokemonListViewModel,
    onPokemonClick: (PokemonEntity) -> Unit
) {
    Surface(
        color = MaterialTheme.colors.surface,
        modifier = Modifier.fillMaxSize()
    ) {
        val pokemonList = viewModel.pokemonList.collectAsLazyPagingItems()
        PokemonGrid(
            pokemonList,
            onPokemonClick
        )
        PokemonListLoadStateView(pokemonList.loadState)
    }
}

@Composable
fun PokemonListLoadStateView(
    loadState: CombinedLoadStates
) {
    when {
        loadState.refresh is LoadState.Loading -> {
            LoadingIndicator()
        }
        loadState.append is LoadState.Loading -> {
            LoadingIndicator()
        }
        loadState.append is LoadState.Error -> {
            // TODO :: Show error.
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PokemonGrid(
    items: LazyPagingItems<PokemonEntity>,
    onPokemonClick: (PokemonEntity) -> Unit
) {
    LazyVerticalGrid(
        modifier = Modifier.fillMaxSize(),
        cells = GridCells.Fixed(2),
        content = {
            items(items) { pokemon ->
                if (pokemon != null) {
                    PokemonGridItem(pokemon, onPokemonClick)
                }
            }
        }
    )
}

@Composable
fun PokemonGridItem(
    pokemon: PokemonEntity,
    onPokemonClick: (PokemonEntity) -> Unit
) {
    Card(
        backgroundColor = MaterialTheme.colors.background,
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1f)
            .padding(8.dp)
            .clip(MaterialTheme.shapes.large)
            .clickable { onPokemonClick.invoke(pokemon) },
        shape = MaterialTheme.shapes.large
    ) {
        Column(
            modifier = Modifier.wrapContentWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                color = PokedexColorPalette.get(case = PokedexColorPalette.Case.PokemonNumber),
                text = "#${pokemon.id}",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp, start = 8.dp),
                textAlign = TextAlign.Start,
                style = MaterialTheme.typography.body1
            )

            PokemonImageView(
                imageUrl = pokemon.imageUrl,
                modifier = Modifier
                    .fillMaxHeight(0.7f)
                    .aspectRatio(1f)
            )
            Text(
                color = PokedexColorPalette.get(case = PokedexColorPalette.Case.PokemonName),
                text = pokemon.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.body1
            )
        }
    }
}

