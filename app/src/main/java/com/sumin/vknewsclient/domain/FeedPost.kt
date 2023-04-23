package com.sumin.vknewsclient.domain

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavType
import com.google.gson.Gson
import com.sumin.vknewsclient.R
import kotlinx.parcelize.Parcelize
import java.util.LinkedList

@Parcelize
data class FeedPost(
    val id: Int = 0,
    val communityName: String = "/dev/null",
    val publicationDate: String = "14:00",
    val avatarResId: Int = R.drawable.post_comunity_thumbnail,
    val contentText: String = "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
    val contentImageResId: Int = R.drawable.post_content_image,
    val statistics: List<StatisticsItem> = listOf(
        StatisticsItem(type = StatisticType.VIEWS, 966),
        StatisticsItem(type = StatisticType.SHARES, 7),
        StatisticsItem(type = StatisticType.COMMENTS, 8),
        StatisticsItem(type = StatisticType.LIKES, 27)
    )
) : Parcelable {

    companion object {

        val NavigationType: NavType<FeedPost> = object : NavType<FeedPost>(false) {

            @Suppress("deprecation")
            override fun get(bundle: Bundle, key: String): FeedPost? {
                return bundle.getParcelable(key)
            }

            override fun parseValue(value: String): FeedPost {
                return Gson().fromJson(value, FeedPost::class.java)
            }

            override fun put(bundle: Bundle, key: String, value: FeedPost) {
                bundle.putParcelable(key, value)
            }
        }
    }
}