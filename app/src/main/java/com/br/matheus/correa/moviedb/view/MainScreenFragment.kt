package com.br.matheus.correa.moviedb.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.br.matheus.correa.moviedb.R
import com.br.matheus.correa.moviedb.data.model.Movie
import com.br.matheus.correa.moviedb.databinding.FragmentMainScreenBinding
import com.br.matheus.correa.moviedb.view.adapter.MovieAdapter
import com.br.matheus.correa.moviedb.view.adapter.OnClickItemListener
import com.br.matheus.correa.moviedb.viewModel.MovieViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainScreenFragment : Fragment(), OnClickItemListener {

    private val TAG = "MainScreenFragment"
    private lateinit var viewBinding : FragmentMainScreenBinding
    private val movieViewModel : MovieViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentMainScreenBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        movieViewModel.getNowPlaying(resources.getString(R.string.API_KEY))
        movieViewModel.getUpComing(resources.getString(R.string.API_KEY))
        movieViewModel.getPopular(resources.getString(R.string.API_KEY))
        movieViewModel.getTopRated(resources.getString(R.string.API_KEY))

        viewBinding.rvNowPlaying.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL, false)
        viewBinding.rvUpComing.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL, false)
        viewBinding.rvPopular.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL, false)
        viewBinding.rvTopRated.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL, false)

        movieViewModel.moviesNowPlaying.observe(viewLifecycleOwner){ movies ->
            viewBinding.rvNowPlaying.adapter = movies?.let { MovieAdapter(it, this) }
        }

        movieViewModel.moviesUpComing.observe(viewLifecycleOwner){ movies ->
            viewBinding.rvUpComing.adapter = movies?.let { MovieAdapter(it, this)}
        }

        movieViewModel.moviesPopular.observe(viewLifecycleOwner){ movies ->
            viewBinding.rvPopular.adapter = movies?.let { MovieAdapter(it, this)}
        }

        movieViewModel.moviesTopRated.observe(viewLifecycleOwner){ movies ->
            viewBinding.rvTopRated.adapter = movies?.let { MovieAdapter(it,this)}
        }

        movieViewModel.requestCode.observe(viewLifecycleOwner){ requestResponse ->
            if (requestResponse.statusMessage != null){
                Toast.makeText(requireContext(), requestResponse.statusMessage, Toast.LENGTH_SHORT).show()
            }

        }


    }

    override fun onItemClick(items: Movie, position: Int) {
        val direction = MainScreenFragmentDirections.actionMainScreenFragmentToDetailScreenFragment(items)
        view?.findNavController()?.navigate(direction)
    }

}