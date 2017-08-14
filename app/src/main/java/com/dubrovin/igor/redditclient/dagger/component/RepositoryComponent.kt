package com.dubrovin.igor.redditclient.dagger.component

import com.dubrovin.igor.redditclient.dagger.module.ApiModule
import com.dubrovin.igor.redditclient.data.repository.NewsRepository
import dagger.Component

/**
 * JuntoTeam
 * Created by Igor Dubrovin on 13.08.2017.
 */
@Component(modules = arrayOf(
        ApiModule::class
))
interface RepositoryComponent {
    fun inject(repository: NewsRepository)
}