package com.example.beerapp.presenter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.example.beerapp.R
import com.example.beerapp.domain.Beer
import com.example.beerapp.framework.viewmodel.BeerListViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var beerListViewModel: BeerListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        beerListViewModel = ViewModelProvider.NewInstanceFactory().create(BeerListViewModel::class.java)
        beerListViewModel.init()
        initObserver()
        loadingVisibility(true)
    }

    private fun initObserver() {
        beerListViewModel.beerList.observe(this) { list ->
            if (list.isNotEmpty()) {
                populateList(list)
                loadingVisibility(false)
            }
        }
    }

    private fun populateList(list: List<Beer>) {
        beerList.apply {
            hasFixedSize()
            adapter = MainAdapter(list)
        }
    }

    private fun loadingVisibility(isLoading: Boolean) {
        progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
    }

}