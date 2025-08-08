package com.example.app

import android.content.ClipData.Item
import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Room
import com.example.app.data.TaskRepository

@Entity(tableName = "tasks")
data class Task(
    // Entity for tasks
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String = "",
    val category: String = "",
    val body: String = ""
)



@Composable
fun TodoHome(modifier: Modifier = Modifier) {
    // Home function of the task list
}


@Composable
fun TaskList(modifier: Modifier = Modifier) {
    // List of all tasks
    TaskForm(modifier)
}

@Composable
fun TaskForm(modifier: Modifier = Modifier) {
    // Form for creating new tasks
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
            onValueChange = { category = it},
            label = { Text("Category") }
        )
        OutlinedTextField(
            value = body,
            onValueChange = { body = it },
            label = { Text("Body") }
        )
        Button(onClick = { TaskRepository.insertItem() }) { Text("submit") }
    }
}