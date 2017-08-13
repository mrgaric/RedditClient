package com.dubrovin.igor.redditclient.dagger.module

import com.dubrovin.igor.redditclient.domain.interactor.newsInteractor.INewsInteractor
import com.dubrovin.igor.redditclient.domain.interactor.newsInteractor.NewsInteractor
import dagger.Module
import dagger.Provides

/**
 * JuntoTeam
 * Created by Igor Dubrovin on 13.08.2017.
 */
@Module
class InteractorModule {
    @Provides
    fun provideNewsInteractor(): INewsInteractor = NewsInteractor()
}