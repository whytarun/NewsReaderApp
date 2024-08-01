package com.example.newsreaderapp.presentation.detail

import com.example.newsreaderapp.domain.model.Article


sealed class DetailsEvent {
    data class UpsertDeleteArticle(val article: Article) : DetailsEvent()

    object RemoveSideEffect : DetailsEvent()

}