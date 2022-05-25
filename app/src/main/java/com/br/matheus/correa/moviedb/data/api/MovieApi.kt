package com.br.matheus.correa.moviedb.data.api

import com.br.matheus.correa.moviedb.data.model.Movie
import com.br.matheus.correa.moviedb.data.model.ResponseMovie
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {

    @GET("movie/now_playing")
    suspend fun getNowPlaying(
        @Query("api_key") apiKey : String,
    ) : Response<ResponseMovie>
}