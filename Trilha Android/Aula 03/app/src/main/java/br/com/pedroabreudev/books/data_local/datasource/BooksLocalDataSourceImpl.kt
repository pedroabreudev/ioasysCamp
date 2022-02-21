package br.com.pedroabreudev.books.data_local.datasource

import br.com.pedroabreudev.books.data.datasources.local.BooksLocalDataSource
import br.com.pedroabreudev.books.data_local.database.BookDao
import br.com.pedroabreudev.books.data_local.mappers.toDao
import br.com.pedroabreudev.books.data_local.mappers.toDomain
import br.com.pedroabreudev.books.data_local.utils.LocalConstants.ACCESS_TOKEN_KEY
import br.com.pedroabreudev.books.data_local.utils.SharedPreferencesHelper
import br.com.pedroabreudev.books.domain.model.Book
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class BooksLocalDataSourceImpl(
    private val sharedPreferencesHelper: SharedPreferencesHelper,
    private val bookDao: BookDao
) : BooksLocalDataSource {

    override fun getAccessToken(): Flow<String> = flow {
        emit(sharedPreferencesHelper.getString(ACCESS_TOKEN_KEY))
    }

    override fun saveBooks(bookList: List<Book>) = bookDao.addBooks(
        bookList = bookList.map {
            it.toDao()
        }
    )

    override fun getBooks(query: String?): Flow<List<Book>> = flow {
        val bookList = bookDao.getBooks().map { it.toDomain() }
        query?.let {
            emit(bookList.filter { book ->
                book.name.trim().contains(it, ignoreCase = true)
            })
        } ?: run {
            emit(bookList)
        }
    }
}