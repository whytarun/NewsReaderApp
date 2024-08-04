package com.example.newsreaderapp

import com.example.newsreaderapp.data.local.NewsDao
import com.example.newsreaderapp.domain.model.Article
import com.example.newsreaderapp.domain.usecases.news.GetSavedArticles
import com.example.newsreaderapp.util.MockData
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class GetSavedArticlesTest {

    private val newsDao: NewsDao = mockk()
    private lateinit var getSavedArticles: GetSavedArticles

    @Before
    fun setUp() {
        getSavedArticles = GetSavedArticles(newsDao)
    }

    @Test
    fun `invoke should return articles from dao`() = runBlocking {
        val articles = MockData.articles
        coEvery { newsDao.getArticles() } returns flowOf(articles)

        val result = getSavedArticles()

        result.collect { actualArticles ->
            assertEquals(articles, actualArticles)
        }
    }
}