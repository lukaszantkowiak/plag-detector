package pl.lantkowiak.plagdetector.algorithm.tokenizer

import pl.lantkowiak.plagdetector.algorithm.tokenizer.lexer.LexerType
import pl.lantkowiak.plagdetector.algorithm.tokenizer.lexer.LexerFactory
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.Lexer

class TokenizerImpl : Tokenizer {
	override fun tokenize(lexerType: LexerType, input: String): List<Int> {
		val lexer = LexerFactory().getLexer(lexerType, CharStreams.fromString(input))

		return lexer.getAllTokens().map { t -> t.getType() }
	}
}