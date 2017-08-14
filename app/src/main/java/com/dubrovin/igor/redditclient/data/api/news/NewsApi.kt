package com.dubrovin.igor.redditclient.data.api.news

import com.dubrovin.igor.redditclient.domain.entity.RedditNewsResponse
import retrofit2.Call
import javax.inject.Inject

/**
 * JuntoTeam
 * Created by Igor Dubrovin on 09.08.2017.
 */
class NewsApi @Inject constructor(
        val redditApi: RedditApi
) : INewsApi {

    override fun getNews(after: String, limit: String): Call<RedditNewsResponse> = redditApi.getTopNews(after, limit)

}