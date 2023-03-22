package br.com.alura.bytebank.model

interface Authenticable {
    var password: Int

    fun authenticate(password: Int): Boolean {
        return this.password == password
    }
}