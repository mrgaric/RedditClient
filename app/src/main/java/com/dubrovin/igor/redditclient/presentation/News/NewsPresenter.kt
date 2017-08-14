package com.dubrovin.igor.redditclient.presentation.News

import com.arellomobile.mvp.InjectViewState
import com.dubrovin.igor.redditclient.RedditApplication
import com.dubrovin.igor.redditclient.domain.entity.RedditNewsItem
import com.dubrovin.igor.redditclient.domain.interactor.newsInteractor.INewsInteractor
import com.dubrovin.igor.redditclient.presentation.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * JuntoTeam
 * Created by Igor Dubrovin on 09.08.2017.
 */
@InjectViewState
class NewsPresenter @Inject constructor(
        var newsInteractor: INewsInteractor
) : BasePresenter<NewsView>() {

    private var after: String? = null

    fun getNews() {
        newsInteractor.getNews(after ?:"")
                .doOnNext { after = it.after }
                .map {
                    it.children
                            .map {
                                val item = it.data
                                RedditNewsItem(item.author,
                                        item.title,
                                        item.num_comments,
                                        item.created,
                                        item.thumbnail,
                                        item.url)
                            }
                }
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