package com.duitddu.pokdex.utils

import com.duitddu.domain.entity.PokemonStatEntity

fun PokemonStatEntity.getStatName(): String =
    when(name) {
        "hp" -> "HP"
        "attack" -> "ATK"
        "defense" -> "DEF"
        "special-attack" -> "SP ATK"
        "special-defense" -> "SP DEF"
        "speed" -> "SPD"
        else -> ""
    }