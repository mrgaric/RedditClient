package com.dubrovin.igor.redditclient.domain.interactor.newsInteractor

import com.dubrovin.igor.redditclient.domain.entity.RedditDataResponse
import io.reactivex.Observable

/**
 * JuntoTeam
 * Created by Igor Dubrovin on 09.08.2017.
 */
interface INewsInteractor {
    fun getNews(after: String, limit: String = "10"): Observable<RedditDataResponse>
}