package com.dubrovin.igor.redditclient.domain.repository

import com.dubrovin.igor.redditclient.domain.entity.RedditNewsResponse
import io.reactivex.Observable

/**
 * JuntoTeam
 * Created by Igor Dubrovin on 09.08.2017.
 */
interface INewsRepository {
    fun getNews(after: String = "", limit: String = "10"): Observable<RedditNewsResponse>
}