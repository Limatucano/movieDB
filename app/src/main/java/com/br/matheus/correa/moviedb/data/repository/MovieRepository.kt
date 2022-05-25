package com.br.matheus.correa.moviedb.data.repository

import com.br.matheus.correa.moviedb.data.api.MovieApi
import com.br.matheus.correa.moviedb.data.model.Movie
import com.br.matheus.correa.moviedb.data.model.ResponseMovie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject


class MovieRepository @Inject constructor(private val movieApi: MovieApi) {

    suspend fun getNowPlaying(apiKey : String) : Response<ResponseMovie>{

        return withContext(Dispatchers.IO){
            movieApi.getNowPlaying(apiKey = apiKey)
        }
    }
}