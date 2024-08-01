package com.example.newsreaderapp.presentation.bookmark

import com.example.newsreaderapp.domain.model.Article


data class BookmarkState(
    val articles: List<Article> = emptyList()
)