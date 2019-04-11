package ch.linusvettiger.kotlinrsa

import java.math.BigInteger

// Put the whole thing together
fun main() {
    // Load the message
    val message = readMessage()
    // Load the secret file and map to BigIntegers
    val keys = readKeyPair().map { it.toBigInteger() }
    // Generate the Keys object with the known data
    val k = Keys(keys[0], BigInteger.ZERO, BigInteger.ZERO, keys[1])
    // Decrypt the input data
    message.forEach {
        val decryptedMessage = decrypt(it, k)
        // Output the encrypted data and the keypair
        print(decryptedMessage.toInt().toChar())
    }
}