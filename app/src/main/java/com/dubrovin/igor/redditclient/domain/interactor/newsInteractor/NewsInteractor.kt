package com.dubrovin.igor.redditclient.domain.interactor.newsInteractor

import com.dubrovin.igor.redditclient.RedditApplication
import com.dubrovin.igor.redditclient.domain.entity.RedditDataResponse
import com.dubrovin.igor.redditclient.domain.repository.INewsRepository
import io.reactivex.Observable
import javax.inject.Inject

/**
 * JuntoTeam
 * Created by Igor Dubrovin on 09.08.2017.
 */
class NewsInteractor : INewsInteractor {

    @Inject
    lateinit var newsRepository: INewsRepository

    init {
        RedditApplication.interactorComponent.inject(this)
    }

    override fun getNews(after: String, limit: String): Observable<RedditDataResponse>
            = newsRepository.getNews(after)
            .map { it.data }
}