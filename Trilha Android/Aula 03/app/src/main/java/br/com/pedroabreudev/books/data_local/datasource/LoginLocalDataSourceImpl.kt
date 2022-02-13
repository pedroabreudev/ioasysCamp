package br.com.pedroabreudev.books.data_local.datasource

import br.com.pedroabreudev.books.data.datasources.local.LoginLocalDataSource
import br.com.pedroabreudev.books.data_local.utils.LocalConstants.ACCESS_TOKEN_KEY
import br.com.pedroabreudev.books.data_local.utils.SharedPreferencesHelper

class LoginLocalDataSourceImpl(private val sharedPreferencesHelper: SharedPreferencesHelper) :
    LoginLocalDataSource {

    override fun saveAccessToken(accessToken: String) = sharedPreferencesHelper.saveString(
        key = ACCESS_TOKEN_KEY,
        value = accessToken
    )


}