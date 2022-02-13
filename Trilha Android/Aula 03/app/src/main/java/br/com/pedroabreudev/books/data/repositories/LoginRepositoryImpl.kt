package br.com.pedroabreudev.books.data.repositories

import br.com.pedroabreudev.books.data.datasources.local.LoginLocalDataSource
import br.com.pedroabreudev.books.data.datasources.remote.LoginRemoteDataSource
import br.com.pedroabreudev.books.domain.model.User
import br.com.pedroabreudev.books.domain.repositories.LoginRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow

class LoginRepositoryImpl(
    private val loginRemoteDataSource: LoginRemoteDataSource,
    private val loginLocalDataSource: LoginLocalDataSource
) : LoginRepository {

    override fun login(email: String, password: String): Flow<User> = flow {
        loginRemoteDataSource.login(email, password).collect { userData ->
            loginLocalDataSource.saveAccessToken(accessToken = userData.accessToken)

            emit(userData)
        }
    }
}