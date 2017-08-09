package com.dubrovin.igor.redditclient.presentation.News

import com.arellomobile.mvp.InjectViewState
import com.dubrovin.igor.redditclient.domain.interactor.newsInteractor.NewsInteractor
import com.dubrovin.igor.redditclient.presentation.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * JuntoTeam
 * Created by Igor Dubrovin on 09.08.2017.
 */
@InjectViewState
class NewsPresenter : BasePresenter<NewsView>() {
    private val newsInteractor = NewsInteractor()

    fun getNews() {
        newsInteractor.getNews()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    viewState.showNews(it)
                }, {
                    viewState.showError("Error")
                })
                .addInCompositeDisposable()
    }
}