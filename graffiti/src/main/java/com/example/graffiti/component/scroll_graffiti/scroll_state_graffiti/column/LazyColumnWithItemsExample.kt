package com.example.graffiti.component.scroll_graffiti.scroll_state_graffiti.column

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.graffiti.component.scroll_graffiti.scroll_state_graffiti.item.userItem
import com.example.graffiti.model.User

@Composable
fun LazyColumnWithItemsExample(
    modifier: Modifier = Modifier,
    userList: List<User>,
) {
    BoxWithConstraints {
        val maxHeight = maxHeight
        LazyColumn(
            modifier = modifier
        ) {
//        Log.d("items 사용", "items 사용")
//        // 단일 항목 추가
            item {
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp)
                        .background(Color.Blue)
                )
            }
//
//        // 리스트 항목 추가
//        items(
//            count = userList.size,
//            key = { index -> userList[index].id },
//            contentType = { index -> userList[index]::class }
//        ) { index ->
//            Log.d("LazyColumn", "user: ${userList[index]}")
//            userItem(index = index, user = userList[index], tag = "items 사용")
//        }
//
//        // 단일 항목 추가
//        item {
//            userItem(index = 0, user = userList[0], tag = "items 사용")
//        }


        exam(userList = userList)

//            nestedItems(
//                modifier = Modifier.heightIn(min = 0.dp, max = maxHeight),
//                userList = userList
//            )
        }
    }

}

fun LazyListScope.exam(
    userList: List<User>,
    tag: String = "LazyListScope.exam",
) {
    Log.d(tag, "exam ///")
    userList.forEach { user ->
        Log.d(tag, "user: ${user}")
        examDetail(user = user)
    }
}

fun LazyListScope.examDetail(
    user: User,
    tag: String = "LazyListScope.examDetail",
) {
    Log.d(tag, "user: ${user}")
    item { 
        Spacer(modifier = Modifier.fillMaxWidth().height(100.dp).background(Color.Yellow))
    }
    
    item {
        userItem(user = user)
    }
}

fun LazyListScope.nestedItems(
    modifier: Modifier = Modifier,
    userList: List<User>,
) {
    item {
        Column {
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .background(Color.Magenta)
            )

            Spacer(modifier = Modifier
                .fillMaxHeight()
                .height(10.dp)
                .background(Color.White))

            LazyColumn(
                modifier = modifier
                    .fillMaxWidth()
                    .then(modifier)  // 필요에 따라 높이를 조정
            ) {
                items(userList) { user ->
                    Log.d("nestedItems", "user: ${user}")
                    userItem(index = userList.indexOf(user), user = user)
                }
            }
        }
    }
}

@Composable
fun ComposableNestedItems(
    userList: List<User>,
) {
    val scrollState = rememberScrollState()

    BoxWithConstraints {
        val maxHeight = maxHeight

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.LightGray)
                .verticalScroll(scrollState)
        ) {
            Text(
                text = "Nested Items",
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentSize()
                    .padding(16.dp)
                    .align(Alignment.CenterHorizontally),
                color = Color.Blue,
                fontSize = 100.sp
            )

            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(min = 0.dp, max = maxHeight)
                    .background(Color.Red)// 필요에 따라 높이를 조정
            ) {
                items(
                    count = userList.size,
                    key = { index -> userList[index].id },
                    contentType = { index -> userList[index]::class }
                ) { index ->
                    Log.d("nestedItems", "user: ${userList[index]}")
                    userItem(index = index, user = userList[index], tag = "items 사용")
                }
            }

            Spacer(modifier = Modifier.height(50.dp))

//            LazyColumn(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .heightIn(min = 0.dp, max = maxHeight)
//                    .background(Color.Blue)// 필요에 따라 높이를 조정
//            ) {
//                items(
//                    count = userList.size,
//                    key = { index -> userList[index].id },
//                    contentType = { index -> userList[index]::class }
//                ) { index ->
//                    Log.d("nestedItems", "user: ${userList[index]}")
//                    userItem(index = index, user = userList[index], tag = "items 사용")
//                }
//            }
        }
    }
}