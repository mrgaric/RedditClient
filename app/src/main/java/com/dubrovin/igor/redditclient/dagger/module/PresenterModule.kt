package com.dubrovin.igor.redditclient.dagger.module

import com.dubrovin.igor.redditclient.dagger.annotation.ActivityScope
import com.dubrovin.igor.redditclient.domain.interactor.newsInteractor.INewsInteractor
import com.dubrovin.igor.redditclient.presentation.News.NewsPresenter
import dagger.Module
import dagger.Provides

/**
 * JuntoTeam
 * Created by Igor Dubrovin on 14.08.2017.
 */
@Module
class PresenterModule {
    @ActivityScope
    @Provides
    fun provideNewsPresenter(newsInteractor: INewsInteractor) = NewsPresenter(newsInteractor)
}