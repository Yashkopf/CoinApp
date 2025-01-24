package com.example.coinapp.data.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CoinNameListDto (
    @SerializedName("Data")
    @Expose
    val names: List<CoinNameContainerDto>? = null
)