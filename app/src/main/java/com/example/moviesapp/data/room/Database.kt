package com.example.moviesapp.data.room

import androidx.room.Database
import androidx.room.Entity
import androidx.room.RoomDatabase
import com.example.moviesapp.data.entity.Movie

@Database(entities = [Movie::class], version = 1)
abstract class Database:RoomDatabase() {
    abstract fun getMoviesDAO():MoviesDAO
}