package com.example.newaccountbookproject.view

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Observer
import com.example.newaccountbookproject.R
import com.example.newaccountbookproject.base.BaseActivity
import com.example.newaccountbookproject.databinding.ActivityMainBinding
import com.example.newaccountbookproject.model.MainViewModel
import com.example.newaccountbookproject.view.ui.theme.NewAccountBookProjectTheme

class MainActivity : BaseActivity<MainViewModel>() {

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
            }
        }
    }

    @Composable
    private fun MainCircularProgressAnimated() {
//        val infiniteTransition = rememberInfiniteTransition() 무한대로 동작하는 애니메이션

        //데이터 변화를 감지하는 ?? liveData로 어떻게 변형하지 ?
        val progress: Float by viewModel.progressNum.observeAsState(0.0f)

        //react effect 와 동일함. activity가 실행될때 최초 실행됨.
//        LaunchedEffect(Unit) {
//            progress = 0.7f
//        }

        val progressAnimation by animateFloatAsState(
            targetValue = progress,
            animationSpec = tween(1000)
        )

        Box() {
            CircularProgressIndicator(
                progress = progressAnimation,
                strokeWidth = 10.dp,
                color = Color.Blue,
                modifier = Modifier.fillMaxWidth().wrapContentHeight()
            )
            Text(
                text = "70%",
                modifier = Modifier.align(Alignment.Center).padding(vertical = 10.dp),
            )
        }

        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Blue
            )) {
            Text(text = "버튼입니다.", color = Color.White)
        }
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