package com.dubrovin.igor.redditclient.dagger.component

import com.dubrovin.igor.redditclient.dagger.module.RepositoryModule
import com.dubrovin.igor.redditclient.domain.interactor.newsInteractor.NewsInteractor
import dagger.Component
import dagger.Subcomponent

/**
 * JuntoTeam
 * Created by Igor Dubrovin on 13.08.2017.
 */

@Component(modules = arrayOf(
        RepositoryModule::class
))
interface InteractorComponent {
    fun inject(interactor: NewsInteractor)
}