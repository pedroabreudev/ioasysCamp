package br.com.pedroabreudev.books.data.datasources

import br.com.pedroabreudev.books.domain.model.Book
import kotlinx.coroutines.flow.Flow

interface BookDataSource {

    fun getBooks(accessToken: String, query: String?): Flow<List<Book>>
}