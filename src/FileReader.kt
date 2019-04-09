import java.io.File

fun readPrivateKey(): String {
    var prk = ""
    File("sk.txt").forEachLine {
        prk = it
    }
    return prk
}