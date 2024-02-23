package ir.hoseinsa.presenter.user.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import ir.hoseinsa.domain.user.model.User

@Composable
fun DetailsSection(
    modifier: Modifier = Modifier,
    user: User
) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(16.dp))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = user.login, style = MaterialTheme.typography.titleLarge)
        Text(text = user.login, style = MaterialTheme.typography.titleMedium)
        Text(text = "Followers: ${user.followers}" + "Followings: ${user.following}", style = MaterialTheme.typography.titleSmall)
    }
}