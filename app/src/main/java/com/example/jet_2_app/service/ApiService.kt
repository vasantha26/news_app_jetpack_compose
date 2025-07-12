package com.example.jet_2_app.service

import com.example.jet_2_app.model.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

//    GET https://newsapi.org/v2/top-headlines?country=us&apiKey=ded1c79efafd455ab7a478d3c48d9871
//    GET https://newsapi.org/v2/top-headlines/sources?category=sportsapiKey=ded1c79efafd455ab7a478d3c48d9871


    @GET("top-headlines")
    suspend fun getTopHeadlines(@Query("country") country: String, @Query("apiKey") apiKey: String
    ): Response<NewsResponse>


  @GET("top-headlines")
    suspend fun getTopHeadlinesCategory(
        @Query("category") category: String,
        @Query("apiKey") apiKey: String
    ): Response<NewsResponse>


}