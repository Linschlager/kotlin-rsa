package ch.linusvettiger.kotlinrsa

import java.math.BigInteger
import kotlin.random.Random

// Implement the outside interface
fun main(args: Array<String>) {
    if (args.isEmpty()) {
        println("Usage:")
        println("--file=<path-to-file> File to encrypt/decrypt. Format: Comma separated characters")
        println("--private-key=<path-to-file> File containing the private key. Format (n,d)")
        println("--public-key=<path-to-file> File containing the public key. Format: (n,e)")
        println("--encrypt Encrypt the input file")
        println("--decrypt Decrypt the input file using --private-key")
        error("No arguments provided")
    }

    var inputFilePath = ""
    var privateKeyPath = ""
    var publicKeyPath = ""
    var programMode = ""
    args.forEach{
        val parts = if (it.contains('=')) {
            it.split('=')
        } else {
            listOf(it)
        }
        when {
            parts[0] == "--file" -> inputFilePath = parts[1]
            parts[0] == "--private-key" -> privateKeyPath = parts[1]
            parts[0] == "--public-key" -> publicKeyPath = parts[1]
            parts[0] == "--decrypt" -> programMode = "decrypt"
            parts[0] == "--encrypt" -> programMode = "encrypt"
        }
    }
    /*
        Possible combination
        - file + encrypt
        - file + encrypt + pubKey
        - file + decrypt + priKey

        Impossible combination
        - no inputFile
        - decrypt + no priKey
     */

    // Load the encrypted message
    val message = readMessage(inputFilePath)
    var keys = Keys(BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO) // Default initialisation

    // Validate input
    if (inputFilePath.isBlank()) {
        error("Please pass the input using --file")
    }
    if (programMode == "decrypt" && privateKeyPath.isBlank()) {
        error("To decrypt the data, you need to pass the path to a private key file using --private-key")
    }

    if (programMode == "decrypt") {
        if (!privateKeyPath.isBlank()) {
            val inputKeys = readKeyPair(privateKeyPath).map { it.toBigInteger() }
            keys = Keys(inputKeys[0], BigInteger.ZERO, BigInteger.ZERO, inputKeys[1])
        }
        // Decrypt the input data
        message.forEach {
            val decryptedMessage = decrypt(it.toBigInteger(), keys)
            // Output the encrypted data and the keypair
            print(decryptedMessage.toInt().toChar())
        }
    }
    if (programMode == "encrypt") {
        // Check for key path
        if (!publicKeyPath.isBlank()) {
            val inputKeys = readKeyPair(publicKeyPath).map { it.toBigInteger() }
            keys = Keys(inputKeys[0], BigInteger.ZERO, inputKeys[1], BigInteger.ZERO)
        } else {
            // Generate keypair
            var p: BigInteger = BigInteger.ZERO
            var q: BigInteger = BigInteger.ZERO

            while (!p.isProbablePrime(1024)) {
                p = Random.nextLong(0, Long.MAX_VALUE).toBigInteger()
            }
            while (!q.isProbablePrime(1024)) {
                q = Random.nextLong(0, Long.MAX_VALUE).toBigInteger()
            }
            keys = generateKeys(p, q)
        }
        message.forEach { single ->
            // If the file contains a
            single.forEach {
                print(encrypt(it.toInt().toBigInteger(), keys))
                print(",")
            }
        }
    }
    println()
    println("Key used: ")
    // Only output the actually set values
    if (keys.e > BigInteger.ZERO)
        println("Public Key (n, e) = (%d, %d)".format(keys.n, keys.e))
    if (keys.d > BigInteger.ZERO)
        println("Private Key (n, d) = (%d, %d)".format(keys.n, keys.d))
}
