package com.dubrovin.igor.redditclient.domain.repository

import com.dubrovin.igor.redditclient.RedditApplication
import com.dubrovin.igor.redditclient.data.api.news.INewsApi
import com.dubrovin.igor.redditclient.data.api.news.NewsApi
import com.dubrovin.igor.redditclient.data.api.news.RedditNewsResponse

import io.reactivex.Observable
import javax.inject.Inject

/**
 * JuntoTeam
 * Created by Igor Dubrovin on 09.08.2017.
 */
class NewsRepository : INewsRepository {

    @Inject
    lateinit var newsApi: INewsApi

    init {
        RedditApplication.repositoryComponent.inject(this)
    }

    override fun getNews(after: String, limit: String): Observable<RedditNewsResponse> = Observable.create {
        val response = newsApi
                .getNews(after, limit)
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
