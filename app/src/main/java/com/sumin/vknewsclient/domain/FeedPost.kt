package com.sumin.vknewsclient.domain

import com.sumin.vknewsclient.R
import java.util.LinkedList

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
)