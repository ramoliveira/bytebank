package br.com.alura.bytebank.model

class Analyst(
    name: String,
    document: String,
    salary: Double
) : Employee(name = name, document = document, salary = salary) {
    override val bonus: Double
        get() {
            return salary * 0.1 + salary
        }
}