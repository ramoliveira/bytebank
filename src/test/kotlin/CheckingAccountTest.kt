import br.com.alura.bytebank.model.*
import br.com.alura.bytebank.model.InsuranceType.CAR
import br.com.alura.bytebank.model.InsuranceType.LIFE
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


class CheckingAccountTest {

    private val account: CheckingAccount = CheckingAccount(
        Client("Ramón", "123.456.789-01", Address(), 1234),
        1234,
        22.0,
        arrayOf(
            Investment(name = "Shares", value = 1000.0),
            Investment(value = 200.0, name = "Public titles")
        ),
        arrayOf(
            Insurance(LIFE),
            Insurance(CAR)
        )
    )

    @Test
    fun test_withdraw() {
        val expected: Double = 0.0
        account.withdraw(20.0)
        assertEquals(expected, account.balance)
    }
}