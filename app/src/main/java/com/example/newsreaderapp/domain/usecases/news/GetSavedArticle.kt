package com.example.newsreaderapp.domain.usecases.news


import com.example.newsreaderapp.data.local.NewsDao
import com.example.newsreaderapp.domain.model.Article
import javax.inject.Inject

class GetSavedArticle @Inject constructor(
    private val newsDao: NewsDao
) {

    suspend operator fun invoke(url: String): Article?{
        return newsDao.getArticle(url = url)
    }

}