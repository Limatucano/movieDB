package com.br.matheus.correa.moviedb.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
    @SerializedName("adult") val adult : Boolean,
    @SerializedName("backdrop_path") val backdropPath : String?,
    @SerializedName("genre_ids") val genreIds : List<Int>,
    @SerializedName("id") val id : Int,
    @SerializedName("original_language") val originalLanguage : String,
    @SerializedName("original_title") val originalTitle : String,
    @SerializedName("overview") val overview : String,
    @SerializedName("popularity") val popularity : Float,
    @SerializedName("poster_path") val posterPath : String?,
    @SerializedName("release_date") val releaseDate : String,
    @SerializedName("title") val title : String,
    @SerializedName("video") val video : String,
    @SerializedName("vote_average") val voteAverage : String,
    @SerializedName("vote_count") val voteCount : String,
) : Parcelable
