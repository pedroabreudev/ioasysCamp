package br.com.pedroabreudev.books.domain.repositories

import br.com.pedroabreudev.books.domain.model.Book
import kotlinx.coroutines.flow.Flow

interface BooksRepository {

    fun getBooks(query: String?): Flow<List<Book>>
    fun saveBooks(bookList: List<Book>)
}