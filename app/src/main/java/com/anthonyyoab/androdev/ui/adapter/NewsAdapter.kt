package com.anthonyyoab.androdev.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.anthonyyoab.androdev.databinding.ItemNewsBinding
import com.anthonyyoab.androdev.ui.model.NewsResponse
import com.bumptech.glide.Glide

class NewsAdapter(private var newsModel: List<NewsResponse>): RecyclerView.Adapter<NewsAdapter.ViewHolder>() {
    inner class ViewHolder(var binding: ItemNewsBinding): RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemNewsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val newsModel = newsModel[position]
        with(holder){
            Glide.with(binding.idNews.context).load(newsModel.imageLink).into(binding.idNews)
            binding.idTitle.text = newsModel.name
        }
    }

    override fun getItemCount(): Int {
        return newsModel.size
    }
}