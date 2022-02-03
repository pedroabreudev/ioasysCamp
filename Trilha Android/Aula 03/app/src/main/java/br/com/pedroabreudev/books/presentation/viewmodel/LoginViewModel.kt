package br.com.pedroabreudev.books.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.pedroabreudev.books.util.ViewState

class LoginViewModel : ViewModel() {

    private val _loggedUserViewState = MutableLiveData<ViewState<Boolean>>()
    val loggedUserViewState = _loggedUserViewState as LiveData<ViewState<Boolean>>

    fun login(email: String, password: String) {
        if (email.isNotEmpty() && password.isNotEmpty()) {
            _loggedUserViewState.value = ViewState.Success(true)
        } else {
            _loggedUserViewState.value = ViewState.Error(Throwable())
        }
    }
}