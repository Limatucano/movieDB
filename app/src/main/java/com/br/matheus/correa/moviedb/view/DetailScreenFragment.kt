package com.br.matheus.correa.moviedb.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.br.matheus.correa.moviedb.R
import com.br.matheus.correa.moviedb.data.model.Movie
import com.br.matheus.correa.moviedb.databinding.FragmentDetailScreenBinding
import com.br.matheus.correa.moviedb.util.Constants
import com.br.matheus.correa.moviedb.view.adapter.MovieAdapter
import com.br.matheus.correa.moviedb.view.adapter.OnClickItemListener
import com.br.matheus.correa.moviedb.viewModel.MovieViewModel
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailScreenFragment : Fragment(), OnClickItemListener {

    private val TAG = "DetailScreenFragment"
    private lateinit var viewBinding : FragmentDetailScreenBinding
    private val movieViewModel : MovieViewModel by viewModels()
    private lateinit var movie : Movie

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bundle = arguments
        if (bundle == null) {
            Log.e(TAG, "Erro ao transferir dados")
            return
        }
        val args = DetailScreenFragmentArgs.fromBundle(bundle)
        movie = args.movie
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentDetailScreenBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewBinding.headerTitle.text = movie.title
        movie.posterPath?.let { loadImage(it, viewBinding.headerPoster) }
        movie.backdropPath?.let { loadImage(it, viewBinding.headerBackPoster) }
        viewBinding.headerVotes.text = requireContext().getString(R.string.voteAverageText,movie.voteAverage)
        viewBinding.sinopse.text = movie.overview

        viewBinding.headerBackButton.setOnClickListener{
            requireActivity().onBackPressed()
        }
        movieViewModel.getDetail(movie.id.toString(),resources.getString(R.string.API_KEY))
        movieViewModel.getSimilar(movie.id.toString(),resources.getString(R.string.API_KEY))

        movieViewModel.movieDetail.observe(viewLifecycleOwner){ detail ->
            detail?.runtime?.let {
                val minutos = detail.runtime.rem(60)
                val horas = (detail.runtime.minus(minutos)).div(60)
                viewBinding.headerTime.text  = requireContext().getString(R.string.timeMovie, horas, minutos)
            }

            detail?.genres?.let {
                val genresNames = it.map { it.name }
                val genres : String = genresNames.reduce { acc, genre -> "$acc - $genre"    }
                viewBinding.headerGenres.text = genres
            }
        }
        viewBinding.rvSimilar.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        movieViewModel.moviesSimilar.observe(viewLifecycleOwner){ movies ->
            viewBinding.rvSimilar.adapter = movies?.let { MovieAdapter(it, this) }
        }
    }


    private fun loadImage(endPoint: String, view: ImageView){
        Glide.with(requireContext())
            .load("${Constants.URL_IMAGE}${endPoint}")
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(view)
    }

    override fun onItemClick(items: Movie, position: Int) {
        val direction = DetailScreenFragmentDirections.actionDetailScreenFragmentSelf(items)
        view?.findNavController()?.navigate(direction)
    }


}