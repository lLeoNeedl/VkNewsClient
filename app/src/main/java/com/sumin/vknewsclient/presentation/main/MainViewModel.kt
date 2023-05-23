package com.sumin.vknewsclient.presentation.main

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sumin.vknewsclient.data.repository.AuthorizationRepository
import com.sumin.vknewsclient.domain.auth_state.AuthState
import com.vk.api.sdk.VKPreferencesKeyValueStorage
import com.vk.api.sdk.auth.VKAccessToken
import com.vk.api.sdk.auth.VKAuthenticationResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel(application: Application): AndroidViewModel(application) {

    private val authRepository = AuthorizationRepository(getApplication())

    val authState: StateFlow<AuthState> = authRepository.authState

    init {
        authRepository.checkAuthState()
    }

    fun performAuthResult(result: VKAuthenticationResult) {
        authRepository.performAuthResult(result)
    }
}