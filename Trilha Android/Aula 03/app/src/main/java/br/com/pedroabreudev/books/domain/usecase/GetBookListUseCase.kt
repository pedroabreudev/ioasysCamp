package br.com.pedroabreudev.books.domain.usecase

import br.com.pedroabreudev.books.domain.model.Book
import br.com.pedroabreudev.books.domain.repositories.BooksRepository
import kotlinx.coroutines.flow.Flow

class GetBookListUseCase(private val booksRepository: BooksRepository) {

    operator fun invoke(params: Params): Flow<List<Book>> =
        booksRepository.getBooks(query = params.input)


    data class Params(
        val input: String,
    )
}