package br.com.pedroabreudev.books.data_remote.service

import br.com.pedroabreudev.books.data_remote.model.BookListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface BookService {

    @GET("books")
    suspend fun getBooks(
        @Header("Authorization") accessToken: String,
        @Query("page") page: Int,
        @Query("title") name: String,
        @Query("category") category: String
    ): Response<BookListResponse>
}