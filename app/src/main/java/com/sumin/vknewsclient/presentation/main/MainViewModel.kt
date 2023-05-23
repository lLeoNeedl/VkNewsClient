package com.sumin.vknewsclient.presentation.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.sumin.vknewsclient.data.repository.NewsFeedRepositoryImpl
import com.sumin.vknewsclient.domain.entity.AuthState
import com.sumin.vknewsclient.domain.usecases.CheckAuthStateUseCase
import com.sumin.vknewsclient.domain.usecases.GetAuthStateFlowUseCase
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel(application: Application): AndroidViewModel(application) {

    private val newsFeedRepository = NewsFeedRepositoryImpl(getApplication())

    private val getAuthStateFlowUseCase = GetAuthStateFlowUseCase(newsFeedRepository)
    private val checkAuthStateUseCase = CheckAuthStateUseCase(newsFeedRepository)

    val authState = getAuthStateFlowUseCase()

    fun performAuthResult() {
        viewModelScope.launch {
            checkAuthStateUseCase()
        }
    }
}