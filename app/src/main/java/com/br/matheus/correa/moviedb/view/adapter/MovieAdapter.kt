package com.br.matheus.correa.moviedb.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.br.matheus.correa.moviedb.R
import com.br.matheus.correa.moviedb.data.model.Movie
import com.br.matheus.correa.moviedb.util.Constants.URL_IMAGE
import com.bumptech.glide.Glide
import com.br.matheus.correa.moviedb.view.adapter.OnClickItemListener

class MovieAdapter(private val movies : List<Movie>, var clickItemListener : OnClickItemListener) : RecyclerView.Adapter<MovieAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_item,parent, false)

        return ViewHolder(view,parent.context)
    }

    override fun onBindViewHolder(holder: MovieAdapter.ViewHolder, position: Int) {
        val item = movies[position]
        holder.initialize(item,clickItemListener,position)
    }

    override fun getItemCount(): Int = movies.size

    class ViewHolder(itemView: View, parentContext: Context) : RecyclerView.ViewHolder(itemView){

        val bannerMovie = itemView.findViewById<ImageView>(R.id.bannerMovie)

        fun initialize(movie : Movie, action: OnClickItemListener, position: Int){
            val imageUrl = "${URL_IMAGE}${movie.posterPath}"
            Glide.with(itemView.context).load(imageUrl).into(bannerMovie)
            itemView.setOnClickListener {
                action.onItemClick(movie,position)
            }
        }
    }

}