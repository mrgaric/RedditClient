package com.dubrovin.igor.redditclient.data.api.news

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * JuntoTeam
 * Created by Igor Dubrovin on 09.08.2017.
 */
interface NewsApi {

    @GET("/top.json")
    fun getTopNews(@Query("after") after: String,
               @Query("limit") limit: String
    ): Call<RedditNewsResponse>
}