package br.com.pedroabreudev.books.data.datasources.remote

import br.com.pedroabreudev.books.domain.model.User
import kotlinx.coroutines.flow.Flow


interface LoginRemoteDataSource {

    fun login(email: String, password: String): Flow<User>
}