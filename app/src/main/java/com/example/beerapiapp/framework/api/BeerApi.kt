package com.example.beerapiapp.framework.api

import com.example.beerapiapp.domain.Beer
import retrofit2.Call
import retrofit2.http.GET

interface BeerApi {

    @GET("beers")
    fun getAllBeer(): Call<List<Beer>>

}