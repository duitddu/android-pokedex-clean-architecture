package com.duitddu.data.remote.response

import com.squareup.moshi.Json

data class PokemonListResponse(
    @field:Json(name = "results")
    val results: List<PokemonListItemResponse>
)

data class PokemonListItemResponse(
    @field:Json(name = "name")
    val name: String,

    @field:Json(name = "url")
    val url: String
) {
    val id: Int
        get() = url.split("/").dropLast(1).last().toInt()
}