package pl.lantkowiak.plagdetector.algorithm.compressor

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class CompressorTest {
    private val INPUT = "ababcbababaaaaaa"

    private val compressor = Compressor<String>()

    @Test
    fun encode() {
        // given
        val input = prepareInput(INPUT)

        // when
        val result = compressor.encode(input);

        // then
        val expected = mutableListOf<CodedTriple<String>>()
        expected.add(CodedTriple(0, 0, "a"))
        expected.add(CodedTriple(0, 0, "b"))
        expected.add(CodedTriple(2, 2, "c"))
        expected.add(CodedTriple(4, 3, "a"))
        expected.add(CodedTriple(2, 3, "a"))
        expected.add(CodedTriple(3, 2, "a"))
        assertThat(result).isEqualTo(expected);
    }

    private fun prepareInput(inputString: String): List<String> {
        val input = mutableListOf<String>()
        for (c in inputString.toCharArray()) {
            input.add(c.toString())
        }

        return input
    }
}