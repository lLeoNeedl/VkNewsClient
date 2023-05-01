package com.sumin.vknewsclient

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sumin.vknewsclient.ui.theme.AuthState
import com.vk.api.sdk.VK
import com.vk.api.sdk.auth.VKAuthenticationResult

class MainViewModel: ViewModel() {

    private val _authState = MutableLiveData<AuthState>(AuthState.Initial)
    val authState: LiveData<AuthState> = _authState

    init {
        _authState.value = if (VK.isLoggedIn()) {
            AuthState.Authorized
        } else {
            AuthState.NotAuthorized
        }
    }

    fun performAuthResult(result: VKAuthenticationResult) {
        if (result is VKAuthenticationResult.Success) {
            _authState.value = AuthState.Authorized
        } else {
            Log.d("MyMainViewModel", (result as VKAuthenticationResult.Failed).exception.toString())
            _authState.value = AuthState.NotAuthorized
        }
    }
}