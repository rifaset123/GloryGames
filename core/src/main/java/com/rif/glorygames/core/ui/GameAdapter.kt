package com.rif.glorygames.core.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rif.glorygames.core.databinding.ItemListTourismBinding
import com.rif.glorygames.core.domain.model.Game

class GameAdapter : ListAdapter<Game, GameAdapter.ListViewHolder>(DIFF_CALLBACK) {

    var onItemClick: ((Game) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ListViewHolder(
            ItemListTourismBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = getItem(position)
        holder.bind(data)
    }

    inner class ListViewHolder(private var binding: ItemListTourismBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Game) {
            Glide.with(itemView.context)
                .load(data.backgroundImage)
                .into(binding.ivGame)
            binding.tvName.text = data.name
            binding.tvReleaseDate.text = data.releaseDate
            binding.tvRating.text = data.rating.toString()
        }

        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(getItem(bindingAdapterPosition))
            }
        }
    }

    companion object {
        val DIFF_CALLBACK: DiffUtil.ItemCallback<Game> =
            object : DiffUtil.ItemCallback<Game>() {
                override fun areItemsTheSame(oldItem: Game, newItem: Game): Boolean {
                    return oldItem.gameId == newItem.gameId
                }

                override fun areContentsTheSame(oldItem: Game, newItem: Game): Boolean {
                    return oldItem == newItem
                }
            }
    }
}