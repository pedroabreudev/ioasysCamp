package br.com.pedroabreudev.books.data.datasources.remote

import br.com.pedroabreudev.books.domain.model.Book
import kotlinx.coroutines.flow.Flow

interface BooksRemoteDataSource {

    fun getBooks(accessToken: String, query: String?): Flow<List<Book>>
}