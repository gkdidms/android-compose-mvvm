package com.example.newaccountbookproject.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.newaccountbookproject.base.BaseViewModel
import com.example.newaccountbookproject.repository.MovieRepository
import com.example.newaccountbookproject.response.DailyBoxOfficeList
import kotlinx.coroutines.launch

class MainViewModel: BaseViewModel() {
    private var _progressNum = MutableLiveData<Float>()
    private var _dailyBoxOfficeList = MutableLiveData<ArrayList<DailyBoxOfficeList>>()
    val repository = MovieRepository()

    val progressNum: LiveData<Float>
        get() = _progressNum
    val dailyBoxOfficeList: LiveData<ArrayList<DailyBoxOfficeList>>
        get() = _dailyBoxOfficeList

    init {
        _progressNum.value = 0.7f
    }

    fun getMoveList(key:String, targetDt: String) {
        viewModelScope.launch {
            try {
                val response = repository.getMovieList(key, targetDt)
                response.let {
                    if (it.isSuccessful) {
                        Log.e("response", it.body()?.boxOfficeResult?.dailyBoxOfficeList.toString())
                        _dailyBoxOfficeList.value = it.body()?.boxOfficeResult?.dailyBoxOfficeList
                    } else{
                        print(it.message())
                    }
                }
            } catch (e: Exception) {
                print(e)
            }
        }
    }

}