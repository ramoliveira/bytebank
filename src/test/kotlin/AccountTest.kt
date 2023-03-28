import br.com.alura.bytebank.exception.InsuficientBalanceException
import br.com.alura.bytebank.model.*
import br.com.alura.bytebank.model.InsuranceType.CAR
import br.com.alura.bytebank.model.InsuranceType.LIFE
import br.com.alura.bytebank.model.ScoreType.BAD
import br.com.alura.bytebank.model.ScoreType.GOOD
import br.com.alura.bytebank.model.ScoreType.NEUTRAL as NeutralScore
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class AccountTest {

    private val account: Account = CheckingAccount(
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
    fun test_name() {
        val expected = "Ramón"
        assertEquals(expected, account.name)
    }

    @Test
    fun test_number() {
        val expected = 1234
        assertEquals(expected, account.number)
    }

    @Test
    fun test_deposit() {
        val expected = 1022.0
        account.deposit(1000.0)
        assertEquals(expected, account.balance)
    }

    @Test
    fun test_failed_deposit() {
        val expected = 22.0
        account.deposit(-100.0)
        assertEquals(expected, account.balance)
    }

    @Test
    fun test_withdraw() {
        val expected = 0.0
        account.withdraw(20.0)
        assertEquals(expected, account.balance)
    }

    @Test
    fun test_failed_withdraw() {
        val expected = 22.0
        assertThrows<InsuficientBalanceException> {
            account.withdraw(1000.0)
        }
    }

    @Test
    fun transfer() {
        val a2 = CheckingAccount(Client("Rayra", "123.456.789-01", Address(), 1234), 1235, 0.0, arrayOf(), arrayOf())
        account.transfer(a2, 10.0)
        assertEquals(a2.balance, 10.0)
        assertEquals(account.balance, 11.0)
    }

    @Test
    fun test_failed_transfer() {
        val a2 = SavingAccount(Client("Rayra", "123.456.789-01", Address(), 1234), 1235, 0.0, arrayOf(), arrayOf())
        account.transfer(a2, 1000.0)
        assertEquals(a2.balance, 0.0)
        assertEquals(account.balance, 22.0)
    }

    @Test
    fun test_score_good() {
        val expected: ScoreType = GOOD
        assertEquals(expected, account.score)
    }

    @Test
    fun test_score_neutral() {
        val expected: ScoreType = NeutralScore
        account.withdraw(20.0)
        assertEquals(expected, account.score)
    }

    @Test
    fun test_score_bad() {
        val expected: ScoreType = BAD
        account.leasing(1000.0)
        assertEquals(expected, account.score)
    }
}