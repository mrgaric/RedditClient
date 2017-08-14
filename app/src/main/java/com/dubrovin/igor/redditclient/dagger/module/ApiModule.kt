package com.dubrovin.igor.redditclient.dagger.module

import com.dubrovin.igor.redditclient.dagger.annotation.ActivityScope
import com.dubrovin.igor.redditclient.data.api.news.INewsApi
import com.dubrovin.igor.redditclient.data.api.news.NewsApi
import com.dubrovin.igor.redditclient.data.api.news.RedditApi
import dagger.Module
import dagger.Provides

/**
 * JuntoTeam
 * Created by Igor Dubrovin on 13.08.2017.
 */
@Module
class ApiModule {
    @ActivityScope
    @Provides
    fun provideNewsApi(redditApi: RedditApi): INewsApi = NewsApi(redditApi)
}