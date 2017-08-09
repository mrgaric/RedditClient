package com.dubrovin.igor.redditclient.domain.repository

import com.dubrovin.igor.redditclient.data.model.RedditNewsItem
import io.reactivex.Observable

/**
 * JuntoTeam
 * Created by Igor Dubrovin on 09.08.2017.
 */
interface INewsRepository {
    fun getNews(): Observable<List<RedditNewsItem>>
}