package ch.linusvettiger.kotlinrsa

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class FastExponentiationAlgorithmTest {
    @Test fun `runs the algorithm correctly`() {
        assertEquals(1.toBigInteger(), fea(19.toBigInteger(), 2.toBigInteger(), 18.toBigInteger()))
        assertEquals(6.toBigInteger(), fea(27.toBigInteger(), 10.toBigInteger(), 23.toBigInteger()))
        assertEquals(1.toBigInteger(), fea(21.toBigInteger(), 100.toBigInteger(), 22.toBigInteger()))
        assertEquals(1.toBigInteger(), fea(8.toBigInteger(), 1_000.toBigInteger(), 9.toBigInteger()))
        assertEquals(1.toBigInteger(), fea(8.toBigInteger(), 1_000_000_000_000_000.toBigInteger(), 9.toBigInteger()))
    }
}