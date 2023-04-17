package com.sumin.vknewsclient.ui.theme

import androidx.compose.foundation.clickable
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.sumin.vknewsclient.MainViewModel
import com.sumin.vknewsclient.navigation.AppNavGraph

@Composable
fun MainScreen(viewModel: MainViewModel) {
    val navHostController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomNavigation {
                val navBackStackEntry by navHostController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route
                val items = listOf(
                    NavigationItem.Home,
                    NavigationItem.Favourite,
                    NavigationItem.Profile
                )
                items.forEach { item ->
                    BottomNavigationItem(
                        selected = currentRoute == item.screen.route,
                        onClick = { navHostController.navigate(item.screen.route) },
                        icon = {
                            Icon(imageVector = item.icon, contentDescription = null)
                        },
                        label = { Text(text = stringResource(id = item.titleResId)) },
                        selectedContentColor = MaterialTheme.colors.onPrimary,
                        unselectedContentColor = MaterialTheme.colors.onSecondary
                    )
                }
            }
        }
    ) { paddingValues ->
        AppNavGraph(
            navHostController = navHostController,
            homeScreenContent = {
                HomeScreen(
                    viewModel = viewModel,
                    paddingValues = paddingValues
                )
            },
            favouriteScreenContent = { TextCounter(name = "Favourite") },
            profileScreenContent = { TextCounter(name = "Profile") }
        )
    }
}

@Composable
private fun TextCounter(name: String) {
    var count by remember {
        mutableStateOf(0)
    }
    Text(
        modifier = Modifier.clickable { count++ },
        text = "$name Count: $count",
        color = MaterialTheme.colors.onPrimary
    )
}