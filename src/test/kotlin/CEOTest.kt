import br.com.alura.bytebank.model.CEO
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class CEOTest {

    private val ceo: CEO = CEO("Ramón", "123.456.789-01", 5000.0, 1234)

    @Test
    fun getBonus() {
        val expected = 5500.0
        assertEquals(ceo.bonus, expected)
    }

    @Test
    fun authenticate() {
        assertTrue(ceo.authenticate(1234))
    }

    @Test
    fun getPassword() {
        val expected = 1234
        assertEquals(ceo.password, expected)
    }
}