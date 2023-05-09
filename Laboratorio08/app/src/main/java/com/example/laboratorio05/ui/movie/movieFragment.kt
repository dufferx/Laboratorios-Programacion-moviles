package com.example.laboratorio05.ui.movie

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.laboratorio05.R
import com.example.laboratorio05.data.model.MovieModel
import com.example.laboratorio05.databinding.FragmentMovieBinding
import com.example.laboratorio05.ui.movie.viewmodel.MovieViewModel

class movieFragment : Fragment() {

    private val viewModel: MovieViewModel by activityViewModels {
        MovieViewModel.Factory
    }

    private lateinit var binding: FragmentMovieBinding



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMovieBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.name.observe(viewLifecycleOwner) { newname ->
            binding.movieNameTextView.text = newname
        }

        viewModel.category.observe(viewLifecycleOwner) { newcategory ->
            binding.movieCategoryTextView.text = newcategory
        }

        viewModel.qualification.observe(viewLifecycleOwner) { newcal ->
            binding.movieCalificationTextMovie.text = newcal
        }
        viewModel.description.observe(viewLifecycleOwner) { newdesc ->
            binding.movieDescriptionTextView.text = newdesc
        }


    }




}