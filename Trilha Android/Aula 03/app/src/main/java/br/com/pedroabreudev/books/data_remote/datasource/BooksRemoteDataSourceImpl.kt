package br.com.pedroabreudev.books.data_remote.datasource

import br.com.pedroabreudev.books.data.datasources.remote.BooksRemoteDataSource
import br.com.pedroabreudev.books.data_remote.mappers.toDomain
import br.com.pedroabreudev.books.data_remote.service.BookService
import br.com.pedroabreudev.books.domain.model.Book
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class BooksRemoteDataSourceImpl(private val bookService: BookService) : BooksRemoteDataSource {
    override fun getBooks(accessToken: String, query: String?): Flow<List<Book>> = flow {
        val response = bookService.getBooks("Bearer $accessToken", 1, "$query", "")
        if (response.isSuccessful) {
            response.body()?.data?.let { bookList ->
                query?.let {
                    emit(bookList.filter { book ->
                        book.name?.trim()?.contains(it, ignoreCase = true) ?: false
                    }.toDomain())
                } ?: run {
                    emit(bookList.toDomain())
                }

            }
        }

    }

}