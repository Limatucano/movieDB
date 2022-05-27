package com.br.matheus.correa.moviedb.view.adapter

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.br.matheus.correa.moviedb.R
import com.br.matheus.correa.moviedb.data.model.Movie
import com.br.matheus.correa.moviedb.data.model.Review
import com.br.matheus.correa.moviedb.util.Constants.URL_IMAGE
import com.bumptech.glide.Glide
import com.br.matheus.correa.moviedb.view.adapter.OnClickItemListener
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target

class CommentAdapter(private val review: List<Review>, var clickItemListener: OnClickItemListener) :
    RecyclerView.Adapter<CommentAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.comment_item, parent, false)

        return ViewHolder(view, parent.context)
    }

    override fun onBindViewHolder(holder: CommentAdapter.ViewHolder, position: Int) {
        val item = review[position]
        holder.initialize(item, clickItemListener, position)
    }

    override fun getItemCount(): Int = review.size

    class ViewHolder(itemView: View, parentContext: Context) : RecyclerView.ViewHolder(itemView) {

        val userName = itemView.findViewById<TextView>(R.id.item_comment_username)
        val comment = itemView.findViewById<TextView>(R.id.item_comment)

        fun initialize(review: Review, action: OnClickItemListener, position: Int) {
            userName.text = review.author
            comment.text = review.content
        }
    }

}