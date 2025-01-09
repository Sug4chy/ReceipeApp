package ru.sug4chy.receipe_app

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.ksp.generated.module
import ru.sug4chy.receipe_app.di.AppModule
import ru.sug4chy.receipe_app.di.appModule
import ru.sug4chy.receipe_app.di.networkModule

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MainApplication)
            modules(appModule, networkModule, AppModule().module)
        }
    }
}