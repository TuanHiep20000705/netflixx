package com.mth.example.buoi1sua.category

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.mth.example.buoi1sua.R
import com.mth.example.buoi1sua.movie.MovieAdapter

class CategoryAdapter(
    private val context: Context
) : ListAdapter<Category, ViewHolder>(CategoryDiffUtil) {
    private val TYPE_HEADER = 0
    private val TYPE_NORMAL = 1

    fun setData(list: List<Category>) {
        submitList(list)
    }

    object CategoryDiffUtil : DiffUtil.ItemCallback<Category>() {
        override fun areItemsTheSame(oldItem: Category, newItem: Category): Boolean {
            return oldItem.nameCategory == newItem.nameCategory
        }

        override fun areContentsTheSame(oldItem: Category, newItem: Category): Boolean {
            return oldItem.nameCategory == newItem.nameCategory
        }

    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) {
            TYPE_HEADER
        } else {
            TYPE_NORMAL
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        if (viewType == TYPE_HEADER) {
            val view: View =
                LayoutInflater.from(context).inflate(R.layout.item_header, parent, false)
            return HeaderViewHolder(view)
        } else {
            val view: View =
                LayoutInflater.from(context).inflate(R.layout.item_category, parent, false)
            return CategoryViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (position > 0) {
            holder as CategoryViewHolder
            holder.onBind(getItem(position - 1))
        }
    }

    override fun getItemCount(): Int {
        return currentList.size + 1
    }

    inner class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val txtNameCategory: TextView = itemView.findViewById(R.id.txt_name_category)
        private val rcvMovie: RecyclerView = itemView.findViewById(R.id.rcv_movie)
        fun onBind(category: Category) {
            txtNameCategory.setText(category.nameCategory)
            rcvMovie.setHasFixedSize(true)
            rcvMovie.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
            val movieAdapter = MovieAdapter(context)
            movieAdapter.setData(category.listMovie)
            rcvMovie.adapter = movieAdapter
        }
    }

    inner class HeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}