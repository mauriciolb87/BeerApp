package com.example.beerapp.usecase

import com.example.beerapp.data.BeerRepository

class BeerListUseCase(private val beerRepository: BeerRepository) {

    operator fun invoke() = beerRepository.getAllBeersFromDataSource()

}