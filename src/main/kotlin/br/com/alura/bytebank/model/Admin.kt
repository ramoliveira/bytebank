package br.com.alura.bytebank.model

abstract  class Admin(
    name: String,
    document: String,
    salary: Double,
    override var password: Int
): Employee(name = name, document = document, salary = salary), Authenticable {
    override fun authenticate(password: Int): Boolean {
        return this.password == password
    }
}