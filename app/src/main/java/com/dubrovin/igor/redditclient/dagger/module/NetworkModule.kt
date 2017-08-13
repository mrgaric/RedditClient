package com.dubrovin.igor.redditclient.dagger.module

import com.dubrovin.igor.redditclient.data.api.news.RedditApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

/**
 * JuntoTeam
 * Created by Igor Dubrovin on 13.08.2017.
 */
@Module
class NetworkModule {
    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
            .baseUrl("https://www.reddit.com")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

    @Singleton
    @Provides
    fun provideRedditApi(retrofit: Retrofit) = retrofit.create(RedditApi::class.java)
}