package com.dubrovin.igor.redditclient.domain.repository

import com.dubrovin.igor.redditclient.data.api.news.RedditNewsResponse
import com.dubrovin.igor.redditclient.data.entity.RedditNewsItem
import io.reactivex.Observable

/**
 * JuntoTeam
 * Created by Igor Dubrovin on 09.08.2017.
 */
interface INewsRepository {
    fun getNews(limit: String = "10"): Observable<RedditNewsResponse>
}