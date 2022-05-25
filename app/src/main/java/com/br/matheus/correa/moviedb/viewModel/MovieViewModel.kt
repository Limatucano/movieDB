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
    val moviesUpComing = MutableLiveData<List<Movie>?>()
    val moviesPopular = MutableLiveData<List<Movie>?>()
    val moviesTopRated = MutableLiveData<List<Movie>?>()

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

    fun getUpComing(apiKey: String){
        try {
            viewModelScope.launch(Dispatchers.IO) {
                val response = movieRepository.getUpComing(apiKey)

                requestCode.postValue(response.code())
                if(response.isSuccessful){
                    val responseBody = response.body()
                    moviesUpComing.postValue(responseBody?.results)
                }

            }
        }catch (exception : Exception){
            requestCode.postValue(HttpURLConnection.HTTP_INTERNAL_ERROR)
        }
    }

    fun getPopular(apiKey: String){
        try {
            viewModelScope.launch(Dispatchers.IO) {
                val response = movieRepository.getPopular(apiKey)

                requestCode.postValue(response.code())
                if(response.isSuccessful){
                    val responseBody = response.body()
                    moviesPopular.postValue(responseBody?.results)
                }

            }
        }catch (exception : Exception){
            requestCode.postValue(HttpURLConnection.HTTP_INTERNAL_ERROR)
        }
    }

    fun getTopRated(apiKey: String){
        try {
            viewModelScope.launch(Dispatchers.IO) {
                val response = movieRepository.getTopRated(apiKey)

                requestCode.postValue(response.code())
                if(response.isSuccessful){
                    val responseBody = response.body()
                    moviesTopRated.postValue(responseBody?.results)
                }

            }
        }catch (exception : Exception){
            requestCode.postValue(HttpURLConnection.HTTP_INTERNAL_ERROR)
        }
    }

}