package com.dubrovin.igor.redditclient.domain.repository

import com.dubrovin.igor.redditclient.data.api.news.RedditNewsResponse
import com.dubrovin.igor.redditclient.data.entity.RedditNewsItem
import com.dubrovin.igor.redditclient.utils.RestApi
import io.reactivex.Observable

/**
 * JuntoTeam
 * Created by Igor Dubrovin on 09.08.2017.
 */
class NewsRepository : INewsRepository {
    override fun getNews(after: String, limit: String): Observable<RedditNewsResponse> = Observable.create {
        val response = RestApi.instance
                .newsApi
                .getTopNews(after, limit)
                .execute()
        if (response.isSuccessful){
            val news = response.body()
            if (news != null) {
                it.onNext(news)
            }
            it.onComplete()
        }
        else
            it.onError(Throwable(response.message()))
        }
}
