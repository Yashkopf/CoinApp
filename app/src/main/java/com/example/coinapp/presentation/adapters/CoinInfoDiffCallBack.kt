package com.example.coinapp.presentation.adapters

import androidx.recyclerview.widget.DiffUtil
import com.example.coinapp.domain.CoinInfo

class CoinInfoDiffCallBack: DiffUtil.ItemCallback<CoinInfo>() {

    override fun areItemsTheSame(
        oldItem: CoinInfo,
        newItem: CoinInfo,
    ): Boolean {
        return oldItem.fromSymbol == newItem.fromSymbol
    }

    override fun areContentsTheSame(
        oldItem: CoinInfo,
        newItem: CoinInfo,
    ): Boolean {
       return oldItem == newItem
    }
}