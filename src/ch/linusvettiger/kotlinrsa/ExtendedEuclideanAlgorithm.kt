package ch.linusvettiger.kotlinrsa

import java.math.BigInteger
import java.security.InvalidAlgorithmParameterException

/**
 * Wrapper class to store results generated by the extended euclidean algorithm
 */
class EEAResult(var gcd: BigInteger, var x0: BigInteger, var y0: BigInteger) {
    /**
     * Checks equality of EEAResults by comparing all Properties
     */
    override fun equals(other: Any?): Boolean {
        if (other !is EEAResult) {
            return false
        }
        return other.gcd == gcd && other.x0 == x0 && other.y0 == y0
    }

    /**
     * Automatically generated by IntelliJ
     */
    override fun hashCode(): Int {
        var result = gcd.hashCode()
        result = 31 * result + x0.hashCode()
        result = 31 * result + y0.hashCode()
        return result
    }
}

/**
 * Runs the extended euclidean algorithm to compute the gcd of large numbers
 * returns the result of the computation containing the gcd and the bézout coefficients
 */
fun eea(num1: BigInteger, num2: BigInteger): EEAResult {
    // Catch invalid input
    if (num1 === 0.toBigInteger() || num2 === 0.toBigInteger()) {
        throw InvalidAlgorithmParameterException("0 is an invalid input")
    }

    // Variable declaration and initialisation
    var a: BigInteger
    var b: BigInteger = num2
    var x0 = BigInteger.ONE
    var y0 = BigInteger.ZERO
    var x1 = BigInteger.ZERO
    var y1 = BigInteger.ONE
    var q = num1 / num2
    var rest = num1 % num2

    // Runs the algorithm until there is no rest and therefore the gcd has been found
    while (rest > BigInteger.ZERO) {
        // Shift x0, x1, y0, y1
        val tmpX1 = x1
        val tmpY1 = y1
        x1 = x0-x1*q
        y1 = y0-y1*q
        x0 = tmpX1
        y0 = tmpY1

        // Shift b -> a | rest -> b
        a=b
        b=rest

        // Perform the next computation
        q = a / b
        rest = a % b
    }
    if (x1 < BigInteger.ZERO) x1 = num2+x1
    if (y1 < BigInteger.ZERO) y1 = num1+y1
    // Returns a wrapper object containing the result data
    return EEAResult(b, x1, y1)
}