package br.com.pedroabreudev.books.presentation.viewmodel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.pedroabreudev.books.domain.model.Book
import br.com.pedroabreudev.books.domain.usecase.GetBookListUseCase
import br.com.pedroabreudev.books.domain.usecase.SaveBookListUseCase
import br.com.pedroabreudev.books.util.ViewState
import br.com.pedroabreudev.books.util.postError
import br.com.pedroabreudev.books.util.postLoading
import br.com.pedroabreudev.books.util.postSuccess


class BookListViewModel(
    private val getBookListUseCase: GetBookListUseCase,
    private val saveBookListUseCase: SaveBookListUseCase,
) : ViewModel() {

    private val _bookListViewState = MutableLiveData<ViewState<List<Book>>>()
    val bookListViewState = _bookListViewState as LiveData<ViewState<List<Book>>>

    fun search(input: String = "") {
        _bookListViewState.postLoading()
        getBookListUseCase(
            params = GetBookListUseCase.Params(
                input = input
            ),
            onSuccess = {
                saveBooks(bookList = it)
                _bookListViewState.postSuccess(it)
            },
            onError = {
                _bookListViewState.postError(it)
            }
        )
    }

    private fun saveBooks(bookList: List<Book>) {
        saveBookListUseCase(params = SaveBookListUseCase.Params(
            bookList = bookList
        ))
    }
}