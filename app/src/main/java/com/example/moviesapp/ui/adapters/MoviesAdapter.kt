package com.example.moviesapp.ui.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesapp.R
import com.example.moviesapp.data.entity.Movie
import com.example.moviesapp.databinding.CardDesignBinding
import com.example.moviesapp.databinding.FragmentDetailsPageBinding
import com.example.moviesapp.ui.fragments.HomePageFragment
import com.example.moviesapp.ui.fragments.HomePageFragmentDirections
import com.google.android.material.snackbar.Snackbar

class MoviesAdapter(val context: Context, var listOfMovies:List<Movie>):RecyclerView.Adapter<MoviesAdapter.CardDesignHolder>() {

    inner class CardDesignHolder(var designHolder: CardDesignBinding):RecyclerView.ViewHolder(designHolder.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHolder {
        val binding:CardDesignBinding = DataBindingUtil.inflate(LayoutInflater.from(context),R.layout.card_design,parent, false)
        return CardDesignHolder(binding)
    }


    override fun onBindViewHolder(holder: CardDesignHolder, position: Int) {
        val movie = listOfMovies[position]
        val binding = holder.designHolder

        binding.movieObject = movie
        binding.cartButton.setOnClickListener {
            Snackbar.make(it,"Added ${movie.movie_name} to Cart!",Snackbar.LENGTH_SHORT).show()
        }

        binding.movieView.setOnClickListener {
            val transition = HomePageFragmentDirections.detailsTransition(movie)
            Navigation.findNavController(it).navigate(transition)
        }

        binding.imageView.setImageResource(context.resources.getIdentifier(movie.movie_image,"drawable",context.packageName))
    }

    override fun getItemCount(): Int {
        return listOfMovies.size
    }


}