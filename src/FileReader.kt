import java.io.File

fun readPrivateKey(): String {
    // Read the input file
    // TODO make input file dynamic
    val lines = File("input/sk.txt").readLines()
    // Since only one line actually contains input, only use the first line
    var firstLine = lines.first()
    // Remove first and last bracket if present
    if (firstLine.startsWith('(')) firstLine = firstLine.substring(1)
    if (firstLine.endsWith(')')) firstLine = firstLine.substring(0, firstLine.length-1)
    return firstLine
}