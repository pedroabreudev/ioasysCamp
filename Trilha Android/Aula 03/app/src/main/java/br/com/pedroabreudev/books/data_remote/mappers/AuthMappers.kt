package br.com.pedroabreudev.books.data_remote.mappers

import br.com.pedroabreudev.books.data_remote.model.LoginResponse
import br.com.pedroabreudev.books.domain.model.User

fun LoginResponse.toDomain(accessToken: String) = User(
    id = this.id,
    name = this.name,
    birthdate = this.birthdate,
    gender = this.gender,
    accessToken = accessToken
)