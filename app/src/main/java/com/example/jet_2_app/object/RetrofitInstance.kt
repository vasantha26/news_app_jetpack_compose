package com.example.jet_2_app.`object`

import com.example.jet_2_app.service.ApiService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance{
    const val BASE_URL = "https://newsapi.org/v2/"

    val api : ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient.Builder().build())
            .build()
            .create(ApiService::class.java)

    }
}