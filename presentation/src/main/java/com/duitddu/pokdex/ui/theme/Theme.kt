package com.duitddu.pokdex.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = gray800,
    primaryVariant = gray700,
    secondary = blue700,
    secondaryVariant = teal,
    background = Color.Black,
    surface = gray900,
    error = red500,
    onPrimary = gray300,
    onSecondary = gray300,
    onBackground = gray200,
    onSurface = gray300,
    onError = red300
)

private val LightColorPalette = lightColors(
    primary = blue500,
    primaryVariant = blue800,
    secondary = blue500,
    secondaryVariant = teal,
    background = gray200,
    surface = Color.White,
    error = red500,
    onPrimary = Color.White,
    onSecondary = Color.White,
    onBackground = gray900,
    onSurface = gray800,
    onError = red500
)

@Composable
fun PokedexTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}