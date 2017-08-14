package com.dubrovin.igor.redditclient.dagger.component

import com.dubrovin.igor.redditclient.dagger.annotation.ActivityScope
import com.dubrovin.igor.redditclient.dagger.module.ApiModule
import com.dubrovin.igor.redditclient.dagger.module.InteractorModule
import com.dubrovin.igor.redditclient.dagger.module.PresenterModule
import com.dubrovin.igor.redditclient.dagger.module.RepositoryModule
import com.dubrovin.igor.redditclient.presentation.News.NewsFragment
import com.dubrovin.igor.redditclient.presentation.News.NewsView
import dagger.Component
import dagger.Subcomponent

/**
 * JuntoTeam
 * Created by Igor Dubrovin on 14.08.2017.
 */
@ActivityScope
@Subcomponent(modules = arrayOf(
        PresenterModule::class,
        InteractorModule::class,
        RepositoryModule::class,
        ApiModule::class
))
interface NewsComponent {

    @Subcomponent.Builder
    interface Builder{
        fun presenterModule(presenterModule: PresenterModule): NewsComponent.Builder
        fun interactorModule(interactorModule: InteractorModule): NewsComponent.Builder
        fun repositoryModule(repositoryModule: RepositoryModule): NewsComponent.Builder
        fun apiModule(apiModule: ApiModule): NewsComponent.Builder
        fun build(): NewsComponent
    }

    fun inject(newsFragment: NewsFragment)
}