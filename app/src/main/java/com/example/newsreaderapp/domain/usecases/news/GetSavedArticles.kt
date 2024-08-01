package com.example.newsreaderapp.domain.usecases.news


import com.example.newsreaderapp.data.local.NewsDao
import com.example.newsreaderapp.domain.model.Article
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSavedArticles @Inject constructor(
    private val newsDao: NewsDao
) {

    operator fun invoke(): Flow<List<Article>>{
        return newsDao.getArticles()
    }

}