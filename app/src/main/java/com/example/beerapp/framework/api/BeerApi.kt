package com.example.beerapp.framework.api

import com.example.beerapp.domain.Beer
import retrofit2.Call
import retrofit2.http.GET

interface BeerApi {

    @GET("beers")
    fun getAllBeer(): Call<List<Beer>>

}