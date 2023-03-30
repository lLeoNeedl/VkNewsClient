package com.sumin.vknewsclient

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
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
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "TopAppBar title")
                },
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(imageVector = Icons.Filled.Menu, contentDescription = null)
                    }
                }
            )
        },
        bottomBar = {
            BottomNavigation {
                BottomNavigationItem(
                    icon = { Icon(imageVector = Icons.Filled.Favorite, contentDescription = null)},
                    label = {Text("Favourite")},
                    selected = false,
                    onClick = { /*TODO*/ }
                )
                BottomNavigationItem(
                    icon = { Icon(imageVector = Icons.Filled.Favorite, contentDescription = null)},
                    label = {Text("Favourite")},
                    selected = false,
                    onClick = { /*TODO*/ }
                )
                BottomNavigationItem(
                    icon = { Icon(imageVector = Icons.Filled.Favorite, contentDescription = null)},
                    label = {Text("Favourite")},
                    selected = false,
                    onClick = { /*TODO*/ }
                )
            }
        },
        drawerContent = {
            NavigationRail {
                NavigationRailItem(
                    selected = false,
                    onClick = { /*TODO*/ },
                    icon = { Icon(imageVector = Icons.Filled.Search, contentDescription = null)},
                    label = { Text(text = "Search")}
                )
                NavigationRailItem(
                    selected = false,
                    onClick = { /*TODO*/ },
                    icon = { Icon(imageVector = Icons.Filled.Add, contentDescription = null)},
                    label = { Text(text = "Add")}
                )
                NavigationRailItem(
                    selected = false,
                    onClick = { /*TODO*/ },
                    icon = { Icon(imageVector = Icons.Filled.Settings, contentDescription = null)},
                    label = { Text(text = "Settings")}
                )
            }
        }
    ) {
        Text(
            modifier = Modifier.padding(it),
            text = "This is scaffold content"
        )
    }
}