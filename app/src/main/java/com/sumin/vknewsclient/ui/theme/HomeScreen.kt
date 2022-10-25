package com.sumin.vknewsclient.ui.theme

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import com.sumin.vknewsclient.MainViewModel
import com.sumin.vknewsclient.domain.PostComment

@OptIn(ExperimentalMaterialApi::class, ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    viewModel: MainViewModel,
    paddingValues: PaddingValues
) {
    val feedPosts = viewModel.feedPosts.observeAsState(listOf())

    val comments = mutableListOf<PostComment>().apply {
        repeat(20) {
            add(
                PostComment(id = it)
            )
        }
    }
    CommentsScreen(feedPost = feedPosts.value[0], comments = comments)

//    LazyColumn(
//        modifier = Modifier.padding(paddingValues),
//        contentPadding = PaddingValues(
//            top = 16.dp,
//            start = 8.dp,
//            end = 8.dp,
//            bottom = 72.dp
//        ),
//        verticalArrangement = Arrangement.spacedBy(8.dp)
//    ) {
//        items(
//            items = feedPosts.value,
//            key = { it.id }) { feedPost ->
//            val dismissState = rememberDismissState()
//            if (dismissState.isDismissed(DismissDirection.EndToStart)) {
//                viewModel.remove(feedPost)
//            }
//            SwipeToDismiss(
//                modifier = Modifier.animateItemPlacement(),
//                state = dismissState,
//                background = {},
//                directions = setOf(DismissDirection.EndToStart)
//            ) {
//                PostCard(
//                    feedPost = feedPost,
//                    onLikeClickListener = { statisticsItem ->
//                        viewModel.updateCount(feedPost, statisticsItem)
//                    },
//                    onShareClickListener = { statisticsItem ->
//                        viewModel.updateCount(feedPost, statisticsItem)
//                    },
//                    onViewsClickListener = { statisticsItem ->
//                        viewModel.updateCount(feedPost, statisticsItem)
//                    },
//                    onCommentClickListener = { statisticsItem ->
//                        viewModel.updateCount(feedPost, statisticsItem)
//                    }
//                )
//            }
//        }
//    }
}