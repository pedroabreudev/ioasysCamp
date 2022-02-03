package br.com.pedroabreudev.books.activity

import android.app.Application
import br.com.pedroabreudev.books.di.PresentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(PresentationModule)
        }.androidContext(applicationContext)
    }
}