package br.com.pedroabreudev.books

import br.com.pedroabreudev.books.domain.exception.InvalidEmailException
import br.com.pedroabreudev.books.domain.exception.InvalidPasswordException
import br.com.pedroabreudev.books.domain.model.User
import br.com.pedroabreudev.books.domain.repositories.LoginRepository
import br.com.pedroabreudev.books.domain.usecase.LoginUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.any
import org.mockito.kotlin.whenever

class LoginUseCaseTest {

    @Mock
    private lateinit var repository: LoginRepository
    private lateinit var subject: LoginUseCase

    private val userFake = User(
        name = "Camp",
        birthdate = "12/12/2022",
        gender = "A",
        accessToken = "Token",
        id = "id"
    )

    @Before
    fun before() {
        MockitoAnnotations.openMocks(this)
        subject = LoginUseCase(
            loginRepository = repository,
            scope = CoroutineScope(Dispatchers.IO)
        )

    }

    @Test
    fun `WHEN SUCCESS MUST RETURN USER`() = runBlocking {
        stubOnSuccess()
        subject.run(
            params = LoginUseCase.Params(
                email = "email",
                password = "aaabbbcccddd"
            )
        ).collect {
            assert(it == userFake)
        }
    }

    @Test(expected = InvalidEmailException::class)
    fun `WHEN EMPTY EMAIL MUST RETURN INVALIDEMAILEXCEPTION`() {
        subject.run(
            params = LoginUseCase.Params(
                email = "",
                password = "dddcccbbbaaa"
            )
        )
    }

    @Test(expected = InvalidPasswordException::class)
    fun `WHEN EMPTY PASSWORD MUST RETURN INVALIDPASSWORDEXCEPTION`() {
        subject.run(
            params = LoginUseCase.Params(
                email = "a@aa.com.br",
                password = ""
            )
        )
    }


    private fun stubOnSuccess() {
        whenever(
            repository.login(
                email = any(),
                password = any()
            )
        ).thenAnswer {
            flowOf(userFake)
        }
    }
}