package com.dubrovin.igor.redditclient.utils.listener

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

/**
 * JuntoTeam
 * Created by Igor Dubrovin on 10.08.2017.
 */
class InfinityScrollListener (
        val func: ()->Unit,
        val layoutManager: LinearLayoutManager) : RecyclerView.OnScrollListener() {

    private var loading = true
    private val visibleThreshold = 2
    private var previousTotal = 0
    private var firstVisibleItem = 0
    private var visibleItemCount = 0
    private var totalItemCount = 0

    override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)

        if (dy > 0 && recyclerView != null){
            visibleItemCount = recyclerView.childCount
            totalItemCount = layoutManager.itemCount
            firstVisibleItem = layoutManager.findFirstVisibleItemPosition()

            if (loading && totalItemCount > previousTotal){
                loading = false
                previousTotal = totalItemCount
            }

            if (!loading && ((totalItemCount - visibleItemCount)
                    <= (firstVisibleItem + visibleThreshold))){
                func()
                loading = true
            }
        }

    }
}