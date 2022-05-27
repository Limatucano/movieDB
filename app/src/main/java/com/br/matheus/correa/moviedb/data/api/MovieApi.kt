package com.br.matheus.correa.moviedb.data.api

import com.br.matheus.correa.moviedb.data.model.Movie
import com.br.matheus.correa.moviedb.data.model.MovieDetail
import com.br.matheus.correa.moviedb.data.model.ResponseMovie
import com.br.matheus.correa.moviedb.data.model.ResponseReview
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {

    @GET("movie/now_playing")
    suspend fun getNowPlaying(
        @Query("api_key") apiKey : String,
    ) : Response<ResponseMovie>

    @GET("movie/upcoming")
    suspend fun getUpComing(
        @Query("api_key") apiKey: String
    ) : Response<ResponseMovie>

    @GET("movie/popular")
    suspend fun getPopular(
        @Query("api_key") apiKey: String
    ) : Response<ResponseMovie>

    @GET("movie/top_rated")
    suspend fun getTopRated(
        @Query("api_key") apiKey: String
    ) : Response<ResponseMovie>

    @GET("movie/{id}")
    suspend fun getDetail(
        @Path("id") id : String,
        @Query("api_key") apiKey: String
    ) : Response<MovieDetail>

    @GET("movie/{id}/reviews")
    suspend fun getReviews(
        @Path("id") id : String,
        @Query("api_key") apiKey: String
    ) : Response<ResponseReview>

    @GET("movie/{id}/similar")
    suspend fun getSimilar(
        @Path("id") id : String,
        @Query("api_key") apiKey: String
    ) : Response<ResponseMovie>
}