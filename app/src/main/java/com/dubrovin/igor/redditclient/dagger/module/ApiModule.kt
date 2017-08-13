package com.dubrovin.igor.redditclient.dagger.module

import com.dubrovin.igor.redditclient.data.api.news.INewsApi
import com.dubrovin.igor.redditclient.data.api.news.NewsApi
import dagger.Module
import dagger.Provides

/**
 * JuntoTeam
 * Created by Igor Dubrovin on 13.08.2017.
 */
@Module
class ApiModule {
    @Provides
    fun provideNewsApi(): INewsApi = NewsApi()
}