package com.sumin.vknewsclient.data.repository

import android.app.Application
import com.sumin.vknewsclient.data.mapper.NewsFeedMapper
import com.sumin.vknewsclient.data.network.ApiFactory
import com.sumin.vknewsclient.domain.FeedPost
import com.vk.api.sdk.VKPreferencesKeyValueStorage
import com.vk.api.sdk.auth.VKAccessToken

class NewsFeedRepository(application: Application) {

    private val storage = VKPreferencesKeyValueStorage(application)
    private val token = VKAccessToken.restore(storage)

    private val apiService = ApiFactory.apiService
    private val mapper = NewsFeedMapper()

    suspend fun loadRecommendations(): List<FeedPost> {
        val response = apiService.loadRecommendations(getAccessToken())
        return mapper.mapResponseToPosts(response)
    }

    suspend fun addLike(feedPost: FeedPost) {
        apiService.addLike(
            token = getAccessToken(),
            ownerId = feedPost.communityId,
            postId = feedPost.id
        )
    }

    private fun getAccessToken(): String {
        return token?.accessToken ?: throw IllegalStateException("Token is null")
    }
}