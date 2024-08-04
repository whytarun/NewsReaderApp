
package com.example.newsreaderapp.presentation.search

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.newsreaderapp.domain.model.Article
import com.example.newsreaderapp.presentation.common.ArticlesList
import com.example.newsreaderapp.presentation.common.SearchBar
import com.example.newsreaderapp.presentation.util.Dimens.MediumPadding1



@Composable
fun SearchScreen(
    state: SearchState,
    event:(SearchEvent) -> Unit,
    navigateToDetails:(Article) -> Unit,
    testMode: Boolean = false
) {

    Column(
        modifier = Modifier
            .padding(top = MediumPadding1, start = MediumPadding1, end = MediumPadding1)
            .statusBarsPadding()
    ) {
        SearchBar(
            modifier = Modifier.testTag("SearchBar"),
            text = state.searchQuery,
            readOnly = false,
            onValueChange = { event(SearchEvent.UpdateSearchQuery(it)) },
            onSearch = {
                event(SearchEvent.SearchNews)
            }
        )
        Spacer(modifier = Modifier.height(MediumPadding1))

        CategoryFilter(
            categories = state.categories,
            selectedCategory = state.selectedCategory,
            onCategorySelected = { event(SearchEvent.SelectCategory(it)) }
        )

        Spacer(modifier = Modifier.height(MediumPadding1))
        state.articles?.let {
            val articles = it.collectAsLazyPagingItems()
            ArticlesList(
                modifier = Modifier.testTag("ArticlesList"),
                articles = articles,
                onClick = navigateToDetails,
                testMode = testMode
            )
        }
    }
}

@Composable
fun CategoryFilter(
    categories: List<String>,
    selectedCategory: String,
    onCategorySelected: (String) -> Unit
) {
    LazyRow(
        modifier = Modifier.padding(horizontal = MediumPadding1)
    ) {
        items(categories) { category ->
            Chip(
                text = category,
                isSelected = category == selectedCategory,
                onClick = { onCategorySelected(category) }
            )
        }
    }
}

@Composable
fun Chip(
    text: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Surface(
        modifier = Modifier
            .padding(4.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(16.dp),
        color = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surface
    ) {
        Text(
            text = text,
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
            color = if (isSelected) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onSurface
        )
    }
}