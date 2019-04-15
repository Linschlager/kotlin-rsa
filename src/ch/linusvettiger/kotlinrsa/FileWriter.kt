package ch.linusvettiger.kotlinrsa

import java.io.File

fun writeFile(fileName: String, content: String) {
    val f = File(fileName)
    if (f.exists()) {
        error("$fileName already exists. Please delete the file and try again")
    }
    f.createNewFile()
    f.writeText(content)
}