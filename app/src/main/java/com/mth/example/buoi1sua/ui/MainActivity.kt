package com.mth.example.buoi1sua.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mth.example.buoi1sua.R
import com.mth.example.buoi1sua.category.CategoryAdapter
import com.mth.example.buoi1sua.category.MovieItem
import com.mth.example.buoi1sua.movie.Movie
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val categoryAdapter by lazy {
        CategoryAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initControls()
    }

    private fun initControls() {
        rcv_category.setHasFixedSize(true)
        categoryAdapter.submitList(getListCategory())
        rcv_category.adapter = categoryAdapter
    }

    private fun getListCategory(): List<MovieItem> {
        val listData: MutableList<MovieItem> = mutableListOf()
        val listMovie: MutableList<Movie> = mutableListOf()
        listMovie.add(Movie(R.drawable.imgitemmovie))
        listMovie.add(Movie(R.drawable.imgitemmovie))
        listMovie.add(Movie(R.drawable.imgitemmovie))
        listMovie.add(Movie(R.drawable.imgitemmovie))
        listMovie.add(Movie(R.drawable.imgitemmovie))
        listMovie.add(Movie(R.drawable.imgitemmovie))
        listMovie.add(Movie(R.drawable.imgitemmovie))
        listMovie.add(Movie(R.drawable.imgitemmovie))

        listData.add(
            MovieItem.Header(
                MovieViewType.TOP_BANNER.toString(),
                MovieViewType.TOP_BANNER.ordinal.toString()
            )
        )
        listData.add(
            MovieItem.Category(
                MovieViewType.TOP_BANNER.toString(),
                "TOP_TEN_VIETNAM_SHOW",
                listMovie
            )
        )
        listData.add(
            MovieItem.Category(
                MovieViewType.TOP_TEN_VIETNAM_SHOW.toString(),
                "TV_SHOW",
                listMovie
            )
        )
        listData.add(
            MovieItem.Category(
                MovieViewType.TV_SHOW.toString(),
                "TRENDING_NOW",
                listMovie
            )
        )
        listData.add(
            MovieItem.Category(
                MovieViewType.TRENDING_NOW.toString(),
                "ANIME",
                listMovie
            )
        )
        return listData
    }
}