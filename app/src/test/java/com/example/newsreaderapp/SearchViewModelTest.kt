package com.example.newsreaderapp

import androidx.paging.PagingData
import com.example.newsreaderapp.domain.usecases.news.SearchNews
import com.example.newsreaderapp.presentation.search.SearchEvent
import com.example.newsreaderapp.presentation.search.SearchViewModel
import io.mockk.coEvery
import io.mockk.junit4.MockKRule
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.flow.flowOf
import org.junit.Before
import org.junit.Rule
import org.junit.Test


class SearchViewModelTest {
    @get:Rule
    val mockkRule = MockKRule(this)

    private val searchNewsUseCase = mockk<SearchNews>()
    private lateinit var viewModel: SearchViewModel

    @Before
    fun setUp() {

        viewModel = SearchViewModel(searchNewsUseCase)
    }
    @Test
    fun `when UpdateSearchQuery event is received, searchQuery is updated and category is cleared`() {
        val searchQuery = "query"
        val initialState = viewModel.state.value
        viewModel.onEvent(SearchEvent.UpdateSearchQuery(searchQuery))

        val state = viewModel.state.value

        assert(state.searchQuery == searchQuery)
        assert(state.selectedCategory == "")
    }

    @Test
    fun `when SelectCategory event is received, selectedCategory is updated and searchNews is called`() {
        val category = "Tech"
        coEvery { searchNewsUseCase(any(), any()) } returns flowOf(PagingData.empty())

        viewModel.onEvent(SearchEvent.SelectCategory(category))

        val state = viewModel.state.value
        assert(state.selectedCategory == category)
        verify { searchNewsUseCase("${state.searchQuery} $category", any()) }
    }
}