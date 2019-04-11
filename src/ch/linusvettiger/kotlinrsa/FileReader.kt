package ch.linusvettiger.kotlinrsa

import java.io.File
import java.math.BigInteger

fun readMessage(): List<BigInteger> {
    return File("input/cipher.txt").readLines().first().split(',').map{ it.toBigInteger() }
}

fun readKeyPair(): List<String> {
    // Read the input file
    // TODO make input file dynamic
    val line = File("input/sk.txt").readLines().first()

    // Input: (n, d)
    return line.substring(1,line.length-1).split(',')
}