package ch.linusvettiger.kotlinrsa

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.math.BigInteger
import kotlin.test.assertEquals

class RSAImplementationTest {
    @Test fun `detects invalid p or q`() {
        assertThrows<Exception> {
            generateKeys(10.toBigInteger(), 20.toBigInteger())
        }
    }

    @Test fun `generates valid keys`() {
        val k = generateKeys(929.toBigInteger(), 619.toBigInteger())
        assertEquals(BigInteger.ONE, (k.e*k.d).rem(k.phi))
    }

    @Test fun `can encrypt and decrypt a message`() {
        val k = generateKeys(929.toBigInteger(), 619.toBigInteger())
        val message = 100.toBigInteger()
        val encryptedMessage = encrypt(message, k)
        println("Encrypted Message: %d".format(encryptedMessage))
        val decryptedMessage = decrypt(encryptedMessage, k)
        println("Decrypted Message: %d".format(decryptedMessage))
        assertEquals(message, decryptedMessage)
    }

    @Test fun `can encrypt and decrypt a big message`() {
        // n has to be > message to not cause an overflow
        val k = generateKeys(602521.toBigInteger(), 1226741.toBigInteger())
        val message = "123456789".toBigInteger()
        val encryptedMessage = encrypt(message, k)
        println("Encrypted Message: %d".format(encryptedMessage))
        val decryptedMessage = decrypt(encryptedMessage, k)
        println("Decrypted Message: %d".format(decryptedMessage))
        assertEquals(message, decryptedMessage)
    }
}