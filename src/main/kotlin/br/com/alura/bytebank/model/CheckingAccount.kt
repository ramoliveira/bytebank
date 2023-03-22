package br.com.alura.bytebank.model

class CheckingAccount(
    holder: Client,
    number: Int,
    balance: Double,
    investments: Array<Investment>,
    insurances: Array<Insurance>
) : Account(holder = holder, number = number, balance = balance, investments, insurances) {

    override fun withdraw(value: Double) {
        if (value * 0.1 > this.balance) return
        this.balance -= value + value * 0.1
    }
}