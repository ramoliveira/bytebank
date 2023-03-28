package br.com.alura.bytebank.model

import br.com.alura.bytebank.model.ScoreType.*

abstract class Account(
    protected val holder: Client,
    number: Int,
    balance: Double,
    private var investments: Array<Investment>,
    private var insurances: Array<Insurance>
) : Authenticable by holder {
    var name: String = holder.name
        private set

    var number: Int = number
        get() = field
        private set

    var balance: Double = balance
        protected set

    var score: ScoreType = NEUTRAL
        get() {
            when {
                this.balance > 0.0 -> {
                    return GOOD
                }
                this.balance == 0.0 -> {
                    return NEUTRAL
                }
                else -> {
                    return BAD
                }
            }
        }
        private set

    companion object {
        var total = 0
            private set
    }

    init {
        total++
    }

    fun deposit(value: Double) {
        if (value < 0.0) return
        this.balance += value
    }

    abstract fun withdraw(value: Double)

    fun transfer(account: Account, value: Double) {
        if (value > this.balance && value > 0.0) return
        account.deposit(value)
        this.withdraw(value)
    }

    fun leasing(value: Double) {
        this.balance -= value
    }

    fun statement() {
        println("===============")
        println("Holder's name: ${this.name}")
        println("model.Account's number: ${this.number}")
        println("Balance: ${this.balance}")

        println("Investments:")
        /*
        for (i in 0..this.investments.size) 0 to this.investments.size
        for (i in 0 until this.investments.size) 0 to this.investments.size-1
        for (i in 0 downTo this.investments.size) this.investments.size to 0
        for (i in 0..this.investments.size step 2) will skip every 2ish element
        there is break and continue
        */
        for (i in 0 until this.investments.size) println("\t${this.investments[i].name}: ${this.investments[i].value}")
    }
}
