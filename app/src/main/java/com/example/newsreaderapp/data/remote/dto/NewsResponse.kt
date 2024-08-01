package com.example.newsreaderapp.data.remote.dto

import com.example.newsreaderapp.domain.model.Article


data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)