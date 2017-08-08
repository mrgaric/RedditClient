package com.dubrovin.igor.redditclient.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup

/**
 * Created by mi on 08.08.2017.
 */
interface ViewTypeDelegateAdapter {
    fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder

    fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType)
}