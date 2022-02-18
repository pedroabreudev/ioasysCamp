package br.com.pedroabreudev.books.di

import br.com.pedroabreudev.books.data.datasources.remote.BooksRemoteDataSource
import br.com.pedroabreudev.books.data.datasources.remote.LoginRemoteDataSource
import br.com.pedroabreudev.books.data_remote.datasource.BooksRemoteDataSourceImpl
import br.com.pedroabreudev.books.data_remote.datasource.LoginRemoteDataSourceImpl
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

    single<BooksRemoteDataSource> { BooksRemoteDataSourceImpl(get()) }

    single<LoginRemoteDataSource> { LoginRemoteDataSourceImpl(get()) }

}