package com.example.beerapiapp.ui.adapter

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.FragmentManager
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.bumptech.glide.Glide
import com.example.beerapiapp.R
import com.example.beerapiapp.domain.Beer
import com.example.beerapiapp.ui.ViewHolder
import com.example.beerapiapp.ui.details.DetailsFragment
import com.example.beerapiapp.ui.main.MainActivity
import kotlinx.android.synthetic.main.beer_item_layout.view.*
import kotlinx.android.synthetic.main.details_fragment.view.*

class MainAdapter(private val beerList: List<Beer> ): RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.beer_item_layout, parent, false)
        return ViewHolder(view)
    }

   override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.apply {
            holder.title.text = beerList[position].name

              Glide.with(context)
                .load(beerList[position].image_url)
                .placeholder(R.drawable.ic_launcher_background)
                .fallback(R.drawable.ic_launcher_background)
                .into(holder.image)

            beerPoster.setOnClickListener {

                  val bundle = Bundle()
                bundle.putString("name", beerList[position].name)
                bundle.putString("image_url", beerList[position].image_url)
                bundle.putString("tagline", beerList[position].tagline)
                bundle.putString("description", beerList[position].description)

                findNavController().navigate(R.id.fromHomeFragmentToDetailsFragment, bundle)

            }
        }
    }

    override fun getItemCount(): Int = beerList.size

}