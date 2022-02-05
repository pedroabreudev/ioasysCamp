package br.com.pedroabreudev.books.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.pedroabreudev.books.domain.exception.LoginException
import br.com.pedroabreudev.books.domain.repositories.LoginRepository
import br.com.pedroabreudev.books.util.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LoginViewModel(private val loginRepository: LoginRepository) : ViewModel() {

    private val _loggedUserViewState = MutableLiveData<ViewState<Boolean>>()
    val loggedUserViewState = _loggedUserViewState as LiveData<ViewState<Boolean>>

    fun login(email: String, password: String) {

        viewModelScope.launch {

            _loggedUserViewState.postLoading()

            delay(2_000)

            if (email.isNotEmpty() && password.isNotEmpty()) {
                _loggedUserViewState.postSuccess(true)
            } else {
                _loggedUserViewState.postError(LoginException())
            }
        }
    }

    fun resetViewState() {
        _loggedUserViewState.postNeutral()
    }
}