package com.dubrovin.igor.redditclient.presentation

import com.arellomobile.mvp.MvpPresenter
import io.reactivex.disposables.CompositeDisposable

/**
 * JuntoTeam
 * Created by Igor Dubrovin on 09.08.2017.
 */
abstract class BasePresenter<View : BaseView> : MvpPresenter<View>(),
        SubscriptionHolder{

    override val compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun attachView(view: View) {
        super.attachView(view)
    }

    override fun detachView(view: View) {
        super.detachView(view)
    }

    override fun onDestroy() {
        super.onDestroy()
        resetCompositeDisposable()
    }
}