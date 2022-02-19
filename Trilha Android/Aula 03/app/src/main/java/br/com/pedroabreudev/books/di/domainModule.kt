package br.com.pedroabreudev.books.di

import br.com.pedroabreudev.books.domain.usecase.LoginUseCase
import org.koin.dsl.module

val domainModule = module {
    factory { LoginUseCase(get()) }
}