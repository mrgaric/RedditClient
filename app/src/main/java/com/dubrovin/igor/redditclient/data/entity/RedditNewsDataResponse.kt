package com.dubrovin.igor.redditclient.data.entity

/**
 * JuntoTeam
 * Created by Igor Dubrovin on 08.08.2017.
 */
data class RedditNewsDataResponse(
        val author: String,
        val title: String,
        val num_comments: Int,
        val created: Long,
        val thumbnail: String,
        val url: String
)