package com.example.coinapp.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.coinapp.R
import com.example.coinapp.databinding.ActivityCoinDetailBinding
import com.example.coinapp.databinding.FragmentCoinDetailBinding
import com.squareup.picasso.Picasso
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.Locale

class CoinDetailFragment : Fragment() {

    private lateinit var viewModel: CoinViewModel

    private var _binding: FragmentCoinDetailBinding? = null
    private val binding: FragmentCoinDetailBinding
        get() = _binding ?: throw RuntimeException("FragmentCoinDetailBinding is null")


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentCoinDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val fromSymbol = getSymbol()
        viewModel = ViewModelProvider(this)[CoinViewModel::class.java]
        viewModel.getDetailInfo(fromSymbol).observe(viewLifecycleOwner, Observer {
            val priceFormat = DecimalFormat("#,###.##", DecimalFormatSymbols(Locale.US))
            binding.tvPrice.text = priceFormat.format(it.price)
            binding.tvMinDealPrice.text = priceFormat.format(it.low24hour)
            binding.tvMaxDealPrice.text = priceFormat.format(it.high24hour)
            binding.tvLastDealMarket.text = it.lastMarket
            binding.tvLastTimeUpdate.text = it.lastUpdate
            binding.tvFromSymbols.text = it.fromSymbol
            binding.tvToSymbols.text = it.toSymbol
            Picasso.get().load(it.imageUrl).into(binding.ivDetailLogo)
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun getSymbol(): String {
        return requireArguments().getString(EXTRA_FROM_SYMBOL, "")
    }

    companion object {
       private const val EXTRA_FROM_SYMBOL = "fSym"

        fun newInstance (fromSymbol: String): Fragment{
            return CoinDetailFragment().apply {
                arguments = Bundle().apply {
                    putString(EXTRA_FROM_SYMBOL, fromSymbol)
                }
            }
        }
    }
}
