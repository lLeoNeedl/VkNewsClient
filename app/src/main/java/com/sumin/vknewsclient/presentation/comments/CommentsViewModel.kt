package com.sumin.vknewsclient.presentation.comments

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sumin.vknewsclient.data.repository.NewsFeedRepository
import com.sumin.vknewsclient.domain.FeedPost
import com.sumin.vknewsclient.domain.PostComment
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class CommentsViewModel(
    feedPost: FeedPost,
    application: Application
) : ViewModel() {

    private val repository = NewsFeedRepository(application)

    val screenState = repository.getComments(feedPost).map {
        CommentsScreenState.Comments(
            feedPost = feedPost,
            comments = it
        )
    }

    init {
        Log.d("CommentsViewModel", "init")
    }
}