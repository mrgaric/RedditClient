package com.dubrovin.igor.redditclient.presentation

import com.arellomobile.mvp.MvpPresenter

/**
 * JuntoTeam
 * Created by Igor Dubrovin on 09.08.2017.
 */
abstract class BasePresenter<View : BaseView> : MvpPresenter<View>() {

    override fun attachView(view: View) {
        super.attachView(view)
    }

    override fun detachView(view: View) {
        super.detachView(view)
    }
}