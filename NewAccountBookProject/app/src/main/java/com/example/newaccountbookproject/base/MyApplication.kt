package com.example.newaccountbookproject.base

import android.app.Application
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class MyApplication:Application() {

    val BASE_API = "https://www.kobis.or.kr"

    //전역변수
    companion object {
        lateinit var sRetrofit: Retrofit
    }


    override fun onCreate() {
        super.onCreate()
        initRetrofitInstance()
    }

    private fun initRetrofitInstance() {
        val okHttp = OkHttpClient.Builder()
            .readTimeout(5000, TimeUnit.SECONDS)
            .connectTimeout(5000, TimeUnit.SECONDS)
            .build()

        sRetrofit = Retrofit.Builder()
            .baseUrl(BASE_API)
            .client(okHttp)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }





}