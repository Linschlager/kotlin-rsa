package ch.linusvettiger.kotlinrsa

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.io.File
import kotlin.test.assertTrue

class FileWriterTest {
    @Test fun `can create a file`() {
        val path = "out/test.txt"
        writeFile(path, "This is content")

        assertTrue(File(path).exists())
        File(path).delete()
    }

    @Test fun `cannot create a file twice`() {
        val path = "out/test.txt"
        writeFile(path, "This is content")

        assertThrows<Exception> {
            writeFile(path, "This is content")
        }
        File(path).delete()
    }
}