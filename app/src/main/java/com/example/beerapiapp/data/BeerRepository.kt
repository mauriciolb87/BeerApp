package com.example.beerapiapp.data


class BeerRepository(private val beerDataSource: BeerDataSource) {

    fun getAllBeersFromDataSource() = beerDataSource.getAllBeer()

    fun getSearchBeerFromDataSource() = beerDataSource.searchBeer()

}