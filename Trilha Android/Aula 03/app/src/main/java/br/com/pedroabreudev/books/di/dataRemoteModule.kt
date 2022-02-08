package br.com.pedroabreudev.books.di

import br.com.pedroabreudev.books.data.datasources.BookDataSource
import br.com.pedroabreudev.books.data.datasources.LoginDataSource
import br.com.pedroabreudev.books.data_remote.datasource.BookDataSourceImpl
import br.com.pedroabreudev.books.data_remote.datasource.LoginDataSourceImpl
import br.com.pedroabreudev.books.data_remote.service.AuthService
import br.com.pedroabreudev.books.data_remote.service.BookService
import br.com.pedroabreudev.books.data_remote.utils.ApiConstants
import br.com.pedroabreudev.books.data_remote.utils.WebServiceFactory
import org.koin.dsl.module

val dataRemoteModule = module {

    single<AuthService> {
        WebServiceFactory.createWebService(
            okHttpClient = get(),
            url = ApiConstants.BASE_URL
        )
    }

    single<BookService> {
        WebServiceFactory.createWebService(
            okHttpClient = get(),
            url = ApiConstants.BASE_URL
        )
    }

    single { WebServiceFactory.providerOkHttpClient() }

    single<BookDataSource> { BookDataSourceImpl(get()) }

    single<LoginDataSource> { LoginDataSourceImpl(get()) }

}