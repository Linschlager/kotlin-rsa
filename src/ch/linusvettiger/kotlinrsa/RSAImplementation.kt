package ch.linusvettiger.kotlinrsa

import java.math.BigInteger
import java.security.InvalidAlgorithmParameterException

class Keys(val n: BigInteger, val phi: BigInteger, val e: BigInteger, val d: BigInteger)

fun generateKeys(p: BigInteger, q: BigInteger): Keys {
    if (!p.isProbablePrime(20) || !q.isProbablePrime(20) || p === q) {
        throw InvalidAlgorithmParameterException("p and q have to be two distinct primes")
    }

    val n = p*q
    val phi = (p-BigInteger.ONE)*(q-BigInteger.ONE)
    val e = BigInteger.valueOf(65537)
    val d = (eea(phi, e)).y0

    if ((e*d).rem(phi) != BigInteger.ONE) {
        error("Invalid KeyPair: e * d mod φ(n) = ${(e*d).rem(phi)}")
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