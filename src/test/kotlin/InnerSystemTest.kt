import br.com.alura.bytebank.model.InnerSystem
import br.com.alura.bytebank.model.Manager
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class InnerSystemTest {

    private val manager: Manager = Manager("Ramón", "123.456.789-01", 5000.0, 1234)
    private val system = InnerSystem()

    @Test
    fun test_enter() {
        system.enter(manager, 1234)
        assertTrue(system.logged)
    }

    fun test_failed_enter() {
        system.enter(manager, 2000)
        assertFalse(system.logged)
    }
}