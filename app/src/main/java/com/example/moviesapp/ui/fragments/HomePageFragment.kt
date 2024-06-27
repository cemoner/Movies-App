package com.example.moviesapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.moviesapp.R
import com.example.moviesapp.data.entity.Movie
import com.example.moviesapp.databinding.FragmentHomePageBinding
import com.example.moviesapp.ui.adapters.MoviesAdapter
import com.example.moviesapp.ui.viewmodel.HomePageViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomePageFragment : Fragment() {
    private lateinit var binding: FragmentHomePageBinding
    private lateinit var viewModel: HomePageViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_home_page, container, false)
        binding.homePageToolBarTitle = "Movies"

        viewModel.movieList.observe(viewLifecycleOwner) {
            val moviesAdapter = MoviesAdapter(requireContext(),it)
            binding.moviesAdapter = moviesAdapter
        }

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel:HomePageViewModel by viewModels()
        viewModel = tempViewModel
    }
}