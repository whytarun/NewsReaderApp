package com.example.newsreaderapp.presentation.search

import androidx.paging.PagingData
import com.example.newsreaderapp.domain.model.Article
import kotlinx.coroutines.flow.Flow

data class SearchState(
    val searchQuery: String = "",
    val selectedCategory: String = "",
    val categories: List<String> = listOf("general", "sports", "business", "entertainment","technology"),
    val articles: Flow<PagingData<Article>>? = null
)