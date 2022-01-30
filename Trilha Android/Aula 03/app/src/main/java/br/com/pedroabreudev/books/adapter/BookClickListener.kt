package br.com.pedroabreudev.books.adapter

import br.com.pedroabreudev.books.model.Book

interface BookClickListener {

    fun onBookClickListener(book: Book)
}