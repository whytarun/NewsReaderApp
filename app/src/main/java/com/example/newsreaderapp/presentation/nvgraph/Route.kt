package com.example.newsreaderapp.presentation.nvgraph

sealed class Route(
    val route :String
) {
    object HomeScreen :Route(route = "homeScreen")
    object SearchScreen :Route(route ="searchScreen")
    object BookmarkScreen: Route(route ="bookmarkScreen")
    object DetailsScreen: Route(route ="detailsScreen")
    object NewsNavigatorScreen : Route(route = "newsNavigator")

}