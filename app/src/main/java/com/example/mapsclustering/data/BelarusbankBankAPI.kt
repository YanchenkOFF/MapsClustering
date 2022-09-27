package com.example.mapsclustering.data

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private const val BASE_URL = " https://belarusbank.by/api/"

interface BelarusbankBankAPI {
    companion object {
        fun createService(): BelarusbankBankAPI {
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            val client = OkHttpClient
                .Builder()
                .addInterceptor(loggingInterceptor)
                .build()
            val retrofit = Retrofit
                .Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(BelarusbankBankAPI::class.java)
        }
    }

    @GET("atm")
    suspend fun getAllATM(): List<AtmNW>

    @GET("infobox")
    suspend fun getAllInf(): List<InfoboxNW>

}