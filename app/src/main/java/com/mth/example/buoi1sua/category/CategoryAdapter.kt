package com.mth.example.buoi1sua.category

import android.app.TaskStackBuilder.create
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

//class CategoryAdapter(
//    private val context: Context
//) : ListAdapter<Category, ViewHolder>(CategoryDiffUtil) {
//    private val TYPE_HEADER = 0
//    private val TYPE_NORMAL = 1
enum class ItemType {
    HEADER, NORMAL
}

//fun setData(list: List<Category>) {
//    submitList(list)
//}

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
//    if (viewType == TYPE_HEADER) {
//        val view: View =
//            LayoutInflater.from(context).inflate(R.layout.item_header, parent, false)
//        return HeaderViewHolder(view)
//    } else {
//        val view: View =
//            LayoutInflater.from(context).inflate(R.layout.item_category, parent, false)
//        return CategoryViewHolder(view)
//    }
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
//    if (position > 0) {
//        holder as CategoryViewHolder
//        holder.onBind(getItem(position - 1))
//    }
        when (getItemViewType(position)) {
            ItemType.HEADER.ordinal -> {
                (holder as HeaderViewHolder).bind()
            }
            else -> {
                (holder as CategoryViewHolder).bind(getItem(position) as MovieItem.Category)
            }
        }
    }

//    override fun getItemCount(): Int {
//        return currentList.size + 1
//    }

    class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val txtNameCategory: TextView = itemView.findViewById(R.id.txt_name_category)
        private val rcvMovie: RecyclerView = itemView.findViewById(R.id.rcv_movie)
        fun bind(category: MovieItem.Category) {
            txtNameCategory.setText(category.nameCategory)
            rcvMovie.setHasFixedSize(true)
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

    class HeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
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