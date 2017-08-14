package com.dubrovin.igor.redditclient

import android.app.Application
import com.dubrovin.igor.redditclient.dagger.component.*
import com.dubrovin.igor.redditclient.dagger.module.*

/**
 * JuntoTeam
 * Created by Igor Dubrovin on 09.08.2017.
 */
class RedditApplication : Application() {
    companion object {
        lateinit var applicationComponent: ApplicationComponent
        var newsComponent: NewsComponent? = null

        fun plusNewsComponent(): NewsComponent{
            if (newsComponent == null)
                newsComponent = applicationComponent.newsComponentBuilder()
                    .presenterModule(PresenterModule())
                    .interactorModule(InteractorModule())
                    .repositoryModule(RepositoryModule())
                    .apiModule(ApiModule())
                    .build()
            return newsComponent as NewsComponent
        }

        fun clearNewsComponent(){
            newsComponent = null
        }
    }

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(ApplicationModule(this))
                .networkModule(NetworkModule())
                .build()
    }
}