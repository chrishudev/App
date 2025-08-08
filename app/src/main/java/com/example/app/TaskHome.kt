package com.example.app

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.app.data.TaskEntity

@Composable
fun TaskForm(modifier: Modifier = Modifier) {
    var title by remember { mutableStateOf("") }
    var category by remember { mutableStateOf("") }
    var body by remember { mutableStateOf("") }

    val coroutineScope = rememberCoroutineScope()

    Column (modifier = modifier) {
        // TODO: use viewModel w/ coroutineScope
        OutlinedTextField(
            value = title,
            onValueChange = { title = it},
            label = { Text("Title")}
        )
        OutlinedTextField(
            value = category,
            onValueChange = { title = it},
            label = { Text("Category") }
        )
        OutlinedTextField(
            value = body,
            onValueChange = { body = it },
            label = { Text("Body") }
        )
        // Outlined button
        //      Onclick: 1) make TaskEntity with values title, category, & body; 2) save to database
    }
}