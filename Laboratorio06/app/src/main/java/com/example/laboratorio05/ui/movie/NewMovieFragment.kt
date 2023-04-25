package com.example.laboratorio05.ui.movie

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.laboratorio05.R
import com.example.laboratorio05.data.model.MovieModel
import com.example.laboratorio05.data.movies
import com.google.android.material.textfield.TextInputEditText

/**
 * A simple [Fragment] subclass.
 * Use the [newMovieFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class newMovieFragment : Fragment() {

    private val viewModel: MovieViewModel by viewModels {
        MovieViewModel.Factory
    }

    private lateinit var submitButton: Button
    private lateinit var addMovieName: TextInputEditText
    private lateinit var addMovieCategory: TextInputEditText
    private lateinit var addMovieDescription: TextInputEditText
    private lateinit var addMovieQualification: TextInputEditText



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_new_movie, container, false)
    }

 override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind()
        submitButton.setOnClickListener {

            val newMovie = MovieModel(addMovieName.text.toString(),addMovieCategory.text.toString(),addMovieDescription.text.toString(),addMovieQualification.text.toString())
            movies.add(newMovie)

            Log.d("NewmmovieFragment", viewModel.getMovies().toString())


          it.findNavController().navigate(R.id.action_newMovieFragment_to_billboardFragment)
        }




    }



    private fun bind(){
        submitButton = view?.findViewById(R.id.submit_button) as Button
        addMovieName = view?.findViewById(R.id.name_input_text) as TextInputEditText
        addMovieDescription = view?.findViewById(R.id.description_input_text) as TextInputEditText
        addMovieCategory = view?.findViewById(R.id.category_name_text) as TextInputEditText
        addMovieQualification = view?.findViewById(R.id.calification_input_text) as TextInputEditText

    }



}