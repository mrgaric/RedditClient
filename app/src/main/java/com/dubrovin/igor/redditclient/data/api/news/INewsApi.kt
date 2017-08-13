package com.dubrovin.igor.redditclient.data.api.news

import retrofit2.Call

/**
 * JuntoTeam
 * Created by Igor Dubrovin on 13.08.2017.
 */
interface INewsApi {
    fun getNews(after: String, limit: String): Call<RedditNewsResponse>
}