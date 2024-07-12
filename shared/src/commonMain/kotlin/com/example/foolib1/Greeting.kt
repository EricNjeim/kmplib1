package com.example.foolib1

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

class Greeting {
    private val platform: Platform = getPlatform()
@Composable
    fun greet() {
    MaterialTheme {
        var showGreeting by remember { mutableStateOf(false) }
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = { showGreeting = !showGreeting }) {
                Text("Click Me")
            }
            if (showGreeting) {
                Text("Hello, Compose!")
            }
    }
}}}