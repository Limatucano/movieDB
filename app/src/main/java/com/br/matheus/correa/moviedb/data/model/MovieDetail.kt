package com.br.matheus.correa.moviedb.data.model

import com.google.gson.annotations.SerializedName

data class MovieDetail(
    @SerializedName("runtime") val runtime : Int?,
    @SerializedName("genres") val genres : List<Genre>
)

data class Genre(
    val id : Int,
    val name : String
)