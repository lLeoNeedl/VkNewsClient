package com.sumin.vknewsclient.presentation.comments

import android.app.Application
import android.util.Log
import androidx.lifecycle.ViewModel
import com.sumin.vknewsclient.data.repository.NewsFeedRepositoryImpl
import com.sumin.vknewsclient.domain.entity.FeedPost
import com.sumin.vknewsclient.domain.usecases.GetCommentsUseCase
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CommentsViewModel @Inject constructor(
    private val feedPost: FeedPost,
    private val getCommentsUseCase: GetCommentsUseCase
) : ViewModel() {

    val screenState = getCommentsUseCase(feedPost)
        .map {
            CommentsScreenState.Comments(
                feedPost = feedPost,
                comments = it
            )
        }
}