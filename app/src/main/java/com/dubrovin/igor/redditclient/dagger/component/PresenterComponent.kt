package com.dubrovin.igor.redditclient.dagger.component

import com.dubrovin.igor.redditclient.dagger.module.InteractorModule
import com.dubrovin.igor.redditclient.presentation.News.NewsPresenter
import dagger.Component
import dagger.Subcomponent

/**
 * JuntoTeam
 * Created by Igor Dubrovin on 13.08.2017.
 */

@Component(modules = arrayOf(
        InteractorModule::class
))
interface PresenterComponent {
    fun inject(presenter: NewsPresenter)
}