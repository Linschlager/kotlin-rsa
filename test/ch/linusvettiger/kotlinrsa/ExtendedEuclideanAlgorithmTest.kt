package ch.linusvettiger.kotlinrsa

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.security.InvalidAlgorithmParameterException
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

class ExtendedEuclideanAlgorithmTest {
    @Test fun `runs the algorithm correctly`() {
        assertEquals(EEAResult(1.toBigInteger(), 2.toBigInteger(), 13.toBigInteger()), eea(18.toBigInteger(), 7.toBigInteger()))
        assertNotEquals(EEAResult(2.toBigInteger(), 2.toBigInteger(), 13.toBigInteger()), eea(18.toBigInteger(), 7.toBigInteger()))
        assertEquals(EEAResult(1.toBigInteger(), 13.toBigInteger(), 2.toBigInteger()), eea(7.toBigInteger(), 18.toBigInteger()))
    }

    @Test fun `cannot compute 0 values`() {
        assertThrows<InvalidAlgorithmParameterException> { eea(1.toBigInteger(), 0.toBigInteger()) }
        assertThrows<InvalidAlgorithmParameterException> { eea(0.toBigInteger(), 1.toBigInteger()) }
    }
}