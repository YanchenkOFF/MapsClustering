package com.example.mapsclustering

import android.app.Application
import com.example.mapsclustering.data.BankRepositoryImpl
import com.example.mapsclustering.data.BelarusbankBankAPI
import com.example.mapsclustering.domain.BankRepository

class App : Application() {
    companion object {
        lateinit var bankRepository: BankRepository
            private set
    }

    override fun onCreate() {
        super.onCreate()
        initBankApiService()
    }

    private fun initBankApiService() {
        bankRepository = BankRepositoryImpl(BelarusbankBankAPI.createService())
    }
}