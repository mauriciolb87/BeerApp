package com.example.beerapiapp.ui

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.beerapiapp.R

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    var image: ImageView = itemView.findViewById(R.id.beerImage)
    var title: TextView = itemView.findViewById(R.id.beerTitle)
    var description: TextView = itemView.findViewById(R.id.beerDescription)
}