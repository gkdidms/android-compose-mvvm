package com.example.newaccountbookproject.repository

import com.example.newaccountbookproject.response.MovieResponse
import retrofit2.Response
import retrofit2.http.GET

interface MovieRepositoryInterface {
    @GET()
    suspend fun getMovie(key: String, targetDt: String) : Response<MovieResponse>
}