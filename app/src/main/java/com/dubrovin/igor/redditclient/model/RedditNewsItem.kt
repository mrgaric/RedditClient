package com.dubrovin.igor.redditclient.model

import com.dubrovin.igor.redditclient.ui.adapter.AdapterConstant
import com.dubrovin.igor.redditclient.ui.adapter.ViewType

/**
 * JuntoTeam
 * Created by Igor Dubrovin on 08.08.2017.
 */
data class RedditNewsItem (
        val author: String,
        val title: String,
        val numComment: Int,
        val created: Long,
        val thumbnail: String,
        val url: String
        ) : ViewType {
    override fun getViewType() = AdapterConstant.NEWS
}