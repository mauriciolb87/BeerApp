package com.example.beerapp.presenter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.beerapp.R
import com.example.beerapp.domain.Beer
import kotlinx.android.synthetic.main.beer_item_layout.view.*

class BeerAdapter(private val beerList: List<Beer>): RecyclerView.Adapter<BeerViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.beer_item_layout, parent, false)
        return BeerViewHolder(view)
    }

    override fun onBindViewHolder(holder: BeerViewHolder, position: Int) {
        holder.itemView.apply {
            beerTitle.text = beerList[position].name
            beerImage.load(beerList[position].image_url) {
                placeholder(R.drawable.ic_launcher_background)
                fallback(R.drawable.ic_launcher_background)
            }
        }
    }

    override fun getItemCount(): Int = beerList.size



}