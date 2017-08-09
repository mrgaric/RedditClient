package com.dubrovin.igor.redditclient.presentation.News.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.dubrovin.igor.redditclient.R
import com.dubrovin.igor.redditclient.data.model.RedditNewsItem
import com.dubrovin.igor.redditclient.utils.getTime
import com.dubrovin.igor.redditclient.utils.inflate
import com.dubrovin.igor.redditclient.utils.loadImage
import kotlinx.android.synthetic.main.item_news.view.*

/**
 * JuntoTeam
 * Created by Igor Dubrovin on 08.08.2017.
 */
class NewsDelegateAdapter : ViewTypeDelegateAdapter {
    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return TurnsViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
        holder as TurnsViewHolder
        holder.bind(item as RedditNewsItem)
    }

    class TurnsViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(parent.inflate(R.layout.item_news)){
        fun bind(item: RedditNewsItem) = with(itemView){
            news_iv_thumbnail.loadImage(item.thumbnail)
            news_tv_author.text = item.author
            news_tv_comments.text = "${item.numComment} comments"
            news_tv_description.text = item.title
            news_tv_time.text = item.created.getTime()
        }
    }
}