package com.example.beerapp.implementations

import android.util.Log
import com.example.beerapp.framework.api.BeerRestApiTask
import com.example.beerapp.data.BeerDataSource
import com.example.beerapp.domain.Beer

class BeerDataSourceImplementation(private val beerRestApiTask: BeerRestApiTask): BeerDataSource {

    companion object {
        const val TAG = "BeerRepository"
    }

    private val beerList = arrayListOf<Beer>()


    override fun getAllBeer(): List<Beer> {
        val request = beerRestApiTask.retrofitApi().getAllBeer().execute()

        if (request.isSuccessful) {
            request.body()?.let {
                beerList.addAll(it)
            }
        } else {
            request.errorBody()?.let {
                Log.d(TAG, it.toString())
            }
        }

        return beerList
    }

}