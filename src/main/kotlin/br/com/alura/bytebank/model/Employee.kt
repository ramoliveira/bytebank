package br.com.alura.bytebank.model

abstract class Employee(
    val name: String,
    val document: String,
    val salary: Double,
) {
    abstract val bonus: Double
}