package pl.lantkowiak.plagdetector.algorithm.tokenizer.lexer

import org.antlr.v4.runtime.Lexer
import org.antlr.v4.runtime.CharStream
import pl.lantkowiak.plagdetector.algorithm.grammar.Java8Lexer
import org.antlr.v4.runtime.CharStreams
import org.junit.Test

class LexerFactoryTest {
	val lexerFactory: LexerFactory = LexerFactory();

	@Test
	fun getLexer_should_returnJava8Lexer_when_Java8TypeIsPassed() {
		// given

		// when
		val result = lexerFactory.getLexer(LexerType.JAVA_8, CharStreams.fromString(""))

		// then
		System.out.println("result " + result)
	}
//	fun getLexer(type: LexerType, cs: CharStream): Lexer {
//		when (type) {
//			LexerType.JAVA_8 -> return Java8Lexer(cs)
//		}
//	}
}