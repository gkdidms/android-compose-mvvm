package com.example.newaccountbookproject.view

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.newaccountbookproject.base.BaseActivity
import com.example.newaccountbookproject.viewmodel.MainViewModel
import com.example.newaccountbookproject.view.ui.theme.NewAccountBookProjectTheme

class MainActivity : BaseActivity<MainViewModel>() {

    override val viewModel: MainViewModel by viewModels() //의존성 주입
    private val key = "b3a487cd4400b8bb9805b40d9df5ec60"
    private val targetDt = "20220728"
    var num: Int = 10
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewAccountBookProjectTheme() {
                num = viewModel.dailyBoxOfficeList.observeAsState().value?.size ?: 10
                MainView()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        viewModel.getMoveList(key=key, targetDt=targetDt)
    }

    @Composable
    private fun MainView() {
        Surface(
            color = Color.White
        ) {
            //RecyclerView 같은거임
            LazyColumn() {
                //MainCircularProgressAnimated()

                items(num) {
                    MainItem(it)
                }
            }
        }
    }

    @Composable
    private fun MainItem(num: Int) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Text(text = viewModel.dailyBoxOfficeList.value?.get(num)?.rnum ?: "데이터 없음")
            Text(text = viewModel.dailyBoxOfficeList.value?.get(num)?.movieNm ?: "데이터 없음")
        }
    }


//    @Composable
//    private fun MainCircularProgressAnimated() {
////        val infiniteTransition = rememberInfiniteTransition() 무한대로 동작하는 애니메이션
//
//        //데이터 변화를 감지하는 ?? liveData로 어떻게 변형하지 ?
//        val progress: Float by viewModel.progressNum.observeAsState(0.0f)
//
//        //react effect 와 동일함. activity가 실행될때 최초 실행됨.
////        LaunchedEffect(Unit) {
////            progress = 0.7f
////        }
//
//        val progressAnimation by animateFloatAsState(
//            targetValue = progress,
//            animationSpec = tween(1000)
//        )
//
//        Box() {
//            CircularProgressIndicator(
//                progress = progressAnimation,
//                strokeWidth = 10.dp,
//                color = Color.Blue,
//                modifier = Modifier.fillMaxWidth().height(500.dp)
//            )
//            Text(
//                text = "70%",
//                modifier = Modifier.align(Alignment.Center).padding(vertical = 10.dp),
//            )
//        }
//
//        Button(
//            onClick = {},
//            colors = ButtonDefaults.buttonColors(
//                backgroundColor = Color.Blue
//            )) {
//            Text(text = "버튼입니다.", color = Color.White)
//        }
//    }

    @Preview(showBackground = true, widthDp = 320, heightDp = 640)
    @Composable
    fun DefaultPreview() {
        NewAccountBookProjectTheme {
            MainView()
        }
    }


}