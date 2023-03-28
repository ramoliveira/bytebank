package br.com.alura.bytebank.model

import br.com.alura.bytebank.exception.FailedAuthenticationException
import br.com.alura.bytebank.exception.InsuficientBalanceException

class CheckingAccount(
    holder: Client,
    number: Int,
    balance: Double,
    investments: Array<Investment>,
    insurances: Array<Insurance>,
) : Account(holder = holder, number = number, balance = balance, investments, insurances) {

    override fun withdraw(value: Double) {
        if (value * 0.1 > this.balance) throw InsuficientBalanceException("Insuficient founds: ${this.balance} current balance, ${value * 0.1} tried to withdraw")
        this.balance -= value + value * 0.1
    }

    fun withdraw(value: Double, password: Int) {
        if (this.holder.authenticate(password)) {
            throw FailedAuthenticationException()
        }
        withdraw(value)
    }
}