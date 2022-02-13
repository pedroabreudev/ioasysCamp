package br.com.pedroabreudev.books.activity

import android.app.Application
import br.com.pedroabreudev.books.di.PresentationModule
import br.com.pedroabreudev.books.di.dataLocalModule
import br.com.pedroabreudev.books.di.dataModule
import br.com.pedroabreudev.books.di.dataRemoteModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(PresentationModule, dataModule, dataRemoteModule, dataLocalModule)
        }.androidContext(applicationContext)
    }
}