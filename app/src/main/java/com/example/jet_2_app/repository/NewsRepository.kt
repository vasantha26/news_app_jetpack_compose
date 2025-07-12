package com.example.jet_2_app.repository

import com.example.jet_2_app.model.NewsResponse
import com.example.jet_2_app.`object`.RetrofitInstance

class NewsRepository() {

    suspend fun getTopHeadlines(country : String,  apiKey:  String): NewsResponse? {
        val response = RetrofitInstance.api.getTopHeadlines(country = country, apiKey = apiKey)
        return if (response.isSuccessful) response.body() else null
    }

    suspend fun getTopHeadlinesCategory(category : String,  apiKey:  String): NewsResponse? {
        val response = RetrofitInstance.api.getTopHeadlinesCategory(category = category, apiKey = apiKey)
        return if (response.isSuccessful) response.body() else null
    }

}