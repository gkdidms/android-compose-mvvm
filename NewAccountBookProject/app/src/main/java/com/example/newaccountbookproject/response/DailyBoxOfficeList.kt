package com.example.newaccountbookproject.response

import com.google.gson.annotations.SerializedName

data class DailyBoxOfficeList(
    @SerializedName("rnum") val rnum : String,
    @SerializedName("movieNm") val movieNm: String
)
