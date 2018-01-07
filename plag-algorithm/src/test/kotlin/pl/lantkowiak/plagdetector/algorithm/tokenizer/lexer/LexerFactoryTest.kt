package pl.lantkowiak.plagdetector.algorithm.tokenizer.lexer

import org.antlr.v4.runtime.CharStreams
import org.assertj.core.api.Assertions
import org.junit.Test
import pl.lantkowiak.plagdetector.algorithm.grammar.Java8Lexer

class LexerFactoryTest {
	@Test
	fun getLexer_should_returnJava8Lexer_when_Java8TypeIsPassed() {
		// given

		// when
		val result = LexerFactory.getLexer(LexerType.JAVA_8, CharStreams.fromString(""))

		// then
		Assertions.assertThat(result).isInstanceOf(Java8Lexer::class.java)
	}
}