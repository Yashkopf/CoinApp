package com.example.coinapp.domain

import java.math.BigDecimal

data class CoinInfo (
    var fromSymbol: String,
    var toSymbol: String?,
    var lastMarket: String?,
    var price: Double?,
    var lastUpdate: String,
    var high24hour: Double?,
    var low24hour: Double?,
    var imageUrl: String
)