package com.example.graffiti

import android.content.ComponentCallbacks2
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.graffiti.component.scroll_graffiti.scroll_state_graffiti.column.LazyColumnWithItemsExample
import com.example.graffiti.data.DummyData.userList
import com.example.graffiti.produceState.UserInformation
import com.example.graffiti.segmented_button.SegmentedButtonItem
import com.example.graffiti.segmented_button.SegmentedButtons
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            var selectedIndex by remember {
                mutableStateOf(0)
            }

            SegmentedButtons {
                SegmentedButtonItem(
                    selected = selectedIndex == 0,
                    onClick = { selectedIndex = 0 },
                    label = { Text(if (selectedIndex == 0) "AAA" else "") },
                    icon = { if (selectedIndex == 0) Icon(imageVector = Icons.Filled.AccountBox, "") }
                )
                SegmentedButtonItem(
                    selected = selectedIndex == 1,
                    onClick = { selectedIndex = 1 },
                    label = { Text(if (selectedIndex == 1) "AAA" else "") },
                    icon = { if (selectedIndex == 1) Icon(imageVector = Icons.Filled.AccountBox, "") }
                )
                SegmentedButtonItem(
                    selected = selectedIndex == 2,
                    onClick = { selectedIndex = 2 },
                    label = { Text(if (selectedIndex == 2) "AAA" else "") },
                    icon = { if (selectedIndex == 2) Icon(imageVector = Icons.Filled.AccountBox, "") }
                )
            }

            val scrollState = rememberScrollState()

//            ComposableNestedItems(userList)
//
            /**
             * LazyColumnItemVsItemsExample
             */
//            LazyColumnItemVsItemsExample()

            /**
             * BottomSheetScaffoldExam
             */
//            BottomSheetScaffoldExam()

            /**
             * ModalBottomSheetExample
             */
//            ModalBottomSheetExample()

            /**
             * rememberExample
             */
//            rememberExample()

            /**
             * rememberSaveableExample
             */
//            rememberSaveableExample()

            /**
             * produceStateExample
             */
//            UserInformation(userId = "15")

//            HostColumn(
//                scrollType = ScrollType.VERTICAL,
//                modifier = Modifier
//                    .fillMaxSize()
//                    .background(Color.White)
////                    .verticalScroll(scrollState),
//            ) {
//                // scrollState를 가진 LazyColumn
//                LazyColumnWithScroll(
//                    modifier = Modifier
//                        .height(300.dp)
//                        .background(Color.Magenta),
//                    users = userList
//                )
//
//                Spacer(modifier = Modifier.height(20.dp))
//
//                // scrollState를 가진 Column
//                ColumnWithScroll(
//                    modifier = Modifier
//                        .height(300.dp)
//                        .background(Color.Blue),
//                    users = userList,
//                )
//
//                Spacer(modifier = Modifier.height(20.dp))
//
//                // scrollState를 가지지 않은 Column
//                Column(
//                    modifier = Modifier.background(Color.Yellow)
//                ) {
//                    for (i in 0..99) {
//                        userItem(
//                            index = i,
//                            user = userList[i]
//                        )
//                    }
//                }
//            }


        }
    }
}

/**
 * LazyColumn의 item{} 블럭과 items{} 블럭의 차이점을 보여주는 예제
 */
@Composable
fun LazyColumnItemVsItemsExample() {
    Column {
//        LazyColumnWithItemExample(
//            modifier = Modifier.weight(1f).background(Color.Blue),
//            userList = userList
//        )

        LazyColumnWithItemsExample(
            modifier = Modifier
                .weight(1f)
                .background(Color.Red),
            userList = userList
        )
    }
}

/**
 * BottomSheetScaffold 예제
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheetScaffoldExam() {
    val scaffoldState = rememberBottomSheetScaffoldState()
    val scope = rememberCoroutineScope()

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Button(onClick = {
                scope.launch {
                    scaffoldState.bottomSheetState.expand()
                }
            }) {
                Text("Bottom Sheet 열기")
            }
        }

        BottomSheetScaffold(
            scaffoldState = scaffoldState,
            sheetContent = {
                Image(
                    imageVector = Icons.Filled.AccountBox,
                    contentDescription = null
                )
            },
            sheetPeekHeight = 0.dp
        ) {}
    }
}

/**
 * ModalBottomSheet 예제
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ModalBottomSheetExample() {
    val sheetState = rememberModalBottomSheetState()
    var isSheetOpen by rememberSaveable {
        mutableStateOf(false)
    }

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Button(onClick = {
                isSheetOpen = true
            }) {
                Text("Bottom Sheet 열기")
            }
        }

        if (isSheetOpen) {
            ModalBottomSheet(
                sheetState = sheetState,
                onDismissRequest = {
                    isSheetOpen = false
                },
            ) {
                Image(
                    imageVector = Icons.Filled.AccountBox,
                    contentDescription = null
                )
            }
        }
    }
}

@Composable
fun rememberExample() {
    var rememberText by remember { mutableStateOf(0) }

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = {
                    rememberText += 1
                }) {
                Text(text = rememberText.toString())
            }
        }
    }
}

@Composable
fun rememberSaveableExample() {
    var rememberText by rememberSaveable { mutableStateOf(0) }

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = {
                    rememberText += 1
                }) {
                Text(text = rememberText.toString())
            }
        }
    }
}

