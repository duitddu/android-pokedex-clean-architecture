package com.duitddu.pokdex.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

object PokedexColorPalette {
    enum class Case(
        val light: Color,
        val dark: Color
    ) {
        Default(
            light = Color.Black,
            dark = Color.White
        ),
        PokemonNumber(
            light = Color.Black,
            dark = Color.White
        ),
        PokemonName(
            light = Color.Black,
            dark = Color.White
        ),
        PokemonPhysicalName(
            light = Color.Black,
            dark = Color.White
        ),
        PokemonPhysicalValue(
            light = Color.Black,
            dark = Color.White
        ),
        PokemonStatName(
            light = Color.Black,
            dark = Color.White
        ),
        PokemonStatProgress(
            light = red300.copy(alpha = 0.3f),
            dark = blue300.copy(alpha = 0.3f)
        ),
        PokemonStatProgressValue(
            light = red500,
            dark = blue500
        ),
    }

    @Composable
    fun get(darkTheme: Boolean = isSystemInDarkTheme(), case: Case) : Color =
        if (darkTheme) case.dark else case.light
}