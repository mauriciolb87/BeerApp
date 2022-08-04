package com.example.beerapiapp.usecase

import com.example.beerapiapp.data.BeerRepository

class BeerSearchtUseCase (private val beerRepository: BeerRepository) {

    operator fun invoke() = beerRepository.getSearchBeerFromDataSource()

}