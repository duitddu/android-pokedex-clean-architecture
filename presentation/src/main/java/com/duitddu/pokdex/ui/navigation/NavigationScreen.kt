package com.duitddu.pokdex.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.duitddu.pokdex.ui.detail.PokemonDetailScreen
import com.duitddu.pokdex.ui.detail.PokemonDetailViewModel
import com.duitddu.pokdex.ui.list.PokemonListScreen
import com.duitddu.pokdex.ui.list.PokemonListViewModel

@Composable
fun NavigationScreen(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Navigation.List.route
    ) {
        composable(Navigation.List.route) {
            val viewModel: PokemonListViewModel = hiltViewModel()
            PokemonListScreen(viewModel) {
                navController.navigate(
                    Navigation.Detail.routeWithParam(it)
                )
            }
        }

        composable(
            route = Navigation.Detail.route,
            arguments = Navigation.Detail.arguments
        ) {
            val viewModel: PokemonDetailViewModel = hiltViewModel()
            PokemonDetailScreen(viewModel)
        }
    }
}