package com.duitddu.pokdex.utils

import androidx.compose.ui.graphics.Color
import com.duitddu.domain.entity.PokemonTypeEntity
import com.duitddu.pokdex.ui.theme.*

fun PokemonTypeEntity.getColor(): Color =
    when (this) {
        PokemonTypeEntity.NORMAL -> gray500
        PokemonTypeEntity.FIRE -> red500
        PokemonTypeEntity.WATER -> blue500
        PokemonTypeEntity.ELECTRIC -> yellow500
        PokemonTypeEntity.GRASS -> green500
        PokemonTypeEntity.ICE -> blue300
        PokemonTypeEntity.FIGHTING -> red400
        PokemonTypeEntity.POISON -> purple400
        PokemonTypeEntity.GROUND -> amber700
        PokemonTypeEntity.FLYING -> gray600
        PokemonTypeEntity.PSYCHIC -> purple500
        PokemonTypeEntity.BUG -> teal
        PokemonTypeEntity.ROCK -> brown500
        PokemonTypeEntity.GHOST -> purple600
        PokemonTypeEntity.DRAGON -> orange500
        PokemonTypeEntity.DARK -> gray600
        PokemonTypeEntity.STEEL -> blueGray400
        PokemonTypeEntity.FAIRY -> pink400
    }