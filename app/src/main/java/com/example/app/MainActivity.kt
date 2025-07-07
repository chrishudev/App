package com.example.app

import android.graphics.pdf.PdfDocument.Page
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.app.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                Body()
            }
        }
    }
}

@Composable
fun Body(modifier: Modifier = Modifier) {
    var page by remember { mutableIntStateOf(0) }
    Scaffold(
        modifier = modifier.fillMaxSize(),
        bottomBar = {
            BottomAppBar {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Button(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f),
                        onClick = { page = 0 }
                    ) { Text("1") }
                    Button(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f),
                        onClick = { page = 1 }
                    ) { Text("2") }
                    Button(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f),
                        onClick = { page = 2 }
                    ) { Text("3") }
                }
            }
        }
    ) { innerPadding ->
        Tabs(Modifier.padding(innerPadding), page)
    }
}

@Composable
fun Tabs(modifier: Modifier = Modifier, page: Int){
    Column(modifier = modifier) {
        when(page) {
            0 -> Text(text="Daily page", modifier = modifier)
            1 -> Text(text="Weekly page", modifier = modifier)
            2 -> Text(text="To-do page", modifier = modifier)
            else -> Text(text="Error page", modifier = modifier)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AppTheme {
        Body()
    }
}