package br.com.pedroabreudev.books.activity

import android.app.Application
import br.com.pedroabreudev.books.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(
                presentationModule,
                dataModule,
                dataRemoteModule,
                dataLocalModule,
                databaseModule
            )
        }.androidContext(applicationContext)
    }
}