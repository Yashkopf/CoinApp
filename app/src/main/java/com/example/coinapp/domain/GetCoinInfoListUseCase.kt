package com.example.coinapp.domain

class GetCoinInfoListUseCase(

    private val repository: CoinRepository
) {
    operator fun invoke() = repository.getCoinInfoList()
}