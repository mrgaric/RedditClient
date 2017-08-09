package com.dubrovin.igor.redditclient.presentation.News

import com.arellomobile.mvp.InjectViewState
import com.dubrovin.igor.redditclient.data.model.RedditNewsItem
import com.dubrovin.igor.redditclient.domain.interactor.newsInteractor.NewsInteractor
import com.dubrovin.igor.redditclient.presentation.BasePresenter

/**
 * JuntoTeam
 * Created by Igor Dubrovin on 09.08.2017.
 */
@InjectViewState
class NewsPresenter : BasePresenter<NewsView>() {
    private val newsInteractor = NewsInteractor()

    fun getNews(){
        newsInteractor.getNews().doOnNext { it -> viewState.showNews(it) }.subscribe()
    }
}