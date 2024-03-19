package ir.hoseinsa.presenter.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.core.content.ContextCompat
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

object ConnectionUtils: KoinComponent {

    val context: Context by inject()

    val connectivityManager: ConnectivityManager? = ContextCompat.getSystemService(context, ConnectivityManager::class.java)

    fun isOnline(): Boolean {
        val capabilities = connectivityManager?.getNetworkCapabilities(connectivityManager.activeNetwork) ?: return false
        return capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) &&
                capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED)
    }


}