package ir.hoseinsa.presenter.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GitHubUsersTopAppBar(
    title: String,
    modifier: Modifier = Modifier,
    navigationIcon: ImageVector? = null,
    onNavigationIconClick: () -> Unit = {},
    actions: (@Composable RowScope.() -> Unit)? = {}
) {
    CenterAlignedTopAppBar(
        title = { Text(text = title, style = MaterialTheme.typography.titleLarge) },
        modifier = modifier.fillMaxWidth(),
        navigationIcon = {
            navigationIcon?.let {
                IconButton(onClick = onNavigationIconClick) {
                    Icon(
                        imageVector = it,
                        contentDescription = null
                    )
                }

            }
        },
        actions = actions ?: {},
    )
}