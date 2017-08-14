package com.dubrovin.igor.redditclient.domain.entity

/**
 * JuntoTeam
 * Created by Igor Dubrovin on 08.08.2017.
 */
data class RedditDataResponse(
        val children: List<RedditChildrenResponse>,
        val after: String?,
        val before: String?
)