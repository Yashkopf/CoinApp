package com.example.coinapp.data.network.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.math.BigDecimal

@Entity(tableName = "full_price_list")
data class CoinInfoDto(
    @SerializedName("TYPE")
    @Expose
    var type: String?,

    @SerializedName("MARKET")
    @Expose
    var market: String?,

    @PrimaryKey
    @SerializedName("FROMSYMBOL")
    @Expose
    var fromSymbol: String,

    @SerializedName("TOSYMBOL")
    @Expose
    var toSymbol: String?,

    @SerializedName("FLAGS")
    @Expose
    var flags: String?,

    @SerializedName("LASTMARKET")
    @Expose
    var lastMarket: String?,

    @SerializedName("MEDIAN")
    @Expose
    var median: Double?,

    @SerializedName("TOPTIERVOLUME24HOUR")
    @Expose
    var topTierVolume24Hour: Double?,

    @SerializedName("TOPTIERVOLUME24HOURTO")
    @Expose
    var topTierVolume24HourTo: Double?,

    @SerializedName("LASTTRADEID")
    @Expose
    var lastTradeId: String?,

    @SerializedName("PRICE")
    @Expose
    var price: Double?,

    @SerializedName("LASTUPDATE")
    @Expose
    var lastUpdate: Long?,

    @SerializedName("LASTVOLUME")
    @Expose
    var lastVolume: Double?,

    @SerializedName("OPENHOUR")
    @Expose
    var openHour: Double?,

    @SerializedName("VOLUME24HOUR")
    @Expose
    var volume24hour: Double?,

    @SerializedName("VOLUME24HOURTO")
    @Expose
    var volume24HourTo: Double?,

    @SerializedName("OPEN24HOUR")
    @Expose
    var open24hour: Double?,

    @SerializedName("HIGH24HOUR")
    @Expose
    var high24hour: Double?,

    @SerializedName("LOW24HOUR")
    @Expose
    var low24hour: Double?,

    @SerializedName("MKTCAP")
    @Expose
    var mktCap: Double?,

    @SerializedName("IMAGEURL")
    @Expose
    var imageUrl: String?
) {

}