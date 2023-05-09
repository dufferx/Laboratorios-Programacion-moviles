package com.example.laboratorio05.ui.movie

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.laboratorio05.R
import com.example.laboratorio05.data.model.MovieModel
import com.example.laboratorio05.databinding.FragmentBillboardBinding
import com.example.laboratorio05.ui.billboard.recyclerview.MovieRecylcerViewHolder
import com.example.laboratorio05.ui.billboard.recyclerview.MoviesAdapter
import com.example.laboratorio05.ui.movie.viewmodel.MovieViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton


class billboardFragment : Fragment() {

    private val viewModel: MovieViewModel by activityViewModels {
        MovieViewModel.Factory
    }

    private lateinit var adapter: MoviesAdapter

    private lateinit var binding: FragmentBillboardBinding



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBillboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setRecyclerView(view)

        binding.newMovieButton.setOnClickListener {
            viewModel.clearData()
            it.findNavController().navigate(R.id.action_billboardFragment_to_newMovieFragment)
        }
    }

    private fun setRecyclerView(view: View){
        binding.recyclerMovies.layoutManager = LinearLayoutManager(view.context)

        adapter = MoviesAdapter { selectedMovie ->
            showSelectedItem(selectedMovie)

        }

        binding.recyclerMovies.adapter = adapter
        displayMovies()

    }

    private fun displayMovies(){
        adapter.setData(viewModel.getMovies())
        adapter.notifyDataSetChanged()
    }

    private fun showSelectedItem(movie: MovieModel){
        viewModel.setSelectedMovie(movie)
        Log.d("PUTA2",viewModel.name.value!!)
  findNavController().navigate(R.id.action_billboardFragment_to_movieFragment)
    }









}