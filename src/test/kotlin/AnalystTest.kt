import br.com.alura.bytebank.model.Analyst
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class AnalystTest {

    private val analyst: Analyst = Analyst("Ramón", "123.456.789-01", 5000.0)

    @Test
    fun getBonus() {
        val expected = 5500.0
        assertEquals(expected, analyst.bonus)
    }
}