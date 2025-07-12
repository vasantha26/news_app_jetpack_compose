package com.example.jet_2_app.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jet_2_app.model.Articles
import com.example.jet_2_app.repository.NewsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class NewsViewModel : ViewModel() {

     val API_KEY = "ded1c79efafd455ab7a478d3c48d9871"

    private val repository =  NewsRepository()

    private val _newsResponse = MutableStateFlow<List<Articles>>(emptyList())
    val newsResponse : StateFlow<List<Articles>> = _newsResponse


  private val _newsResponseCategory = MutableStateFlow<List<Articles>>(emptyList())
    val newsResponseCategory : StateFlow<List<Articles>> = _newsResponseCategory

    private  val _isLoading  = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    init {
        fetchNews()
    }

    private fun fetchNews(){
        viewModelScope.launch {
            _isLoading.value = true

            val response = repository.getTopHeadlines(country = "us", apiKey = API_KEY)

            response.let {
                Log.d("AllScreen", "Article: ${it?.articles}")

                _newsResponse.value = it?.articles ?: emptyList()
                _isLoading.value = false

            }
        }
    }

     fun fetchCategory(category: String) {
         Log.d("AllScreen", "getTopHeadlinesCategory 1 : ${category}")

         viewModelScope.launch {
             _isLoading.value = true
            val response = repository.getTopHeadlinesCategory(category = category, apiKey = API_KEY)

            response.let {
                Log.d("AllScreen", "getTopHeadlinesCategory: ${it?.articles}")

                _newsResponseCategory.value = it?.articles ?: emptyList()
                _isLoading.value = false
            }
        }
    }





}