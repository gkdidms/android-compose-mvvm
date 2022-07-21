package com.example.newaccountbookproject.view

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
    private fun MainView() {
        Surface(
            color = Color.White
        ) {
            Column() {
                MainCircularProgressAnimated()
                MainButton()
            }
        }
    }



    @Composable
    private fun MainCircularProgressAnimated() {
        val progressValue = 0.75f
//        val infiniteTransition = rememberInfiniteTransition()
        var progress by remember {
            mutableStateOf(0.0f)
        }

        //react effect 와 동일함. activity가 실행될때 최초 실행됨.
        LaunchedEffect(Unit) {
            progress = 0.7f
        }

        val progressAnimation by animateFloatAsState(
            targetValue = progress,
            animationSpec = tween(1000)
        )
        CircularProgressIndicator(
            progress = progressAnimation,
            strokeWidth = 5.dp,
            color = Color.Blue
        )

        Button(onClick = {
                         progress = (0 until 100).random().toFloat() / 100
        },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Blue
            )) {
            Text(text = "버튼입니다.", color = Color.White)
        }
    }

    @Composable
    private fun MainButton() {

    }

    @Composable
    private fun TextGreeting(text: String) {
        Surface(
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 12.dp)
        ) {
            Text(
                text = text,
                modifier = Modifier.fillMaxWidth()
            )
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