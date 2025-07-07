package com.example.app

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Task(
    @PrimaryKey val id: Int,
    val title: String = "",
    val category: String = "",
    val body: String = ""
)
@Composable
fun TodoForm(modifier: Modifier = Modifier) {
    var title by remember { mutableStateOf("") }
    var category by remember { mutableStateOf("") }
    var body by remember { mutableStateOf("") }

    Column (modifier = modifier) {
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
    }
}