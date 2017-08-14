package com.dubrovin.igor.redditclient.dagger.module

import com.dubrovin.igor.redditclient.dagger.annotation.ActivityScope
import com.dubrovin.igor.redditclient.domain.interactor.newsInteractor.INewsInteractor
import com.dubrovin.igor.redditclient.domain.interactor.newsInteractor.NewsInteractor
import com.dubrovin.igor.redditclient.domain.repository.INewsRepository
import dagger.Module
import dagger.Provides

/**
 * JuntoTeam
 * Created by Igor Dubrovin on 13.08.2017.
 */
@Module
class InteractorModule {
    @ActivityScope
    @Provides
    fun provideNewsInteractor(newsRepository: INewsRepository): INewsInteractor = NewsInteractor(newsRepository)
}