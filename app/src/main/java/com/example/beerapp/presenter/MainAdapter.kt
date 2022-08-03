package com.example.beerapp.presenter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.beerapp.R
import com.example.beerapp.domain.Beer
import kotlinx.android.synthetic.main.beer_item_layout.view.*

class MainAdapter(private val beerList: List<Beer>): RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.beer_item_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.apply {
            beerTitle.text = beerList[position].name
            beerImage.load(beerList[position].image_url) {
                placeholder(R.drawable.ic_launcher_background)
                fallback(R.drawable.ic_launcher_background)
            }
            beerPoster.setOnClickListener {
                val intent = Intent(it.context, Details::class.java)
                intent.putExtra("beerData" , beerList[position])
               // detail.putExtra("extra", beerList[position].id)
                it.context.startActivity(intent)
            }
        }
    }

    override fun getItemCount(): Int = beerList.size

}