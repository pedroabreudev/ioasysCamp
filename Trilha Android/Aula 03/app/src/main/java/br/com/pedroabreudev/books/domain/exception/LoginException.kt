package br.com.pedroabreudev.books.domain.exception

open class LoginException : Exception()

class InvalidEmailException : LoginException()
class InvalidPasswordException : LoginException()