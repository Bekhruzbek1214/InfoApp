package com.example.newinfoapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.newinfoapp.databinding.ItemLayoutBinding

class AdapterOfItem : ListAdapter<ItemData, AdapterOfItem.AdapterOfItemViewHolder>(AdapterDiffUtil) {

     private var onClick: ((ItemData) -> Unit)? = null

     inner class AdapterOfItemViewHolder(private val binding: ItemLayoutBinding) : ViewHolder(binding.root){
        init {
            binding.item.setOnClickListener {
                 onClick?.invoke(getItem(adapterPosition))
            }
        }

          fun bind(){
               getItem(adapterPosition).apply {
                   Glide.with(itemView.context)
                       .load(img1)
                       .into(binding.image)

                    binding.name.text = name
                    binding.desc.text = description
               }
          }
     }
     object AdapterDiffUtil : DiffUtil.ItemCallback<ItemData>(){
          override fun areItemsTheSame(oldItem: ItemData, newItem: ItemData): Boolean {
           return oldItem.id == newItem.id
          }

          override fun areContentsTheSame(oldItem: ItemData, newItem: ItemData): Boolean {
               return oldItem == newItem
          }

     }

     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterOfItemViewHolder {
          return AdapterOfItemViewHolder(
               ItemLayoutBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
               )
          )
     }

     override fun onBindViewHolder(holder: AdapterOfItemViewHolder, position: Int) {
          holder.bind()
     }

    fun setOnClickItem(onClickItem : (ItemData) -> Unit){
        this.onClick = onClickItem
    }



}