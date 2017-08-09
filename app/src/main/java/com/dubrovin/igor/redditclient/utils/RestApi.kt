package com.dubrovin.igor.redditclient.utils

import com.dubrovin.igor.redditclient.data.api.news.NewsApi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * JuntoTeam
 * Created by Igor Dubrovin on 09.08.2017.
 */
class RestApi private constructor(){
    val newsApi: NewsApi
    init {
        newsApi = Retrofit.Builder()
                .baseUrl("https://www.reddit.com")
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
                .create(NewsApi::class.java)
    }
    private object Holder {val instance = RestApi()}
    companion object {
        val instance: RestApi by lazy { Holder.instance }
    }
}