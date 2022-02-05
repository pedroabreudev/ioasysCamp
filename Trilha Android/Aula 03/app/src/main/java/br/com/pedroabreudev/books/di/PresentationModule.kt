package br.com.pedroabreudev.books.di

import br.com.pedroabreudev.books.presentation.viewmodel.BookListViewModel
import br.com.pedroabreudev.books.presentation.viewmodel.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val PresentationModule = module {
    viewModel { LoginViewModel(get()) }
    viewModel { BookListViewModel() }

}