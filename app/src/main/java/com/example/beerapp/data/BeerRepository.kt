package com.example.beerapp.data



class BeerRepository(private val beerDataSource: BeerDataSource) {

    fun getAllBeersFromDataSource() = beerDataSource.getAllBeer()

}