package ch.linusvettiger.kotlinrsa

import java.math.BigInteger
import kotlin.math.pow

fun fea(base: BigInteger, exponent: BigInteger, divisor: BigInteger): BigInteger {
    var result = 1.toBigInteger() // Perform first modulo to remove an unnecessarily big base

    // Find binary representation of exponent
    val binaryExponent = exponent.toString(2).reversed()
    val list = emptyList<Int>().toMutableList()
    for (i in 0 until binaryExponent.length) {
        if (binaryExponent[i] == '1')
            list += i
    }

    var counter = 0
    var runningPower = base.rem(divisor)
    while (2.0.pow(counter).toInt().toBigInteger() < exponent) {
        // Compute base^(2*counter) mod divisor
        if (counter > 0) {
            runningPower *= runningPower
            runningPower = runningPower.rem(divisor)
        }
        // Check if counter is included in the list of binary parts
        if (list.contains(counter)) {
            result = (result * runningPower).rem(divisor)
        }
        counter ++
    }

    println(binaryExponent)
    println(list)
    println("===[]===")

    return result.rem(divisor)
}