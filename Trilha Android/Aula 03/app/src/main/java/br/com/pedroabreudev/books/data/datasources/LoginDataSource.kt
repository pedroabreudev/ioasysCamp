package br.com.pedroabreudev.books.data.datasources

import br.com.pedroabreudev.books.domain.model.User
import kotlinx.coroutines.flow.Flow


interface LoginDataSource {

    fun login(email: String, password: String): Flow<User>
}