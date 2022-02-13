package br.com.pedroabreudev.books.data.datasources.local

import kotlinx.coroutines.flow.Flow

interface BooksLocalDataSource {

    fun getAccessToken(): Flow<String>
}