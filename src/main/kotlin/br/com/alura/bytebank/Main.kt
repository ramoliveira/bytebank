package br.com.alura.bytebank

import br.com.alura.bytebank.model.Address
import br.com.alura.bytebank.model.Client
import br.com.alura.bytebank.model.SavingAccount

fun main() {
    testWith()

    testRun()

    add(2, 5) {
        toBigDecimal()
    }.let (::println)
}

fun add(lhs: Int, rhs: Int, block: Int.() -> Unit) {
    val total = lhs + rhs
    total.block()
}

fun testRun() {
    val annualRate = 0.05
    val monthlyRate = annualRate / 12.0
    println("Monthly Tax: $monthlyRate")

    val client = Client(name = "Ramón", document = "123.123.123-12", password = 1234)

    val savingAccount = client.let {
        SavingAccount(holder = it)
    }

    savingAccount.run {
        deposit(1000.0)
        println("Simulating monthly yield: ${balance * monthlyRate}")
    }

    println(savingAccount)

    val yearlyYield = run {
        var balance = savingAccount.balance
        repeat(12) {
            balance += balance * monthlyRate
        }
        balance
    }
    println("Simulating yearly yield: $yearlyYield")
}

fun testWith() {
    val completeAddress = with(Address()) {
        firstLine = "Rua Vergueiro 3185"
        secondLine = "Vila Mariana"
        city = "São Paulo"
        state = "SP"
        zipCode = "01234-567"
        country = "Brasil"
        complete()
    }.let {
        println(it)
    }
}

