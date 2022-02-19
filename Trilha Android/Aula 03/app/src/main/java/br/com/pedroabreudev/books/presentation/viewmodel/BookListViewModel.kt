package br.com.pedroabreudev.books.presentation.viewmodel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.pedroabreudev.books.domain.model.Book
import br.com.pedroabreudev.books.domain.repositories.BooksRepository
import br.com.pedroabreudev.books.domain.usecase.GetBookListUseCase
import br.com.pedroabreudev.books.domain.usecase.SaveBookListUseCase
import br.com.pedroabreudev.books.util.ViewState
import br.com.pedroabreudev.books.util.postError
import br.com.pedroabreudev.books.util.postLoading
import br.com.pedroabreudev.books.util.postSuccess
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class BookListViewModel(
    private val getBookListUseCase: GetBookListUseCase,
    private val saveBookListUseCase: SaveBookListUseCase,
) : ViewModel() {

    private val _bookListViewState = MutableLiveData<ViewState<List<Book>>>()
    val bookListViewState = _bookListViewState as LiveData<ViewState<List<Book>>>

    fun search(input: String = "") {
        viewModelScope.launch {
            _bookListViewState.postLoading()

            try {
                withContext(Dispatchers.IO) {
                    getBookListUseCase(params = GetBookListUseCase.Params(input = input)).collect {
                        saveBooks(bookList = it)
                        _bookListViewState.postSuccess(it)
                    }

                }
            } catch (err: Exception) {
                withContext(Dispatchers.Main) {
                    _bookListViewState.postError(err)
                }
            }
        }
    }

    private fun saveBooks(bookList: List<Book>) {
        viewModelScope.launch {
            try {
                withContext(Dispatchers.IO) {
                    saveBookListUseCase(params = SaveBookListUseCase.Params(bookList = bookList))
                }
            } catch (err: Exception) {
                return@launch
            }
        }
    }
}