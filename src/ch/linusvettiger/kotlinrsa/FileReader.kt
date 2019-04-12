package ch.linusvettiger.kotlinrsa

import java.io.File

fun readMessage(filePath: String): List<String> {
    try {
        return File(filePath).readLines().first().split(',').map{ it.trim() }
    } catch (e: Exception) {
        e.printStackTrace()
    }
    return emptyList()
}

fun readKeyPair(filePath: String): List<String> {
    // Read the input file
    try {
        val line = File(filePath).readLines().first()

        // Input: (n, d)
        return line.substring(1, line.length - 1).split(',')
    } catch (e: Exception) {
        e.printStackTrace()
    }
    return emptyList()
}