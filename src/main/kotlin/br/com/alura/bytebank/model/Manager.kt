package br.com.alura.bytebank.model

class Manager(
    name: String,
    document: String,
    salary: Double,
    password: Int
) : Admin(name = name, document = document, salary = salary, password = password) {

    public override var password: Int = password
        get() = field

    override val bonus: Double get() = salary * 0.2
}