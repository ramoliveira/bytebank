import br.com.alura.bytebank.model.Insurance
import br.com.alura.bytebank.model.InsuranceType
import br.com.alura.bytebank.model.InsuranceType.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class InsuranceTest {

    @Test
    fun getType() {
        val insurance = Insurance(LIFE)
        val expected: InsuranceType = LIFE
        assertEquals(insurance.type, expected)
    }
}