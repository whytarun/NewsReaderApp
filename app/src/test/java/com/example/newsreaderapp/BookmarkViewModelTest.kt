package com.example.newsreaderapp

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.newsreaderapp.domain.usecases.news.GetSavedArticles
import com.example.newsreaderapp.presentation.bookmark.BookmarkViewModel
import com.example.newsreaderapp.util.MockData
import io.mockk.coEvery
import io.mockk.mockk
import io.mockk.verify
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.TestCoroutineScope
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@ExperimentalCoroutinesApi
@RunWith(JUnit4::class)
class BookmarkViewModelTest {
    @get:Rule
    val rule: TestRule = InstantTaskExecutorRule()

    private val testDispatcher = StandardTestDispatcher()
    private val testScope = TestCoroutineScope(testDispatcher)

    private val getSavedArticlesUseCase: GetSavedArticles = mockk()
    private lateinit var viewModel: BookmarkViewModel

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        val articles = MockData.articles
        println("getSavedArticlesUseCase: $articles")

        coEvery { getSavedArticlesUseCase() } returns flowOf(articles)

        viewModel = BookmarkViewModel(
            newsUseCases = mockk(),
            getSavedArticlesUseCase = getSavedArticlesUseCase
        )
    }
    @After
    fun tearDown() {
        Dispatchers.resetMain()
        testScope.cleanupTestCoroutines()
    }

    @Test
    fun `getArticles should update state with articles`() = runTest {
        val articles = MockData.articles
        println("articles: $articles")
        coEvery { getSavedArticlesUseCase() } returns flowOf(articles)

        viewModel = BookmarkViewModel(
            newsUseCases = mockk(),
            getSavedArticlesUseCase = getSavedArticlesUseCase
        )

        testScope.advanceUntilIdle()

        assert( viewModel.state.value.articles == articles)
    }
}