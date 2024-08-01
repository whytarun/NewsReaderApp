package com.example.newsreaderapp.domain.usecases.news

data class NewsUseCases(
    val getNews: GetNews,
    val searchNews: SearchNews,
    val deleteArticle: DeleteArticle,
    val upsertArticle: UpsertArticle,
    val selectArticel :SelectArticle,
    val getSavedArticles: GetSavedArticles,
    val getSavedArticle: GetSavedArticle
)
