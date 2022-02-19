package br.com.pedroabreudev.books.di

import br.com.pedroabreudev.books.domain.usecase.GetBookListUseCase
import br.com.pedroabreudev.books.domain.usecase.LoginUseCase
import br.com.pedroabreudev.books.domain.usecase.SaveBookListUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

val domainModule = module {

    single { CoroutineScope(Dispatchers.IO) }

    factory { LoginUseCase(get(), get()) }
    factory { GetBookListUseCase(get(), get()) }
    factory { SaveBookListUseCase(get(), get()) }
}