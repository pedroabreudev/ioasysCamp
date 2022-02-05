package br.com.pedroabreudev.books.domain.repositories

import br.com.pedroabreudev.books.domain.model.User
import kotlinx.coroutines.flow.Flow

interface LoginRepository {

    fun login(email: String, password: String): Flow<User>
}