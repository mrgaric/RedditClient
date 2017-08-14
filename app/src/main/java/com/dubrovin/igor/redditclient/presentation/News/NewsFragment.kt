package com.dubrovin.igor.redditclient.presentation.News

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.PresenterType
import com.dubrovin.igor.redditclient.R
import com.dubrovin.igor.redditclient.domain.entity.RedditNewsItem
import com.dubrovin.igor.redditclient.presentation.BaseFragment
import com.dubrovin.igor.redditclient.presentation.News.adapter.NewsAdapter
import com.dubrovin.igor.redditclient.utils.inflate
import com.dubrovin.igor.redditclient.utils.listener.InfinityScrollListener
import com.dubrovin.igor.redditclient.utils.showSnackbar
import kotlinx.android.synthetic.main.fragment_news.*

class NewsFragment : BaseFragment(), NewsView {

    @InjectPresenter(type = PresenterType.LOCAL, tag = "News")
    lateinit var newsPresenter: NewsPresenter

    private val rvNews by lazy {
        news_fragment_rv_news
    }

    companion object {
        fun newInstance(args: Bundle?): NewsFragment {
            val fragment = NewsFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = container?.inflate(R.layout.fragment_news)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        rvNews.setHasFixedSize(true)
        val layoutManager = LinearLayoutManager(context)
        rvNews.layoutManager = layoutManager
        rvNews.addOnScrollListener(InfinityScrollListener({ requestNews()}, layoutManager))
        initAdapter()
        if (savedInstanceState == null) {
            requestNews()
        }
    }

    private fun initAdapter(){
        if (rvNews.adapter == null)
            rvNews.adapter = NewsAdapter()
    }

    private fun requestNews(){
        newsPresenter.getNews()
    }

    override fun showNews(items: List<RedditNewsItem>) {
        ((rvNews.adapter) as NewsAdapter).addNews(items)
    }

    override fun showError(message: String) {
        rvNews.showSnackbar(message)
    }
}