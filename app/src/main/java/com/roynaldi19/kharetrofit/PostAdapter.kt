package com.roynaldi19.kharetrofit

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.roynaldi19.kharetrofit.databinding.ItemPostBinding

class PostAdapter(private val list: ArrayList<PostResponse>) :
    RecyclerView.Adapter<PostAdapter.ViewHolder>() {
    class ViewHolder(var binding: ItemPostBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(postResponse: PostResponse) {
            val text = "id: ${postResponse.id}\n" +
                    "title: ${postResponse.title}\n +" +
                    "text: ${postResponse.body}"
            binding.tvText.text = text
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostAdapter.ViewHolder {
        val binding = ItemPostBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])

    }

    override fun getItemCount() = list.size
}