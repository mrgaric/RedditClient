package com.dubrovin.igor.redditclient.ui.fragment

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatFragment
import com.dubrovin.igor.redditclient.R
import com.dubrovin.igor.redditclient.model.RedditNewsItem
import com.dubrovin.igor.redditclient.ui.adapter.NewsAdapter
import com.dubrovin.igor.redditclient.utils.inflate
import kotlinx.android.synthetic.main.fragment_news.*

class NewsFragment : MvpAppCompatFragment() {

    private val rvNews by lazy {
        news_fragment_rv_news
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = container?.inflate(R.layout.fragment_news)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        rvNews.setHasFixedSize(true)
        rvNews.layoutManager = LinearLayoutManager(context)
        initAdapter()
        if (savedInstanceState == null) {
            val news = mutableListOf<RedditNewsItem>()
            for (i in 1..10) {
                news.add(RedditNewsItem(
                        "author$i",
                        "Title$i",
                        i,
                        1457207701L - i * 200,
                        "http://lorempixel.com/200/200/technics/$i", // image url
                        "url"
                ))
            }
            (rvNews.adapter as NewsAdapter).addNews(news)
        }
    }

    private fun initAdapter(){
        if (rvNews.adapter == null)
            rvNews.adapter = NewsAdapter()
    }
}