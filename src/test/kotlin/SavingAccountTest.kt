import br.com.alura.bytebank.model.*
import br.com.alura.bytebank.model.InsuranceType.CAR
import br.com.alura.bytebank.model.InsuranceType.LIFE
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SavingAccountTest {

    private val account: SavingAccount = SavingAccount(
        Client("Ramón", "123.456.789-01", Address(), 1234),
        1234,
        500.0,
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
    fun withdraw() {
        val expected = 100.0
        account.withdraw(400.0)
        assertEquals(expected, account.balance)
    }
}