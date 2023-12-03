internal class CodeBreaker {

    private val wordToNumberMap = mapOf(
        "one" to "1",
        "two" to "2",
        "three" to "3",
        "four" to "4",
        "five" to "5",
        "six" to "6",
        "seven" to "7",
        "eight" to "8",
        "nine" to "9"
    )
    private var zerolines: Int = 0
    private var regex: Regex = Regex("\\d|one|two|three|four|five|six|seven|eight|nine")
    fun decryptLine(line: String): Int {
//        val value = findFirstDigit(line) * 10 + findLastDigit(line)
//        if (value == 0) zerolines++
//        println("$line -> $value")
//        return value
        val matcherResults = regex.findAll(line)
        if (!matcherResults.any()) return 0
        return ((wordToNumberMap[matcherResults.first().value]
            ?: matcherResults.first().value) + (wordToNumberMap[matcherResults.last().value]
            ?: matcherResults.last().value)).toInt()
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
