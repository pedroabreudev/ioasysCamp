package br.com.pedroabreudev.books.presentation.viewmodel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.pedroabreudev.books.domain.model.Book
import br.com.pedroabreudev.books.domain.repositories.BookRepository
import br.com.pedroabreudev.books.util.ViewState
import br.com.pedroabreudev.books.util.postError
import br.com.pedroabreudev.books.util.postLoading
import br.com.pedroabreudev.books.util.postSuccess
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


class BookListViewModel(private val bookRepository: BookRepository) : ViewModel() {

    private val _bookListViewState = MutableLiveData<ViewState<List<Book>>>()
    val bookListViewState = _bookListViewState as LiveData<ViewState<List<Book>>>

    fun search(input: String = "", accessToken: String) {
        viewModelScope.launch {
            _bookListViewState.postLoading()

            try {
                bookRepository.getBooks(accessToken, input).collect {
                    if (it.isNotEmpty()) {
                        _bookListViewState.postSuccess(it)
                    } else {
                        _bookListViewState.postError(Exception("Algo deu errado!"))
                    }
                }

            } catch (err: Exception) {
                _bookListViewState.postError(err)

            }
        }

    }
}