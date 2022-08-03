package com.example.beerapiapp.framework.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class BeerRestApiTask {

    companion object {
        const val BASE_URL = "https://api.punkapi.com/v2/"
    }

    private fun beerProvider( ): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun retrofitApi(): BeerApi = beerProvider().create(BeerApi::class.java)



}