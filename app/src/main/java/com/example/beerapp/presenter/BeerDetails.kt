package com.example.beerapp.presenter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.beerapp.R
import com.example.beerapp.domain.Beer
import kotlinx.android.synthetic.main.beer_item_layout.view.*

class BeerDetails