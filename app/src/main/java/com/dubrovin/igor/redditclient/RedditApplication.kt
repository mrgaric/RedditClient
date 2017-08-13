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
        lateinit var interactorComponent: InteractorComponent
        lateinit var presenterComponent: PresenterComponent
        lateinit var repositoryComponent: RepositoryComponent
    }

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(ApplicationModule(this))
                .networkModule(NetworkModule())
                .build()

        interactorComponent = DaggerInteractorComponent
                .builder()
                .repositoryModule(RepositoryModule())
                .build()

        presenterComponent = DaggerPresenterComponent
                .builder()
                .interactorModule(InteractorModule())
                .build()

        repositoryComponent = DaggerRepositoryComponent
                .builder()
                .apiModule(ApiModule())
                .build()
    }
}