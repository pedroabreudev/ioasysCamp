package br.com.pedroabreudev.books.presentation.viewmodel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.pedroabreudev.books.domain.exception.EmptyBookListException
import br.com.pedroabreudev.books.domain.model.Book
import br.com.pedroabreudev.books.util.ViewState
import br.com.pedroabreudev.books.util.postError
import br.com.pedroabreudev.books.util.postSuccess
import kotlinx.coroutines.launch


class BookListViewModel : ViewModel() {

    private val _bookListViewState = MutableLiveData<ViewState<List<Book>>>()
    val bookListViewState = _bookListViewState as LiveData<ViewState<List<Book>>>

    private val bookDataList: List<Book> by lazy { Book.getMockList() }

    private fun getBook(input: String): List<Book> {
        return if (input.trim().isEmpty()) {
            bookDataList
        } else {
            bookDataList.filter { book ->
                book.name.trim().contains(input, ignoreCase = true)
            }
        }
    }

    fun search(input: String = "") {
        viewModelScope.launch {
            getBook(input).let { books ->
                when {
                    books.isNotEmpty() -> {
                        _bookListViewState.postSuccess(books)
                    }
                    else -> {
                        _bookListViewState.postError(EmptyBookListException())
                    }
                }

            }
        }

    }
}