package com.br.matheus.correa.moviedb.DI

import com.br.matheus.correa.moviedb.data.api.MovieApi
import com.br.matheus.correa.moviedb.data.repository.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object MovieRepositoryModule {

    @Provides
    fun provideMovieRepository(movieApi: MovieApi) : MovieRepository = MovieRepository(movieApi)
}