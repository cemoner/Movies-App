package com.example.moviesapp.data.repo

import com.example.moviesapp.data.datasource.MoviesDataSource
import com.example.moviesapp.data.entity.Movie

class MoviesRepository(var movieDS:MoviesDataSource) {
    suspend fun getMovies():List<Movie> = movieDS.getMovies()
}