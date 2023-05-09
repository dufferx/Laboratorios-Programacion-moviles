package com.example.laboratorio05.ui.billboard.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.example.laboratorio05.data.model.MovieModel
import com.example.laboratorio05.databinding.ItemMovieBinding

class MovieRecylcerViewHolder(private val binding: ItemMovieBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(movie: MovieModel, clickListener: (MovieModel)-> Unit) {
        binding.movieName.text = movie.name
        binding.calificationTextView.text = movie.qualification

        binding.movieItemCardView.setOnClickListener {
            clickListener(movie)
        }
    }
}