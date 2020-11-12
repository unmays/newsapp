package com.khoofiya.realnews.home.views.fragments

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class PageEndListener(
    private val layoutManager: LinearLayoutManager,
    private val onPageEnd: (pageCount: Int) -> Unit
) : RecyclerView.OnScrollListener() {

    private var pageCount = 1;
    var isLoading: Boolean = false

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)
        val visibleItemCount = layoutManager.childCount
        val totalItemCount = layoutManager.itemCount
        val firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition()
        if (!isLoading && ((visibleItemCount + firstVisibleItemPosition) >= totalItemCount && firstVisibleItemPosition >= 0)) {
            isLoading = true
            onPageEnd.invoke(++pageCount)
        }
    }

}