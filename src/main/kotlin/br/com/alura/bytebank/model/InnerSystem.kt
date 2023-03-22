package br.com.alura.bytebank.model

class InnerSystem {
    var logged: Boolean = false
        private set

    fun enter(admin: Admin, password: Int) {
        logged = admin.authenticate(password)
    }
}