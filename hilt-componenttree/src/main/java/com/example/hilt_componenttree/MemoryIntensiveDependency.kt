package com.example.hilt_componenttree

import android.util.Log
import javax.inject.Inject


class MemoryIntensiveDependency @Inject constructor() {
    private val largeData: MutableList<IntArray> = mutableListOf()

    init {
        for (i in 0 until 20) {
            largeData.add(IntArray(1024 * 1024)) // 각 배열이 약 4MB를 차지
        }
        Log.d("MemoryUsage", "Memory intensive dependency initialized.")
    }
}

class ComponentA @Inject constructor(private val componentB: ComponentB) {
    fun doSomething() {
        Log.d("Action", "A doing something, invoking B.")
        componentB.doSomething()
    }
}

class ComponentB @Inject constructor(private val componentC: ComponentC) {
    fun doSomething() {
        Log.d("Action", "B doing something, invoking C.")
        componentC.doSomething()
    }
}

class ComponentC @Inject constructor(private val componentD: ComponentD) {
    fun doSomething() {
        Log.d("Action", "C doing something, invoking D.")
        componentD.doSomething()
    }
}

class ComponentD @Inject constructor(private val componentE: ComponentE) {
    fun doSomething() {
        Log.d("Action", "D doing something, invoking E.")
        componentE.doSomething()
    }
}

class ComponentE @Inject constructor(private val componentF: ComponentF) {
    fun doSomething() {
        Log.d("Action", "E doing something, invoking F.")
        componentF.doSomething()
    }
}

class ComponentF @Inject constructor(private val memoryDependency: MemoryIntensiveDependency) {
    fun doSomething() {
        Log.d("Action", "F doing something with heavy memory usage.")
        memoryDependency.toString()
    }
}
