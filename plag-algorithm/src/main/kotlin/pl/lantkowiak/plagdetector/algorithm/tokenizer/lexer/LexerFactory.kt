package pl.lantkowiak.plagdetector.algorithm.tokenizer.lexer

import org.antlr.v4.runtime.Lexer
import org.antlr.v4.runtime.CharStream
import pl.lantkowiak.plagdetector.algorithm.grammar.Java8Lexer

class LexerFactory {
	fun getLexer(type: LexerType, cs: CharStream): Lexer {
		when (type) {
			LexerType.JAVA_8 -> return Java8Lexer(cs)
		}
	}
}