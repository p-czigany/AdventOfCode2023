internal class CodeBreaker {

    private var zerolines: Int = 0
    fun decryptLine(line: String): Int {
        val value = findFirstDigit(line) * 10 + findLastDigit(line)
        if (value == 0) zerolines++
        println("$line -> $value")
        return value
    }

    fun findFirstDigit(input: String): Int =
        input.firstOrNull { it.isDigit() }?.digitToInt() ?: 0

    fun findLastDigit(input: String): Int =
        input.reversed().firstOrNull { it.isDigit() }?.digitToInt() ?: 0

    fun decryptText(text: String): Int {
        val finalResult = text.lines().sumOf { decryptLine(it) }
        println("number of zero valued lines: $zerolines")
        return finalResult
    }
}
