import br.com.alura.bytebank.model.Manager
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ManagerTest {

    private val manager: Manager = Manager("Ramón", "123.456.789-01", 5000.0, 1234)

    @Test
    fun getBonus() {
        val expected = 1000.0
        assertEquals(expected, manager.bonus)
    }

    @Test
    fun authenticate() {
        assertTrue(manager.authenticate(1234))
    }

    @Test
    fun getPassword() {
        val expected = 1234
        assertEquals(expected, manager.password)
    }
}