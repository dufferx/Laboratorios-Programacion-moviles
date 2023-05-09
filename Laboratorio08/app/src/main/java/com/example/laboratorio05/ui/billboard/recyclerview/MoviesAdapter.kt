package com.example.laboratorio05.ui.billboard.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.laboratorio05.R
import com.example.laboratorio05.data.model.MovieModel
import com.example.laboratorio05.databinding.ItemMovieBinding

class MoviesAdapter(
    private val clickListener: (MovieModel) -> Unit
): RecyclerView.Adapter<MovieRecylcerViewHolder>() {
    private val movies = ArrayList<MovieModel>()





    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieRecylcerViewHolder {
        val binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieRecylcerViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: MovieRecylcerViewHolder, position: Int) {
        val movie = movies[position]
        holder.bind(movie, clickListener)
    }

    fun setData(moviesList: List<MovieModel>){
        movies.clear()
        movies.addAll(moviesList)
    }
}





