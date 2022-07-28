package com.example.newaccountbookproject.repository

import android.app.Application
import com.example.newaccountbookproject.base.MyApplication
import com.example.newaccountbookproject.base.MyApplication.Companion.sRetrofit

class MovieRepository {
    private val movieRepositoryInterface: MovieRepositoryInterface = sRetrofit.create(
        MovieRepositoryInterface::class.java
    )

    suspend fun getMovieList(key: String, targetDt: String) = movieRepositoryInterface.getMovie(key, targetDt)
}