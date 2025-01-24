package com.example.coinapp.presentation.adapters

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.coinapp.R
import com.example.coinapp.databinding.ItemCoinInfoBinding
import com.example.coinapp.domain.CoinInfo
import com.example.coinapp.presentation.adapters.CoinInfoViewHolder
import com.squareup.picasso.Picasso
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.Locale


class CoinInfoAdapter(private val onItemClick: (CoinInfo) -> Unit) :
    ListAdapter<CoinInfo, CoinInfoViewHolder>
        (
        CoinInfoDiffCallBack()
    ) {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ) = CoinInfoViewHolder(
        ItemCoinInfoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )


    @SuppressLint("DefaultLocale")
    override fun onBindViewHolder(
        holder: CoinInfoViewHolder,
        position: Int,
    ) {
        val coin = getItem(position)
        holder.binding.apply {
            val symbolsTemplate = root.context.getString(R.string.symbols_template)
            val lasUpdateTemplate = root.context.getString(R.string.last_update_template)
            val formatPrice = DecimalFormat("#,###.##$", DecimalFormatSymbols(Locale.US))
            tvSymbols.text = String.format(symbolsTemplate, coin.fromSymbol, coin.toSymbol)
            tvPrice.text = formatPrice.format(coin.price)
            tvTimeUpdate.text = String.format(lasUpdateTemplate, (coin.lastUpdate))
            Picasso.get().load(coin.imageUrl).into(ivCoinLogo)
            root.setOnClickListener {
                onItemClick(coin)
            }
        }
        Log.e("gere", "$coin")
    }
}