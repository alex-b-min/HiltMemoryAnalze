package com.example.hilt

import android.app.ActivityManager
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
        @Inject
        lateinit var someDependency: SomeDependency
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        logMemoryUsage("@ Before Hilt Initialization")
        setContent {
            MainScreen()
        }
        someDependency.doSomething()

        logMemoryUsage("@ After Hilt Initialization")
    }
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    Scaffold(
        content = { paddingValues ->
            NavHost(
                navController = navController,
                startDestination = "one_screen",
                modifier = Modifier.padding(paddingValues)
            ) {
                composable("one_screen") { OneScreen(navController) }
                composable("two_screen") { TwoScreen(navController) }
                composable("three_screen") { ThreeScreen(navController) }
            }
        }
    )
}

@Composable
fun OneScreen(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "This is OneScreen")
            Button(onClick = { navController.navigate("two_screen") }) {
                Text(text = "Go to TwoScreen")
            }
            Button(onClick = { navController.navigate("three_screen") }) {
                Text(text = "Go to ThreeScreen")
            }
        }
    }
}

@Composable
fun TwoScreen(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "This is TwoScreen")
            Button(onClick = { navController.navigate("one_screen") }) {
                Text(text = "Go to OneScreen")
            }
            Button(onClick = { navController.navigate("three_screen") }) {
                Text(text = "Go to ThreeScreen")
            }
        }
    }
}

@Composable
fun ThreeScreen(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "This is ThreeScreen")
            Button(onClick = { navController.navigate("one_screen") }) {
                Text(text = "Go to OneScreen")
            }
            Button(onClick = { navController.navigate("two_screen") }) {
                Text(text = "Go to TwoScreen")
            }
        }
    }
}

fun Context.logMemoryUsage(tag: String) {
    val memoryInfo = ActivityManager.MemoryInfo()
    val activityManager = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
    activityManager.getMemoryInfo(memoryInfo)

    val usedMemory = memoryInfo.totalMem - memoryInfo.availMem

    Log.d(
        "$tag MemoryUsage",
        "Used Memory: $usedMemory, Available Memory: ${memoryInfo.availMem}, Total Memory: ${memoryInfo.totalMem}"
    )
}