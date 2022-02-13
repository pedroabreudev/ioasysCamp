package br.com.pedroabreudev.books.di

import br.com.pedroabreudev.books.data.datasources.local.BooksLocalDataSource
import br.com.pedroabreudev.books.data.datasources.local.LoginLocalDataSource
import br.com.pedroabreudev.books.data_local.datasource.BooksLocalDataSourceImpl
import br.com.pedroabreudev.books.data_local.datasource.LoginLocalDataSourceImpl
import br.com.pedroabreudev.books.data_local.utils.SharedPreferencesHelper
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataLocalModule = module {
    single { SharedPreferencesHelper(androidContext()) }
    single<LoginLocalDataSource> { LoginLocalDataSourceImpl(get()) }
    single<BooksLocalDataSource> { BooksLocalDataSourceImpl(get()) }
}