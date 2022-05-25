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

    suspend fun getUpComing(apiKey: String) : Response<ResponseMovie>{

        return withContext(Dispatchers.IO){
            movieApi.getUpComing(apiKey = apiKey)
        }
    }

    suspend fun getPopular(apiKey: String) : Response<ResponseMovie>{

        return withContext(Dispatchers.IO){
            movieApi.getPopular(apiKey = apiKey)
        }
    }

    suspend fun getTopRated(apiKey: String) : Response<ResponseMovie>{

        return withContext(Dispatchers.IO){
            movieApi.getTopRated(apiKey = apiKey)
        }
    }
}