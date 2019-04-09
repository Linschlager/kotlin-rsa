import org.junit.jupiter.api.Test

class FileReaderTest {
    @Test fun `can read file`() {
        val pk: String = readPrivateKey()
        assert(pk.isNotEmpty())
        assert(!pk.contains('('))
        assert(!pk.contains(')'))
    }
}