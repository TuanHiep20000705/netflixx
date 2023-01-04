package com.mth.example.buoi1sua.category

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.mth.example.buoi1sua.R
import com.mth.example.buoi1sua.movie.MovieAdapter

enum class ItemType {
    HEADER, NORMAL
}

class CategoryAdapter : ListAdapter<MovieItem, ViewHolder>(CategoryDiffUtil) {

    object CategoryDiffUtil : DiffUtil.ItemCallback<MovieItem>() {
        override fun areItemsTheSame(oldItem: MovieItem, newItem: MovieItem): Boolean {
            return oldItem::class.java.simpleName == newItem::class.java.simpleName
        }
        override fun areContentsTheSame(oldItem: MovieItem, newItem: MovieItem): Boolean {
            return oldItem.id == newItem.id
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) {
            ItemType.HEADER.ordinal
        } else {
            ItemType.NORMAL.ordinal
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return when (viewType) {
            ItemType.HEADER.ordinal -> {
                HeaderViewHolder.create(parent)
            }
            else -> {
                CategoryViewHolder.create(parent)
            }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        when (getItem(position)) {
//            is MovieItem.Header -> {
//                (holder as HeaderViewHolder).bind()
//            }
//            else -> {
//                (holder as CategoryViewHolder).bind((getItem(position) as MovieItem.Category))
//            }
//        }
        when (getItemViewType(position)) {
            ItemType.HEADER.ordinal -> {
                (holder as HeaderViewHolder).bind()
            }
            else -> {
                (holder as CategoryViewHolder).bind(getItem(position) as MovieItem.Category)
            }
        }
    }

    class CategoryViewHolder(itemView: View) : ViewHolder(itemView) {
        private val txtNameCategory: TextView = itemView.findViewById(R.id.txt_name_category)
        private val rcvMovie: RecyclerView = itemView.findViewById(R.id.rcv_movie)
        fun bind(category: MovieItem.Category) {
            txtNameCategory.text = category.nameCategory
            val movieAdapter = MovieAdapter()
            movieAdapter.setData(category.listMovie)
            rcvMovie.adapter = movieAdapter
        }

        companion object {
            fun create(parent: ViewGroup): CategoryViewHolder {
                val view: View =
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_category, parent, false)
                return CategoryViewHolder(view)
            }
        }
    }

    class HeaderViewHolder(itemView: View) : ViewHolder(itemView) {
        fun bind() {}

        companion object {
            fun create(parent: ViewGroup): HeaderViewHolder {
                val view: View =
                    LayoutInflater.from(parent.context).inflate(R.layout.item_header, parent, false)
                return HeaderViewHolder(view)
            }
        }
    }
}
