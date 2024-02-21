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
import ir.hoseinsa.domain.users.model.user.UserItem

@Composable
fun InformationSection(
    modifier: Modifier = Modifier,
    userItem: UserItem
) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(16.dp))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = userItem.login, style = MaterialTheme.typography.titleLarge)
        Text(text = userItem.login, style = MaterialTheme.typography.titleMedium)
        Text(text = "Followers: ${userItem.followers_url}", style = MaterialTheme.typography.titleSmall)
    }
}