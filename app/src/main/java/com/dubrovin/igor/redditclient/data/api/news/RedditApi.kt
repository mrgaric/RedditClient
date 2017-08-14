package com.dubrovin.igor.redditclient.data.api.news

import com.dubrovin.igor.redditclient.domain.entity.RedditNewsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * JuntoTeam
 * Created by Igor Dubrovin on 13.08.2017.
 */
interface RedditApi {
    @GET("/top.json")
    fun getTopNews(@Query("after") after: String,
                   @Query("limit") limit: String
    ): Call<RedditNewsResponse>
}