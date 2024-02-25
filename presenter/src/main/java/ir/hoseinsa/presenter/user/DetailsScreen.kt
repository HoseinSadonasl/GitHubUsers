package ir.hoseinsa.presenter.user

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import ir.hoseinsa.presenter.components.CircularImageComponent
import ir.hoseinsa.presenter.user.components.DetailsSection
import ir.hoseinsa.presenter.user.intent.UserDataIntent
import kotlinx.coroutines.flow.collect
import org.koin.androidx.compose.koinViewModel

@Composable
fun DetailsScreen(
    username: String?,
    userViewModel: UserViewModel = koinViewModel(),
    screenTitle: (String?) -> Unit = {},
    showSnackBar: (String) -> Unit = {},
) {
    val userState = userViewModel.userState

    LaunchedEffect(key1 = username) {
        userViewModel.dataIntent.send(UserDataIntent.GetUser(username!!))
        screenTitle(username)
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        if(userState.isLoading) {
            CircularProgressIndicator()
        } else if (userState.user != null) {
            CircularImageComponent(imageUrl = userState.user.avatarUrl, modifier = Modifier
                .width(180.dp)
                .height(180.dp))
            Spacer(modifier = Modifier.height(16.dp))
            DetailsSection(user = userState.user)
        } else if (!userState.error.isNullOrBlank()) {
            showSnackBar(userState.error)
        }
    }
}