package com.khoofiya.realnews.sourceheadlines.views.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.khoofiya.realnews.R
import com.khoofiya.realnews.pojos.Article
import kotlinx.android.synthetic.main.article_view_item.view.*

class TopHeadlinesAdapter(var articles: List<Article>, val onClick: (article: Article) -> Unit) :
    RecyclerView.Adapter<TopHeadlinesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.article_view_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return articles.size
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val article = articles[position]
        viewHolder.itemView.run {
            Glide.with(this).load(article.urlToImage).into(articleImage)
            articleTitle.text = article.title?.trim()
            articleDesc.text = article.description?.trim()
            articleSourceName.text = article.source?.name?.trim()
            articleAuthor.text = article.author?.trim()
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {}

}
