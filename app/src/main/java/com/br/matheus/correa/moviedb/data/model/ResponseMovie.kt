package com.br.matheus.correa.moviedb.data.model

data class ResponseMovie (
    val page : Int,
    val results : List<Movie>
)