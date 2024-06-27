package com.example.moviesapp.di

import android.content.Context
import androidx.room.Room
import com.example.moviesapp.data.datasource.MoviesDataSource
import com.example.moviesapp.data.repo.MoviesRepository
import com.example.moviesapp.data.room.Database
import com.example.moviesapp.data.room.MoviesDAO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideMoviesDataSource(moviesDAO: MoviesDAO): MoviesDataSource {
        return MoviesDataSource(moviesDAO)
    }

    @Provides
    @Singleton
    fun provideMoviesRepository(mds:MoviesDataSource): MoviesRepository {
        return MoviesRepository(mds)
    }
    @Provides
    @Singleton
    fun provideMoviesDao(@ApplicationContext context: Context): MoviesDAO {
        val db = Room.databaseBuilder(context, Database::class.java,"filmler_app.sqlite").createFromAsset("filmler_app.sqlite").build()
        return db.getMoviesDAO()
    }
}