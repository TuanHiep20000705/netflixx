package com.mth.example.buoi1sua.category

import com.mth.example.buoi1sua.movie.Movie

sealed class MovieItem(val id: String) {
    class Header(id: String, var nameCategory: String = "") :
        MovieItem(id)

    class Category(id: String, var nameCategory: String = "", var listMovie: List<Movie>) :
        MovieItem(id)
}
