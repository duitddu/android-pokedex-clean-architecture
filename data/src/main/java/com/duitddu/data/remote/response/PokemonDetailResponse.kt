package com.duitddu.data.remote.response

import com.squareup.moshi.Json

data class PokemonDetailResponse(
    @field:Json(name = "id")
    val id: Int,

    @field:Json(name = "name")
    val name: String,

    @field:Json(name = "height")
    val height: Int,

    @field:Json(name = "weight")
    val weight: Int,

    @field:Json(name = "stats")
    val stats: List<PokemonStatResponse>,

    @field:Json(name = "types")
    val types: List<PokemonTypeResponse>
)

data class PokemonTypeResponse(
    @field:Json(name = "type")
    val type: PokemonTypeNameResponse,
)

data class PokemonTypeNameResponse(
    @field:Json(name = "name")
    val name: String
)

data class PokemonStatResponse(
    @field:Json(name = "base_stat")
    val baseStat: Int,

    @field:Json(name = "stat")
    val stat: PokemonStatNameResponse,
)

data class PokemonStatNameResponse(
    @field:Json(name = "name")
    val statName: String
)