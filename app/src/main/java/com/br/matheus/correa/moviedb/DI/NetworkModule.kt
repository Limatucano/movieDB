package com.br.matheus.correa.moviedb.DI

import com.br.matheus.correa.moviedb.data.api.MovieApi
import com.br.matheus.correa.moviedb.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {


    @Singleton
    @Provides
    fun provideConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }
    @Singleton
    @Provides
    fun provideRetrofitInstance(
        gsonConverterFactory: GsonConverterFactory,
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(gsonConverterFactory)
            .build()
    }

    @Singleton
    @Provides
    fun provideMovieApiService(retrofit: Retrofit): MovieApi {
        return retrofit.create(MovieApi::class.java)
    }
}