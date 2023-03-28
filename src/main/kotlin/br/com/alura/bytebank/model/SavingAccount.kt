package br.com.alura.bytebank.model

import br.com.alura.bytebank.exception.InsuficientBalanceException

class SavingAccount(
    holder: Client,
    number: Int,
    balance: Double,
    investments: Array<Investment>,
    insurances: Array<Insurance>
) : Account(holder, number, balance, investments, insurances) {

    override fun withdraw(value: Double) {
        if (value > this.balance) throw InsuficientBalanceException()
        this.balance -= value
    }
}