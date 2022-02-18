package br.com.pedroabreudev.books.data.repositories

import br.com.pedroabreudev.books.data.datasources.local.BooksLocalDataSource
import br.com.pedroabreudev.books.data.datasources.remote.BooksRemoteDataSource
import br.com.pedroabreudev.books.domain.model.Book
import br.com.pedroabreudev.books.domain.repositories.BooksRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow

class BooksRepositoryImpl(
    private val booksRemoteDataSource: BooksRemoteDataSource,
    private val booksLocalDataSource: BooksLocalDataSource
) : BooksRepository {

    override fun getBooks(query: String?): Flow<List<Book>> = flow {
        booksLocalDataSource.getAccessToken().collect { token ->
            booksRemoteDataSource.getBooks(token, query).collect { bookList ->
                emit(bookList)
            }
        }
    }

    override fun saveBooks(bookList: List<Book>) = booksLocalDataSource.saveBooks(
        bookList = bookList
    )
}