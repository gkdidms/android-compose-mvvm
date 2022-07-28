package com.example.newaccountbookproject.response

import com.google.gson.annotations.SerializedName

data class BoxOfficeResult(
    @SerializedName("dailyBoxOfficeList") val dailyBoxOfficeList : ArrayList<DailyBoxOfficeList>
)
