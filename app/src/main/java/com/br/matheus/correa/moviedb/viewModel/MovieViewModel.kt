package com.br.matheus.correa.moviedb.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.br.matheus.correa.moviedb.data.model.Movie
import com.br.matheus.correa.moviedb.data.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.net.HttpURLConnection
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor( private val movieRepository: MovieRepository ) : ViewModel() {

    val requestCode = MutableLiveData<Int>()
    val moviesNowPlaying = MutableLiveData<List<Movie>?>()

    fun getNowPlaying(apiKey: String){
        try {
            viewModelScope.launch(Dispatchers.IO) {
                val response = movieRepository.getNowPlaying(apiKey)

                requestCode.postValue(response.code())
                if(response.isSuccessful){
                    val responseBody = response.body()
                    moviesNowPlaying.postValue(responseBody?.results)
                }

            }
        }catch (exception : Exception){
            requestCode.postValue(HttpURLConnection.HTTP_INTERNAL_ERROR)
        }
    }

}