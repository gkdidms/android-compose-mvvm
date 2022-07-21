package com.example.newaccountbookproject.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import com.example.newaccountbookproject.R
import com.example.newaccountbookproject.base.BaseActivity
import com.example.newaccountbookproject.databinding.ActivityMainBinding
import com.example.newaccountbookproject.model.MainViewModel
import com.example.newaccountbookproject.view.ui.theme.NewAccountBookProjectTheme

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(R.layout.activity_main) {

    override val viewModel: MainViewModel by viewModels() //의존성 주입

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewAccountBookProjectTheme() {
                MainView()
            }
        }


    }

    @Composable
    private fun MainView(names: List<String> = listOf("ioio", "yeeun")) {
        Surface(color = Color.Black
        ) {
            Column() {
                for (name in names) {
                    TextGreeting(text = name)
                }
            }
        }

    }

    @Composable
    private fun TextGreeting(text: String) {
        Surface(
            color = Color.White,
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 12.dp)
        ) {
            Text(text = text, modifier = Modifier.fillMaxWidth())
        }
    }

    @Preview(showBackground = true, widthDp = 320, heightDp = 640)
    @Composable
    fun DefaultPreview() {
        NewAccountBookProjectTheme {
            MainView()
        }
    }


}