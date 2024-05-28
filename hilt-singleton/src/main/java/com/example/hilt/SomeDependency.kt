package com.example.hilt

import android.util.Log
import javax.inject.Inject

class SomeDependency @Inject constructor() {
    private val largeData: MutableList<IntArray> = mutableListOf()

    init {
        val startTime = System.currentTimeMillis()
        // 배열 할당 코드
        val largeData = mutableListOf<IntArray>()
        for (i in 0 until 20) {
            largeData.add(IntArray(1024 * 1024))  // 각 배열이 약 4MB를 차지
        }
        val endTime = System.currentTimeMillis()
        Log.d("SomeDependency", "Init block took ${endTime - startTime} milliseconds.")
    }

    fun doSomething(tag: String) {
        Log.d("SomeDependency", "tag")
    }
}
