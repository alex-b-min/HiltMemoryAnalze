package com.example.hilt

import android.util.Log
import javax.inject.Inject

class SomeDependency @Inject constructor() {
    private val largeData: MutableList<IntArray> = mutableListOf()

    init {
        // 메모리를 많이 사용하는 큰 데이터 생성
        for (i in 0 until 20) {
            largeData.add(IntArray(1024 * 1024)) // 각 배열이 약 4MB를 차지
        }
    }

    fun doSomething() {
        // 메모리를 많이 사용하는 작업 수행
        for (data in largeData) {
            data.fill(1) // 데이터 채우기
        }
        largeData.forEach {
            Log.d("data", "$it")
        }
    }
}
