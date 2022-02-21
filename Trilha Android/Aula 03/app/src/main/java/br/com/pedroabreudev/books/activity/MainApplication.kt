package br.com.pedroabreudev.books.activity

import android.app.Application
import br.com.pedroabreudev.books.R
import br.com.pedroabreudev.books.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        setTheme(R.style.Theme_Books)
        startKoin {
            modules(
                presentationModule,
                dataModule,
                dataRemoteModule,
                dataLocalModule,
                databaseModule,
                domainModule
            )
        }.androidContext(applicationContext)
    }
}