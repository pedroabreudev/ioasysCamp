package br.com.pedroabreudev.books.di

import br.com.pedroabreudev.books.data.repositories.BooksRepositoryImpl
import br.com.pedroabreudev.books.data.repositories.LoginRepositoryImpl
import br.com.pedroabreudev.books.domain.repositories.BooksRepository
import br.com.pedroabreudev.books.domain.repositories.LoginRepository
import org.koin.dsl.module

val dataModule = module {

    single<BooksRepository> { BooksRepositoryImpl(get(), get()) }
    single<LoginRepository> { LoginRepositoryImpl(get(), get()) }
}