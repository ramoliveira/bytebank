package br.com.alura.bytebank.model

class InnerSystem {
    var logged: Boolean = false
        private set

    fun enter(admin: Admin, password: Int, authenticated: (Boolean) -> Unit = {}) {
        enter(admin, password, authenticated)
    }

    fun enter(user: Authenticable, password: Int, authenticated: (Boolean) -> Unit = {}) {
        logged = user.authenticate(password)
        authenticated(logged)
    }
}