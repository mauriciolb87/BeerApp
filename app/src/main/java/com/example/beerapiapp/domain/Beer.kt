package com.example.beerapiapp.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.io.Serializable


data class Beer(
    val id: Int,
    val name: String,
    val tagline: String,
    val image_url: String,
    val description: String,
    val alcoholByVolume: String,
    val bitterness: String,
    val foodPairing: List<String>,
    var isAvailable: Boolean
) : Serializable