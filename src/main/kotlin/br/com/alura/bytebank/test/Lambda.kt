package br.com.alura.bytebank.test

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