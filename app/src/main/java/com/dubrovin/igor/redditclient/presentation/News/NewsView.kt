package com.dubrovin.igor.redditclient.presentation.News

import com.arellomobile.mvp.viewstate.strategy.AddToEndStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.dubrovin.igor.redditclient.domain.entity.RedditNewsItem
import com.dubrovin.igor.redditclient.presentation.BaseView

/**
 * JuntoTeam
 * Created by Igor Dubrovin on 09.08.2017.
 */
interface NewsView : BaseView {
    @StateStrategyType(AddToEndStrategy::class)
    fun showNews(items: List<RedditNewsItem>)
}