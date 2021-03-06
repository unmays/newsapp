package com.khoofiya.realnews.home.views.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.khoofiya.realnews.R
import com.khoofiya.realnews.pojos.Source
import kotlinx.android.synthetic.main.source_view_item.view.*

class SourcesAdapter(var sources: List<Source>, val onClick: (source: Source) -> Unit) :
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
            sourceName.text = source.name?.trim()
            sourceDescription.text = source.description?.trim()
            setOnClickListener {
                onClick.invoke(source)
            }
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {}

}
