package br.com.pedroabreudev.books.data_remote.datasource

import br.com.pedroabreudev.books.data.datasources.LoginDataSource
import br.com.pedroabreudev.books.domain.model.User
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class LoginDataSourceImpl : LoginDataSource {

    override fun login(email: String, password: String): Flow<User> = flow {
        delay(3_000)
        emit(
            User(
                name = "Pedro",
                birthdate = "14/10/1994",
                gender = "Male",
                accessToken = "123456"
            )
        )
    }
}