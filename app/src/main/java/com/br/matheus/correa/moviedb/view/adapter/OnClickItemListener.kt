package com.br.matheus.correa.moviedb.view.adapter

import com.br.matheus.correa.moviedb.data.model.Movie

interface OnClickItemListener{
    fun onItemClick(items: Movie, position: Int)
}