package com.example.graffiti.component.scroll_graffiti.scroll_state_graffiti.column

import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.example.graffiti.component.scroll_graffiti.scroll_state_graffiti.item.userItem
import com.example.graffiti.model.User
import kotlinx.coroutines.delay

@Composable
fun ColumnWithScroll(
    modifier: Modifier = Modifier,
    users: List<User>,
) {
    val scrollState = rememberScrollState()
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        while (true) {
            scrollState.animateScrollTo(
                value = scrollState.value + 10,
                animationSpec = tween(durationMillis = 50)
            )
            delay(50)
            if (scrollState.value == scrollState.maxValue) {
                scrollState.scrollTo(0)
            }
        }
    }

    Column(
        modifier = modifier.verticalScroll(scrollState)
    ) {
        for (i in 0..users.size - 1) {
            userItem(
                index = i,
                user = users[i]
            )
        }
    }
}

