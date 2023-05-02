package com.example.laboratorio05.ui.movie

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.laboratorio05.R
import com.example.laboratorio05.data.model.MovieModel

class MoviesAdapter:RecyclerView.Adapter<MoviesAdapter.ViewHolderMovie>(){
    
    
    private var movies: List<MovieModel>? = null
    
    class ViewHolderMovie(itemView: View):RecyclerView.ViewHolder(itemView) {
        
        fun bind(movie: MovieModel){
            itemView.findViewById<TextView>(R.id.movie_name).text = movie.name
            itemView.findViewById<TextView>(R.id.calification_text_view).text = movie.qualification
        }
        
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderMovie {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_movie, parent, false)
        
        
        return ViewHolderMovie(view)
            
    }

    override fun getItemCount(): Int = movies?.size ?: 0

    override fun onBindViewHolder(holder: ViewHolderMovie, position: Int) {
       movies?.let {
           holder.bind(it[position])
       } 
    }
    
    fun submitData(movies : List<MovieModel>) {
        this.movies = movies
        notifyDataSetChanged()
    }


}