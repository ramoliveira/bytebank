package br.com.alura.bytebank.model

fun main() {
    println("Welcome to Bytebank!")

    val (holder, accountNumber, balance) = declaringVariables()
    stringInterpolation(holder, accountNumber, balance)

    objectExpression()

    overcharging()

    equalsClient()

    clientHash()

    clientToString()
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

