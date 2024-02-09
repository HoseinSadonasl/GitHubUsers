package ir.hoseinsa.githubusers.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ir.hoseinsa.githubusers.R
import ir.hoseinsa.githubusers.domain.models.user.UserPresenter

@Composable
fun UserItemComponent(
    userPresenter: UserPresenter
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
    ) {
        CircularImageComponent(
            modifier = Modifier
                .height(48.dp)
                .width(48.dp),
            imageUrl = userPresenter.avatar_url
        )
        Spacer(modifier = Modifier.width(8.dp))
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
            ) {
            Column() {
                Text(text = userPresenter.login, style = MaterialTheme.typography.bodyMedium)
            }
            ItemOptionComponent(modifier = Modifier.height(24.dp), icon = R.drawable.all_github, text = "18" , textStyle = MaterialTheme.typography.labelSmall)
        }

    }
}