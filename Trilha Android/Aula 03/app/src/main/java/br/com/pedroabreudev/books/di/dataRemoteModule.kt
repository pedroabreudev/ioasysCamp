package br.com.pedroabreudev.books.di

import br.com.pedroabreudev.books.data.datasources.BookDataSource
import br.com.pedroabreudev.books.data.datasources.LoginDataSource
import br.com.pedroabreudev.books.data_remote.datasource.BookDataSourceImpl
import br.com.pedroabreudev.books.data_remote.datasource.LoginDataSourceImpl
import org.koin.dsl.module

val dataRemoteModule = module {

    single<BookDataSource> { BookDataSourceImpl() }
    single<LoginDataSource> { LoginDataSourceImpl() }

}