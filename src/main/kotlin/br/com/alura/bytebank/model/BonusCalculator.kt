package br.com.alura.bytebank.model

class BonusCalculator {
    var total: Double = 0.0
        private set

    fun add(employee: Employee) {
        this.total += employee.bonus
    }

    // not safe
    fun add_notSafe(employee: Any) {
        employee as Employee // Casting
        this.total += employee.bonus
    }

    fun add(employee: Any) {
        if (employee is Employee) {
            this.total += employee.bonus
        }
    }
}