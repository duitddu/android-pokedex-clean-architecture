package com.duitddu.pokdex.ui.navigation

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.duitddu.domain.entity.PokemonEntity

sealed class Navigation(
    val route: String
) {
    object List : Navigation("list")

    object Detail : Navigation("detail/{name}") {
        fun routeWithParam(pokemonEntity: PokemonEntity): String =
            "detail/${pokemonEntity.name}"

        val arguments = listOf<NamedNavArgument>(
            navArgument("name") { type = NavType.StringType }
        )
    }
}