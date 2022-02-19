package br.com.pedroabreudev.books.domain.usecase

import br.com.pedroabreudev.books.domain.model.Book
import br.com.pedroabreudev.books.domain.repositories.BooksRepository
import br.com.pedroabreudev.books.domain.utils.UseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class SaveBookListUseCase(
    private val booksRepository: BooksRepository,
    scope: CoroutineScope,
) : UseCase<SaveBookListUseCase.Params, Unit>(scope = scope) {

    override fun run(params: Params?): Flow<Unit> =
        flowOf(booksRepository.saveBooks(bookList = params?.bookList ?: listOf()))

    data class Params(
        val bookList: List<Book>,
    )
}