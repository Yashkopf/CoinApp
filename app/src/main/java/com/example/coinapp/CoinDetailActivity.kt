package com.example.coinapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.coinapp.databinding.ActivityCoinDetailBinding
import com.squareup.picasso.Picasso
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.Locale

class CoinDetailActivity : AppCompatActivity() {

    private lateinit var viewModel: CoinViewModel
    private lateinit var binding: ActivityCoinDetailBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_coin_detail)
        binding = ActivityCoinDetailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val fromSymbol = intent.getStringExtra(EXTRA_FROM_SYMBOL)?: run{
            finish()
            return
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        viewModel = ViewModelProvider(this)[CoinViewModel::class.java]
        viewModel.getDetailInfo(fromSymbol).observe(this, Observer {
            val priceFormat = DecimalFormat("#,###.##", DecimalFormatSymbols(Locale.US))
            binding.tvPrice.text = priceFormat.format(it.price)
            binding.tvMinDealPrice.text = priceFormat.format(it.low24hour)
            binding.tvMaxDealPrice.text = priceFormat.format(it.high24hour)
            binding.tvLastDealMarket.text = it.lastMarket
            binding.tvLastTimeUpdate.text = it.getFormattedTime()
            binding.tvFromSymbols.text = it.fromSymbol
            binding.tvToSymbols.text = it.toSymbol
            Picasso.get().load(it.getFullImageUrl()).into(binding.ivDetailLogo)
        })
    }

    companion object {
       private const val EXTRA_FROM_SYMBOL = "fSym"

        fun newIntent (context: Context, fromSymbol: String): Intent{
            val intent = Intent(context, CoinDetailActivity::class.java)
            intent.putExtra(EXTRA_FROM_SYMBOL, fromSymbol)
            return intent
        }
    }
}
