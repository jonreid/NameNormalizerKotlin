import assertk.assertThat
import assertk.assertions.isEqualTo
import kotlin.test.assertFailsWith
import org.junit.Before
import org.junit.Ignore
import org.junit.Test

class AuthorNameNormalizerTests {
    private lateinit var normalizer: AuthorNameNormalizer

    @Before
    fun setUp() {
        normalizer = AuthorNameNormalizer()
    }

    @Ignore
    @Test
    fun `returns empty string when empty`() {
        assertThat(normalizer.normalize("")).isEqualTo("")
    }

    @Ignore
    @Test
    fun `returns single word name`() {
        assertThat(normalizer.normalize("Plato")).isEqualTo("Plato")
    }

    @Ignore
    @Test
    fun `swaps first and last names`() {
        assertThat(normalizer.normalize("Haruki Murakami")).isEqualTo("Murakami, Haruki")
    }

    @Ignore
    @Test
    fun `trims leading and trailing whitespace`() {
        assertThat(normalizer.normalize("  Big Boi   ")).isEqualTo("Boi, Big")
    }

    @Ignore
    @Test
    fun `initializes middle name`() {
        assertThat(normalizer.normalize("Henry David Thoreau")).isEqualTo("Thoreau, Henry D.")
    }

    @Ignore
    @Test
    fun `does not initialize one letter middle name`() {
        assertThat(normalizer.normalize("Harry S Truman")).isEqualTo("Truman, Harry S")
    }

    @Ignore
    @Test
    fun `initializes each of multiple middle names`() {
        assertThat(normalizer.normalize("Julia Scarlett Elizabeth Louis-Dreyfus")).isEqualTo("Louis-Dreyfus, Julia S. E.")
    }

    @Ignore
    @Test
    fun `appends suffixes to end`() {
        assertThat(normalizer.normalize("Martin Luther King, Jr.")).isEqualTo("King, Martin L., Jr.")
    }

    @Ignore
    @Test
    fun `throws when name contains two commas`() {
        assertFailsWith(IllegalArgumentException::class) {
            normalizer.normalize("Thurston, Howell, III")
        }
    }
}
