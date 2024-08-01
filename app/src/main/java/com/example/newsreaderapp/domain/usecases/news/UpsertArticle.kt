package com.example.newsreaderapp.domain.usecases.news

import com.example.newsreaderapp.data.local.NewsDao
import com.example.newsreaderapp.domain.model.Article
import javax.inject.Inject

class UpsertArticle @Inject constructor(
    private val newsDao: NewsDao
) {

    suspend operator fun invoke(article: Article){
        newsDao.upsert(article = article)
    }

}