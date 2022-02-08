package br.com.pedroabreudev.books.data_remote.model

import com.google.gson.annotations.SerializedName

data class BookListResponse(
    @SerializedName("data")
    val data: List<BookResponse>
)
