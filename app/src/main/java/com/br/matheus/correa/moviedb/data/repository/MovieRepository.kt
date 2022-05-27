package com.br.matheus.correa.moviedb.data.repository

import com.br.matheus.correa.moviedb.data.api.MovieApi
import com.br.matheus.correa.moviedb.data.model.Movie
import com.br.matheus.correa.moviedb.data.model.MovieDetail
import com.br.matheus.correa.moviedb.data.model.ResponseMovie
import com.br.matheus.correa.moviedb.data.model.ResponseReview
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

    suspend fun getDetail(movieId : String, apiKey: String) : Response<MovieDetail>{

        return withContext(Dispatchers.IO){
            movieApi.getDetail(id = movieId, apiKey = apiKey)
        }
    }

    suspend fun getSimilar(movieId : String, apiKey: String) : Response<ResponseMovie>{

        return withContext(Dispatchers.IO){
            movieApi.getSimilar(id = movieId, apiKey = apiKey)
        }
    }

    suspend fun getReviews(movieId : String, apiKey: String) : Response<ResponseReview>{

        return withContext(Dispatchers.IO){
            movieApi.getReviews(id = movieId, apiKey = apiKey)
        }
    }


}