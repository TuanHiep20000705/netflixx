package com.mth.example.buoi1sua.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mth.example.buoi1sua.R
import com.mth.example.buoi1sua.category.Category
import com.mth.example.buoi1sua.category.CategoryAdapter
import com.mth.example.buoi1sua.movie.Movie
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val categoryAdapter: CategoryAdapter by lazy {
        CategoryAdapter(this@MainActivity)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initControls()
    }

    private fun initControls() {
        rcv_category.setHasFixedSize(true)
        rcv_category.layoutManager = LinearLayoutManager(this)
        categoryAdapter.setData(getListCategory())
        rcv_category.adapter = categoryAdapter
    }

    private fun getListCategory(): List<Category> {
        val listCategory: MutableList<Category> = mutableListOf()
        val listMovie: MutableList<Movie> = mutableListOf()
        listMovie.add(Movie(R.drawable.imgitemmovie))
        listMovie.add(Movie(R.drawable.imgitemmovie))
        listMovie.add(Movie(R.drawable.imgitemmovie))
        listMovie.add(Movie(R.drawable.imgitemmovie))
        listMovie.add(Movie(R.drawable.imgitemmovie))
        listMovie.add(Movie(R.drawable.imgitemmovie))
        listMovie.add(Movie(R.drawable.imgitemmovie))
        listMovie.add(Movie(R.drawable.imgitemmovie))

        listCategory.add(Category(MovieViewType.TOP_BANNER.toString(), listMovie))
        listCategory.add(Category(MovieViewType.TOP_TEN_VIETNAM_SHOW.toString(), listMovie))
        listCategory.add(Category(MovieViewType.TV_SHOW.toString(), listMovie))
        listCategory.add(Category(MovieViewType.TRENDING_NOW.toString(), listMovie))
        return listCategory
    }
}