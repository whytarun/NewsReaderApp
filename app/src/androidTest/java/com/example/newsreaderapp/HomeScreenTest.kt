package com.example.newsreaderapp

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.printToLog
import androidx.paging.PagingData
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.newsreaderapp.presentation.home.HomeScreen
import com.example.newsreaderapp.util.MockData
import kotlinx.coroutines.flow.flowOf
import org.junit.Rule
import org.junit.Test

class HomeScreenTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun homeScreen_displaysArticles() {
        val articles = flowOf(PagingData.from(MockData.articles))
        composeTestRule.setContent {

            HomeScreen(
                articles = articles.collectAsLazyPagingItems(),
                navigateToSearch = {},
                navigateToDetails = {},
                testMode = true
            )
        }

        composeTestRule.waitForIdle()

        composeTestRule.onRoot(useUnmergedTree = true).printToLog("currentLabelExists")

        composeTestRule.onNodeWithTag("ArticlesList", useUnmergedTree = true).assertExists().assertIsDisplayed()
       composeTestRule.onNodeWithText("Bitcoin Bros Go Wild for Donald Trump", useUnmergedTree = true).assertExists().assertIsDisplayed()


    }

}