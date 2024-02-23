package ir.hoseinsa.presenter.users.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ir.hoseinsa.domain.users.model.user.UserItem
import ir.hoseinsa.presenter.R
import ir.hoseinsa.presenter.components.CircularImageComponent

@Composable
fun UserItemComponent(
    userItemPresenter: UserItem,
    onUserClick: (String) -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onUserClick(userItemPresenter.login) },
    ) {
        CircularImageComponent(
            modifier = Modifier
                .height(48.dp)
                .width(48.dp),
            imageUrl = userItemPresenter.avatar_url
        )
        Spacer(modifier = Modifier.width(8.dp))
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
            ) {
            Column() {
                Text(text = userItemPresenter.login, style = MaterialTheme.typography.bodyMedium)
            }
            ItemOptionComponent(modifier = Modifier.height(24.dp), icon = R.drawable.all_github, text = "18" , textStyle = MaterialTheme.typography.labelSmall)
        }

    }
}