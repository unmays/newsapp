package com.khoofiya.realnews.home.views.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.khoofiya.realnews.R
import com.khoofiya.realnews.pojos.Source
import kotlinx.android.synthetic.main.source_view_item.view.*

class SourcesAdapter(var sources: List<Source>) :
    RecyclerView.Adapter<SourcesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.source_view_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return sources.size
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val source = sources[position]
        viewHolder.itemView.run {
            sourceName.text = source.name
            sourceDescription.text = source.description
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {}

}
