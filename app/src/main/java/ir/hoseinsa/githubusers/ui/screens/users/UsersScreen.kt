package ir.hoseinsa.githubusers.ui.screens.users

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Divider
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ir.hoseinsa.githubusers.ui.components.UserItemComponent


@Composable
fun UsersScreen(
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
        }
        LazyColumn(
            contentPadding = PaddingValues(8.dp),
            state = rememberLazyListState()
        ) {
            items(20) {
                UserItemComponent()
                Divider(thickness = 0.5.dp, color = Color.Gray)
            }
        }
    }
}