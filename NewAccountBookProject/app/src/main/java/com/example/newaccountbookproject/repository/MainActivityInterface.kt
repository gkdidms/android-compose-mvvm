package com.example.newaccountbookproject.repository

import com.example.newaccountbookproject.response.MovieResponse

interface MainActivityInterface {
    fun onGetMovieListSuccess(result: MovieResponse)
    fun onGetMovieListFuiled(message: String)
}