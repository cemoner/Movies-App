package com.example.moviesapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import com.example.moviesapp.R
import com.example.moviesapp.databinding.FragmentDetailsPageBinding
import com.example.moviesapp.databinding.FragmentHomePageBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class DetailsPageFragment : Fragment() {
    private lateinit var binding: FragmentDetailsPageBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_details_page, container, false)

        val bundle: DetailsPageFragmentArgs by navArgs()
        val movie = bundle.movie
        binding.movieObject = movie
        binding.ivMovie.setImageResource(resources.getIdentifier(movie.movie_image,"drawable",requireContext().packageName))


        return binding.root
    }
}