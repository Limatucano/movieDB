package com.br.matheus.correa.moviedb.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.br.matheus.correa.moviedb.data.model.Movie
import com.br.matheus.correa.moviedb.data.model.MovieDetail
import com.br.matheus.correa.moviedb.data.repository.MovieRepository
import com.br.matheus.correa.moviedb.util.NetworkResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONObject
import java.net.HttpURLConnection
import javax.inject.Inject


@HiltViewModel
class MovieViewModel @Inject constructor( private val movieRepository: MovieRepository ) : ViewModel() {

    private val INTERNAL_ERROR_MESSAGE = "Internal server error"

    val requestCode = MutableLiveData<NetworkResponse>()
    val moviesNowPlaying = MutableLiveData<List<Movie>?>()
    val moviesUpComing = MutableLiveData<List<Movie>?>()
    val moviesPopular = MutableLiveData<List<Movie>?>()
    val moviesTopRated = MutableLiveData<List<Movie>?>()
    val movieDetail = MutableLiveData<MovieDetail?>()
    val moviesSimilar = MutableLiveData<List<Movie>?>()

    fun getNowPlaying(apiKey: String){
        try {
            viewModelScope.launch(Dispatchers.IO) {
                val response = movieRepository.getNowPlaying(apiKey)
                val responseBody = response.body()

                if(response.isSuccessful){
                    moviesNowPlaying.postValue(responseBody?.results)
                }else{
                    readBodyError(response.errorBody()?.string())
                }

            }
        }catch (exception : Exception){
            requestCode.postValue(
                NetworkResponse(INTERNAL_ERROR_MESSAGE, HttpURLConnection.HTTP_INTERNAL_ERROR)
            )
        }
    }

    fun getUpComing(apiKey: String){
        try {
            viewModelScope.launch(Dispatchers.IO) {
                val response = movieRepository.getUpComing(apiKey)
                val responseBody = response.body()

                if(response.isSuccessful){
                    moviesUpComing.postValue(responseBody?.results)
                }else{
                    readBodyError(response.errorBody()?.string())
                }

            }
        }catch (exception : Exception){
            requestCode.postValue(
                NetworkResponse(INTERNAL_ERROR_MESSAGE, HttpURLConnection.HTTP_INTERNAL_ERROR)
            )
        }
    }

    fun getPopular(apiKey: String){
        try {
            viewModelScope.launch(Dispatchers.IO) {
                val response = movieRepository.getPopular(apiKey)
                val responseBody = response.body()

                if(response.isSuccessful){
                    moviesPopular.postValue(responseBody?.results)
                }else{
                    readBodyError(response.errorBody()?.string())
                }

            }
        }catch (exception : Exception){
            requestCode.postValue(
                NetworkResponse(INTERNAL_ERROR_MESSAGE, HttpURLConnection.HTTP_INTERNAL_ERROR)
            )
        }
    }

    fun getTopRated(apiKey: String) {
        try {
            viewModelScope.launch(Dispatchers.IO) {
                val response = movieRepository.getTopRated(apiKey)
                val responseBody = response.body()

                if (response.isSuccessful) {
                    moviesTopRated.postValue(responseBody?.results)
                } else {
                    readBodyError(response.errorBody()?.string())
                }

            }
        } catch (exception: Exception) {
            requestCode.postValue(
                NetworkResponse(INTERNAL_ERROR_MESSAGE, HttpURLConnection.HTTP_INTERNAL_ERROR)
            )
        }
    }

    fun getDetail(movieId : String, apiKey: String){
        try {
            viewModelScope.launch(Dispatchers.IO) {
                val response = movieRepository.getDetail(movieId,apiKey)
                val responseBody = response.body()

                if (response.isSuccessful) {
                    movieDetail.postValue(responseBody)
                } else {
                    readBodyError(response.errorBody()?.string())
                }

            }
        } catch (exception: Exception) {
            requestCode.postValue(
                NetworkResponse(INTERNAL_ERROR_MESSAGE, HttpURLConnection.HTTP_INTERNAL_ERROR)
            )
        }
    }

    fun getSimilar(movieId : String, apiKey: String){
        try {
            viewModelScope.launch(Dispatchers.IO) {
                val response = movieRepository.getSimilar(movieId,apiKey)
                val responseBody = response.body()

                if (response.isSuccessful) {
                    moviesSimilar.postValue(responseBody?.results)
                } else {
                    readBodyError(response.errorBody()?.string())
                }

            }
        } catch (exception: Exception) {
            requestCode.postValue(
                NetworkResponse(INTERNAL_ERROR_MESSAGE, HttpURLConnection.HTTP_INTERNAL_ERROR)
            )
        }
    }

    private fun readBodyError(errorBody: String?) = errorBody?.let{
        val objError = JSONObject(errorBody)
        requestCode.postValue(
            NetworkResponse(objError.getString("status_message"), objError.getInt("status_code"))
        )
    }

}