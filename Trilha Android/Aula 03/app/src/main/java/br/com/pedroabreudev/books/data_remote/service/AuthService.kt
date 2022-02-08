package br.com.pedroabreudev.books.data_remote.service

import br.com.pedroabreudev.books.data_remote.model.LoginRequest
import br.com.pedroabreudev.books.data_remote.model.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {

    @POST("auth/sign-in")
    suspend fun signIn(@Body loginRequest: LoginRequest): Response<LoginResponse>
}