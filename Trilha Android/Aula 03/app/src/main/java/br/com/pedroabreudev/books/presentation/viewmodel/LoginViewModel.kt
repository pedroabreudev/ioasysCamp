package br.com.pedroabreudev.books.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.pedroabreudev.books.domain.usecase.LoginUseCase
import br.com.pedroabreudev.books.util.*

class LoginViewModel(private val loginUseCase: LoginUseCase) : ViewModel() {

    private val _loggedUserViewState = MutableLiveData<ViewState<String>>()
    val loggedUserViewState = _loggedUserViewState as LiveData<ViewState<String>>

    fun login(email: String, password: String) {
        _loggedUserViewState.postLoading()
        loginUseCase(
            params = LoginUseCase.Params(
                email = email,
                password = password
            ),
            onSuccess = {
                _loggedUserViewState.postSuccess(it.accessToken)
            },
            onError = { _loggedUserViewState.postError(it) }
        )
    }

    fun resetViewState() {
        _loggedUserViewState.postNeutral()
    }
}