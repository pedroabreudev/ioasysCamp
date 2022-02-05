package br.com.pedroabreudev.books.domain.model

data class User(
    val id: String,
    val name: String,
    val birthdate: String,
    val gender: String,
    val accessToken: String
)
