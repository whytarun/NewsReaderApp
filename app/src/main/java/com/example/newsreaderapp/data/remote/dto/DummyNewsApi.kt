package com.example.newsreaderapp.data.remote.dto

import com.example.newsreaderapp.data.remote.NewsApi
import com.example.newsreaderapp.domain.model.Article
import com.example.newsreaderapp.domain.model.Source

class DummyNewsApi : NewsApi {
    override suspend fun getNews(sources: String, page: Int, apiKey: String): NewsResponse {
        // Return a dummy NewsResponse
        return NewsResponse(
            status = "ok",
            totalResults = 1,
            articles = listOf(
                Article(
                    source = Source(id = "wired", name = "Wired"),
                    author = "Jessica Klein",
                    title = "Bitcoin Bros Go Wild for Donald Trump",
                    description = "At Bitcoin 2024 conference in Nashville, Trump is finally telling crypto enthusiasts what they want to hear.",
                    url = "https://www.wired.com/story/bitcoin-bros-go-wild-for-donald-trump/",
                    urlToImage = "https://media.wired.com/photos/66a56f21bf2909f08a634953/191:100/w_1280,c_limit/Crypto-Bros-Business-2162975355.jpg",
                    publishedAt = "2024-07-28T12:43:07Z",
                    content = "Trump's speech is an hour behind. A half hour into the wait, restless attendees start chanting Trump."
                )
            )
        )
    }

    override suspend fun searchNews(searchQuery: String, sources: String, page: Int, apiKey: String): NewsResponse {
        // Return a dummy NewsResponse for search
        return NewsResponse(
            status = "ok",
            totalResults = 1,
            articles = listOf(
                Article(
                    source = Source(id = "wired", name = "Wired"),
                    author = "Jessica Klein",
                    title = "Bitcoin Bros Go Wild for Donald Trump",
                    description = "At Bitcoin 2024 conference in Nashville, Trump is finally telling crypto enthusiasts what they want to hear.",
                    url = "https://www.wired.com/story/bitcoin-bros-go-wild-for-donald-trump/",
                    urlToImage = "https://media.wired.com/photos/66a56f21bf2909f08a634953/191:100/w_1280,c_limit/Crypto-Bros-Business-2162975355.jpg",
                    publishedAt = "2024-07-28T12:43:07Z",
                    content = "Trump's speech is an hour behind. A half hour into the wait, restless attendees start chanting Trump."
                )
            )
        )
    }
}