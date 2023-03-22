import br.com.alura.bytebank.model.Analyst
import br.com.alura.bytebank.model.Employee
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class EmployeeTest {

    private var employee: Employee? = null

    @Test
    fun test_bonus() {
        employee = Analyst("Ramón", "123.456.789-01", 5000.0)
        assertTrue(employee is Employee)
    }
}