package com.dubrovin.igor.redditclient.presentation

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * JuntoTeam
 * Created by Igor Dubrovin on 09.08.2017.
 */
interface SubscriptionHolder {

    val compositeDisposable: CompositeDisposable

    fun Disposable.addInCompositeDisposable() = compositeDisposable.add(this)

    fun resetCompositeDisposable(){
        compositeDisposable.clear()
    }
}