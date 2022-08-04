package com.example.beerapiapp.usecase

import com.example.beerapiapp.data.BeerRepository

class BeerListUseCase(private val beerRepository: BeerRepository) {

    operator fun invoke() = beerRepository.getAllBeersFromDataSource()

}