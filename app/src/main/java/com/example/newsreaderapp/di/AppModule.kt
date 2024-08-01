package com.example.newsreaderapp.di

import android.app.Application
import androidx.room.DeleteTable
import androidx.room.Room
import com.example.newsreaderapp.data.local.NewsDao
import com.example.newsreaderapp.data.local.NewsDatabase
import com.example.newsreaderapp.data.local.NewsTypeConvertor
import com.example.newsreaderapp.data.remote.NewsApi
import com.example.newsreaderapp.data.repository.NewsRepositoryImpl
import com.example.newsreaderapp.domain.repository.NewsRepository
import com.example.newsreaderapp.domain.usecases.news.DeleteArticle
import com.example.newsreaderapp.domain.usecases.news.GetNews
import com.example.newsreaderapp.domain.usecases.news.GetSavedArticle
import com.example.newsreaderapp.domain.usecases.news.GetSavedArticles
import com.example.newsreaderapp.domain.usecases.news.NewsUseCases
import com.example.newsreaderapp.domain.usecases.news.SearchNews
import com.example.newsreaderapp.domain.usecases.news.SelectArticle
import com.example.newsreaderapp.domain.usecases.news.UpsertArticle
import com.example.newsreaderapp.util.Constant
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    @Singleton
    fun provideNewsApi(): NewsApi {
        return Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)
    }



    @Provides
    @Singleton
    fun provideNewsRepository(
        newsApi: NewsApi,
        newsDao: NewsDao
    ):NewsRepository =NewsRepositoryImpl(newsApi,newsDao)

    @Provides
    @Singleton
    fun provideNewsUseCases(
        newsRepository: NewsRepository,
        newsDao: NewsDao
    ): NewsUseCases {
        return NewsUseCases(
            getNews = GetNews(newsRepository),
            searchNews = SearchNews(newsRepository),
            selectArticel = SelectArticle(newsDao),
            upsertArticle = UpsertArticle(newsDao),
            deleteArticle = DeleteArticle(newsDao),
            getSavedArticle = GetSavedArticle(newsDao),
            getSavedArticles = GetSavedArticles(newsDao)
        )
    }

    @Provides
    @Singleton
    fun provideNewsDatabase(
        application: Application
    ): NewsDatabase {
        return Room.databaseBuilder(
            context = application,
            klass = NewsDatabase::class.java,
            name = "news_db"
        ).addTypeConverter(NewsTypeConvertor())
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideNewsDao(newsDatabase: NewsDatabase): NewsDao {
        return newsDatabase.newsDao
    }
}