package com.example.laboratorio05.repositories

import com.example.laboratorio05.data.dao.MovieDao
import com.example.laboratorio05.data.model.MovieModel

class MovieRepository(private val moviesDao: MovieDao) {


    suspend fun getMovies() = moviesDao.getAllmovies()

   suspend fun addMovies(movie: MovieModel) = moviesDao.insertMovie(movie)

   suspend fun getMoviesWithActors(id: Int) = moviesDao.getMoviesWithActorsById(id)

}