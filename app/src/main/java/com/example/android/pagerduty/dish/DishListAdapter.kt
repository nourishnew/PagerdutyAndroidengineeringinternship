package com.example.android.pagerduty.dish

import android.view.LayoutInflater
import android.view.ViewGroup

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android.pagerduty.databinding.ListItemViewBinding

class DishListAdapter(val onClickListener: OnClickListener): ListAdapter<Dish, DishListAdapter.DishViewHolder>(DiffCallback) {

    class DishViewHolder(var binding:ListItemViewBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(Dish: Dish){
            binding.dish=Dish
            binding.executePendingBindings()
        }

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DishViewHolder {
        var inflater= LayoutInflater.from(parent.context)
        var view= ListItemViewBinding.inflate(inflater, parent, false)
        return DishViewHolder(view)
    }

    override fun onBindViewHolder(holder: DishViewHolder, position: Int) {
        var dish= getItem(position)
        holder.binding.deleteButton.setOnClickListener {
            onClickListener.onClick(holder.adapterPosition)
        }
        holder.bind(dish)
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Dish>() {
        override fun areItemsTheSame(oldItem: Dish, newItem: Dish): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Dish, newItem: Dish): Boolean {
            return oldItem.index == newItem.index
        }

    }

    class OnClickListener(val clickListener: (index:Int) -> Unit){
        fun onClick(index: Int)= clickListener(index)
    }

}
