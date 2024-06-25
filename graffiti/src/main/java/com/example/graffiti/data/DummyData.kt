package com.example.graffiti.data

import com.example.graffiti.model.User

object DummyData {
    val userList = List(20) {
        User(
            id = it,
            name = "User $it",
            email = "user$it@example.com",
            phone = "123-456-789$it"
        )
    }
}