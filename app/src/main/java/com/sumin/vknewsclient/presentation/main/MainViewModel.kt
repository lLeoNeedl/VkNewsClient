package com.sumin.vknewsclient.presentation.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sumin.vknewsclient.data.repository.NewsFeedRepositoryImpl
import com.sumin.vknewsclient.domain.entity.AuthState
import com.sumin.vknewsclient.domain.usecases.CheckAuthStateUseCase
import com.sumin.vknewsclient.domain.usecases.GetAuthStateFlowUseCase
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val getAuthStateFlowUseCase: GetAuthStateFlowUseCase,
    private val checkAuthStateUseCase: CheckAuthStateUseCase
) : ViewModel() {

    val authState = getAuthStateFlowUseCase()

    fun performAuthResult() {
        viewModelScope.launch {
            checkAuthStateUseCase()
        }
    }
}