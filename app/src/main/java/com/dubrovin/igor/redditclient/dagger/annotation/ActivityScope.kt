package com.dubrovin.igor.redditclient.dagger.annotation

import java.lang.annotation.RetentionPolicy
import javax.inject.Scope

/**
 * JuntoTeam
 * Created by Igor Dubrovin on 14.08.2017.
 */
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class ActivityScope