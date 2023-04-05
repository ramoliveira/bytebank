package br.com.alura.bytebank

import br.com.alura.bytebank.model.Address
import br.com.alura.bytebank.model.Authenticable
import br.com.alura.bytebank.model.InnerSystem
import kotlin.contracts.contract

fun main() {
    /*
    * let() -> Executar um lambda em objetos não nulos
    * let() -> Introduzindo uma expressão como uma variável no escopo local
    * apply() -> Configuração de objeto
    * run() -> Configuração do objeto e computação do resultado
    * run() -> Execução de instrução quando a expressão é necessária
    * also() -> Execuções adicionais sem afetar o programa
    * with() -> Agrupamento de chamadas de função em um objeto
    *
    * takeIf e takeUnless
    * Utilizamos para verificar o estado do objeto
    * Retorna o objeto null dependendo do predicado:
    * takeIf() -> Verdadeiro
    * takeUnless() -> Falso
    * */

    val a1 = Address()
        .also { println("Instantiating address") }
        .apply {
            firstLine = "Rua Vergueiro 3184"
            city = "São Paulo"
        }
        .also {
            println(it)
        }

    val address = Address(firstLine = "Rua Vergueiro 3185")

    run {
        println("Executing run without extension")
    }

    with(address) {
        "$firstLine".uppercase()
    }.let {
        println(it)
    }

    Address(firstLine = "Rua Vergueiro 3185")
        .let {
        "${it.firstLine}".uppercase()
        }
        .let (::println)

    Address(firstLine = "Rua Vergueiro 3186")
        .run { "$firstLine".uppercase() }
        .let (::println)

    listOf(
        Address(secondLine = "casa"),
        Address(),
        Address(secondLine = "apartamento")
    ).filter {
        it.secondLine.isNotEmpty()
    }.let (::println)

    add(2, 3) {
        println(it)
    }

    val user = object : Authenticable {
        override var password = 1234
        override fun authenticate(password: Int): Boolean = this.password == password
    }

    InnerSystem().enter(user, 1234) {
        println("Did enter? ${it.toEnglish()}")
    }
}

fun Boolean.toEnglish(): String {
    return if (this) {
        "Yes"
    } else {
        "No"
    }
}

fun add(lhs: Int, rhs: Int, block: (Int) -> Unit) {
    block(lhs + rhs)
}

private fun testLet() {
    val age: Int? = 10

    val safeAge = age.let { it ?: 0 }

    "".let(::testString)

    val name = "".test { println("Inside block") }.let { println("Inside let") }
}

fun String.test(block: () -> Unit): String {
    block()
    return this
}

fun testString(value: String) {}
