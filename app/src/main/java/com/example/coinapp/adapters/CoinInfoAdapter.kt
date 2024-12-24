package com.example.coinapp.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.coinapp.CoinInfoViewHolder
import com.example.coinapp.R
import com.example.coinapp.databinding.ItemCoinInfoBinding
import com.example.coinapp.pojo.CoinPriceInfo
import com.squareup.picasso.Picasso
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.Locale


class CoinInfoAdapter(private val onItemClick: (CoinPriceInfo) -> Unit) : RecyclerView.Adapter<CoinInfoViewHolder>() {


    var coinInfoList: List<CoinPriceInfo> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ) = CoinInfoViewHolder(
        ItemCoinInfoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )


    @SuppressLint("DefaultLocale")
    override fun onBindViewHolder(
        holder: CoinInfoViewHolder,
        position: Int
    ) {
        val coin = coinInfoList[position]
        holder.binding.apply {
            val symbolsTemplate = root.context.getString(R.string.symbols_template)
            val lasUpdateTemplate = root.context.getString(R.string.last_update_template)
            val priceFormat = DecimalFormat("#,###.##$", DecimalFormatSymbols(Locale.US))
            tvSymbols.text = String.format(symbolsTemplate, coin.fromSymbol, coin.toSymbol)
            tvPrice.text = priceFormat.format(coin.price)
            tvTimeUpdate.text = String.format(lasUpdateTemplate, coin.getFormattedTime())
            Picasso.get().load(coin.getFullImageUrl()).into(ivCoinLogo)
            root.setOnClickListener {
                onItemClick(coin)
            }
        }
    }

    override fun getItemCount(): Int {
        return coinInfoList.size
    }
}