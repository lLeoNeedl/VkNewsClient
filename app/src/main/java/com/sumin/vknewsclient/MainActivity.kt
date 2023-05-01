package com.sumin.vknewsclient

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.sumin.vknewsclient.ui.theme.MainScreen
import com.sumin.vknewsclient.ui.theme.VkNewsClientTheme
import com.vk.api.sdk.VK
import com.vk.api.sdk.auth.VKAuthenticationResult
import com.vk.api.sdk.auth.VKScope

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VkNewsClientTheme {
                val someState = remember {
                    mutableStateOf(true)
                }
                Log.d("MyMainActivity", "Recomposition: {${someState.value}}")
                val launcher = rememberLauncherForActivityResult(
                    contract = VK.getVKAuthActivityResultContract()
                )
                {
                    when (it) {
                        is VKAuthenticationResult.Success -> {
                            Log.d("MyMainActivity", "Success auth")
                        }

                        is VKAuthenticationResult.Failed -> {
                            Log.d("MyMainActivity", "Failed auth")
                        }
                    }
                }
                LaunchedEffect(key1 = someState.value) {
//                    launcher.launch(listOf(VKScope.WALL))
                    Log.d("MyMainActivity", "LaunchedEffect")
                }
                SideEffect {
                    Log.d("MyMainActivity", "SideEffect")
                }
                Button(onClick = { someState.value = !someState.value }) {
                    Text(text = "Change state")
                }
            }
        }
    }
}

