package br.com.pedroabreudev.books.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.pedroabreudev.books.domain.exception.LoginException
import br.com.pedroabreudev.books.domain.repositories.LoginRepository
import br.com.pedroabreudev.books.util.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.lang.Exception

class LoginViewModel(private val loginRepository: LoginRepository) : ViewModel() {

    private val _loggedUserViewState = MutableLiveData<ViewState<String>>()
    val loggedUserViewState = _loggedUserViewState as LiveData<ViewState<String>>

    fun login(email: String, password: String) {

        viewModelScope.launch {

            _loggedUserViewState.postLoading()

            try {
                loginRepository.login(email, password).collect {
                    if (it.name.isNotEmpty()) {
                        _loggedUserViewState.postSuccess(it.accessToken)
                    } else {
                        _loggedUserViewState.postError(Exception("Body do usuário vazio"))
                    }
                }

            } catch (err: Exception) {
                _loggedUserViewState.postError(err)

            }
        }
    }

    fun resetViewState() {
        _loggedUserViewState.postNeutral()
    }
}