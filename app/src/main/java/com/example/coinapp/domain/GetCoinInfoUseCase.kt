package com.example.coinapp.domain

class GetCoinInfoUseCase(

    private val repository: CoinRepository
) {

    operator fun invoke(fromSymbol: String) = repository.getCoinInfo(fromSymbol)
}