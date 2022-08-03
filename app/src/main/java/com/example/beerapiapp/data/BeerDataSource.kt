package com.example.beerapiapp.data

import com.example.beerapiapp.domain.Beer

interface BeerDataSource {

    fun getAllBeer(): List<Beer>

}