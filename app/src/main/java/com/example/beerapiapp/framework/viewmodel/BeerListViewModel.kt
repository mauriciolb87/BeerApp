package com.example.beerapiapp.framework.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.beerapiapp.framework.api.BeerRestApiTask
import com.example.beerapiapp.data.BeerRepository
import com.example.beerapiapp.domain.Beer
import com.example.beerapiapp.implementations.BeerDataSourceImplementation
import com.example.beerapiapp.usecase.BeerListUseCase
import com.example.beerapiapp.usecase.BeerSearchtUseCase

class BeerListViewModel: ViewModel() {

    companion object {
        const val TAG = "BeerRepository"
    }

    private val beerRestApiTask = BeerRestApiTask()
    private val beerDataSource = BeerDataSourceImplementation(beerRestApiTask)
    private val beerRepository = BeerRepository(beerDataSource)
    private val beerListUseCase = BeerListUseCase(beerRepository)
    private val beerSearchUseCase = BeerSearchtUseCase(beerRepository)

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

    private fun getSearchBeer() {
        Thread {
            try {
                _beerList.postValue(beerSearchUseCase.invoke())
            } catch (exception: Exception) {
                Log.d(TAG, exception.message.toString())
            }
        }.start()
    }

}