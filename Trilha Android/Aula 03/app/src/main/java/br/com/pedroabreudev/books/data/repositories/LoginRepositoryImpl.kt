package br.com.pedroabreudev.books.data.repositories

import br.com.pedroabreudev.books.data.datasources.LoginDataSource
import br.com.pedroabreudev.books.domain.model.User
import br.com.pedroabreudev.books.domain.repositories.LoginRepository
import kotlinx.coroutines.flow.Flow

class LoginRepositoryImpl(private val loginDataSource: LoginDataSource) : LoginRepository {

    override fun login(email: String, password: String): Flow<User> =
        loginDataSource.login(email, password)


}