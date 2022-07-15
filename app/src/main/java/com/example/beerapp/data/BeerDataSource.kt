package com.example.beerapp.data

import com.example.beerapp.domain.Beer

interface BeerDataSource {

    fun getAllBeer(): List<Beer>

}