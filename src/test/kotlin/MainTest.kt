import org.junit.jupiter.api.assertThrows
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class MainTest {

    @Test
    fun justAnEmptyTestFunction() {
    }

    @Test
    fun testTrivial() {
        assertTrue(true)
    }

    @Test
    fun testValidation() {
        val codeBreaker = CodeBreaker()
        assertThrows<Exception> { codeBreaker.decryptLine("noDigits") }
    }

    @Test
    fun testGetValueFromLine() {
        val codeBreaker = CodeBreaker()
        assertEquals(11, codeBreaker.decryptLine("sa11a1a"))
        assertEquals(22, codeBreaker.decryptLine("berd2aa"))
        assertEquals(31, codeBreaker.decryptLine("33a1a"))
        assertEquals(12, codeBreaker.decryptLine("1abc2"))
        assertEquals(15, codeBreaker.decryptLine("a1b2c3d4e5f"))
        assertEquals(77, codeBreaker.decryptLine("treb7uchet"))
    }

    @Test
    fun testGetValueFromText() {

        val codeBreaker = CodeBreaker()

        val inputText = """
            sa11a1a
            berd2aa
            33a1a
            1abc2
            a1b2c3d4e5f
            treb7uchet
            683
        """.trimIndent()

        assertEquals(11 + 22 + 31 + 12 + 15 + 77 + 63, codeBreaker.decryptText(inputText))
    }

}