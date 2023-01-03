package com.mth.example.buoi1sua.movie

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.mth.example.buoi1sua.R

class MovieAdapter(
    private val context: Context
) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
    private var movieList: List<Movie> = listOf()
    fun setData(list: List<Movie>) {
        this.movieList = list
        notifyDataSetChanged()
    }
    inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imgItemMovie: ImageView = itemView.findViewById(R.id.img_item_movie)
        fun onBind(movie: Movie) {
            imgItemMovie.setImageResource(movie.resourceID)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.item_movie,parent,false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.onBind(movieList[position])
    }

    override fun getItemCount(): Int = movieList.size
}