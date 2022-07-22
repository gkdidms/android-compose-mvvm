package com.example.newaccountbookproject.base

import android.app.Activity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

//제너릭 문법 공부 필요
abstract class BaseActivity<R: BaseViewModel> : ComponentActivity() {

    abstract val viewModel: R

    fun showToastMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

}