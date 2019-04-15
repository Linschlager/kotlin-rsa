package ch.linusvettiger.kotlinrsa

import java.io.File

fun writeFile(fileName: String, content: String) {
    val f = File(fileName)
    if (f.exists()) {
        error("%s already exists. Please delete the file and try again".format(fileName))
    }
    f.createNewFile()
    f.writeText(content)
}