package com.example.graffiti.component.scroll_graffiti.scroll_state_graffiti.column

import android.util.Log
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.graffiti.component.scroll_graffiti.scroll_state_graffiti.item.userItem
import com.example.graffiti.model.User

@Composable
fun LazyColumnWithItemExample(
    userList: List<User>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
    ) {
        Log.d("items 사용 X", "items 사용 X")
        // 단일 항목 추가
        item {
            userItem(index = 0, user = userList[0], tag = "items 사용 X")
        }

        // 여러 항목을 반복문으로 추가
        item {
            for (i in 1..<userList.size - 1) {
                userItem(index = i, user = userList[i], tag = "items 사용 X")
            }
        }

        // 단일 항목 추가
        item {
            userItem(index = 0, user = userList[0], tag = "items 사용 X")
        }
    }
}
