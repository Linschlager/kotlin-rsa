package ch.linusvettiger.kotlinrsa

import org.junit.jupiter.api.Test
import java.math.BigInteger
import kotlin.test.assertEquals

class FastExponentiationAlgorithmTest {
    @Test fun `runs the algorithm correctly`() {
        assertEquals(1.toBigInteger(), fea(19.toBigInteger(), 2.toBigInteger(), 18.toBigInteger()))
        assertEquals(6.toBigInteger(), fea(27.toBigInteger(), 10.toBigInteger(), 23.toBigInteger()))
        assertEquals(1.toBigInteger(), fea(21.toBigInteger(), 100.toBigInteger(), 22.toBigInteger()))
        assertEquals(1.toBigInteger(), fea(8.toBigInteger(), 1_000.toBigInteger(), 9.toBigInteger()))
        assertEquals(1.toBigInteger(), fea(8.toBigInteger(), 1_000_000_000_000_000.toBigInteger(), 9.toBigInteger()))
    }

    @Test fun `can compute absurdly big numbers`() {
        val base = BigInteger.TWO.pow(Int.MAX_VALUE-1)
        val exp = "4376821462035615623549684168164198491898189198899498191793132443214".toBigInteger()
        val div = "534825732857389457304875398204573847432178462136471893625839405734859032475823904557".toBigInteger()
        print(fea(base, exp, div))
    }
}