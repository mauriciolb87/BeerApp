package com.example.beerapiapp.implementations

import android.util.Log
import com.example.beerapiapp.framework.api.BeerRestApiTask
import com.example.beerapiapp.data.BeerDataSource
import com.example.beerapiapp.domain.Beer

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

    override fun searchBeer(): List<Beer> {
        val request = beerRestApiTask.retrofitApi().searchBeer().execute()

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