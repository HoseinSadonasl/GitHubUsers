package ir.hoseinsa.githubusers

import android.app.Application
import ir.hoseinsa.domain.di.domainModule
import ir.hoseinsa.githubusers.data.di.dataModule
import ir.hoseinsa.presenter.di.presenterModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(dataModule, domainModule, presenterModule)
        }
    }

}