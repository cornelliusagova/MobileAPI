package com.example.responsimws

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitCilent {
    private const val BASE_URL = "https://latihan.aviljepara.com/"

    val instance: Api by lazy{
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofit.create(Api::class.java)
    }
}