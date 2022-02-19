package br.com.pedroabreudev.books.domain.usecase

import br.com.pedroabreudev.books.domain.model.Book
import br.com.pedroabreudev.books.domain.repositories.BooksRepository
import br.com.pedroabreudev.books.domain.utils.UseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow

class GetBookListUseCase(
    private val booksRepository: BooksRepository,
    scope: CoroutineScope,
) : UseCase<GetBookListUseCase.Params, List<Book>>(scope = scope) {

    override fun run(params: Params?): Flow<List<Book>> =
        booksRepository.getBooks(query = params?.input)

    data class Params(
        val input: String,
    )
}