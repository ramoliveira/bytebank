package br.com.alura.bytebank.model

class CEO(
    name: String,
    document: String,
    salary: Double,
    password: Int
) : Admin(name = name, document = document, salary = salary, password = password) {

    override var password: Int = password
        get() = field

    override val bonus: Double
        get() {
            return salary * 0.1 + salary
        }

    override fun authenticate(password: Int): Boolean {
        return super<Admin>.authenticate(password)
    }
}