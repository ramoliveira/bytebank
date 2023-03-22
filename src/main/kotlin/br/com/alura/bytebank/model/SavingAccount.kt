package br.com.alura.bytebank.model

class SavingAccount(
    holder: Client,
    number: Int,
    balance: Double,
    investments: Array<Investment>,
    insurances: Array<Insurance>
) : Account(holder, number, balance, investments, insurances) {

    override fun withdraw(value: Double) {
        if (value > this.balance) return
        this.balance -= value
    }
}