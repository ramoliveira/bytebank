package br.com.alura.bytebank.model

import br.com.alura.bytebank.exception.InsuficientBalanceException

class SavingAccount(
    holder: Client,
    number: Int = 0,
    balance: Double = 0.0,
    investments: Array<Investment> = arrayOf(),
    insurances: Array<Insurance> = arrayOf()
) : Account(holder, number, balance, investments, insurances) {

    override fun withdraw(value: Double) {
        if (value > this.balance) throw InsuficientBalanceException()
        this.balance -= value
    }

    override fun toString(): String {
        return """
 holder: ${holder.name}
 balance: ${balance}
        """.trimIndent()
    }
}