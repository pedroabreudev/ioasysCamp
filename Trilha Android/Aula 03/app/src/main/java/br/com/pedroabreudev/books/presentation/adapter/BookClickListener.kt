package br.com.pedroabreudev.books.presentation.adapter

import br.com.pedroabreudev.books.domain.model.Book

interface BookClickListener {

    fun onBookClickListener(book: Book)
}