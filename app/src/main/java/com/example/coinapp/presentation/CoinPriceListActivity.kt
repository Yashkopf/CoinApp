package com.example.coinapp.presentation

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.coinapp.R
import com.example.coinapp.databinding.ActivityCoinPriceListBinding
import com.example.coinapp.presentation.adapters.CoinInfoAdapter

class CoinPriceListActivity : AppCompatActivity() {

    private lateinit var viewModel: CoinViewModel
    private lateinit var binding: ActivityCoinPriceListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityCoinPriceListBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val adapter = CoinInfoAdapter ( onItemClick = {
            val intent = CoinDetailActivity.newIntent(this@CoinPriceListActivity, it.fromSymbol)
            startActivity(intent)
        })
        binding.rvCoinPriceList.adapter = adapter
        initSystemBar()

        viewModel = ViewModelProvider(this)[CoinViewModel::class.java]
        viewModel.coinInfoList.observe(this) { value ->
            adapter.coinInfoList = value
        }
    }
    private fun initSystemBar() {
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
