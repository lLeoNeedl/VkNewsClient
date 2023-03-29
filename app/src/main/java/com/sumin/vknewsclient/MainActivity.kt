package com.sumin.vknewsclient

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sumin.vknewsclient.ui.theme.VkNewsClientTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Test()
        }
    }
}

@Preview
@Composable
private fun Test() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Example3()
    }
}

@Composable
private fun Example1() {
    OutlinedButton(onClick = { /*TODO*/ }) {
        Text(text = "Hello World")
    }
}

@Composable
private fun Example2() {
    TextField(
        value = "Value",
        onValueChange = { },
        label = {
            Text(text = "Label")
        }
    )
}

@Composable
private fun Example3() {
    AlertDialog(
        onDismissRequest = { },
        confirmButton = {
            TextButton(onClick = { /*TODO*/ }) {
                Text(text = "Yes", color = Color.Black)
            }
        },
        dismissButton = {
            TextButton(onClick = { /*TODO*/ }) {
                Text("No", color = Color.Black)
            }
        },
        title = {
            Text("Are you sure?")
        },
        text = {
            Text(text = "Do you want to delete this file?")
        }
    )
}
