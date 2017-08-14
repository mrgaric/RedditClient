package com.dubrovin.igor.redditclient.dagger.module

import com.dubrovin.igor.redditclient.domain.repository.INewsRepository
import com.dubrovin.igor.redditclient.data.repository.NewsRepository
import dagger.Module
import dagger.Provides

/**
 * JuntoTeam
 * Created by Igor Dubrovin on 13.08.2017.
 */
@Module
class RepositoryModule {
    @Provides
    fun provideNewsRepository(): INewsRepository = NewsRepository()
}