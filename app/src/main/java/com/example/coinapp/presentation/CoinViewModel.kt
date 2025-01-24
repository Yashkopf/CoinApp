package com.example.coinapp.presentation

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.example.coinapp.data.network.ApiFactory
import com.example.coinapp.data.database.AppDataBase
import com.example.coinapp.data.mapper.CoinMapper
import com.example.coinapp.data.network.model.CoinInfoDto
import com.example.coinapp.data.network.model.CoinInfoJsonContainerDto
import com.example.coinapp.data.repository.CoinRepositoryImpl
import com.example.coinapp.domain.CoinRepository
import com.example.coinapp.domain.GetCoinInfoListUseCase
import com.example.coinapp.domain.GetCoinInfoUseCase
import com.example.coinapp.domain.LoadDataUseCase
import com.google.gson.Gson
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit

class CoinViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = CoinRepositoryImpl(application)

    private val getCoinInfoUseCase = GetCoinInfoUseCase(repository)
    private val getCoinInfoListUseCase = GetCoinInfoListUseCase(repository)
    private val LoadDataUseCase = LoadDataUseCase(repository)

    val coinInfoList = getCoinInfoListUseCase()

    fun getDetailInfo(fSym: String) = getCoinInfoUseCase(fSym)

    init {
        viewModelScope.launch {
            LoadDataUseCase()
        }
    }
}
