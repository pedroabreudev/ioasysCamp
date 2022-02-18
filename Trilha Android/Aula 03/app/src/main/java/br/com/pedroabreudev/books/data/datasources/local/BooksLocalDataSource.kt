package br.com.pedroabreudev.books.data.datasources.local

import br.com.pedroabreudev.books.domain.model.Book
import kotlinx.coroutines.flow.Flow

interface BooksLocalDataSource {

    fun getAccessToken(): Flow<String>
    fun saveBooks(bookList: List<Book>)
    fun getBooks(query: String?): Flow<List<Book>>
}