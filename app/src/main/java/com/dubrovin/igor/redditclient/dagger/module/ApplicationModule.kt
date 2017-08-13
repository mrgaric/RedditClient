package com.dubrovin.igor.redditclient.dagger.module

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * JuntoTeam
 * Created by Igor Dubrovin on 13.08.2017.
 */
@Module
class ApplicationModule(val appContext: Context) {

    @Singleton
    @Provides
    fun ProvideAppContext(): Context = appContext
}