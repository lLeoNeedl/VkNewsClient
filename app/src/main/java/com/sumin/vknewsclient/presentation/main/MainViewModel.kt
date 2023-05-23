package com.sumin.vknewsclient.presentation.main

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.sumin.vknewsclient.data.repository.AuthorizationRepository
import com.sumin.vknewsclient.data.repository.NewsFeedRepository
import com.sumin.vknewsclient.domain.auth_state.AuthState
import com.vk.api.sdk.VKPreferencesKeyValueStorage
import com.vk.api.sdk.auth.VKAccessToken
import com.vk.api.sdk.auth.VKAuthenticationResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel(application: Application): AndroidViewModel(application) {

    private val newsFeedRepository = NewsFeedRepository(getApplication())

    val authState: StateFlow<AuthState> = newsFeedRepository.authStateFlow

    fun performAuthResult() {
        viewModelScope.launch {
            newsFeedRepository.checkAuthState()
        }
    }
}