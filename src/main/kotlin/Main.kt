import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL
import javax.net.ssl.HttpsURLConnection

fun main(args: Array<String>) {
    println("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")

    val finalResult = CodeBreaker().decryptText(readFileFromResources("input.txt"))

    println()
    println()
    println("--------------------------------")
    println("FINAL RESULT: $finalResult")
}

fun readFileFromResources(fileName: String): String {
    val inputStream = object {}.javaClass.getResourceAsStream("/$fileName")
    val reader = BufferedReader(InputStreamReader(inputStream))

    val content = StringBuilder()
    var line: String?
    while (reader.readLine().also { line = it } != null) {
        content.append(line).append("\n")
    }

    reader.close()
    return content.toString()
}