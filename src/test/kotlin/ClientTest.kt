import br.com.alura.bytebank.model.Address
import br.com.alura.bytebank.model.Client
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ClientTest {

    private val client: Client = Client("Ramón", "123.456.789-01", Address(), 1234)

    @Test
    fun getPassword() {
        assertEquals(1234, client.password)
    }

    @Test
    fun authenticate() {
        assertTrue(client.authenticate(1234))
    }
}