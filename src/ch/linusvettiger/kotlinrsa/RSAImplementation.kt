package ch.linusvettiger.kotlinrsa

import java.math.BigInteger
import java.security.InvalidAlgorithmParameterException

class Keys(val n: BigInteger, val phi: BigInteger, val e: BigInteger, val d: BigInteger) {
    override fun toString(): String {
        return "φ(n): %d\nPublic Key: (%d, %d)\nPrivate Key: (%d, %d)".format(phi, n, e, n, d)
    }
}

fun generateKeys(p: BigInteger, q: BigInteger): Keys {
    if (!p.isProbablePrime(20) || !q.isProbablePrime(20) || p === q) {
        throw InvalidAlgorithmParameterException("p and q have to be two distinct primes")
    }


    val n = p*q
    val phi = (p-1.toBigInteger())*(q-1.toBigInteger())

    val e = 65537.toBigInteger()

    val d = (eea(phi, e)).y0

    if ((e*d).rem(phi) != 1.toBigInteger()) {
        error("Invalid KeyPair: " + (e*d).rem(phi))
    }

    //Test: val m = (fea(message.toBigInteger(), e*d, n))
    return Keys(n, phi, e, d)
}

fun encrypt(message: BigInteger, k: Keys): BigInteger {
    return fea(message, k.e, k.n)
}

fun decrypt(message: BigInteger, k: Keys): BigInteger {
    return fea(message, k.d, k.n)
}