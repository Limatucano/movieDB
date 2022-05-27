package com.br.matheus.correa.moviedb.data.model

import com.google.gson.annotations.SerializedName

data class Review (
    @SerializedName("author") val author: String,
    @SerializedName("content") val content : String,
)