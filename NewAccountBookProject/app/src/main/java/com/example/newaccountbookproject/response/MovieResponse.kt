package com.example.newaccountbookproject.response

import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @SerializedName("boxOfficeResult") val boxOfficeResult: BoxOfficeResult
)
