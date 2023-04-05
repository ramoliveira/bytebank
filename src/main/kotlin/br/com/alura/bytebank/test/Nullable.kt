package br.com.alura.bytebank.test

import br.com.alura.bytebank.model.Address
import br.com.alura.bytebank.model.Authenticable
import br.com.alura.bytebank.model.Client
import java.lang.ArithmeticException
import java.lang.NullPointerException
import java.lang.NumberFormatException

fun testNullable() {
    val (holder, accountNumber, balance) = declaringVariables()
    stringInterpolation(holder, accountNumber, balance)

    objectExpression()

    overcharging()

    equalsClient()

    clientHash()

    clientToString()

    // execptionTesting()

    castingExceptionTryCatchNormal()

    castingExceptionExpression()

    castingExceptionWhen()

    // castingExceptionThrow()

    // nullParameters()

    nullSafeCall()

    letFunction()

    elvisOperator()

    safeCast()
}

private fun safeCast() {
    val address: Address? = Address(firstLine = "QS 10 Conjunto 4 Casa 1")
    val number: Int? = address as? Int
    println(number)
}

private fun elvisOperator() {
    var nullAddress: Address? = Address(firstLine = "QS 10 Conjunto 4 Casa 1")
    nullAddress?.let {
        val length: Int = it.firstLine?.length ?: 0
        val throwableLength: Int = it.firstLine?.length ?: throw NullPointerException()
        println("length: $length")
        println("length: $throwableLength")
    }
}

private fun letFunction() {
    var nullAddress: Address? = Address(firstLine = "QS 10 Conjunto 4 Casa 1")
    nullAddress.let {
        println(it?.firstLine)
    }

    nullAddress?.let { address: Address ->
        println(address.firstLine)
    }
}

private fun nullSafeCall() {
    var nullAddress: Address? = Address(firstLine = "QS 10 Conjunto 4 Casa 1")
    println(nullAddress?.firstLine?.length)
}

private fun nullParameters() {
    var nullAddress: Address? = null
    val nonNullAddress: Address = nullAddress!!
    println(nonNullAddress.firstLine)
}

private fun castingExceptionThrow() {
    for (i in 1..5) {
        println(i)
        val address = Any()
        throw ArithmeticException()
    }
}

private fun castingExceptionWhen() {
    val input: String = "1"

    val value: Double? = try {
        input.toDouble()
    } catch (e: NumberFormatException) {
        println("casting exception")
        e.printStackTrace()
        null
    }

    val taxedValue: Double? = when {
        value != null -> {
            value + 0.1
        }
        else -> {
            null
        }
    }

    println("value with tax: $taxedValue")
}

private fun castingExceptionExpression() {
    val input: String = "1"

    val value: Double? = try {
        input.toDouble()
    } catch (e: NumberFormatException) {
        println("casting exception")
        e.printStackTrace()
        null
    }

    if (value != null) {
        println("value: $value")
    } else {
        println("invalid value")
    }

    val taxedValue: Double? = if (value != null) {
        value + 0.1
    } else {
        null
    }

    println("value with tax: $taxedValue")
}

private fun castingExceptionTryCatchNormal() {
    val input: String = "1.9"

    try {
        val value: Double = input.toDouble()
        println("value $value")
    } catch (e: NumberFormatException) {
        println("casting exception")
        e.printStackTrace()
    }
}

private fun execptionTesting() {
    for (i in 1..5) {
        println(i)
        try {
            val address = Any()
            address as Address
        } catch (e: ClassCastException) {
            println("Got an exception $e")
            println(e.message)
            println(e.stackTrace)
            println(e.cause)
            e.printStackTrace()
        }
    }
}

private fun clientToString() {
    println(Client("Ramón", "123.456.789-01", Address(), 1234))
}

private fun clientHash() {
    val client = Client("Ramón", "123.456.789-01", Address(), 1234)
    val newClient = Client("Ramón", "123.456.789-01", Address(), 1234)
    println(client.hashCode())
    println(newClient.hashCode())
}

private fun equalsClient() {
    val client = Client("Ramón", "123.456.789-01", Address(), 1234)
    var newClient = client

    println(client.equals(newClient))

    newClient = Client("Ramón", "123.456.789-01", Address(), 1234)

    println(client.equals(newClient))
}

private fun overcharging() {
    foo("bar")
    val o = foo(object {
        var foo: String = "foo"
    })
    println(o)
}

private fun foo(bar: String) {
    println("foo $bar")
}

private fun foo(bar: Any?): Any? {
    println("$bar")
    return bar
}

private fun objectExpression() {
    val o = object: Authenticable {
        val name: String = "Ramón"
        val document: String = "123.456.789-01"
        override var password: Int = 1234

        override fun authenticate(password: Int): Boolean = this.password == password

        override fun toString(): String {
            return "name:${this.name}, document:${this.document}, password:${this.password}"
        }
    }

    println(o)
    println(o.authenticate(1234))
}

private fun stringInterpolation(holder: String, accountNumber: Int, balance: Double) {
    println("Holder: ${holder}") // Holder: Ramón
    println("Holder: $holder")   // Holder: Ramón
    println("model.Account Number: $accountNumber") // model.Account Number: 1234
    println("Balance: $balance") // Balance: 0.0
}

private fun declaringVariables(): Triple<String, Int, Double> {
    // val -> can't change the value
    // var -> can change the value
    val holder = "Ramón"
    val accountNumber = 1234
    val balance = 0.0

    return Triple(holder, accountNumber, balance)
}