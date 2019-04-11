package ch.linusvettiger.kotlinrsa

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

class MathLibTest {
    @Test fun `runs the extended euclidean algorithm correctly`() {
        assertEquals(EEAResult(1.toBigInteger(), 2.toBigInteger(), 13.toBigInteger()), eea(18.toBigInteger(), 7.toBigInteger()))
        assertNotEquals(EEAResult(2.toBigInteger(), 2.toBigInteger(), 13.toBigInteger()), eea(18.toBigInteger(), 7.toBigInteger()))
        assertEquals(EEAResult(1.toBigInteger(), 13.toBigInteger(), 2.toBigInteger()), eea(7.toBigInteger(), 18.toBigInteger()))
    }

    @Test fun `runs the fast exponentiation algorithm correctly`() {
        assert(false)
    }
}