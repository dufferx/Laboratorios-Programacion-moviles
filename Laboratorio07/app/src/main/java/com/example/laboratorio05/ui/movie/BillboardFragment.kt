package com.example.laboratorio05.ui.movie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.cardview.widget.CardView
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.laboratorio05.MovieReviewerAplicattion
import com.example.laboratorio05.R
import com.example.laboratorio05.repositories.MovieRepository
import com.google.android.material.floatingactionbutton.FloatingActionButton




class billboardFragment : Fragment() {

    private lateinit var buttonNewMovie: FloatingActionButton
    private lateinit var starWarsCard: CardView

    private val viewModel: MovieViewModel by viewModels {
        MovieViewModel.Factory
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_billboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind()


        buttonNewMovie.setOnClickListener {
            it.findNavController().navigate(R.id.action_billboardFragment_to_newMovieFragment)
        }

        starWarsCard.setOnClickListener {
            it.findNavController().navigate(R.id.action_billboardFragment_to_movieFragment)
        }




    }




    private fun bind(){
        buttonNewMovie = view?.findViewById(R.id.new_movie_button) as FloatingActionButton
        starWarsCard = view?.findViewById(R.id.star_wars_card_view) as CardView


    }



}