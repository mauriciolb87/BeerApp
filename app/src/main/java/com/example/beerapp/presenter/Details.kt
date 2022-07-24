package com.example.beerapp.presenter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.beerapp.R
import com.example.beerapp.databinding.BeerDetailsLayoutBinding
import com.example.beerapp.domain.Beer
import com.example.beerapp.framework.viewmodel.BeerListViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.beer_item_layout.view.*

private lateinit var binding: BeerDetailsLayoutBinding

class Details : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = BeerDetailsLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras
        val beer = bundle?.get("beerData") as Beer
        binding.tvName.text = beer.name
        binding.tvDescription.text = beer.description
        binding.ivBeerImage.load(beer.image_url) {
            placeholder(R.drawable.ic_launcher_background)
            fallback(R.drawable.ic_launcher_background)
        }

    }

}