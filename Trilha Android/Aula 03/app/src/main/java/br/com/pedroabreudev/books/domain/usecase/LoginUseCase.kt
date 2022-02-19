package br.com.pedroabreudev.books.domain.usecase

import br.com.pedroabreudev.books.domain.exception.InvalidEmailException
import br.com.pedroabreudev.books.domain.exception.InvalidPasswordException
import br.com.pedroabreudev.books.domain.model.User
import br.com.pedroabreudev.books.domain.repositories.LoginRepository
import kotlinx.coroutines.flow.Flow

class LoginUseCase(private val loginRepository: LoginRepository) {

    operator fun invoke(params: Params): Flow<User> = when {
        params.email.isEmpty() -> throw InvalidEmailException()
        params.password.isEmpty() -> throw InvalidPasswordException()
        else -> loginRepository.login(
            email = params.email,
            password = params.password
        )
    }

    data class Params(
        val email: String,
        val password: String,
    )
}