package com.dubrovin.igor.redditclient.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.dubrovin.igor.redditclient.R
import com.dubrovin.igor.redditclient.utils.inflate

class LoadingDelegateAdapter : ViewTypeDelegateAdapter {

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder = LoadingViewHolder(parent)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    class LoadingViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(parent.inflate(R.layout.item_loading))
}