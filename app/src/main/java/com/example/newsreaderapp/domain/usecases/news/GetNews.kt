package com.example.newsreaderapp.domain.usecases.news

import androidx.paging.PagingData
import com.example.newsreaderapp.data.remote.NewsPagingSource
import com.example.newsreaderapp.domain.model.Article
import com.example.newsreaderapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetNews @Inject constructor(private val newsRepository: NewsRepository) {
    operator fun invoke(sources: List<String>) :Flow<PagingData<Article>>{
        return newsRepository.getNews(sources = sources)
    }
}