package br.com.alura.bytebank.model

class Address(
    var firstLine: String = "",
    var secondLine: String = "",
    var city: String = "",
    var state: String = "",
    var zipCode: String = "",
    var country: String = "",
) {
    override fun toString(): String {
        return """
            first line: ${this.firstLine},
            second line: ${this.secondLine},
            city: ${this.city},
            state: ${this.state},
            zip code: ${this.zipCode},
            country: ${this.country}
        """.trimMargin().trimIndent()
    }

    fun complete(): String {
        return """
$firstLine, $secondLine
$city - $state, $country
$zipCode
        """.trimIndent()
    }
}