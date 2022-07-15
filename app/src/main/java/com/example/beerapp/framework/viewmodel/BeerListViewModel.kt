package com.example.beerapp.framework.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.beerapp.framework.api.BeerRestApiTask
import com.example.beerapp.data.BeerRepository
import com.example.beerapp.domain.Beer
import com.example.beerapp.implementations.BeerDataSourceImplementation
import com.example.beerapp.usecase.BeerListUseCase

class BeerListViewModel: ViewModel() {

    companion object {
        const val TAG = "BeerRepository"
    }

    private val beerRestApiTask = BeerRestApiTask()
    private val beerDataSource = BeerDataSourceImplementation(beerRestApiTask)
    private val beerRepository = BeerRepository(beerDataSource)
    private val beerListUseCase = BeerListUseCase(beerRepository)

    private var _beerList = MutableLiveData<List<Beer>>()
    val beerList: LiveData<List<Beer>>
        get() = _beerList

    fun init() {
        getAllBeer()
    }

    private fun getAllBeer() {
        Thread {
            try {
                _beerList.postValue(beerListUseCase.invoke())
            } catch (exception: Exception) {
                Log.d(TAG, exception.message.toString())
            }
        }.start()
    }

}