package com.example.newsreaderapp.presentation.search

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.newsreaderapp.domain.usecases.news.SearchNews
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchNewsUseCase: SearchNews
) : ViewModel() {

    private var _state = mutableStateOf(SearchState())
    val state: State<SearchState> = _state


    fun onEvent(event: SearchEvent) {
        when (event) {
            is SearchEvent.UpdateSearchQuery -> {
                _state.value = _state.value.copy(searchQuery = event.searchQuery, selectedCategory = "")
            }

            is SearchEvent.SearchNews -> {
                searchNews()
            }

            is SearchEvent.SelectCategory -> {
                _state.value = _state.value.copy(selectedCategory = event.category)
                searchNews()
            }

            else -> {}
        }
    }

    private fun searchNews() {
        val searchQueryWithCategory = if (_state.value.selectedCategory.isNotEmpty()) {
            "${_state.value.searchQuery} ${_state.value.selectedCategory}"
        } else {
            _state.value.searchQuery
        }
        val articles = searchNewsUseCase(
            searchQuery = searchQueryWithCategory,
            sources = listOf("bbc-news", "abc-news", "al-jazeera-english"),
        ).cachedIn(viewModelScope)
        _state.value = _state.value.copy(articles = articles)
    }

}