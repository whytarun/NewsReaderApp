package com.example.newsreaderapp.presentation.common

import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.newsreaderapp.domain.model.Article
import com.example.newsreaderapp.presentation.util.Dimens.ArticleCardSize
import com.example.newsreaderapp.presentation.util.Dimens.ExtraSmallPadding
import com.example.newsreaderapp.presentation.util.Dimens.ExtraSmallPadding2
import com.example.newsreaderapp.presentation.util.Dimens.MediumPadding1
import com.example.newsreaderapp.presentation.util.Dimens.SmallIconSize
import ti.mp.androidarchitecturesample.R

fun Modifier.shimmerEffect() = composed {
    val transition = rememberInfiniteTransition()
    val alpha = transition.animateFloat(
        initialValue = 0.2f,
        targetValue = 0.9f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1000)
        ), label = ""
    ).value
    background(color = colorResource(id = R.color.shimmer).copy(alpha = alpha))
}

@Composable
fun ArticleCardShimmerEffect(
    modifier: Modifier = Modifier
){
    Row(modifier = modifier){

        Box(
            modifier = Modifier
                .size(ArticleCardSize)
                .clip(MaterialTheme.shapes.medium)
                .shimmerEffect(),
        )

        androidx.compose.foundation.layout.Column(
            verticalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .padding(horizontal = ExtraSmallPadding)
                .height(ArticleCardSize)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(30.dp)
                    .padding(horizontal = MediumPadding1)
                    .clip(MaterialTheme.shapes.medium)
                    .shimmerEffect(),
            )
            Row(verticalAlignment = Alignment.CenterVertically){
                Box(
                    modifier = Modifier
                        .fillMaxWidth(.5f)
                        .height(15.dp)
                        .padding(horizontal = MediumPadding1)
                        .clip(MaterialTheme.shapes.medium)
                        .shimmerEffect(),
                )
            }
        }
    }
}