package com.example.coinapp.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.math.BigDecimal

@Entity(tableName = "full_price_list")
data class CoinInfoDbModel(
    @PrimaryKey
    var fromSymbol: String,
    var toSymbol: String?,
    var lastMarket: String?,
    var price: Double?,
    var lastUpdate: Long?,
    var high24hour: Double?,
    var low24hour: Double?,
    var imageUrl: String

)