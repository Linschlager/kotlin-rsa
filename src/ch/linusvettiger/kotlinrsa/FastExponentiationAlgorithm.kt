package ch.linusvettiger.kotlinrsa

import java.math.BigInteger

fun fea(base: BigInteger, exponent: BigInteger, divisor: BigInteger): BigInteger {
    var result = BigInteger.ONE

    // Find binary representation of exponent
    val binaryExponent = exponent.toString(2).reversed()
    val list = emptyList<Int>().toMutableList()
    for (i in 0 until binaryExponent.length) {
        if (binaryExponent[i] == '1')
            list += i
    }

    var counter = 0
    var runningPower = base.rem(divisor)
    while (BigInteger.TWO.pow(counter) < exponent) {
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
    return result.rem(divisor)
}