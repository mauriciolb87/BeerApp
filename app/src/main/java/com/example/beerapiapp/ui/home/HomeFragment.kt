package com.example.beerapiapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.beerapiapp.R
import com.example.beerapiapp.databinding.HomeFragmentBinding
import com.example.beerapiapp.domain.Beer
import com.example.beerapiapp.framework.viewmodel.BeerListViewModel
import com.example.beerapiapp.ui.adapter.MainAdapter
import com.example.beerapiapp.ui.details.DetailsFragment
import kotlinx.android.synthetic.main.beer_item_layout.view.*
import kotlinx.android.synthetic.main.home_fragment.*

class HomeFragment : Fragment()  {

    private lateinit var beerListViewModel: BeerListViewModel
    private lateinit var _binding: HomeFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = HomeFragmentBinding.inflate(inflater)

        beerListViewModel = ViewModelProvider.NewInstanceFactory().create(BeerListViewModel::class.java)
        beerListViewModel.init()
        initObserver()


        return _binding.root
    }

    private fun initObserver() {
        beerListViewModel.beerList.observe(viewLifecycleOwner) { list ->
            if (list.isNotEmpty()) {
                populateList(list)
            }
        }
    }

    private fun populateList(list: List<Beer>) {
        beerList.apply {
            hasFixedSize()
            adapter = MainAdapter(list)
        }
    }



}