package com.example.newsreaderapp.presentation.nvgraph

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.newsreaderapp.presentation.home.HomeScreen
import com.example.newsreaderapp.presentation.home.HomeViewModel
import com.example.newsreaderapp.presentation.news_navigator.NewsNavigator

@Composable
fun NavGraph(
    startDestination: String
) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = startDestination) {
        composable(route = Route.NewsNavigatorScreen.route) {
            NewsNavigator()
        }

    }

}