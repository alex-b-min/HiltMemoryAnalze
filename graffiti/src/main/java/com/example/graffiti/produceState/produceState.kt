package com.example.graffiti.produceState

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import kotlinx.coroutines.delay

@Composable
fun UserInformation(userId: String) {
    val userData = produceState<User?>(initialValue = null) {
        value = fetchUserData(userId) // 비동기 함수 호출
    }

    when (val user = userData.value) {
        null -> CircularProgressIndicator() // 데이터 로딩 중
        else -> Text("Hello, ${user.name}!") // 데이터 로드 완료
    }
}

suspend fun fetchUserData(userId: String): User {
    delay(2000) // 네트워크 지연 시뮬레이션
    return User(userId, "John Doe") // 사용자 데이터 반환
}

data class User(val id: String, val name: String)