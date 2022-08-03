package com.example.newaccountbookproject.view

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newaccountbookproject.base.BaseActivity
import com.example.newaccountbookproject.view.ui.theme.NewAccountBookProjectTheme
import com.example.newaccountbookproject.viewmodel.MainViewModel

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
        viewModel.getMoveList(key = key, targetDt = targetDt)
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
        Box(modifier = Modifier.padding(10.dp)) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .border(1.dp, Color.Black, RoundedCornerShape(5.dp))
                    .padding(10.dp, 5.dp)
            ) {
                NumText(viewModel.dailyBoxOfficeList.value?.get(num)?.rnum ?: "데이터 없음")
                TitleText(viewModel.dailyBoxOfficeList.value?.get(num)?.movieNm ?: "데이터 없음")
            }
        }
    }

    @Composable
    private fun TitleText(title: String) {
        Text(text = title, fontSize = 20.sp)
    }

    @Composable
    private fun NumText(num: String) {
        Text(text = num, fontSize = 18.sp)
    }

    @Preview(showBackground = true, widthDp = 320, heightDp = 640)
    @Composable
    fun DefaultPreview() {
        NewAccountBookProjectTheme {
            MainView()
        }
    }


}