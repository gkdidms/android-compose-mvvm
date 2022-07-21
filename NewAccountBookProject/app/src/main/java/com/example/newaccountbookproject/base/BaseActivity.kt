package com.example.newaccountbookproject.base

import android.app.Activity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

//제너릭 문법 공부 필요
abstract class BaseActivity<T: ViewDataBinding, R: BaseViewModel>(private val layoutInt: Int) : ComponentActivity() {

    private lateinit var binding: T

    abstract val viewModel: R

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, layoutInt)
        binding.lifecycleOwner = this@BaseActivity

    }

    fun showToastMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

}