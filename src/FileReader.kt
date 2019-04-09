import java.io.File

fun readKeyPair(): List<String> {
    // Read the input file
    // TODO make input file dynamic
    val line = File("input/sk.txt").readLines().first()

    // Input: (n, d)
    return line.substring(1,line.length-1).split(',')
}