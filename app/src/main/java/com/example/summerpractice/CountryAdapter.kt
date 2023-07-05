package com.example.summerpractice

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.example.summerpractice.databinding.ItemCountryBinding

class CountryAdapter(
    private var list: List<Country>,
    private val glide: RequestManager,
    private val onItemClick: (Country) -> Unit
) : RecyclerView.Adapter<CountryItem>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CountryItem = CountryItem(
        binding = ItemCountryBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false,
        ),
        glide = glide,
        onItemClick = onItemClick,
    )

    override fun onBindViewHolder(holder: CountryItem, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }


}