package br.com.pedroabreudev.books.data_remote.datasource

import br.com.pedroabreudev.books.data.datasources.remote.LoginRemoteDataSource
import br.com.pedroabreudev.books.data_remote.mappers.toDomain
import br.com.pedroabreudev.books.data_remote.model.LoginRequest
import br.com.pedroabreudev.books.data_remote.service.AuthService
import br.com.pedroabreudev.books.domain.model.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class LoginRemoteDataSourceImpl(private val authService: AuthService) : LoginRemoteDataSource {

    override fun login(email: String, password: String): Flow<User> = flow {
        val response = authService.signIn(LoginRequest(email, password))
        val accessToken = response.headers()["authorization"]
        if (response.isSuccessful) {
            response.body()?.let { loginResponse ->
                emit(loginResponse.toDomain(accessToken ?: ""))
            }
        }
    }
}