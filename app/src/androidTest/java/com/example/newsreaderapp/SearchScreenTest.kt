package com.example.newsreaderapp

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.printToLog
import androidx.paging.PagingData
import com.example.newsreaderapp.domain.model.Article
import com.example.newsreaderapp.presentation.search.SearchEvent
import com.example.newsreaderapp.presentation.search.SearchScreen
import com.example.newsreaderapp.presentation.search.SearchState
import com.example.newsreaderapp.util.MockData
import kotlinx.coroutines.flow.flowOf
import org.junit.Rule
import org.junit.Test

class SearchScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun searchScreen_displaysCorrectComponents() {
        val initialState = SearchState(
            searchQuery = "",
            categories = listOf("general", "sports"),
            selectedCategory = "general",
            articles = flowOf(PagingData.from(MockData.articles))
        )
        val mockEvent: (SearchEvent) -> Unit = {}
        val mockNavigateToDetails: (Article) -> Unit = {}

        composeTestRule.setContent {
            SearchScreen(
                state = initialState,
                event = mockEvent,
                navigateToDetails = mockNavigateToDetails,
                testMode = true
            )
        }
        composeTestRule.waitForIdle()
        composeTestRule.onRoot(useUnmergedTree = true).printToLog("currentLabelExists")
        composeTestRule.onNodeWithTag("SearchBar").assertIsDisplayed()

        composeTestRule.onNodeWithTag("ArticlesList").assertIsDisplayed()
    }
}