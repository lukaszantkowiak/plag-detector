package pl.lantkowiak.plagdetector.algorithm.tokenizer

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import pl.lantkowiak.plagdetector.algorithm.tokenizer.lexer.LexerType
import java.nio.file.Files
import java.nio.file.Paths

class TokenizerTest {
    private val INPUT_FILE = "tokenizer/HelloWorld.java"
    private val RESULT_FILE = "tokenizer/result.txt"

    private val tokenizer = Tokenizer()

    @Test
    fun tokenize_should_tokenizeCode_when_passed() {
        // given
        val inputResource = Paths.get(javaClass.classLoader.getResource(INPUT_FILE).toURI())
        val input = Files.lines(inputResource).reduce { a, b -> a + " " + b }.get()

        // when
        val result = tokenizer.tokenize(LexerType.JAVA_8, input)

        // then
        val expectedResource = Paths.get(javaClass.classLoader.getResource(RESULT_FILE).toURI())
        val expected = Files.lines(expectedResource).findFirst().get().split(", ").map { i -> Integer.valueOf(i) }
        assertThat(result).containsExactlyElementsOf(expected);
    }
}