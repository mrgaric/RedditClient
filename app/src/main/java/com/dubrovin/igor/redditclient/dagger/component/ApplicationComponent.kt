package com.dubrovin.igor.redditclient.dagger.component

import com.dubrovin.igor.redditclient.dagger.module.ApiModule
import com.dubrovin.igor.redditclient.dagger.module.ApplicationModule
import com.dubrovin.igor.redditclient.dagger.module.NetworkModule
import com.dubrovin.igor.redditclient.data.api.news.NewsApi
import dagger.Component
import javax.inject.Singleton

/**
 * JuntoTeam
 * Created by Igor Dubrovin on 13.08.2017.
 */
@Singleton
@Component(modules = arrayOf(
        ApplicationModule::class,
        NetworkModule::class
))
interface ApplicationComponent {
    fun inject(newsApi: NewsApi)
}