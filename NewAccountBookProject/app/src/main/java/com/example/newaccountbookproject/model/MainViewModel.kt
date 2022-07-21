package com.example.newaccountbookproject.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.newaccountbookproject.base.BaseViewModel

class MainViewModel: BaseViewModel() {
    private var _progressNum = MutableLiveData<Float>()

    val progressNum: LiveData<Float>
        get() = _progressNum

    init {
        _progressNum.value = 0.7f
    }

}