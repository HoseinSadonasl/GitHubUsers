package ir.hoseinsa.githubusers.presenter.components

import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import coil.compose.AsyncImage
import ir.hoseinsa.githubusers.R

@Composable
fun CircularImageComponent(
    modifier: Modifier = Modifier,
    imageUrl: String?
) {
    AsyncImage(
        model = imageUrl,
        placeholder = painterResource(R.drawable.all_github),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = modifier
            .clip(RoundedCornerShape(percent = 50))
            .background(Color.Gray)
    )
}