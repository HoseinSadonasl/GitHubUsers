package ir.hoseinsa.githubusers.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import ir.hoseinsa.githubusers.R
import org.koin.androidx.compose.get
import org.koin.compose.getKoin
import org.koin.compose.koinInject

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