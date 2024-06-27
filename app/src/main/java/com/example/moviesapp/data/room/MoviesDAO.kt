package com.example.moviesapp.data.room

import androidx.room.Dao
import androidx.room.Query
import com.example.moviesapp.data.entity.Movie


@Dao
interface MoviesDAO {
    @Query("SELECT * FROM filmler")
    suspend fun loadMovies():List<Movie>
}