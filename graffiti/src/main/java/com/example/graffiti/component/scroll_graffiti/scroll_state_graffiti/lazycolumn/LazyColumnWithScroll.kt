package com.example.graffiti.component.scroll_graffiti.scroll_state_graffiti.lazycolumn

import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import com.example.graffiti.component.scroll_graffiti.scroll_state_graffiti.item.userItem
import com.example.graffiti.model.User
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.launch

@OptIn(FlowPreview::class)
@Composable
fun LazyColumnWithScroll(
    modifier: Modifier = Modifier,
    users: List<User>,
) {
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        snapshotFlow { listState.isScrollInProgress }
            .debounce(300) // Adjust debounce time as needed
            .collect { isScrolling ->
                if (!isScrolling) {
                    coroutineScope.launch {
                        while (true) {
                            delay(1500)
                            if (listState.isScrollInProgress) {
                                break
                            }
                            val lastVisibleItemIndex = listState.layoutInfo.visibleItemsInfo.lastOrNull()?.index
                            if (lastVisibleItemIndex != null) {
                                val targetIndex = lastVisibleItemIndex + 1
                                if (targetIndex < users.size) {
                                    listState.animateScrollToItem(targetIndex)
                                } else {
                                    listState.scrollToItem(0)
                                }
                            }
                        }
                    }
                }
            }
    }

    LazyColumn(
        modifier = Modifier.wrapContentSize(),
        state = listState
    ) {
        itemsIndexed(
            items = users,
            key = { index, user -> user.id },
            contentType = { index, user -> user::class }
        ) { index, user ->
            userItem(
                index = index,
                user = user
            )
        }
    }
}