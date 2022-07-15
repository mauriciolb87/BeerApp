package com.example.beerapp.framework.api

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

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