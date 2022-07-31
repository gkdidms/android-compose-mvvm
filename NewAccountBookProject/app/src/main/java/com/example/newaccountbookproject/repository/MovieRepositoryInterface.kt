package com.example.newaccountbookproject.repository

import com.example.newaccountbookproject.response.MovieResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Part
import retrofit2.http.Query

interface MovieRepositoryInterface {
    @GET("/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json")
    suspend fun getMovie(@Query("key") key: String, @Query("targetDt") targetDt: String) : Response<MovieResponse>
}