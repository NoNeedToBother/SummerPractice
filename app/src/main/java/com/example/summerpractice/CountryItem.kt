package com.example.summerpractice

import android.content.Context
import com.example.summerpractice.databinding.ItemCountryBinding
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions

class CountryItem(
    private val binding: ItemCountryBinding,
    private val glide: RequestManager,
    private val onItemClick: (Country) -> Unit
) : ViewHolder(binding.root){
    private val options: RequestOptions = RequestOptions
        .diskCacheStrategyOf(DiskCacheStrategy.NONE)

    private val context: Context
        get() = itemView.context

    fun onBind(country: Country) {
        binding.run {
            tvTitle.text = country.name
            tvDesc.text = country.description
            glide
                .load(country.url)
                .placeholder(R.drawable.ic_action_name)
                .error(R.drawable.ic_action_name)
                .apply(options)
                .into(ivImage)

            root.setOnClickListener {
                onItemClick(country)
            }
        }
    }
}