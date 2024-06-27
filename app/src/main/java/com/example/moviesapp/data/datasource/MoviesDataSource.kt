package com.example.moviesapp.data.datasource

import com.example.moviesapp.data.entity.Movie
import com.example.moviesapp.data.room.MoviesDAO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MoviesDataSource(var mdao:MoviesDAO) {
    suspend fun getMovies():List<Movie> =
        withContext(Dispatchers.IO){
            return@withContext mdao.loadMovies()
        }



}