package ch.linusvettiger.kotlinrsa

import org.junit.jupiter.api.Test

class FileReaderTest {
    @Test fun `can read file`() {
        val privateKey = readKeyPair("input/sk.txt")
        // There need to be exactly two entries in the list (n, d)
        assert(privateKey.isNotEmpty())
        assert(privateKey.size == 2)
        // keypair needs to contain two valid BigInteger's
        privateKey[0].toBigInteger()
        privateKey[1].toBigInteger()
    }
}