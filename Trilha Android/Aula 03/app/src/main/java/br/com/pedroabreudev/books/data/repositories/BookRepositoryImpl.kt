package br.com.pedroabreudev.books.data.repositories

import br.com.pedroabreudev.books.data.datasources.BookDataSource
import br.com.pedroabreudev.books.domain.model.Book
import br.com.pedroabreudev.books.domain.repositories.BookRepository
import kotlinx.coroutines.flow.Flow

class BookRepositoryImpl(private val bookDataSource: BookDataSource) : BookRepository {
    override fun getBooks(accessToken: String, query: String?): Flow<List<Book>> =
        bookDataSource.getBooks(accessToken, query)

}