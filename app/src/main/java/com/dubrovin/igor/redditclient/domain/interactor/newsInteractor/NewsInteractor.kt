package com.dubrovin.igor.redditclient.domain.interactor.newsInteractor

import com.dubrovin.igor.redditclient.data.model.RedditNewsItem
import com.dubrovin.igor.redditclient.domain.repository.NewsRepository
import io.reactivex.Observable

/**
 * JuntoTeam
 * Created by Igor Dubrovin on 09.08.2017.
 */
class NewsInteractor : INewsInteractor {
    override fun getNews(): Observable<List<RedditNewsItem>> {
        return NewsRepository().getNews()
    }
}