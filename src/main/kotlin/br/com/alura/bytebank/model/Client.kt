package br.com.alura.bytebank.model

class Client(
    val name: String,
    val document: String,
    var address: Address = Address(),
    password: Int
): Authenticable {
    override var password: Int = password
        get() = field

    override fun toString(): String {
        return """
            name: ${this.name},
            document: ${this.document},
            address: ${this.address},
            password: ${this.password},
        """.trimIndent()
    }
}