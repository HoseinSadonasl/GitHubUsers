package ir.hoseinsa.presenter.users.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ir.hoseinsa.domain.users.model.user.UserItem
import ir.hoseinsa.presenter.components.CircularImageComponent
import kotlin.random.Random

@Composable
fun UserItemComponent(
    userItem: UserItem,
    onUserClick: (String) -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onUserClick(userItem.login) }
            .padding(8.dp),
    ) {
        CircularImageComponent(
            modifier = Modifier
                .height(48.dp)
                .width(48.dp),
            imageUrl = userItem.avatar_url
        )
        Spacer(modifier = Modifier.width(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(text = userItem.login, style = MaterialTheme.typography.bodyLarge)
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun UserItemComponentLoading(
) {
    val randomWidth = Random.nextInt(from = 40, until = 160)
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
    ) {
        Card(
            modifier = Modifier
                .height(48.dp)
                .width(48.dp),
            shape = RoundedCornerShape(percent = 50)
        ) {

        }
        Spacer(modifier = Modifier.width(8.dp))
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Card(
                modifier = Modifier
                    .height(12.dp)
                    .width(randomWidth.dp)
                    .padding(end = 8.dp),
                shape = RoundedCornerShape(percent = 50)
            ) {}
        }
    }
}