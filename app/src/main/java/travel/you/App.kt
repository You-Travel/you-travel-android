package travel.you

import android.app.Application

import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    companion object SERVER_URL {
        var URL = "https://localhost:8080"
        lateinit var app: App
    }

    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidContext(this@App)
            modules(travel.you.di.modules)
        }
    }

}