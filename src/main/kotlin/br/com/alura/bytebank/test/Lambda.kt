package br.com.alura.bytebank.test

import br.com.alura.bytebank.model.Address
import br.com.alura.bytebank.model.Authenticable
import br.com.alura.bytebank.model.InnerSystem

fun testScopeFunction() {
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
        .let(::println)

    Address(firstLine = "Rua Vergueiro 3186")
        .run { "$firstLine".uppercase() }
        .let(::println)

    listOf(
        Address(secondLine = "casa"),
        Address(),
        Address(secondLine = "apartamento")
    ).filter {
        it.secondLine.isNotEmpty()
    }.let(::println)

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

public fun testMultipleReturnsLambda() {
    val b1: (salary: Double) -> Double = lambda@{ salary ->
        if (salary > 1000.0) return@lambda salary + 50.0
        salary + 100.0
    }
    println("bonus ${b1(500.0)}")
    println("bonus ${b1(1100.0)}")

    val b2 = fun(salary: Double): Double {
        if (salary > 1000.0) return salary + 50.0
        return salary + 100.0
    }
    println("bonus ${b2(500.0)}")
    println("bonus ${b2(1100.0)}")
}

public fun testFunctionAsLambda() {
    val f1: (Int) -> Unit = {
        println("Function as lambda [$it]")
    }
    f1(1)

    val f2 = { number: Int ->
        println("Function as lambda [$number]")
    }
    f2(2)

    val f3: (Int) -> Unit = fun(number) {
        println("Function as anonymous lambda [$number]")
    }
    f3(3)

    val add1: (Int, Int) -> Int = { lhs: Int, rhs: Int ->
        lhs + rhs
    }
    println("Function as lambda | add ${add1(1, 2)}")

    val add2 = { lhs: Int, rhs: Int ->
        lhs + rhs
    }
    println("Function as lambda | add ${add2(2, 3)}")

    val add3 = fun(lhs: Int, rhs: Int): Int {
        return lhs + rhs
    }
    println("Function as anonymous lambda | add ${add3(3, 4)}")
}

public fun testFunctionAsReference() {
    val f1: (Int) -> Unit = ::functionAsReference
    f1(1)

    val f2 = ::functionAsReference
    f2(2)
}

public fun testFunctionAsClass() {
    val functionAsClass: (Int) -> Unit = FunctionAsClass()
    functionAsClass(1)

    val add = Add()
    println(add(2, 5))
}

fun functionAsReference(id: Int = 1) {
    println("Function as Reference [$id]")
}

class FunctionAsClass: (Int) -> Unit {
    override fun invoke(number: Int) {
        println("Function as class [$number]")
    }
}

class Add: (Int, Int) -> Int {
    override fun invoke(lhs: Int, rhs: Int): Int {
        return lhs + rhs
    }
}