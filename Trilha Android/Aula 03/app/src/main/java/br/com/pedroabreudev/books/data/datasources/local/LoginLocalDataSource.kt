package br.com.pedroabreudev.books.data.datasources.local

interface LoginLocalDataSource {

    fun saveAccessToken(accessToken: String)
}