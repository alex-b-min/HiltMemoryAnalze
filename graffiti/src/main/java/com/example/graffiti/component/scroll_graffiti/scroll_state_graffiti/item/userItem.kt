package com.example.graffiti.component.scroll_graffiti.scroll_state_graffiti.item

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.graffiti.model.User

@Composable
fun userItem(
    index: Int = 1,
    user: User,
    tag: String = ""
) {
    if (index != 0) {
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(10.dp)
                .background(Color.LightGray)
        )
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .padding(top = if (index != 0) 10.dp else 0.dp)
            .padding(bottom = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Log.d(tag, "user: ${user}")
        Text(text = "Name: ${user.name}", style = MaterialTheme.typography.titleLarge)
        Text(text = "Email: ${user.email}", style = MaterialTheme.typography.bodyMedium)
        Text(text = "Phone: ${user.phone}", style = MaterialTheme.typography.bodyMedium)
    }

    Spacer(
        modifier = Modifier
            .fillMaxWidth()
            .height(1.dp)
            .background(Color.LightGray)
    )
}