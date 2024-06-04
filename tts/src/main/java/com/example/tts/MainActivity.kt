package com.example.tts

import android.content.Context
import android.os.Bundle
import android.speech.tts.TextToSpeech
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
import java.util.Locale

class MainActivity : ComponentActivity() {
    private var tts: TextToSpeech? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen(onOneScreenClicked = { text ->
                tts.readText(text)
            })
        }

        tts = initTTS(this@MainActivity)
    }

    fun initTTS(context: Context): TextToSpeech {
        var tts: TextToSpeech? = null
        tts = TextToSpeech(context) {
            if (it == TextToSpeech.SUCCESS) {
                val result = tts!!.setLanguage(Locale.US)
                if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                    Log.e("TextToSpeech", "해당 언어는 지원되지 않습니다.")
                    return@TextToSpeech
                }
            }
        }
        return tts
    }
}

fun TextToSpeech?.readText(text: String) {
    this?.speak(text, TextToSpeech.QUEUE_FLUSH, null, "")
    this?.playSilentUtterance(5000, TextToSpeech.QUEUE_ADD, null)
}

@Composable
fun MainScreen(
    onOneScreenClicked: (String) -> Unit,
) {
    val navController = rememberNavController()

    Scaffold(
        content = { paddingValues ->
            NavHost(
                navController = navController,
                startDestination = "one_screen",
                modifier = Modifier.padding(paddingValues)
            ) {
                composable("one_screen") {
                    OneScreen(
                        navController = navController,
                        onOneScreenClicked = onOneScreenClicked
                    )
                }
                composable("two_screen") { TwoScreen(navController) }
                composable("three_screen") { ThreeScreen(navController) }
            }
        }
    )
}

@Composable
fun OneScreen(
    navController: NavController,
    onOneScreenClicked: (String) -> Unit,
) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            val goToTwoScreen = "Go to TwoScreen"

            Text(text = "This is OneScreen")
            Button(onClick = {
                navController.navigate("two_screen")
                onOneScreenClicked(goToTwoScreen)
            }) {

                Text(text = goToTwoScreen)
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

//fun Context.logMemoryUsage(tag: String) {
//    val memoryInfo = ActivityManager.MemoryInfo()
//    val activityManager = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
//    activityManager.getMemoryInfo(memoryInfo)
//
//    val usedMemory = memoryInfo.totalMem - memoryInfo.availMem
//
//    Log.d(
//        "$tag MemoryUsage",
//        "Used Memory: $usedMemory, Available Memory: ${memoryInfo.availMem}, Total Memory: ${memoryInfo.totalMem}"
//    )
//}