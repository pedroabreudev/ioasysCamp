package br.com.pedroabreudev.books.di

import br.com.pedroabreudev.books.domain.usecase.GetBookListUseCase
import br.com.pedroabreudev.books.domain.usecase.LoginUseCase
import br.com.pedroabreudev.books.domain.usecase.SaveBookListUseCase
import org.koin.dsl.module

val domainModule = module {
    factory { LoginUseCase(get()) }
    factory { GetBookListUseCase(get()) }
    factory { SaveBookListUseCase(get()) }
}