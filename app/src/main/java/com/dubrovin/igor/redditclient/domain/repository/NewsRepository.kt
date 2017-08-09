package com.dubrovin.igor.redditclient.domain.repository

import com.dubrovin.igor.redditclient.data.model.RedditNewsItem
import io.reactivex.Observable

/**
 * JuntoTeam
 * Created by Igor Dubrovin on 09.08.2017.
 */
class NewsRepository : INewsRepository {
    override fun getNews(): Observable<List<RedditNewsItem>> = Observable.create {
            subscriber ->

            val news = mutableListOf<RedditNewsItem>()
            for (i in 1..10) {
                news.add(RedditNewsItem(
                        "author$i",
                        "Title $i",
                        i, // number of comments
                        1457207701L - i * 200, // time
                        "http://lorempixel.com/200/200/technics/$i", // image url
                        "url"
                ))
            }
            subscriber.onNext(news)
        }

}
