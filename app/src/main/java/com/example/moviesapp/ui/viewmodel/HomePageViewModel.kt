package com.example.moviesapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.moviesapp.data.entity.Movie
import com.example.moviesapp.data.repo.MoviesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomePageViewModel @Inject constructor(var movieRepo: MoviesRepository):ViewModel() {
    var movieList = MutableLiveData<List<Movie>>()

    init {
        getMovies()
    }


    fun getMovies() {
        CoroutineScope(Dispatchers.Main).launch {
            movieList.value = movieRepo.getMovies()
        }
    }
}